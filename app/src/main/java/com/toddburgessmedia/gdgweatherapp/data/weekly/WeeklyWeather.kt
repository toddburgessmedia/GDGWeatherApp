package com.toddburgessmedia.gdgweatherapp.data.weekly

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class WeeklyWeather(
    val city: City,
    val cnt: Int,
    val cod: String,
    val list: List<X>,
    val message: Int
) : Parcelable