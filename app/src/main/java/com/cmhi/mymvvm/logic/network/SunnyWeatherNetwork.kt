package com.cmhi.mymvvm.logic.network

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.await
import java.lang.RuntimeException
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

/**
 * =================================================
 * @author   qi ji
 * @date     2021/8/17 11:20
 * @Email:   534438777@qq.com
 * @Content:
 * =================================================
 */
object SunnyWeatherNetwork {

    private val placeService = ServiceCreator.create<PlaceService>()

    suspend fun searchPlaces(query: String) = placeService.searchPlaces(query)
        .await()


    private suspend fun <T> Call<T>.await(): T{
        return suspendCoroutine { continuation ->
            enqueue(object :Callback<T>{
                override fun onResponse(call: Call<T>, response: Response<T>) {
                    val body = response.body()
                    if (body!=null)continuation.resume(body)
                    else continuation.resumeWithException(RuntimeException(" response body is null "))
                }

                override fun onFailure(call: Call<T>, t: Throwable) {

                    continuation.resumeWithException(t)

                }
            })
        }
    }

}