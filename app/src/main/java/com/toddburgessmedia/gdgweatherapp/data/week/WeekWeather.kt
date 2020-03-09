package com.toddburgessmedia.gdgweatherapp.data.week

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class WeekWeather(
    val city: City,
    val cnt: Int,
    val cod: String,
    val list: List<X>,
    val message: Int
) : Parcelable