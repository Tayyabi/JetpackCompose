package com.xyron.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.LocalOverscrollConfiguration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.xyron.jetpackcompose.ui.theme.JetpackComposeTheme

class ScrollPagerActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTheme {
                ScrollPager()
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ScrollPager() {

    val list = listOf(
        "Banner 1",
        "Banner 2",
        "Banner 3",
        "Banner 4",
        "Banner 5",
        "Banner 6",
    )

    val pagerState = rememberPagerState(pageCount = { list.size })

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center
    ){

        CompositionLocalProvider( LocalOverscrollConfiguration provides null) {

            HorizontalPager(
                modifier = Modifier.height(150.dp),
                pageSpacing = 15.dp,
                contentPadding = PaddingValues(horizontal = 40.dp),
                state = pagerState
            ){page ->

                list.getOrNull(
                    page % (list.size)
                )?.let { content ->
                    BannerItemView(content = content)
                }
            }

        }
        
    }

}

@Composable
private fun BannerItemView(content: String){

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Cyan),
        contentAlignment = Alignment.Center
    ){
        Text(
            text = content,
            fontWeight = FontWeight.Bold,
            color = Color.DarkGray,
            fontSize = 25.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ScrollPagerPreview() {
    JetpackComposeTheme {
        ScrollPager()
    }
}