package com.msk.flickr.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.msk.flickr.R
import com.msk.flickr.di.ViewModelFactory
import com.msk.flickr.util.ShowErrorDialog
import javax.inject.Inject

abstract class BaseActivity: AppCompatActivity() {

    // FOR DATA
    @Inject lateinit var viewModelFactory: ViewModelFactory

    // --- LIFECYCLE METHODS ---
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutById())
        configureDagger()
        configureDesign()
    }

    // --- DEPENDENCIES INJECTION ---
    private fun configureDagger() = (this.application as BaseApplication).appComponent.inject(this)

    // --- ABSTRACT METHODS ---
    abstract fun getLayoutById(): Int
    abstract fun configureDesign()

    protected fun showNetworkDialog() {
        val alertDialog =
            ShowErrorDialog.newInstance(
                getString(R.string.network), getString(
                    R.string.message
                )
            )
        alertDialog.show(supportFragmentManager, getString(R.string.fragment_tag))
    }
}