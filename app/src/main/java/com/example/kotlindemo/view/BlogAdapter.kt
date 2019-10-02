package com.example.kotlindemo.view

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.kotlindemo.R
import com.example.kotlindemo.model.Blog
import java.lang.Exception
import android.support.annotation.NonNull
import com.example.kotlindemo.databinding.BlogItemBinding
import android.databinding.DataBindingUtil


class BlogAdapter(var blogList: List<Blog>?) : RecyclerView.Adapter<BlogAdapter.ViewHolder>() {

    private var mContext: Context? = null

    override fun getItemCount(): Int {
        return blogList!!.size
    }


    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
        this.mContext = parent.context
//        return ViewHolder(
//            LayoutInflater.from(parent.context).inflate(R.layout.blog_item, parent, false)
//        )

        val blogItemBinding = BlogItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return ViewHolder(blogItemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val mBlog = blogList!!.get(position)
        holder.blogItemBinding.blog = mBlog



//        if (mBlog.thumbnail != null) {
//            Glide.with(mContext!!)
//                .load(mBlog.thumbnail)
//                .into(holder.ivThumbnail)
//        }
//
//        if (mBlog.title != null) {
//            holder.tvTitle.text = mBlog.title
//        }
//        if (mBlog.description != null) {
//            holder.tvDescription.text = mBlog.description
//        }
//        if (mBlog.link != null) {
//            holder.tvLink.text = mBlog.link
//        }
//
//        if (mBlog.link != null) {
//            try {
//                val intent = Intent()
//                intent.setAction(Intent.ACTION_VIEW)
//                intent.addCategory(Intent.CATEGORY_BROWSABLE)
//                intent.setData(Uri.parse(mBlog.link))
//                mContext!!.startActivity(intent)
//
//            } catch (e: Exception) {
//
//            }
//        }
    }

//    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        val ivThumbnail: ImageView = itemView.findViewById(R.id.ivThumbnail);
//        val tvTitle: TextView = itemView.findViewById(R.id.tvTitle);
//        val tvDescription: TextView = itemView.findViewById(R.id.tvDescription);
//        val tvLink: TextView = itemView.findViewById(R.id.tvLink);
//    }


    class ViewHolder(val blogItemBinding: BlogItemBinding) :
        RecyclerView.ViewHolder(blogItemBinding.getRoot())
}