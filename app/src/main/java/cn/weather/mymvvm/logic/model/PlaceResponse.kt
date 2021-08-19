package cn.weather.mymvvm.logic.model

import com.google.gson.annotations.SerializedName

/**
 * =================================================
 * @author   qi ji
 * @date     2021/8/17 11:02
 * @Email:   534438777@qq.com
 * @Content:
 * =================================================
 */


class PlaceResponse(val status: String, val places: List<Place>)


class Place(
    val name: String,
    val location: Location,
    @SerializedName("formatted_address") val address: String
)

class Location(val lng: String, val lat: String)




