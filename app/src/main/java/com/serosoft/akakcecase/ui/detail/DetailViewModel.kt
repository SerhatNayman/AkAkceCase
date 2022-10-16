package com.serosoft.akakcecase.ui.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.serosoft.akakcecase.data.entity.ResultDetail
import com.serosoft.akakcecase.data.repo.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private var productRepository: ProductRepository) :
    ViewModel() {

    var detailProduct = MutableLiveData<ResultDetail?>()

    fun getDetailProduct(code: Int) {
        productRepository.getDetail(code)
        detailProduct = productRepository.getDetailProduct()
    }
}