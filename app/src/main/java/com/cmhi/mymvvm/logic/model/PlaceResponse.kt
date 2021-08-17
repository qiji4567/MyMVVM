package com.cmhi.mymvvm.logic.model

import android.location.Address
import android.location.Location
import com.google.gson.annotations.SerializedName
import java.sql.ClientInfoStatus

/**
 * =================================================
 * @author   qi ji
 * @date     2021/8/17 11:02
 * @Email:   534438777@qq.com
 * @Content:
 * =================================================
 */
class PlaceResponse {

    data class PlaceResponse(val status: String, val places: List<Place>)

    data class Place(
        val name: String,
        val location: Location,
        @SerializedName("formatted_address") val address: String
    )

    data class Location(val long: String, val lat: String)

}





