package com.msk.flickr.main.photodetail

import android.content.Context
import android.content.Intent
import com.msk.flickr.R
import com.msk.flickr.base.BaseActivity
import com.msk.flickr.model.Feed
import com.msk.flickr.util.ImageLoader
import com.msk.flickr.util.DateUtil
import kotlinx.android.synthetic.main.photo_detail.*

class PhotoDetailActivity : BaseActivity() {

    override fun getLayoutById(): Int = R.layout.photo_detail

    override fun configureDesign() {
        val feed = intent.extras?.get(FEED_PARAM) as Feed
        with(feed) {
            authorText.text = author
            authorIdText.text = authorId
            publishedText.text = DateUtil.getFormattedDate(published)
            datetaken.text = DateUtil.getFormattedDate(dateTaken)
            tagsText.text = if(tags.isEmpty())getString(R.string.no_tag_present)else tags
            toolbar.title = title
            ImageLoader.loadLargeImage(photoView, media.imageUrl)
        }
        toolbar.setNavigationOnClickListener {
            finish()
        }
    }

    companion object {
        private const val FEED_PARAM = "feed"

        fun newIntent(context: Context, feed: Feed): Intent =
            Intent(context, PhotoDetailActivity::class.java).apply {
                putExtra(FEED_PARAM, feed)
            }
    }
}
