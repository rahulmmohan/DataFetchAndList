package sample.network.rahul.datafetchandlist.ui

import android.databinding.BindingAdapter
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.webkit.WebView
import sample.network.rahul.datafetchandlist.R
import sample.network.rahul.datafetchandlist.databinding.ActivityWebBinding
import sample.network.rahul.datafetchandlist.model.Announcement

class WebActivity : AppCompatActivity() {

    private var binding: ActivityWebBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_web)
        val announcement:Announcement = intent.getSerializableExtra("data") as Announcement
        binding!!.announcement = announcement
    }
}

@BindingAdapter("htmlData")
fun loadHtml(view: WebView, html: String) {
    view.loadData(html, "text/html", "UTF-8");
}