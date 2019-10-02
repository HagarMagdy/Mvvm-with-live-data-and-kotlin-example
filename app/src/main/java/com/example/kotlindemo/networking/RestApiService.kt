package com.example.kotlindemo.networking

import com.example.kotlindemo.model.BlogWrapper
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import java.util.concurrent.TimeUnit

interface RestApiService {
    @GET("/api/feed.json")
    fun getPopularBlog(): Deferred<BlogWrapper>

    companion object {
        fun createCorService():RestApiService{
            val okHttpClient = OkHttpClient.Builder()
                .connectTimeout(1,TimeUnit.MINUTES)
                .readTimeout(30,TimeUnit.SECONDS)
                .writeTimeout(15,TimeUnit.SECONDS)
                .build()

            return Retrofit.Builder()
                .baseUrl("https://androidwave.com")
                .addConverterFactory(MoshiConverterFactory.create())
                .client(okHttpClient)
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .build().create(RestApiService::class.java)
        }
    }
}