package cn.weather.mymvvm.application

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

/**
 * =================================================
 * @author   qi ji
 * @date     2021/8/17 10:57
 * @Email:   534438777@qq.com
 * @Content:
 * =================================================
 */
class SunnyWeatherApplication : Application() {

    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context
        const val TOKEN = "BNBRvBveaD2VfHVI"
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }


}