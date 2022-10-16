package com.serosoft.akakcecase.retrofit

import com.serosoft.akakcecase.data.entity.DetailResponse
import com.serosoft.akakcecase.data.entity.ProductResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ProductApiService {

    @GET("59906f35-d5d5-40f7-8d44-53fd26eb3a05")
    fun allProducts(): Call<ProductResponse>

    @GET("59906f35-d5d5-40f7-8d44-53fd26eb3a05")
    fun nextUrl(): Call<ProductResponse>

    @GET("1a1fb542-22d1-4919-914a-750114879775")
    fun getProductDetail(@Query("code") code: Int): Call<DetailResponse>

}