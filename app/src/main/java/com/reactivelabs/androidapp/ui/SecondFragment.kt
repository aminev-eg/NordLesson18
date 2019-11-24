package com.reactivelabs.androidapp.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.reactivelabs.androidapp.R
import com.reactivelabs.androidapp.data.Post
import com.reactivelabs.androidapp.data.SimpleRepository
import kotlinx.android.synthetic.main.fragment_second.*

class SecondFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val repository = SimpleRepository()
        val adapter = SimpleAdapter()
        postsList.adapter = adapter

        repository.getAllPosts {
            adapter.addPosts(it)
        }
    }
}