package com.toddburgessmedia.gdgweatherapp.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.toddburgessmedia.gdgweatherapp.R
import com.toddburgessmedia.gdgweatherapp.data.week.X
import kotlinx.android.synthetic.main.recycle_weather_day.view.*

class WeatherWeekAdapter(private val days : List<X>) : RecyclerView.Adapter<WeatherWeekAdapter.WeatherDayViewHolder>()  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherDayViewHolder {
        val view =  LayoutInflater.from(parent.context).inflate(R.layout.recycle_weather_day, parent,false )
        return WeatherDayViewHolder(view)
    }

    override fun getItemCount(): Int = days.size

    override fun onBindViewHolder(holder: WeatherDayViewHolder, position: Int) {

        holder.day.text = days[position].dt.toString()
    }

    class WeatherDayViewHolder(v : View) : RecyclerView.ViewHolder(v) {

        var day = v.recycle_day

    }
}