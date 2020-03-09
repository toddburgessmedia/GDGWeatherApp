package com.toddburgessmedia.gdgweatherapp.data.week

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class X(
    val clouds: Clouds,
    val dt: Int,
    val dt_txt: String,
    val main: Main,
    val rain: Rain,
    val snow: Snow,
    val sys: Sys,
    val weather: List<Weather>,
    val wind: Wind
) : Parcelable