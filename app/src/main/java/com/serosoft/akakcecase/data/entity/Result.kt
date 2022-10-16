package com.serosoft.akakcecase.data.entity


import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("horizontalProducts")
    val horizontalProducts: List<HorizontalProduct>,
    @SerializedName("nextUrl")
    val nextUrl: String,
    @SerializedName("products")
    val products: List<Product>
)