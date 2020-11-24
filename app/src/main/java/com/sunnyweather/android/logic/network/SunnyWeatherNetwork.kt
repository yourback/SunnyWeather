package com.sunnyweather.android.logic.network

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.RuntimeException
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

/**
 * @Author sy
 * @Date 2020/11/19-17:20
 * @Email 609188080@qq.com
 */
object SunnyWeatherNetwork {
//    private val placeService = ServiceCreator.create(PlaceService::class.java)
    private val placeService = ServiceCreator.create<PlaceService>()

    private suspend fun <T> Call<T>.await(): T {
        return suspendCoroutine { continuation ->
            enqueue(object : Callback<T> {
                override fun onFailure(call: Call<T>, t: Throwable) {
                    continuation.resumeWithException(t)
                }

                override fun onResponse(call: Call<T>, response: Response<T>) {
                    val body = response.body()
                    if (body != null) continuation.resume(body)
                    else continuation.resumeWithException(RuntimeException("response body is null"))
                }

            })
        }
    }

    suspend fun searchPlaces(query: String) = placeService.searchPlaces(query).await()
}