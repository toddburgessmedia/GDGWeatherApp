package com.toddburgessmedia.gdgweatherapp.data.week

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Sys(
    val pod: String
) : Parcelable