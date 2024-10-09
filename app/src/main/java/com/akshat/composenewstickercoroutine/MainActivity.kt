package com.akshat.composenewstickercoroutine

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.akshat.composenewstickercoroutine.navigation.NewsTickerNavigation
import com.akshat.composenewstickercoroutine.ui.theme.ComposeNewsTickerCoroutineTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeNewsTickerCoroutineTheme {
                NewsTickerApp()
            }
        }
    }
}

@Composable
fun NewsTickerApp() {
    Surface(color = MaterialTheme.colorScheme.background,
        modifier = Modifier.fillMaxSize(),
        content = {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                NewsTickerNavigation()
            }
        })
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeNewsTickerCoroutineTheme {
        NewsTickerApp()
    }
}