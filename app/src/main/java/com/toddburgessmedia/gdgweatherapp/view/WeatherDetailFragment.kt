package com.toddburgessmedia.gdgweatherapp.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.squareup.picasso.Picasso
import com.toddburgessmedia.gdgweatherapp.R
import com.toddburgessmedia.gdgweatherapp.data.DayWeather
import kotlinx.android.synthetic.main.fragment_weather_detail.*
import java.text.SimpleDateFormat
import java.util.*

class WeatherDetailFragment : Fragment() {

    companion object {
        fun newInstance(dayWeather: DayWeather) : WeatherDetailFragment {
            val fragment = WeatherDetailFragment()
            val args = Bundle()
            args.putParcelable("dayweather",dayWeather)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_weather_detail,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dayWeather = arguments?.get("dayweather") as DayWeather

        weatherdetail_city.text = dayWeather.name
        weatherdetail_date.text = getDateString(dayWeather.dt)
        weatherdetail_main.text = dayWeather.weather[0].description

        getImageIcon(dayWeather.weather[0].icon)
        weatherdetail_temp.text = dayWeather.main.temp.toInt().toString()
        weatherdetail_feelsLike.text = dayWeather.main.feels_like.toInt().toString()
        weatherdetail_low.text = dayWeather.main.temp_min.toInt().toString()
        weatherdetail_high.text = dayWeather.main.temp_max.toInt().toString()

        weatherdetail_humidity.text = dayWeather.main.humidity.toString() + "%"
        weatherdetail_pressure.text = dayWeather.main.pressure.toString() + " kPa"
        weatherdetail_sunrise.text = getTime(dayWeather.sys.sunrise)
        weatherdetail_sunset.text = getTime(dayWeather.sys.sunset)

    }

    private fun getDateString(utc : Int ) : String {

        val date = Date(utc*1000L)
        val sdf = SimpleDateFormat("E, LLL d, y", Locale.CANADA)
        sdf.timeZone = TimeZone.getDefault()

        return sdf.format(date)
    }

    private fun getTime(utc : Int) : String {

        val date = Date(utc * 1000L)
        val sdf = SimpleDateFormat("h:m a", Locale.CANADA)
        sdf.timeZone = TimeZone.getDefault()

        return sdf.format(date)
    }

    private fun getImageIcon(icon : String) {

        val iconUrl = "http://openweathermap.org/img/w/$icon.png"
        Picasso.get()
            .load(iconUrl)
            //.resize(175,175)
            .into(weatherdetail_icon)
    }
}