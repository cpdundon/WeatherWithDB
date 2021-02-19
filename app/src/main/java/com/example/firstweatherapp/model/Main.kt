package com.example.firstweatherapp.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Main(
    val temp: Double?,
    @Json(name = "feels_like")
    val feelsLike: Double?,
    @Json(name = "temp_min")
    val tempMin: Double?,
    @Json(name = "temp_max")
    val tempMax: Double?,
    val pressure: Int?,
    val humidity: Int?
)