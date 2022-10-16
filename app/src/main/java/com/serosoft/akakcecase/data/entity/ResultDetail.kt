package com.serosoft.akakcecase.data.entity

import com.google.gson.annotations.SerializedName

data class ResultDetail(
    @SerializedName("badge")
    val badge: String?,
    @SerializedName("countOfPrices")
    val countOfPrices: Int?,
    @SerializedName("freeShipping")
    val freeShipping: Boolean?,
    @SerializedName("imageUrl")
    val imageUrl: String?,
    @SerializedName("lastUpdate")
    val lastUpdate: String?,
    @SerializedName("mkName")
    val mkName: String?,
    @SerializedName("price")
    val price: Int?,
    @SerializedName("productName")
    val productName: String?,
    @SerializedName("rating")
    val rating: Double?,
    @SerializedName("storageOptions")
    val storageOptions: List<String?>?
)
