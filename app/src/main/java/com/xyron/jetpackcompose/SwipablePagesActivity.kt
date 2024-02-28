package com.xyron.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.xyron.jetpackcompose.ui.theme.JetpackComposeTheme


class SwipablePagesActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTheme {
                SwipablePages()
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SwipablePages() {
    val animal = listOf(
        R.drawable.ic_launcher_background,
        R.drawable.ic_launcher_background,
        R.drawable.ic_launcher_background
    )


    Box(
        modifier = Modifier. fillMaxSize()
    ){
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview6() {
    JetpackComposeTheme {
        SwipablePages()
    }
}