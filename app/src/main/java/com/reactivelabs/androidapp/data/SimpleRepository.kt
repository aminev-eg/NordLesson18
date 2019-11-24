package com.reactivelabs.androidapp.data

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SimpleRepository {

    private var api: SimpleApi = Retrofit.Builder()
        .baseUrl(SimpleApi.SERVER_HOST)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(SimpleApi::class.java)


    fun getAllPosts(result: (List<Post>) -> Unit) {
        api.getAllPosts().enqueue(object : Callback<List<Post>> {
            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
            }

            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                result(response.body() ?: emptyList())
            }

        })
    }

    fun getPostsByUserId(userId: Int, result: (List<Post>) -> Unit) {
        api.getPostsByUserId(userId).enqueue(object : Callback<List<Post>> {
            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
            }

            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                result(response.body() ?: emptyList())
            }

        })
    }

    fun createNewPost(post: Post, result: (Boolean) -> Unit) {
        api.createNewPost(post).enqueue(object : Callback<Post> {
            override fun onFailure(call: Call<Post>, t: Throwable) {
            }

            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                result(response.body() != null)
            }

        })
    }

    fun getPostById(id:Int, result: (Post) -> Unit) {
        val ourCallback = OurCallback(result)
        api.getPostById(id).enqueue(ourCallback)
    }

}

class OurCallback(val result: (Post) -> Unit) : Callback<Post> {
    override fun onFailure(call: Call<Post>, t: Throwable) {

    }

    override fun onResponse(call: Call<Post>, response: Response<Post>) {
        result(response.body()!!)
    }

}