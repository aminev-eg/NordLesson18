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
                //запуск программы FirstFragment, инициирующей отображение
                .replace(R.id.fragmentContainer, FirstFragment())
                .commit()
        }

        //функция реакции на кнопку buttonFragment2
        buttonFragment2.setOnClickListener {
            val fragment = SecondFragment()      //фиксация к какому фрагменту переходим
            val bundle = Bundle()                //привязка переменной bundle к данным, хранящимся в Bundle()
            bundle.putString("someData", "Pretty string") //имя данных "someData", строка данных "Pretty string"
            fragment.arguments = bundle          //фиксация данных в аргументах фрагмента
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .commit()
        }
    }
}
