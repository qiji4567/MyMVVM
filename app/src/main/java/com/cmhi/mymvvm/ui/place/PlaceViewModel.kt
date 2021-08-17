package com.cmhi.mymvvm.ui.place

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.cmhi.mymvvm.logic.Repository
import com.cmhi.mymvvm.logic.model.PlaceResponse

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

    val placeList = ArrayList<PlaceResponse.Place>()

    val placeLiveData = Transformations.switchMap(searchLiveData) { query ->
        Repository.searchPlaces(query)
    }

    fun searchPlaces(query: String) {
        searchLiveData.value = query
    }

//    fun savePlace(place: PlaceResponse.Place) = Repository.savePlace(place)
//
//    fun getSavedPlace() = Repository.getSavedPlace()
//
//    fun isPlaceSaved() = Repository.isPlaceSaved()



}