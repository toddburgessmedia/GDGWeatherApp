package com.toddburgessmedia.gdgweatherapp.view

import java.text.SimpleDateFormat
import java.time.ZoneId
import java.util.*

object DateTimeUtil {

    fun getDateString(utc : Int ) : String {

        val date = Date(utc*1000L)
        val sdf = SimpleDateFormat("E, LLL d, y", Locale.CANADA)
        sdf.timeZone = TimeZone.getDefault()

        return sdf.format(date)
    }

    fun getTime(utc : Int) : String {

        val date = Date(utc * 1000L)
        val sdf = SimpleDateFormat("h:m a", Locale.CANADA)
        sdf.timeZone = TimeZone.getDefault()

        return sdf.format(date)
    }

    fun getDay(utc : Int) : String {

        val date = Date(utc*1000L)
        val sdf = SimpleDateFormat("E", Locale.CANADA)
        sdf.timeZone = TimeZone.getTimeZone("GMT")

        return sdf.format(date)
    }
}