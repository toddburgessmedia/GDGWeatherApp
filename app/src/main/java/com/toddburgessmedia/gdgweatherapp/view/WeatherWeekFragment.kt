package com.toddburgessmedia.gdgweatherapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.toddburgessmedia.gdgweatherapp.R
import com.toddburgessmedia.gdgweatherapp.data.week.WeekWeather
import kotlinx.android.synthetic.main.fragment_weather_week.*
import java.lang.IllegalArgumentException

class WeatherWeekFragment : Fragment() {

    lateinit var weatherAdapter : WeatherWeekAdapter
    val layout = LinearLayoutManager(activity)

    companion object Factory {

        fun newInstance(weekWeather: WeekWeather) : WeatherWeekFragment {

            val fragment = WeatherWeekFragment()
            val args = Bundle()
            args.putParcelable("weekweather",weekWeather)
            fragment.arguments = args
            return fragment
        }

        fun newInstanceEmpty() = WeatherWeekFragment()
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_weather_week,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val weekWeather = arguments?.getParcelable("weekweather") as WeekWeather?

        weatherweek_city.text = weekWeather?.city?.name

        weatherweek_recycle.apply {
            setHasFixedSize(true)
            layoutManager = layout
            weekWeather?.list?.let { list ->
                weatherAdapter = WeatherWeekAdapter(list)
                adapter = weatherAdapter
            } ?: throw IllegalArgumentException("Weather List should not be null")
        }
    }
}