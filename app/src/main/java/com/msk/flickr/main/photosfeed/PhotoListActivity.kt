package com.msk.flickr.main.photosfeed

import android.view.Menu
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.msk.flickr.R
import com.msk.flickr.base.BaseActivity
import com.msk.flickr.model.Feed
import com.miguelcatalan.materialsearchview.MaterialSearchView
import kotlinx.android.synthetic.main.photo_list.*
import com.msk.flickr.main.photodetail.PhotoDetailActivity
import com.msk.flickr.util.BottomSheetDialog
import com.msk.flickr.util.SortByDate
import com.msk.flickr.util.hide
import com.msk.flickr.util.show
import org.jetbrains.annotations.TestOnly


class PhotoListActivity : BaseActivity(), BottomSheetDialog.BottomSheetListener {
    // FOR DATA
    private lateinit var viewModel: PhotosViewModel
    private lateinit var recyclerAdapter: PhotosRecyclerAdapter
    private var feeds: List<Feed> = emptyList()


    override fun getLayoutById(): Int = R.layout.photo_list

    override fun configureDesign() {
        setSupportActionBar(toolbar)
        //Set up recycler view
        recyclerAdapter = PhotosRecyclerAdapter(this) {
                startActivity(PhotoDetailActivity.newIntent(this, it.feed))
        }
        photosRecyclerView.apply {
            layoutManager = GridLayoutManager(this@PhotoListActivity, 2)
            isNestedScrollingEnabled = false
            isFocusable = false
            adapter = recyclerAdapter
        }
        configureViewModel()
        observeData()
    }

    private fun initSearch(menu: Menu?) {
        searchView.setMenuItem(menu?.findItem(R.id.search))
        searchView.setOnQueryTextListener(object : MaterialSearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean = query?.let {
                selected_tag.text = it
                viewModel.getFlickrFeed(it)
            }!!

            override fun onQueryTextChange(newText: String?): Boolean = false
        })

        sort_option.setOnClickListener {
            if (feeds.isNotEmpty()) BottomSheetDialog().show(supportFragmentManager, null)
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.search_photos, menu)
        initSearch(menu)
        return true
    }

    private fun configureViewModel() {
        viewModel = ViewModelProvider(this, viewModelFactory)[PhotosViewModel::class.java]
        viewModel.getFlickrFeed()
    }

    private fun observeData() {
        viewModel.feedResponse.observe(this, Observer {
            feeds = it.feeds
            loadList(feeds)
        })

        viewModel.isLoading.observe(this, Observer { showLoader ->
            if (showLoader) {
                noItemsText.hide()
                progress.show()
            } else {
                progress.hide()
            }
        })
        viewModel.errorMessage.observe(this, Observer {
            photosRecyclerView.hide()
            noItemsText.show()
            showNetworkDialog()
        })
    }


    override fun onOptionClick(selectedDate: SortByDate) {
        when (selectedDate) {
            SortByDate.DATE_TAKEN -> loadList(feeds.sortedBy { it.dateTaken })
            SortByDate.PUBLISHED -> loadList(feeds.sortedBy { it.published })
        }
    }

    private fun loadList(feeds: List<Feed>) {
        if (feeds.isNotEmpty()) {
            photosRecyclerView.show()
            noItemsText.hide()
            recyclerAdapter.feedList = feeds
        } else {
            photosRecyclerView.hide()
            noItemsText.show()
        }
    }
    /**
     * Required for activity tests using robo electric
     */
    @TestOnly
    fun setTestViewModel(testViewModel: PhotosViewModel) {
        viewModel = testViewModel
    }

    /**
     * Required for activity tests using robo electric
     */
    @TestOnly
    fun subscribeToFeed() {
        observeData()
    }


}
