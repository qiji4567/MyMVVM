package com.cmhi.mymvvm.logic.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * =================================================
 * @author   qi ji
 * @date     2021/8/17 11:15
 * @Email:   534438777@qq.com
 * @Content:
 * =================================================
 */
object ServiceCreator {
    private const val BASE_URL = "https://api.caiyunapp.com/"

    //        初始化OKhttp
    var okHttpClient = OkHttpClient()
        .newBuilder()
        .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun <T> create(serviceClass: Class<T>): T = retrofit.create(serviceClass)
    inline  fun <reified T> create():T = create(T::class.java)

}