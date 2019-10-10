package com.example.kotlindemo.networking

import android.arch.lifecycle.MutableLiveData
import android.util.Log
import com.example.kotlindemo.model.Blog
import com.example.kotlindemo.networking.RestApiService
import kotlinx.coroutines.*
import retrofit2.HttpException

class BlogRepository {

    private var movies = mutableListOf<Blog>()
    private var mutableLiveData = MutableLiveData<List<Blog>>()
    val completeJob = Job()
    private val coroutineScope = CoroutineScope(Dispatchers.IO + completeJob)
//
//     val thisApiCorService by lazy {
//        RestApiService.createCorService()
//
//    }
//

//    fun getMutableLiveData(): MutableLiveData<List<Blog>>{
//        coroutineScope.launch {
//
//            val request = thisApiCorService.getPopularBlog()
//            withContext(Dispatchers.Main)
//            {
//                try{
//                    val response = request.await()
//                    val mBlogWrapper = response
//                    if (mBlogWrapper!= null&&mBlogWrapper.blog!=null)
//                    {
//                        movies = mBlogWrapper.blog as MutableList<Blog>
//                        mutableLiveData.value=movies
//                    }
//                    else
//                    {
//                    }
//                }
//                catch (e: HttpException)
//                {
//
//                }
//                catch (e : Throwable)
//                {
//                }
//            }
//        }
//        return mutableLiveData
//    }
}