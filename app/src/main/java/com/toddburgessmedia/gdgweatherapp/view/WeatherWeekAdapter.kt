package com.toddburgessmedia.gdgweatherapp.view

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.toddburgessmedia.gdgweatherapp.R
import com.toddburgessmedia.gdgweatherapp.data.week.X
import kotlinx.android.synthetic.main.recycle_weather_day.view.*

class WeatherWeekAdapter(private val daysList : List<X>) : RecyclerView.Adapter<WeatherWeekAdapter.WeatherDayViewHolder>()  {

    private val days = daysList.reversed().chunked(7).reversed().takeLast(5)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherDayViewHolder =
        WeatherDayViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.recycle_weather_day, parent,false ))

    override fun getItemCount(): Int = days.size

    override fun onBindViewHolder(holder: WeatherDayViewHolder, position: Int) {

        Log.d("GDGWeather", "item ${days[position].size}")
        holder.day.text = DateTimeUtil.getDay(days[position][0].dt)

    }

    class WeatherDayViewHolder(v : View) : RecyclerView.ViewHolder(v) {

        private var view = v
        var day = view.recycle_day

    }
}