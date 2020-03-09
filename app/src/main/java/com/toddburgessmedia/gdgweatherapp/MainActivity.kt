package com.toddburgessmedia.gdgweatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.toddburgessmedia.gdgweatherapp.model.WeatherModel
import com.toddburgessmedia.gdgweatherapp.model.WeatherService
import com.toddburgessmedia.gdgweatherapp.view.WeatherDetailFragment
import com.toddburgessmedia.gdgweatherapp.view.WeatherWeekFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collect
import kotlin.coroutines.CoroutineContext

class MainActivity : AppCompatActivity(), CoroutineScope by MainScope() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val weatherService = WeatherModel()

//        val transaction = supportFragmentManager.beginTransaction()
//                transaction.replace(R.id.main_framelayout,WeatherWeekFragment.newInstanceEmpty())
//                transaction.commit()

        val job = launch {
            weatherService.getWeatherForCityForWeek("Toronto").collect { weather ->
                Log.d("GDGWeather", weather.city.name)
                val transaction = supportFragmentManager.beginTransaction()
                transaction.replace(R.id.main_framelayout,WeatherWeekFragment.newInstance(weather))
                transaction.commit()
            }
        }

    }
}
