package com.msk.flickr.api

import com.msk.flickr.model.FeedResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface FlickrApiService {
    @GET("feeds/photos_public.gne")
    fun getFeedsAsync(
        @Query("tags") tag: String,
        @Query("nojsoncallback") nojsoncallback: Int,
        @Query("per_page") itemCount: Int,
        @Query("format") format: String
    ): Observable<FeedResponse>
}