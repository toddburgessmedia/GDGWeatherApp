package com.toddburgessmedia.gdgweatherapp.data.weekly

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class City(
    val country: String,
    val geoname_id: Int,
    val iso2: String,
    val lat: Double,
    val lon: Double,
    val name: String,
    val population: Int,
    val type: String
) : Parcelable