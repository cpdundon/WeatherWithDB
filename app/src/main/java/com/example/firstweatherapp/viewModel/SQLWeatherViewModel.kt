package com.example.firstweatherapp.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.firstweatherapp.database.WeatherOneCallDatabase
import com.example.firstweatherapp.model.oneCall.WeatherOneCall
import com.example.firstweatherapp.dao.OneCallDao

class SQLWeatherViewModel (application: Application) : AndroidViewModel(application) {
//
//    private val weatherDao: OneCallDao = WeatherOneCallDatabase.getDatabase(application).wocDao()
//
//    private val _oneCallDB = MutableLiveData<WeatherOneCall>()
//    val oneCallDB: LiveData<WeatherOneCall>
//        get() = _oneCallDB
//
//        init {
//            _oneCallDB = weatherDao.
//        }
//
//        suspend fun insert(vararg directors: Director) {
//            directorDao.insert(*directors)
//        }
//
//        suspend fun update(director: Director) {
//            directorDao.update(director)
//        }
//
//        suspend fun deleteAll() {
//            directorDao.deleteAll()
//        }
//    }

}