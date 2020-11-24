package com.sunnyweather.android.logic

import androidx.lifecycle.liveData
import com.sunnyweather.android.logic.model.Place
import com.sunnyweather.android.logic.network.SunnyWeatherNetwork
import kotlinx.coroutines.Dispatchers
import java.lang.Exception
import java.lang.RuntimeException

/**
 * @Author sy
 * @Date 2020/11/19-17:43
 * @Email 609188080@qq.com
 */
object Repository {
    fun searchPlaces(query: String) =
            liveData(Dispatchers.IO) {
                val result = try {
                    val placeResponse = SunnyWeatherNetwork.searchPlaces(query)
                    if (placeResponse.status == "ok") {
                        val places = placeResponse.places
                        Result.success<List<Place>>(places)
                    } else {
                        Result.failure<List<Place>>(RuntimeException("response status is ${placeResponse.status}"))
                    }
                } catch (e: Exception) {
                    Result.failure<List<Place>>(e)
                }
                emit(result)
            }
}