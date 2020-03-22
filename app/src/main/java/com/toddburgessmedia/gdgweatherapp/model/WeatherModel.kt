package com.toddburgessmedia.gdgweatherapp.model

import android.util.Log
import com.toddburgessmedia.gdgweatherapp.BuildConfig
import com.toddburgessmedia.gdgweatherapp.data.DayWeather
import com.toddburgessmedia.gdgweatherapp.data.Weather
import com.toddburgessmedia.gdgweatherapp.data.week.WeekWeather
import com.toddburgessmedia.gdgweatherapp.data.week.X
import com.toddburgessmedia.gdgweatherapp.data.weekly.WeeklyWeather
import com.toddburgessmedia.gdgweatherapp.view.DateTimeUtil
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
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

    fun getWeatherForCity(city : String) : Flow<DayWeather> = flow {

        val weather = weatherService.getWeatherByCity(city, BuildConfig.API_KEY)
        emit(weather)
    }

    fun getWeatherForCityForWeek(city : String) : Flow<WeeklyWeather> = flow {

        val weatherWeek  = weatherService.getWeatherByCityForWeek(city, BuildConfig.API_KEY)
        emit(weatherWeek)
    }



}

