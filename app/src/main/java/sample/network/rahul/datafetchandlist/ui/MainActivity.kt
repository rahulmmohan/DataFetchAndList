package sample.network.rahul.datafetchandlist.ui

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import sample.network.rahul.datafetchandlist.R
import sample.network.rahul.datafetchandlist.databinding.ActivityMainBinding
import sample.network.rahul.datafetchandlist.datasource.DataManager
import sample.network.rahul.datafetchandlist.model.Announcement


class MainActivity : AppCompatActivity(),AnnouncementRecyclerViewAdapter.AnnouncementItemListener,DataManager.DataCallback {

    private var adapter: AnnouncementRecyclerViewAdapter? = null
    private var binding: ActivityMainBinding? = null
    private var announcements: ArrayList<Announcement> = ArrayList()

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
        binding!!.progressBar.visibility = View.GONE
        binding!!.recyclerView.visibility = View.VISIBLE
    }


    override fun onItemClick(announcement: Announcement) {
        val intent = Intent(this, WebActivity::class.java)
        intent.putExtra(getString(R.string.data_key), announcement)
        startActivity(intent)
    }
}
