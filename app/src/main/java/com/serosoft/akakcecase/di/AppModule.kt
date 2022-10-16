package com.serosoft.akakcecase.di

import com.serosoft.akakcecase.data.repo.ProductRepository
import com.serosoft.akakcecase.retrofit.ApiUtils
import com.serosoft.akakcecase.retrofit.ProductApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideProductApiService(): ProductApiService {
        return ApiUtils.getProductApiService()
    }

    @Provides
    @Singleton
    fun provideProductRepository(productApiService: ProductApiService): ProductRepository {
        return ProductRepository(productApiService)
    }


}