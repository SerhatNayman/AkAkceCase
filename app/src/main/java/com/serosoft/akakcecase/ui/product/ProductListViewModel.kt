package com.serosoft.akakcecase.ui.product

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.serosoft.akakcecase.data.entity.HorizontalProduct
import com.serosoft.akakcecase.data.entity.Product
import com.serosoft.akakcecase.data.entity.ProductResponse
import com.serosoft.akakcecase.data.repo.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProductListViewModel @Inject constructor(var productRepository: ProductRepository) :
    ViewModel() {
    var productList = MutableLiveData<List<Product>?>()
    var horizontalProductList = MutableLiveData<List<HorizontalProduct>?>()

    init {
        getProduct()
        productList = productRepository.getProducts()
        horizontalProductList = productRepository.getHorizontalProducts()

    }

    fun getProduct() {
        productRepository.getProduct()
    }


}