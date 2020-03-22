package com.toddburgessmedia.gdgweatherapp.data.weekly

data class X(
    val clouds: Int,
    val deg: Int,
    val dt: Int,
    val humidity: Int,
    val pressure: Double,
    val snow: Double,
    val speed: Double,
    val temp: Temp,
    val weather: List<Weather>
)