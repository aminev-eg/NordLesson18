package com.reactivelabs.androidapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.reactivelabs.androidapp.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .add(R.id.fragmentContainer, FirstFragment())
            .commit()

        buttonFragment1.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, FirstFragment())
                .commit()
        }

        buttonFragment2.setOnClickListener {
            val fragment = SecondFragment()
            val bundle = Bundle()
            bundle.putString("someData", "Pretty string")
            fragment.arguments = bundle
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .commit()
        }

    }
}
