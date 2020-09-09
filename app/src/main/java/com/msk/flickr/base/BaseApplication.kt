package com.msk.flickr.base

import android.app.Application
import com.msk.flickr.BASE_URL
import com.msk.flickr.di.*

open class BaseApplication : Application() {

    // FOR DATA
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        this.appComponent = this.initDagger()
    }

    // --- Dependencies injection ---

    protected open fun initDagger(): AppComponent
            = DaggerAppComponent.builder()
            .netModule(NetModule(BASE_URL))
            .repositoryModule(RepositoryModule())
            .rxJavaModule(RxJavaModule())
            .build()
}