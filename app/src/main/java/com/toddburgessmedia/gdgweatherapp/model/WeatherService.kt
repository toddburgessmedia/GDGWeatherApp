package com.toddburgessmedia.gdgweatherapp.model

import com.toddburgessmedia.gdgweatherapp.data.DayWeather
import com.toddburgessmedia.gdgweatherapp.data.week.WeekWeather
import com.toddburgessmedia.gdgweatherapp.data.weekly.WeeklyWeather
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService  {

    @GET("http://api.openweathermap.org/data/2.5/weather?units=metric")
    suspend fun getWeatherByCity(@Query("q") city : String, @Query("appid") appid : String) : DayWeather

    @GET("https://api.openweathermap.org/data/2.5/forecast/daily?units=metric")
    suspend fun getWeatherByCityForWeek(@Query("q") city : String, @Query("appid") appid : String) : WeeklyWeather
}