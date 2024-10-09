package com.akshat.composenewstickercoroutine.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
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