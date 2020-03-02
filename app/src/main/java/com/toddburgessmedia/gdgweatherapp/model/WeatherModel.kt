package com.toddburgessmedia.gdgweatherapp.model

import com.toddburgessmedia.gdgweatherapp.BuildConfig
import com.toddburgessmedia.gdgweatherapp.data.Weather
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.CoroutineContext

class WeatherModel {

    val weatherService : WeatherService by lazy {

            val retrofit = Retrofit.Builder()
                .addConverterFactory(MoshiConverterFactory.create())
                .baseUrl("http://api.openweathermap.org")
                .build()
            retrofit.create(WeatherService::class.java)
        }

    fun getWeatherForCity(city : String) : Weather? {

        var weather : Weather? = null

        runBlocking {
             weather = weatherService.getWeatherByCity(city, BuildConfig.API_KEY)
        }

        return weather
    }

}

