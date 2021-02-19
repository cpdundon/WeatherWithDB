package com.example.firstweatherapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.firstweatherapp.databinding.ActivityMainBinding
import com.example.firstweatherapp.model.CurrentWeather
import com.example.firstweatherapp.viewModel.WeatherViewModel

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    val viewModel = WeatherViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //setObservers()
    }

    private fun setUpObservers() {
        viewModel.weather.observe(this,
            Observer<CurrentWeather> {
                val temperature = it.main?.temp
                val dateTime = System.currentTimeMillis()
                val description = it?.weather?.get(0)?.description

            })
    }
}