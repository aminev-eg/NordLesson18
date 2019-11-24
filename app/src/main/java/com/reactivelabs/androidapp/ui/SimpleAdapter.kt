package com.reactivelabs.androidapp.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.reactivelabs.androidapp.R
import com.reactivelabs.androidapp.data.Post
import kotlinx.android.synthetic.main.item_post.view.*

class SimpleAdapter : RecyclerView.Adapter<SimpleAdapter.PostViewHolder>() {

    private val posts = mutableListOf<Post>()

    fun addPosts(newPosts: List<Post>) {
        posts.addAll(newPosts)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false)
        return PostViewHolder(view)
    }

    override fun getItemCount() = posts.size

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(posts[position])
    }

    class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(post: Post) = itemView.apply {
            title.text = post.title
            body.text = post.body
        }
    }
}