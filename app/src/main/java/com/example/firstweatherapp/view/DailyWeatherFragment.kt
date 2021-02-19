package com.example.firstweatherapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.firstweatherapp.databinding.FragmentDailyWeatherBinding

class DailyWeatherFragment : Fragment() {
    //private lateinit var binding: FragmentDailyWeatherBinding
    //private val viewModel = WeatherViewModel()

    override fun onCreateView(
                inflater: LayoutInflater,
                container: ViewGroup?,
                savedInstanceState: Bundle?
        ) = FragmentDailyWeatherBinding.inflate(
                inflater,
                container,
                false
        ).root
//    ).also { binding = it }.root
}