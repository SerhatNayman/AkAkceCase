package com.serosoft.akakcecase.data.entity


import com.google.gson.annotations.SerializedName

data class DetailResponse(
    @SerializedName("result")
    val result: ResultDetail?
)