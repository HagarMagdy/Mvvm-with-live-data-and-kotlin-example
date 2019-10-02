package com.example.kotlindemo.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.example.kotlindemo.model.Blog

class MainViewModel() : ViewModel() {
    val moviesRepository = BlogRepository()
    val allBlogs: LiveData<List<Blog>> get() = moviesRepository.getMutableLiveData()

    override fun onCleared() {
        super.onCleared()
        moviesRepository.completeJob.cancel()
    }

}