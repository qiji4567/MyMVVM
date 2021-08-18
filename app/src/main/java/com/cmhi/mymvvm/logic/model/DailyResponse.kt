package com.cmhi.mymvvm.logic.model

import com.google.gson.annotations.SerializedName
import java.util.*

/**
 * =================================================
 * @author   qi ji
 * @date     2021/8/17 16:39
 * @Email:   534438777@qq.com
 * @Content:
 * =================================================
 */
data class DailyResponse(val status: String, val result: Result) {

    data class Result(val daily: Daily)

    data class Daily(val temperature: List<Temperature>, val skycon: List<Skycon>, @SerializedName("life_index") val lifeIndex: LifeIndex)

    data class Temperature(val max: Float, val min: Float)

    data class Skycon(val value: String, val date: Date)

    data class LifeIndex(val coldRisk: List<LifeDescription>, val carWashing: List<LifeDescription>, val ultraviolet: List<LifeDescription>, val dressing: List<LifeDescription>)

    data class LifeDescription(val desc: String)
}