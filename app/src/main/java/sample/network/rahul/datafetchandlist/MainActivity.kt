package sample.network.rahul.datafetchandlist

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import sample.network.rahul.datafetchandlist.databinding.ActivityMainBinding
import sample.network.rahul.datafetchandlist.datasource.DataManager
import sample.network.rahul.datafetchandlist.model.Announcement
import sample.network.rahul.datafetchandlist.model.Title
import sample.network.rahul.datafetchandlist.ui.AnnouncementRecyclerViewAdapter


class MainActivity : AppCompatActivity(),AnnouncementRecyclerViewAdapter.AnnouncementItemListener,DataManager.DataCallback {

    private var adapter: AnnouncementRecyclerViewAdapter? = null
    private var binding: ActivityMainBinding? = null
    var announcements: ArrayList<Announcement> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding!!.recyclerView.layoutManager = LinearLayoutManager(this)
        binding!!.recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        adapter = AnnouncementRecyclerViewAdapter(announcements, this)
        binding!!.recyclerView.adapter = adapter
        DataManager().loadData(this)
    }

    override fun onResponse(list: ArrayList<Announcement>) {
        announcements.addAll(list)
        adapter!!.notifyDataSetChanged()
    }


    override fun onItemClick(announcement: Announcement) {

    }
}
