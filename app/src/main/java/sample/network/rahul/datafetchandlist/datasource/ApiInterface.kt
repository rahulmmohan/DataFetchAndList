package sample.network.rahul.datafetchandlist.datasource

import retrofit2.Call
import retrofit2.http.GET
import sample.network.rahul.datafetchandlist.model.Announcement

interface ApiInterface {
    @GET("ipdpb.ashx?TemplateName=Promotions_ipad.htm&p=Common.Announcements&Handler=News&AppName=EMC&Type=News&F=J")
    fun getAnnouncements(): Call<ArrayList<Announcement>>
}