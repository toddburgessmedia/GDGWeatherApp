package com.toddburgessmedia.gdgweatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.toddburgessmedia.gdgweatherapp.model.WeatherModel
import com.toddburgessmedia.gdgweatherapp.model.WeatherService
import com.toddburgessmedia.gdgweatherapp.view.WeatherDetailFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collect
import kotlin.coroutines.CoroutineContext

class MainActivity : AppCompatActivity(), CoroutineScope by MainScope() {

//    override val coroutineContext: CoroutineContext
//        get() = Dispatchers.IO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val weatherService = WeatherModel()

        val job = launch {
            weatherService.getWeatherForCity("Toronto").collect { weather ->
                val transaction = supportFragmentManager.beginTransaction()
                transaction.replace(R.id.main_framelayout,WeatherDetailFragment.newInstance(weather))
                transaction.commit()
            }
        }
    }
}
