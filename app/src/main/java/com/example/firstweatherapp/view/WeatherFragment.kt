package com.example.firstweatherapp.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.firstweatherapp.adapter.DailyWeatherAdapter
import com.example.firstweatherapp.databinding.FragmentWeatherBinding
import com.example.firstweatherapp.model.CurrentWeather
import com.example.firstweatherapp.model.oneCall.WeatherOneCall
import com.example.firstweatherapp.viewModel.WeatherViewModel
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter

class WeatherFragment : Fragment() {
    private lateinit var binding: FragmentWeatherBinding
    private val viewModel = WeatherViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentWeatherBinding.inflate(
        inflater,
        container,
        false
    ).also { binding = it }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvDaily.layoutManager = getGridLayoutMgr(true)

        setUpObservers()

        viewModel.fetchWeatherOneCall(
            40.7493,
            -73.6407,
            "imperial",
            "6eb589c3b7d362f55bb5f42759e23021",
            requireContext()
        )
        val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE)

    }

    private fun setUpObservers() {
        viewModel.weather.observe(viewLifecycleOwner,
            Observer<CurrentWeather> {
                val temperature = it.main?.temp
                val dateTime = System.currentTimeMillis()
                val description = it?.weather?.get(0)?.description
                loadInfo(temperature, dateTime, description)
            })

        viewModel.oneCall.observe(viewLifecycleOwner,
            Observer<WeatherOneCall> {
                val temperature = it.current?.temp
                //val temperature = it.lon
                val dateTime = System.currentTimeMillis()
                //val description = it?.current?.weather?.get(0)?.description
                loadInfo(temperature, dateTime, "")
            })

        viewModel.oneCall.observe(viewLifecycleOwner,
            Observer<WeatherOneCall> {
//                val dailyAdapter = DailyWeatherAdapter(it.daily)
//                binding.rvDaily.adapter = dailyAdapter
            })

    }

    private fun loadInfo(temperature: Double?, dateTime: Long, description: String?) {
        binding.tvTemp.text = temperature?.toInt().toString() + (176).toChar()
//        binding.tvWeatherDesc.text = description

        val instant = Instant.ofEpochMilli(dateTime)
        var formatter = DateTimeFormatter.ofPattern("HH:mm")
        val date = LocalDateTime.ofInstant(instant, ZoneId.systemDefault())
        binding.tvTime.text = formatter.format(date)

        formatter = DateTimeFormatter.ofPattern("EEEE, dd MMM")
        binding.tvDate.text = formatter.format(date) + " - " + description
    }

    private fun getGridLayoutMgr(horizontal: Boolean = false, gridToggle: Boolean = false): RecyclerView.LayoutManager {
        val const = if (horizontal) {
            LinearLayoutManager.HORIZONTAL
        } else {
            LinearLayoutManager.VERTICAL
        }

        return if (gridToggle) {
            GridLayoutManager(this.context, 2)
        } else {
            LinearLayoutManager(this.context, const, false)
        }
    }
}
