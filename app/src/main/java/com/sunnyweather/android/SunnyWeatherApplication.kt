package com.sunnyweather.android

import android.app.Application
import android.content.Context

/**
 * @Author sy
 * @Date 2020/11/19-16:34
 * @Email 609188080@qq.com
 */
class SunnyWeatherApplication : Application() {
    companion object{
        const val TOKEN = "uEKdiPM0wfpahety"
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context = this
    }
}