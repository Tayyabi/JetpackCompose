package com.xyron.jetpackcompose

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.AsyncImage
import coil.imageLoader
import com.xyron.jetpackcompose.ui.theme.JetpackComposeTheme

class CoilImageCachingActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTheme {
                CoilImageCaching(applicationContext)

            }
        }
    }
}

@OptIn(ExperimentalCoilApi::class)
@Composable
fun CoilImageCaching(context: Context) {

    val imageUrl = "https://images.barcodelookup.com/81580/815809095-1.jpg"

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        AsyncImage(
            model = imageUrl,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1280f / 847f)
        )

        Spacer(Modifier.height(20.dp))

        Button(
            onClick = {
                context.imageLoader.diskCache?.remove(imageUrl)
                context.imageLoader.memoryCache?.clear()
            }
        ){
            Text(text = "Clear Cache")
        }
    }
}

/*
@Preview(showBackground = true)
@Composable
fun CoilImageCachingPreview() {
    JetpackComposeTheme {
        CoilImageCaching()
    }
}*/
