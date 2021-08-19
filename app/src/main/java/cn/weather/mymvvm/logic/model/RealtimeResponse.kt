package cn.weather.mymvvm.logic.model

import com.google.gson.annotations.SerializedName

/**
 * =================================================
 * @author   qi ji
 * @date     2021/8/17 16:30
 * @Email:   534438777@qq.com
 * @Content:
 * =================================================
 */
data class RealtimeResponse(val status: String, val result: Result) {
    data class Result(val realtime: Realtime)

    data class Realtime(
        val skycon: String,
        val temperature: Float,
        @SerializedName("air_quality") val airQuality: AirQuality
    )

    data class AirQuality(val aqi: AQI)

    data class AQI(val chn: Float)


}