package com.msk.flickr.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import com.msk.flickr.main.photosfeed.PhotosViewModel

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(PhotosViewModel::class)
    internal abstract fun postMainViewModel(viewModel: PhotosViewModel): ViewModel
}