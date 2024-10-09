package com.akshat.composenewstickercoroutine.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.akshat.composenewstickercoroutine.repository.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class HomeScreenViewModel @Inject constructor(private val repository: NewsRepository) : ViewModel() {

    val newsArticles = repository.getNewsArticles().asLiveData()


}