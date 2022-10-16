package com.serosoft.akakcecase.data.entity


import com.google.gson.annotations.SerializedName

data class ProductResponse(
    @SerializedName("result")
    val result: Result
)