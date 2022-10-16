package com.serosoft.akakcecase.data.entity


import com.google.gson.annotations.SerializedName

data class Product(
    @SerializedName("code")
    val code: Int?,
    @SerializedName("countOfPrices")
    val countOfPrices: Int?,
    @SerializedName("dropRatio")
    val dropRatio: Double?,
    @SerializedName("followCount")
    val followCount: Int?,
    @SerializedName("imageUrl")
    val imageUrl: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("price")
    val price: Double?
) :java.io.Serializable{

}