package com.akshat.composenewstickercoroutine.di

import com.akshat.composenewstickercoroutine.network.NewsService
import com.akshat.composenewstickercoroutine.repository.NewsRepository
import com.akshat.composenewstickercoroutine.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideNewsRepository(api: NewsService)
    = NewsRepository(api)

    @Singleton
    @Provides
    fun providesNewsApi() : NewsService {
        return Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build().create(NewsService::class.java)
    }

}