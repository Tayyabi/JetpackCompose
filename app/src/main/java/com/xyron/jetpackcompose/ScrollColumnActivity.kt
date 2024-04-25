package com.xyron.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.xyron.jetpackcompose.ui.theme.JetpackComposeTheme

class ScrollColumnActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ScrollColumn()
                }
            }
        }
    }
}

@Composable
fun ScrollColumn() {

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {

        Column (
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.LightGray)
                .height(180.dp)
        ){

        }

        Column {

            Column(
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .weight(1f)
                    .padding(start = 20.dp, end = 20.dp, top = 50.dp)
                    .clip(RoundedCornerShape(14.dp))
                    .background(Color.White)
                    .padding(bottom = 20.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                repeat(20) {
                    Text(
                        text = "Index $it",
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.Red)
                            .padding(40.dp),
                        textAlign = TextAlign.Center
                    )
                }
            }

            Row(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
                    .height(100.dp)
            ) {

            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview8() {
    JetpackComposeTheme {
        ScrollColumn()
    }
}