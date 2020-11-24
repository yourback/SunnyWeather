package com.sunnyweather.android.logic.model

import com.google.gson.annotations.SerializedName

/**
 * @Author sy
 * @Date 2020/11/19-16:36
 * @Email 609188080@qq.com
 */

// 返回值
data class PlaceResponse(
        val status: String,
        val places: List<Place>
)

// 返回值：地方
data class Place(
        val name: String,
        val location: Location,
        @SerializedName("formatted_address")
        val address: String)

// 经纬度
data class Location(val lng: String, val lat: String)