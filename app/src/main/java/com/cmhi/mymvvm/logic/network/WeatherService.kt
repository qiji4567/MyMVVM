package com.cmhi.mymvvm.logic.network

import com.cmhi.mymvvm.application.SunnyWeatherApplication
import com.cmhi.mymvvm.logic.model.DailyResponse
import com.cmhi.mymvvm.logic.model.RealtimeResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * =================================================
 * @author   qi ji
 * @date     2021/8/17 16:42
 * @Email:   534438777@qq.com
 * @Content:
 * =================================================
 */
interface WeatherService {
    @GET("v2.5/${SunnyWeatherApplication.TOKEN}/{lng},{lat}/realtime.json")
    fun getRealtimeWeather(@Path("lng") lng: String, @Path("lat") lat: String): Call<RealtimeResponse>

    @GET("v2.5/${SunnyWeatherApplication.TOKEN}/{lng},{lat}/daily.json")
    fun getDailyWeather(@Path("lng") lng: String, @Path("lat") lat: String): Call<DailyResponse>
}