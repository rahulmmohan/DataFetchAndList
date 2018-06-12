package sample.network.rahul.datafetchandlist.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



class Announcement {
    @SerializedName("ANNOUNCEMENT_DATE")
    @Expose
    var date: Date? = null
    @SerializedName("ANNOUNCEMENT_TITLE")
    @Expose
    var title: Title? = null
    @SerializedName("ANNOUNCEMENT_IMAGE")
    @Expose
    var image: Image? = null
    @SerializedName("ANNOUNCEMENT_HTML")
    @Expose
    var html: Html? = null
}