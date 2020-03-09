package com.toddburgessmedia.gdgweatherapp.data.week

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Rain(
    val `3h`: Double
) : Parcelable