package com.toddburgessmedia.gdgweatherapp.data.weekly

data class WeeklyWeather(
    val city: City,
    val cnt: Int,
    val cod: String,
    val list: List<X>,
    val message: Int
)