package com.example.kotlindemo.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.kotlindemo.model.Blog

class MainViewModel() : ViewModel() {
    val moviesRepository = BlogRepository()
    val allBlogs: LiveData<List<Blog>> get() = moviesRepository.getMutableLiveData()

    override fun onCleared() {
        super.onCleared()
        moviesRepository.completeJob.cancel()
    }

   fun openLink( blog: Blog,context: Context){
            val intent = Intent()
            intent.setAction(Intent.ACTION_VIEW)
            intent.addCategory(Intent.CATEGORY_BROWSABLE)
            intent.setData(Uri.parse(blog.link))
            context.startActivity(intent)
    }

}