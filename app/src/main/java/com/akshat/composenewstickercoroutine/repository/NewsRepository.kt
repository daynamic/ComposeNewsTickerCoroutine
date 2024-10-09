package com.akshat.composenewstickercoroutine.repository

import com.akshat.composenewstickercoroutine.model.NewsArticle
import com.akshat.composenewstickercoroutine.network.NewsService
import com.akshat.composenewstickercoroutine.utils.Constants
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class NewsRepository @Inject constructor(private val api: NewsService) {

    fun getNewsArticles(): Flow<NewsArticle> {
        return flow {
            var newsSource = api.getNews()
            newsSource.forEach {
                emit(it)
                kotlinx.coroutines.delay(Constants.NEWS_DELAY)
            }
        }
    }
}