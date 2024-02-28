package com.xyron.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.xyron.jetpackcompose.ui.theme.JetpackComposeTheme
import kotlinx.coroutines.launch
import java.util.UUID

val category = Category(UUID.randomUUID(), "Hello", "Hello Image")
val animals = listOf(
    Deal(category, "Hello"),
    Deal(category, "Hello 1"),
    Deal(category, "Hello 2"),
    Deal(category, "Hello 3"),
    Deal(category, "Hello 4"),
)

class AccompanistPagerActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTheme {


                HorizontalPagerWithIndicators(animals)

            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HorizontalPagerWithIndicators(deals: List<Deal>) {

    val pagerState = rememberPagerState(pageCount = { deals.size })
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        HorizontalPager(
            state = pagerState,
            contentPadding = PaddingValues(horizontal = 20.dp),
            pageSpacing = 10.dp
        ) { page ->
            DisplayDeal(deal = deals[page])

        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize(Alignment.Center)
                .padding(top = 10.dp)
        ) {
            HorizontalPagerIndicator(
                pageCount = deals.size,
                pagerState = pagerState,
                modifier = Modifier
                    .clickable {

                        val currentPage = pagerState.currentPage
                        val totalPages = deals.size
                        val nextPage =
                            if (currentPage < totalPages - 1)
                                currentPage + 1
                            else
                                0

                        coroutineScope.launch { pagerState.animateScrollToPage(nextPage) }

                    }

            )
        }

        LaunchedEffect(pagerState) {
            snapshotFlow { pagerState.currentPage }
                .collect { currentPage ->
                    pagerState.animateScrollToPage(currentPage)
                }
        }
    }

}

@Composable
fun DisplayDeal(deal: Deal) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .background(Color.Red),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = deal.dealValue,
            color = Color.White,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(8.dp)
                .background(Color.Black)
                .padding(horizontal = 4.dp, vertical = 2.dp)
        )
    }

}


@Preview(showBackground = true)
@Composable
fun HorizontalPagerWithIndicatorsPreview() {
    JetpackComposeTheme {
        HorizontalPagerWithIndicators(animals)
    }
}