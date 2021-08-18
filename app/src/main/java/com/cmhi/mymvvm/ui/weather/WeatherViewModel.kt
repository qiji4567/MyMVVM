package com.cmhi.mymvvm.ui.weather

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.cmhi.mymvvm.logic.Repository
import com.cmhi.mymvvm.logic.model.Location
import com.cmhi.mymvvm.logic.model.PlaceResponse

/**
 * =================================================
 * @author   qi ji
 * @date     2021/8/17 18:06
 * @Email:   534438777@qq.com
 * @Content:
 * =================================================
 */
class WeatherViewModel:ViewModel() {

    private val locationLiveData = MutableLiveData<Location>()

    var locationLng=""
    var locationLat=""
    var placeName=""
    val weatherLiveData = Transformations.switchMap(locationLiveData){
        location -> Repository.refreshWeather(location.lng,location.lat)
    }

    fun refreshWeather(lng:String,lat:String){
        locationLiveData.value = Location(lng, lat)
    }

}