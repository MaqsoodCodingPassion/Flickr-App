package com.msk.flickr.di

import dagger.Module
import dagger.Provides
import com.msk.flickr.api.FlickrApiService
import com.msk.flickr.repository.FlickrRepository
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideUserRepository(flickrApiService: FlickrApiService) = FlickrRepository(flickrApiService)

}