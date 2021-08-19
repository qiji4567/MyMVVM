package cn.weather.mymvvm.logic.network

import cn.weather.mymvvm.application.SunnyWeatherApplication
import cn.weather.mymvvm.logic.model.PlaceResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * =================================================
 * @author   qi ji
 * @date     2021/8/17 11:11
 * @Email:   534438777@qq.com
 * @Content:
 * =================================================
 */
interface PlaceService {

    @GET("v2/place?token=${SunnyWeatherApplication.TOKEN}&lang=zh_CN")
    fun searchPlaces(@Query("query") query: String):Call<PlaceResponse>

}