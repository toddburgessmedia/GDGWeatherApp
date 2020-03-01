package com.toddburgessmedia.gdgweatherapp.model

import com.toddburgessmedia.gdgweatherapp.data.Weather
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService  {

    @GET("http://api.openweathermap.org/data/2.5/weather")
    suspend fun getWeatherByCity(@Query("q") city : String, @Query("appid") appid : String) : Weather
}