package com.example.firstweatherapp.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Sys(
    val type: Int?,
    val id: Int?,
    val country: String?,
    val sunrise: Int?,
    val sunset: Int?
)