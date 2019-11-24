package com.reactivelabs.androidapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.reactivelabs.androidapp.R
import kotlinx.android.synthetic.main.fragment_first.*

class FirstFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // ooops, comment
        // sample comment
        // another comment
        // https://hookagency.com/wp-content/uploads/2018/02/hilarious-stock-photos-for-memes.jpg
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //загрузка картинки
        Glide.with(this)
            .load("https://hookagency.com/wp-content/uploads/2018/02/hilarious-stock-photos-for-memes.jpg")
            .error(R.drawable.ic_launcher_foreground)
            .apply(RequestOptions().circleCrop())
            .into(somePhoto)
    }
}