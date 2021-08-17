package com.cmhi.mymvvm.logic

import androidx.lifecycle.liveData
import com.cmhi.mymvvm.logic.model.PlaceResponse
import com.cmhi.mymvvm.logic.network.SunnyWeatherNetwork
import kotlinx.coroutines.Dispatchers

/**
 * =================================================
 * @author   qi ji
 * @date     2021/8/17 15:19
 * @Email:   534438777@qq.com
 * @Content:
 * =================================================
 */
object Repository {

    fun searchPlaces(query: String) = liveData(Dispatchers.IO) {
        val result = try {
            val placeResponse = SunnyWeatherNetwork.searchPlaces(query)
            if (placeResponse.status == "ok") {
                val places = placeResponse.places
                Result.success(places)
            } else {
                Result.failure(RuntimeException("response status is" +
                        "${placeResponse.status}"))
            }
        } catch (e: Exception) {
            Result.failure<List<PlaceResponse.Place>>(e)
        }
        emit(result)
    }

}