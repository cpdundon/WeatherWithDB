package com.example.firstweatherapp.adapter

import android.icu.text.NumberFormat
import android.icu.text.NumberFormat.INTEGERSTYLE
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.firstweatherapp.databinding.FragmentDailyWeatherBinding
import com.example.firstweatherapp.model.oneCall.Daily
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import kotlin.math.round

class DailyWeatherAdapter(private val dWeather: List<Daily>?) :
        RecyclerView.Adapter<DailyWeatherAdapter.DailyWeatherViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DailyWeatherViewHolder {

        val binding: FragmentDailyWeatherBinding = FragmentDailyWeatherBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
        )
        return DailyWeatherViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return dWeather?.size ?: 0
    }

    override fun onBindViewHolder(holder: DailyWeatherViewHolder, position: Int) {
        if (dWeather != null) {
            if (dWeather.isNotEmpty()) holder.setWeather(dWeather[position])
        }
    }

    class DailyWeatherViewHolder(private val binding: FragmentDailyWeatherBinding) : RecyclerView.ViewHolder(binding.root) {
        fun setWeather(wDay: Daily) {
            val instant = Instant.ofEpochSecond(wDay.dt ?: 0)
            val formatter = DateTimeFormatter.ofPattern("dd-MMM")
            val date = LocalDateTime.ofInstant(instant, ZoneId.systemDefault())
            Log.e("TAG -> DailyWeatherAdapter", "setWeather: " + formatter.format(date) + " - High Temp: " + wDay.temp?.max.toString())
            binding.tvDate.text = formatter.format(date)
            binding.tvTemp.text = round(wDay.temp?.max ?: 0.0).toInt().toString() + (176).toChar()
            binding.tvConditions.text = wDay.weather?.get(0)?.description ?: "N/A"

        }
    }

}
