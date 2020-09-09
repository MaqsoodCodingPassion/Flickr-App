package com.msk.flickr.repository

import com.msk.flickr.api.FlickrApiService

private const val NO_JSON_CALLBACK = 1
private const val ITEM_COUNT = 100
private const val FORMAT = "json"

class FlickrRepository(private val flickrApiService: FlickrApiService) {

    fun getFeed(
        tag: String,
        noJsonCallback: Int = NO_JSON_CALLBACK,
        itemCount: Int = ITEM_COUNT,
        format: String = FORMAT
    ) = flickrApiService.getFeedsAsync(
        tag, noJsonCallback,
        itemCount, format
    )

}