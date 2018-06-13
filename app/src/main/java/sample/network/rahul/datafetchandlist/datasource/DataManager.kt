package sample.network.rahul.datafetchandlist.datasource

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import sample.network.rahul.datafetchandlist.model.Announcement


class DataManager : Callback<ArrayList<Announcement>> {
private lateinit var listener: DataCallback
    fun loadData(listener:DataCallback) {
        this.listener = listener
        val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        val api = retrofit.create<ApiInterface>(ApiInterface::class.java)

        val call = api.getAnnouncements()
        call.isCanceled
        call.enqueue(this)

    }

    override fun onResponse(call: Call<ArrayList<Announcement>>, response: Response<ArrayList<Announcement>>) {
        if (response.isSuccessful) {
            val announcementList = response.body()
            if (announcementList != null) {
                listener.onResponse(announcementList)
            }
        } else {
            listener.onFailure()
        }
    }

    override fun onFailure(call: Call<ArrayList<Announcement>>, t: Throwable) {
        t.printStackTrace()
        listener.onFailure()
    }

    companion object {

        internal const val BASE_URL = "http://94.56.199.34/EMC/IPDP/"
    }

    interface DataCallback{
        fun onResponse(list: ArrayList<Announcement>)
        fun onFailure()
    }
}