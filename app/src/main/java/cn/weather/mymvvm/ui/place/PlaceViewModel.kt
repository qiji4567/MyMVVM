package cn.weather.mymvvm.ui.place

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import cn.weather.mymvvm.logic.Repository
import cn.weather.mymvvm.logic.model.Place

/**
 * =================================================
 * @author   qi ji
 * @date     2021/8/17 11:43
 * @Email:   534438777@qq.com
 * @Content:
 * =================================================
 */
class PlaceViewModel : ViewModel() {



    private val searchLiveData = MutableLiveData<String>()

    val placeList = ArrayList<Place>()

    val placeLiveData = Transformations.switchMap(searchLiveData) {
            query -> Repository.searchPlaces(query)
    }

    fun searchPlaces(query: String) {
        searchLiveData.value = query
    }



    fun savePlace(place: Place) = Repository.savePlace(place)

    fun getSavedPlace() = Repository.getSavedPlace()

    fun isPlaceSaved() = Repository.isPlaceSaved()



}