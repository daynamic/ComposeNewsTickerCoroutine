package com.akshat.composenewstickercoroutine.screens

import android.util.Log
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Observer
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.navigation.NavHostController
import com.akshat.composenewstickercoroutine.components.NewsArticleRow
import com.akshat.composenewstickercoroutine.components.NewsTickerAppBar
import com.akshat.composenewstickercoroutine.model.NewsArticle
import kotlinx.coroutines.flow.MutableStateFlow

@Composable
fun NewsTickerHomeScreen(navController: NavHostController, viewModel: HomeScreenViewModel) {
    Scaffold(topBar = {
        NewsTickerAppBar(title = "News Ticker App",
            navController = navController)
    }) {
        Surface(
            modifier = Modifier
                .padding(top = it.calculateTopPadding())
                .fillMaxSize()
        ) {
            val lifecycleOwner = LocalLifecycleOwner.current

            var _newsList = remember { MutableStateFlow(emptyList<NewsArticle>()) }
            val newsList by remember { _newsList }.collectAsState()
            val newList : ArrayList<NewsArticle> = ArrayList()

           viewModel.newsArticles.observe( lifecycleOwner, Observer { article ->
               newList.add(0, article)
               _newsList.value += article
               Log.d("TRACK", "response is ${_newsList.value}")
           })

            MainContent(newsList)

        }
    }
}


@Composable
fun MainContent(text: List<NewsArticle>) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        color = Color(0xFFEEF1EF)
    ) {
        LazyColumn(
            modifier = Modifier.padding(2.dp),
            contentPadding = PaddingValues(1.dp)
        ) {

            items(text.size) { it ->
                NewsArticleRow(text[it])
            }

        }

    }
}

