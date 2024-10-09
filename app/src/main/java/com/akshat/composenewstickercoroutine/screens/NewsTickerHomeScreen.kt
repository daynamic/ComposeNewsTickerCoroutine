package com.akshat.composenewstickercoroutine.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.Observer
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.navigation.NavHostController
import com.akshat.composenewstickercoroutine.components.NewsTickerAppBar

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
            var text by remember {
                mutableStateOf("")
            }

           viewModel.newsArticles.observe( lifecycleOwner, Observer { article ->
               text = article.toString()
           })

            Text("Text is $text")

        }
    }
}