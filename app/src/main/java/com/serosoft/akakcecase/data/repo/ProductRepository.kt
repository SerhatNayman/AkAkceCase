package com.serosoft.akakcecase.data.repo

import androidx.lifecycle.MutableLiveData
import com.serosoft.akakcecase.data.entity.*
import com.serosoft.akakcecase.retrofit.ProductApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ProductRepository(private var productApiService: ProductApiService) {

    val productList = MutableLiveData<List<Product>?>()
    val productListHorizontal = MutableLiveData<List<Product>?>()
    val productDetail = MutableLiveData<ResultDetail?>()

    fun getProduct() {
        productApiService.allProducts().enqueue(object : Callback<ProductResponse> {

            override fun onResponse(
                call: Call<ProductResponse>,
                response: Response<ProductResponse>
            ) {
                response.body()!!.result.products.let { products ->

                    if (response.isSuccessful) {
                        productList.value = products
                    }
                    response.body()?.result?.horizontalProducts.let { horizontalProducts ->

                        if (response.isSuccessful) {
                            productListHorizontal.value = horizontalProducts
                        }
                    }
                }
            }

            override fun onFailure(call: Call<ProductResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })

        productApiService.nextUrl().enqueue(object : Callback<ProductResponse> {

            override fun onResponse(
                call: Call<ProductResponse>,
                response: Response<ProductResponse>
            ) {
                response.body()!!.result.nextUrl.let {

                    val list = response.body()
                    list?.result?.nextUrl?.let { url ->
                        if (response.isSuccessful) {

                        }
                    }
                }
            }

            override fun onFailure(call: Call<ProductResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }


    fun getProducts(): MutableLiveData<List<Product>?> {
        return productList
    }

    fun getHorizontalProducts(): MutableLiveData<List<Product>?> {
        return productListHorizontal
    }

    fun getDetailProduct(): MutableLiveData<ResultDetail?> {
        return productDetail
    }

    fun getDetail(code:Int) {
        productApiService.getProductDetail(code).enqueue(object :Callback<DetailResponse>{

            override fun onResponse(
                call: Call<DetailResponse>,
                response: Response<DetailResponse>
            ) {
                response.body()?.result?.let { result ->
                    productDetail.value = result
                }
            }

            override fun onFailure(call: Call<DetailResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
}