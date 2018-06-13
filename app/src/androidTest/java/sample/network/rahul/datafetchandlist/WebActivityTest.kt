package sample.network.rahul.datafetchandlist

import android.content.Intent
import android.support.test.InstrumentationRegistry
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.web.assertion.WebViewAssertions.webMatches
import android.support.test.espresso.web.sugar.Web
import android.support.test.espresso.web.sugar.Web.onWebView
import android.support.test.espresso.web.webdriver.DriverAtoms
import android.support.test.espresso.web.webdriver.DriverAtoms.findElement
import android.support.test.espresso.web.webdriver.Locator
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import org.hamcrest.Matchers.containsString
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import sample.network.rahul.datafetchandlist.model.Announcement
import sample.network.rahul.datafetchandlist.model.Field
import sample.network.rahul.datafetchandlist.ui.WebActivity


@RunWith(AndroidJUnit4::class)
class WebActivityTest {
    @get:Rule
    var mActivityRule: ActivityTestRule<WebActivity> = object : ActivityTestRule<WebActivity>(WebActivity::class.java) {
        override fun getActivityIntent(): Intent {
            val targetContext = InstrumentationRegistry.getInstrumentation().targetContext
            val result = Intent(targetContext, WebActivity::class.java)
            val announcement = Announcement()
            val html = Field()
            html.value = "<html>Hello World!</html>"
            announcement.html = html
            result.putExtra(targetContext.getString(R.string.data_key), announcement)
            return result
        }

        override fun afterActivityLaunched() {
            super.afterActivityLaunched()
            onWebView(withId(R.id.webView)).forceJavascriptEnabled()
        }
    }

    @Test
    fun shouldShowHelloWorld() {
        Web.onWebView(withId(R.id.webView))
                .withElement(findElement(Locator.TAG_NAME, "html"))
                .check(webMatches(DriverAtoms.getText(), containsString("Hello World!")))
    }
}