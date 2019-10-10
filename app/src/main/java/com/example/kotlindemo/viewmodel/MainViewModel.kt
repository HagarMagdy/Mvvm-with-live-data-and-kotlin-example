package com.example.kotlindemo.viewmodel

import android.arch.lifecycle.*
import android.util.Log
import com.example.kotlindemo.model.Blog
import com.example.kotlindemo.networking.RestApiService

import javax.inject.Inject
import android.arch.lifecycle.LiveData
import com.example.kotlindemo.model.BlogWrapper
import com.example.kotlindemo.networking.ApiResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainViewModel() : ViewModel() {
    private var restApiService: RestApiService? = null
//    val returnedBlogs: LiveData<ApiResponse> get() = getBlogs()
    val apiResponse:MutableLiveData<ApiResponse>  =  MutableLiveData()
    @Inject
    constructor(restApiService: RestApiService) : this() {
        Log.i("DebugTag", "VIEW MODEL")
        this.restApiService = restApiService
    }


    fun getBlogs(): LiveData<ApiResponse> {
        Log.i("DebugTag", "getBlogs")
        val call = restApiService!!.getPopularBlog()
        call.enqueue(object : Callback<BlogWrapper> {
            override fun onResponse(call: Call<BlogWrapper>, response: Response<BlogWrapper>) {
                if (response.code() == 200) {

                    apiResponse.value= ApiResponse(response.body()!!.blog!!)
                }
            }



            override fun onFailure(call: Call<BlogWrapper>, t: Throwable) {
                apiResponse.value = ApiResponse(t)
            }
        })

        return apiResponse
    }


}