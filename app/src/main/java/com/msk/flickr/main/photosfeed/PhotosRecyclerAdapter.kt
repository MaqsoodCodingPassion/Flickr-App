package com.msk.flickr.main.photosfeed

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.msk.flickr.R
import com.msk.flickr.model.Feed
import com.msk.flickr.model.PhotosAdapterEvent
import com.msk.flickr.util.ImageLoader
import com.msk.flickr.util.DateUtil
import kotlinx.android.synthetic.main.photo_row.view.*


class PhotosRecyclerAdapter(
    private val context: Context,
    private val listener: (PhotosAdapterEvent) -> Unit
) : ListAdapter<Feed, ViewHolder>(PhotosDiff) {

    var feedList: List<Feed> = emptyList()
        set(value) {
            field = value
            submitList(value)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(LayoutInflater.from(context).inflate(R.layout.photo_row, parent, false)
        )


    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(getItem(position), context, listener)
}

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(feed: Feed, context: Context, listener: (PhotosAdapterEvent) -> Unit) =
        with(itemView) {
            title.text = context.getString(R.string.title, feed.title)
            tags.text = context.getString(R.string.tags, feed.tags)
            published.text =
                context.getString(R.string.published, DateUtil.getFormattedDate(feed.published))
            datetaken.text =
                context.getString(R.string.date_taken, DateUtil.getFormattedDate(feed.dateTaken))
            ImageLoader.loadMediumImage(image, feed.media.imageUrl)
            image.setOnClickListener {
                listener(PhotosAdapterEvent.ClickEvent(feed))
            }


        }
}

object PhotosDiff : DiffUtil.ItemCallback<Feed>() {
    override fun areItemsTheSame(oldItem: Feed, newItem: Feed): Boolean {
        return oldItem.title == newItem.title &&
                oldItem.dateTaken == newItem.dateTaken &&
                oldItem.published == newItem.published &&
                oldItem.link == newItem.link
    }

    override fun areContentsTheSame(oldItem: Feed, newItem: Feed) = oldItem == newItem
}
