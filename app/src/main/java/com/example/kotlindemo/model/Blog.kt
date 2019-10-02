package com.example.kotlindemo.model

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import android.R
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.Glide


@JsonClass(generateAdapter = true)
data class Blog(
    @Json(name = "author")
    var author: String? = null,
    @Json(name = "description")
    var description: String? = null,
    @Json(name = "link")
    var link: String? = null,
    @Json(name = "pubDate")
    var pubDate: String? = null,
    @Json(name = "thumbnail")
    var thumbnail: String? = null,
    @Json(name = "title")
    var title: String? = null
)

@BindingAdapter("thumbnail")
fun loadPhotoFilePath(imageView: ImageView, path: String) {
    Glide.with(imageView.context)
        .setDefaultRequestOptions(
            RequestOptions()
        )
        .load(path)
        .into(imageView)
}
