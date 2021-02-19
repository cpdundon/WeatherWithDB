package com.example.firstweatherapp.model.oneCall


import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class Hourly(
    val dt: Int?,
    val temp: Double?,
    @Json(name = "feels_like")
    val feelsLike: Double?,
    val pressure: Int?,
    val humidity: Int?,
    @Json(name = "dew_point")
    val dewPoint: Double?,
    val uvi: Double?,
    val clouds: Int?,
    val visibility: Int?,
    @Json(name = "wind_speed")
    val windSpeed: Double?,
    @Json(name = "wind_deg")
    val windDeg: Int?,
    val weather: List<Weather>?,
    val pop: Double?,
    val snow: Snow?,
    val rain: Rain?
) : Parcelable