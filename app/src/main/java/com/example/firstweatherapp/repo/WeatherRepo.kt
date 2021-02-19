package com.example.firstweatherapp.repo

import android.content.Context
import androidx.core.content.ContentProviderCompat.requireContext
import com.example.countrieskotlin.repo.remote.WeatherRetroInstance
import com.example.firstweatherapp.database.WeatherOneCallDatabase
import com.example.firstweatherapp.model.CurrentWeather
import com.example.firstweatherapp.model.oneCall.WeatherOneCall
import retrofit2.Response

object WeatherRepo {
    suspend fun getWeather(
        location: String,
        units: String,
        appid: String
    ): Response<CurrentWeather> {
        return WeatherRetroInstance.weatherService.getWeather(location, units, appid)
    }

    suspend fun getWeatherOneCall(
        lat: Double,
        long: Double,
        units: String,
        appid: String,
        context: Context,
        isAPICall: Boolean
    ): WeatherOneCall? {
        return if (isAPICall) {
            WeatherRetroInstance.weatherService.getWeatherOneCall(lat, long, units, appid).body()
        } else {
            WeatherOneCallDatabase.getDatabase(context).wocDao().findOneCall()
        }
    }

    suspend fun saveOneCall(oneCall: WeatherOneCall, context: Context) : Long {
        val weatherDao = WeatherOneCallDatabase.getDatabase(context).wocDao()
        return weatherDao.insert(oneCall)
    }
}

