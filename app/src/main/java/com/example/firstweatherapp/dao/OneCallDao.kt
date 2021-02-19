package com.example.firstweatherapp.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.firstweatherapp.model.oneCall.WeatherOneCall

@Dao
interface OneCallDao {
    @Query("SELECT * FROM WeatherOneCall LIMIT 1")
    suspend fun findOneCall(): WeatherOneCall?

//    @Query("SELECT * FROM ONE_CALL WHERE full_name = :fullName LIMIT 1")
//    suspend fun findDirectorByName(fullName: String?): Director?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(oneCall: WeatherOneCall): Long

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(vararg oneCalls: WeatherOneCall)

    @Update(onConflict = OnConflictStrategy.IGNORE)
    suspend fun update(oneCall: WeatherOneCall)

    @Query("DELETE FROM WeatherOneCall")
    suspend fun deleteAll()

//    @Query("SELECT * FROM WeatherOneCall ORDER BY id DESC")
//    suspend fun findAll(): LiveData<List<WeatherOneCall>>
}
