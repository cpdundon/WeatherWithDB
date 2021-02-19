package com.example.firstweatherapp.model.oneCall


import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class Daily(
    val dt: Long?,
    val sunrise: Int?,
    val sunset: Int?,
    val temp: Temp?,
    @Json(name = "feels_like")
    val feelsLike: FeelsLike?,
    val pressure: Int?,
    val humidity: Int?,
    @Json(name = "dew_point")
    val dewPoint: Double?,
    @Json(name = "wind_speed")
    val windSpeed: Double?,
    @Json(name = "wind_deg")
    val windDeg: Int?,
    val weather: List<Weather>?,
    val clouds: Int?,
    val pop: Double?,
    val uvi: Double?,
    val rain: Double?,
    val snow: Double?
) : Parcelable