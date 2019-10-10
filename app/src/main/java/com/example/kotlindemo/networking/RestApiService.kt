package com.example.kotlindemo.networking

import com.example.kotlindemo.model.BlogWrapper
import retrofit2.Call
import retrofit2.http.GET

interface RestApiService {
    @GET("/api/feed.json")
    fun getPopularBlog(): Call<BlogWrapper>

}