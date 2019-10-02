package com.example.kotlindemo.view

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.res.Configuration
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.example.kotlindemo.R
import com.example.kotlindemo.model.Blog
import com.example.kotlindemo.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*
import android.databinding.DataBindingUtil
import com.example.kotlindemo.databinding.ActivityMainBinding
import android.support.v7.widget.RecyclerView




class MainActivity : AppCompatActivity() {

    var mainViewModel: MainViewModel? = null
    var mBlogAdapter: BlogAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        val activityMainBinding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        setPopularBlog()

        swiperefresh.setOnRefreshListener { setPopularBlog() }
    }

    private fun setPopularBlog() {
        swiperefresh.isRefreshing = false
        mainViewModel!!.allBlogs.observe(this, Observer { blogList -> prepareRecyclerView(blogList) })

    }

    private fun prepareRecyclerView(blogList: List<Blog>?) {

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
