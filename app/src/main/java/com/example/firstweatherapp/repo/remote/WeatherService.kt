package com.example.firstweatherapp.repo.remote

import com.example.firstweatherapp.model.CurrentWeather
import com.example.firstweatherapp.model.oneCall.WeatherOneCall
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {
    @GET("weather")
    suspend fun getWeather (@Query("q") location: String, @Query("units") units: String, @Query("appid") appid: String): Response<CurrentWeather>

    @GET("onecall")
    suspend fun getWeatherOneCall (@Query("lat") lat: Double, @Query("lon") long: Double, @Query("units") units: String, @Query("appid") appid: String): Response<WeatherOneCall>
}