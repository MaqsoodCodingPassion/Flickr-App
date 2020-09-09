package com.msk.flickr.model


import android.os.Parcelable
import com.msk.flickr.EMPTY_STRING
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Feed(
    @SerializedName("date_taken")
    var dateTaken: String = EMPTY_STRING,
    @SerializedName("published")
    var published: String = EMPTY_STRING,
    @SerializedName("media")
    var media: Media = Media(),
    @SerializedName("title")
    var title: String = EMPTY_STRING,
    @SerializedName("link")
    var link: String = EMPTY_STRING,
    @SerializedName("tags")
    var tags: String = EMPTY_STRING,
    @SerializedName("author")
    var author: String = EMPTY_STRING,
    @SerializedName("author_id")
    var authorId: String = EMPTY_STRING
) : Parcelable

@Parcelize
data class Media(
    @SerializedName("m")
    var imageUrl: String = EMPTY_STRING
) : Parcelable