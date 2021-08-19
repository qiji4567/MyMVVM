package cn.weather.mymvvm.logic.dao

import android.content.Context
import androidx.core.content.edit
import cn.weather.mymvvm.application.SunnyWeatherApplication
import cn.weather.mymvvm.logic.model.Place
import com.google.gson.Gson

/**
 * =================================================
 * @author   qi ji
 * @date     2021/8/18 13:42
 * @Email:   534438777@qq.com
 * @Content:
 * =================================================
 */
object PlaceDao {

    fun savePlace(place: Place) {
        sharedPreferences().edit {
            putString("place", Gson().toJson(place))
        }
    }

    fun getSavedPlace(): Place {
        val placeJson = sharedPreferences().getString("place", "")
        return Gson().fromJson(placeJson, Place::class.java)
    }

    fun isPlaceSaved() = sharedPreferences().contains("place")

    private fun sharedPreferences() = SunnyWeatherApplication.context
        .getSharedPreferences("sunny_weather", Context.MODE_PRIVATE)
}