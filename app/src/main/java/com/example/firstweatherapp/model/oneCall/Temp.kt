package com.example.firstweatherapp.model.oneCall


import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class Temp(
    val day: Double?,
    val min: Double?,
    val max: Double?,
    val night: Double?,
    val eve: Double?,
    val morn: Double?
) : Parcelable