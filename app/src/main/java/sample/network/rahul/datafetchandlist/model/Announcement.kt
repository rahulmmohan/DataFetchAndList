package sample.network.rahul.datafetchandlist.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable


class Announcement: Serializable {
    @SerializedName("ANNOUNCEMENT_TITLE")
    @Expose
    var title: Field? = null
    @SerializedName("ANNOUNCEMENT_IMAGE_THUMBNAIL")
    @Expose
    var image: Field? = null
    @SerializedName("ANNOUNCEMENT_HTML")
    @Expose
    var html: Field? = null
}