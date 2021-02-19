package com.example.firstweatherapp.model.oneCall


import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class Weather(
    val id: Long?,
    val main: String?,
    val description: String?,
    val icon: String?
) : Parcelable