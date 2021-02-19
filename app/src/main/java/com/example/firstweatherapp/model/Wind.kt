package com.example.firstweatherapp.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Wind(
    val speed: Double?,
    val deg: Int?
)