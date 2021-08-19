package cn.weather.mymvvm.ui.weather

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import cn.weather.mymvvm.logic.Repository
import cn.weather.mymvvm.logic.model.Location
import cn.weather.mymvvm.logic.model.PlaceResponse

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