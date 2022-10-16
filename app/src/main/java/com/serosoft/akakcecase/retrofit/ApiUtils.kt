package com.serosoft.akakcecase.retrofit

class ApiUtils {
    companion object {
        val BASE_URL = "https://mocki.io/v1/"

        fun getProductApiService(): ProductApiService {
            return RetrofitClient.getClient(BASE_URL).create(ProductApiService::class.java)
        }

    }
}