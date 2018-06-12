package sample.network.rahul.datafetchandlist.datasource

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



class Announcement {
    @SerializedName("ANNOUNCEMENT_DATE")
    @Expose
    var aNNOUNCEMENTDATE: Date? = null
    @SerializedName("ANNOUNCEMENT_TITLE")
    @Expose
    var aNNOUNCEMENTTITLE: Title? = null
    @SerializedName("ANNOUNCEMENT_IMAGE")
    @Expose
    var aNNOUNCEMENTIMAGE: Image? = null
    @SerializedName("ANNOUNCEMENT_HTML")
    @Expose
    var aNNOUNCEMENTHTML: Html? = null
}