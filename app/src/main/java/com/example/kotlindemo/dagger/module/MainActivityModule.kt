package com.example.kotlindemo.dagger.module

import com.example.kotlindemo.networking.RestApiService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class MainActivityModule {

    @Provides
    fun provideApi(retrofit: Retrofit): RestApiService {
        return retrofit.create(RestApiService::class.java)
    }
}



