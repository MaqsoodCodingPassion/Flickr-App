package com.msk.flickr.model


import com.msk.flickr.EMPTY_STRING
import com.google.gson.annotations.SerializedName


data class FeedResponse(
    @SerializedName("description")
    var description: String = EMPTY_STRING,
    @SerializedName("generator")
    var generator: String = EMPTY_STRING,
    @SerializedName("items")
    var feeds: List<Feed> = listOf(),
    @SerializedName("link")
    var link: String = EMPTY_STRING,
    @SerializedName("modified")
    var modified: String = EMPTY_STRING,
    @SerializedName("title")
    var title: String = EMPTY_STRING
)