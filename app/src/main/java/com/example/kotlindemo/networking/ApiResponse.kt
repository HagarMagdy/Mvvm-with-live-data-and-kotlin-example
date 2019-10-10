package com.example.kotlindemo.networking

import com.example.kotlindemo.model.Blog
import com.example.kotlindemo.model.BlogWrapper

class ApiResponse {

    var blogs: MutableList<Blog>? = null
    var error: Throwable? = null

    constructor(blogs: MutableList<Blog>) {
        this.blogs = blogs
        this.error = null
    }

    constructor(error: Throwable) {
        this.error = error
        this.blogs = null
    }
}

