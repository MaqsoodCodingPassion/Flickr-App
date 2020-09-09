package com.msk.flickr.util

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions



object ImageLoader {

    fun loadMediumImage(imageView: ImageView, url: String) {
        Glide.with(imageView.context.applicationContext)
            .load(url.replace("_m", "_e"))
            .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
            .apply(RequestOptions().diskCacheStrategy(DiskCacheStrategy.ALL))
            .placeholder(android.R.drawable.picture_frame)
            .error(android.R.drawable.picture_frame)
            .into(imageView)
    }

    fun loadLargeImage(imageView: ImageView, url: String) {
        Glide.with(imageView.context.applicationContext)
            .load(url.replace("_m", "_b"))
            .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
            .apply(RequestOptions().diskCacheStrategy(DiskCacheStrategy.ALL))
            .placeholder(android.R.color.background_light)
            .error(android.R.color.background_light)
            .into(imageView)
    }

}