package sample.network.rahul.datafetchandlist.ui

import android.databinding.DataBindingUtil.inflate
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import sample.network.rahul.datafetchandlist.R
import sample.network.rahul.datafetchandlist.databinding.ListItemBinding
import sample.network.rahul.datafetchandlist.model.Announcement


class AnnouncementRecyclerViewAdapter(private val announcementList: List<Announcement>, private val listener: AnnouncementItemListener) : RecyclerView.Adapter<AnnouncementRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): AnnouncementRecyclerViewAdapter.ViewHolder {
        val binding: ListItemBinding = inflate(LayoutInflater.from(parent.context), R.layout.list_item, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val announcement = announcementList[position]
        holder.itemBinding.announcement = announcement
        holder.itemBinding.itemClickListener = listener
    }

    override fun getItemCount(): Int {
        return announcementList.size
    }

    inner class ViewHolder(var itemBinding: ListItemBinding) : RecyclerView.ViewHolder(itemBinding.getRoot())
    interface AnnouncementItemListener {
        fun onItemClick(announcement: Announcement)
    }
}