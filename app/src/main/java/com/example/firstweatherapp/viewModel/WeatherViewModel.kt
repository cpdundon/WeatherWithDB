package com.example.firstweatherapp.viewModel

import android.content.Context
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.firstweatherapp.model.CurrentWeather
import com.example.firstweatherapp.model.oneCall.WeatherOneCall
import com.example.firstweatherapp.repo.WeatherRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WeatherViewModel : ViewModel() {
    companion object {
        private const val TAG = "WeatherViewModel"
        private const val DELAY_TEN_MIN = 1000 * 60 * 10
        private const val DELAY_QUARTER_MIN = 1000 * 15
        private const val DELAY_ONE_MIN = 1000 * 60
    }

    private val _weather = MutableLiveData<CurrentWeather>()
    private val _oneCall = MutableLiveData<WeatherOneCall>()

    val weather: LiveData<CurrentWeather>
        get() = _weather

    val oneCall: LiveData<WeatherOneCall>
        get() = _oneCall


    init {
        //fetchWeather("Mineola,NY,USA", "Imperial", "6eb589c3b7d362f55bb5f42759e23021")
    }

    fun fetchWeather(location: String, units: String, appid: String) {

        viewModelScope.launch(Dispatchers.IO) {
            val weather = WeatherRepo.getWeather(location, units, appid)
            _weather.postValue(weather.body())
        }
    }

    fun fetchWeatherOneCall(lat: Double, long: Double, units: String, appid: String, context: Context)
    {
        viewModelScope.launch(Dispatchers.IO) {
            var oneCall = WeatherRepo.getWeatherOneCall(lat, long, units, appid, context, false)
            val time = oneCall?.creationDateTime
            if ((oneCall == null) || (System.currentTimeMillis() - (time?:0) > DELAY_ONE_MIN)) {
                oneCall = WeatherRepo.getWeatherOneCall(lat, long, units, appid, context, true)

                if (oneCall != null) _oneCall.postValue(oneCall!!)
                updateOneCall(context)
            } else {
                if (oneCall != null) _oneCall.postValue(oneCall!!)
            }
        }
    }

    fun updateOneCall(context: Context) {
        viewModelScope.launch(Dispatchers.IO) {
            if (oneCall.value != null) {
                val rtn = WeatherRepo.saveOneCall(oneCall.value!!, context)
            }
        }
    }

}