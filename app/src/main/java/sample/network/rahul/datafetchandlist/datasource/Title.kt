package sample.network.rahul.datafetchandlist.datasource

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



class Title {
    @SerializedName("Tag")
    @Expose
    var tag: String? = null
    @SerializedName("TypeCode")
    @Expose
    var typeCode: Int? = null
    @SerializedName("Value")
    @Expose
    var value: String? = null
    @SerializedName("IsBinaryUnique")
    @Expose
    var isBinaryUnique: Boolean? = null
}