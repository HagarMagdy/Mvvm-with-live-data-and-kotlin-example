package com.example.kotlindemo.view

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.res.Configuration
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.example.kotlindemo.model.Blog
import com.example.kotlindemo.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*
import android.databinding.DataBindingUtil
import android.view.View
import com.example.kotlindemo.R
import com.example.kotlindemo.databinding.ActivityMainBinding
import com.example.kotlindemo.viewmodel.ViewModelProviderFactory
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject
import android.widget.Toast
import com.example.kotlindemo.networking.ApiResponse


class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var providerFactory: ViewModelProviderFactory
    private lateinit var mainViewModel: MainViewModel
    private var mBlogAdapter: BlogAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        Log.i("DebugTag", "providerFactory= ${providerFactory}")
        mainViewModel = ViewModelProviders.of(this, providerFactory).get(MainViewModel::class.java)
        getPopularBlog(mainViewModel)
        swiperefresh.setOnRefreshListener { getPopularBlog(mainViewModel) }
    }

    private fun getPopularBlog(mainViewModel: MainViewModel) {
        swiperefresh.isRefreshing = false

        mainViewModel.getBlogs().observe(this,
            Observer<ApiResponse> { apiResponse ->
                if (apiResponse == null) {
                    // handle error here
                    Toast.makeText(this@MainActivity, "No response", Toast.LENGTH_SHORT).show()

                    return@Observer
                }
                if (apiResponse.error == null) {
                    // call is successful
                    prepareRecyclerView(apiResponse.blogs)
                } else {
                    // call failed.
                    val e = apiResponse.error
                    Toast.makeText(this@MainActivity, "Error is " + e!!.message, Toast.LENGTH_SHORT).show()

                }
            })

    }

    private fun showProgressBar(isVisible: Boolean) {
        when {
            isVisible -> progressBar.visibility = View.VISIBLE
            else -> progressBar.visibility = View.GONE
        }
    }
    private fun prepareRecyclerView(blogList: List<Blog>?) {
        showProgressBar(false)
        Log.i("DebugTag", "list size = ${blogList!!.size}")
        mBlogAdapter = BlogAdapter(blogList)
        if (this.resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            blogRecyclerView.layoutManager = LinearLayoutManager(this)
        } else {
            blogRecyclerView.layoutManager = GridLayoutManager(this, 4)
        }
        blogRecyclerView.itemAnimator = DefaultItemAnimator()
        blogRecyclerView.adapter = mBlogAdapter
    }
}
