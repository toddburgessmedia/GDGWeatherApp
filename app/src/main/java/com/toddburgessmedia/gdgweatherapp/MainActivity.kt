package com.toddburgessmedia.gdgweatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.toddburgessmedia.gdgweatherapp.view.WeatherDetailFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.main_framelayout,WeatherDetailFragment.newInstance())
        transaction.commit()

    }
}
