package com.example.firstweatherapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.firstweatherapp.model.oneCall.WeatherOneCall
import com.example.firstweatherapp.dao.OneCallDao

@Database(entities = [WeatherOneCall::class], version = 1)
abstract class WeatherOneCallDatabase : RoomDatabase() {
    abstract fun wocDao(): OneCallDao

    companion object {
        private var INSTANCE: WeatherOneCallDatabase? = null
        private const val DB_NAME = "oneCall_v2.db"

        fun getDatabase(context: Context): WeatherOneCallDatabase {
            if (INSTANCE == null) {
                synchronized(WeatherOneCallDatabase::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(
                            context.applicationContext, WeatherOneCallDatabase::class.java, DB_NAME
                        ).build()

                    }
                }
            }

            return INSTANCE!!

        }
    }
}