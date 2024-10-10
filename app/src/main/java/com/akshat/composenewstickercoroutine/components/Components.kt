package com.akshat.composenewstickercoroutine.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.akshat.composenewstickercoroutine.model.NewsArticle
import com.akshat.composenewstickercoroutine.utils.Constants

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsTickerAppBar(
    title: String,
    icon: ImageVector? = null,
    showProfile: Boolean = true,
    navController: NavController,
    elevation: Dp = 0.dp,
    onBackArrowClicked: () -> Unit = {}
) {

    TopAppBar(
        title = {
            Row(verticalAlignment = Alignment.CenterVertically) {

                if (icon != null){
                    Icon(imageVector = icon, contentDescription = "arrow back",
                        tint = Color.Red.copy(alpha = 0.7f),
                        modifier = Modifier.clickable { onBackArrowClicked.invoke() })

                }
                Spacer(modifier = Modifier.width(40.dp))

                Text(
                    text = title, color = Color.White, style = TextStyle(
                        fontWeight = FontWeight.Bold, fontSize = 17.sp
                    )
                )


            }
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = Constants.APP_BAR_THEME_COLOR),
    )

}

@Composable
fun NewsArticleRow(
    newsArticle: NewsArticle
) {

    Card(
        modifier = Modifier
            .padding(top = 6.dp)
            .fillMaxWidth()
            .height(350.dp)
            .wrapContentHeight()
            .clickable {},
        shape = RoundedCornerShape(corner = CornerSize(6.dp)),
        colors = CardColors(
            Color.White,
            Color.Black,
            Color.White,
            Color.White
        ),
        elevation = CardDefaults.cardElevation(6.dp)

    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {



            newsArticle.urlToImage?.let { NewsImage(imageUrl = it, newsArticle.author.toString()) }


            NewsDetails(newsArticle = newsArticle)
        }
    }


}

@Composable
fun NewsDetails(newsArticle: NewsArticle) {
    Column(
        modifier = Modifier
            .height(IntrinsicSize.Min)
            .padding(start = 8.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.Start
    ) {

        Row(modifier = Modifier.padding(4.dp)) {
            Text(
                text = newsArticle.title.toString(),
                modifier = Modifier.padding(end = 10.dp),
                style = MaterialTheme.typography.bodyLarge
            )
        }

        Row(modifier = Modifier.padding(8.dp)) {
            Text(
                text = newsArticle.publishedAt.toString(),
                modifier = Modifier.padding(end = 10.dp),
                color = Color.Blue,
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }

}

@Composable
fun NewsImage(imageUrl: String, title: String) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 8.dp)
            .background(Color(0f, 0f, 1f, 0.5f)),
        contentAlignment = Alignment.BottomStart
    ) {

        Image(
            painter = rememberAsyncImagePainter(imageUrl),
            contentDescription = "news image",
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp),
            contentScale = ContentScale.FillBounds
        )

        Text(
            text = title,
            modifier = Modifier.padding(start = 6.dp),
            color = Color.White,
            style = MaterialTheme.typography.headlineMedium
        )
    }
}
