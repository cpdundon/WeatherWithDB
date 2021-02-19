package com.example.firstweatherapp.model.oneCall


import android.os.Parcelable
import androidx.room.*
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
@JsonClass(generateAdapter = true)
@Entity()
data class WeatherOneCall @JvmOverloads constructor(
    val lat: Double,
    val lon: Double,
    val timezone: String,
    @Json(name = "timezone_offset")
    val timezoneOffset: Long,
    @Ignore val current: Current = Current(
            0, 0, 0, 75.0, 0.0,
            0, 0, 0.0, 0.0, 0, 0,
            0.0, 0, mutableListOf()
    ),
    @Ignore val hourly: List<Hourly> = listOf(),
    @Ignore val daily: List<Daily> = listOf()
) : Parcelable
{
    @PrimaryKey(autoGenerate = false)
    var id: Long = 0
    var creationDateTime = System.currentTimeMillis()

    companion object {
        const val TABLE_NAME = "ONE_CALL"
        const val HOURLY_NAME = "hourly"
        const val DAILY_NAME = "daily"
        const val CURRENT_NAME = "current"
    }
}

