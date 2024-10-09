package com.akshat.composenewstickercoroutine.network

import com.akshat.composenewstickercoroutine.model.NewsArticle
import retrofit2.http.GET
import javax.inject.Singleton

@Singleton
interface NewsService {
    @GET("news.json")
    suspend fun getNews(): List<NewsArticle>
}