package com.xyron.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val painter = painterResource(id = R.drawable.ic_launcher_background)
            val description = "Kermit in the snow"
            val title = "Kermit is playing"

            Box(modifier = Modifier.fillMaxWidth(0.5f)){
                ImageCard(
                    painter = painter,
                    contentDescription = description,
                    title = title)
            }

        }
    }
}


@Composable
fun ImageCard(
    painter: Painter,
    contentDescription: String,
    title: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(15.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        )
    ) {

        Box(modifier = Modifier.height(200.dp)) {
            Image(
                painter = painter,
                contentDescription = contentDescription,
                contentScale = ContentScale.Crop)


            Box(modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Black
                        ),
                        startY = 300f
                    )
                ))

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp),
                contentAlignment = Alignment.BottomStart) {

                Text(title, style = TextStyle(color = Color.White,fontSize = 16.sp) )
            }
        }
    }

}

@Composable
fun Modifiers() {

    Column(
        modifier = Modifier
            .background(Color.Green)
            .fillMaxHeight(0.5f)
            .fillMaxWidth()
            .border(5.dp, Color.Magenta)
            .padding(16.dp)
            //.requiredWidth(600.dp)
    ) {
        Text("Hello ", modifier = Modifier
            .offset(0.dp, 20.dp))
        Spacer(modifier = Modifier.height(50.dp))
        Text("World ")
    }

}
@Composable
fun RowsAndColumns() {

    Row(
        modifier = Modifier
            //.fillMaxSize()
            //.fillMaxSize(0.5f)
            //.fillMaxWidth()
            //.fillMaxHeight()
            .width(200.dp)
            .height(200.dp)
            .background(Color.Green),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text("Hello ")
        Text("World ")
        Text("Hello ")
    }

    /*Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Green),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ) {
        Text("Hello ")
        Text("World ")
        Text("Hello ")
    }*/
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    val painter = painterResource(id = R.drawable.ic_launcher_background)
    val description = "Kermit in the snow"
    val title = "Kermit is playing"

    Box(modifier = Modifier
        .fillMaxWidth(0.5f)
        .padding(60.dp)){
        ImageCard(
            painter = painter,
            contentDescription = description,
            title = title)
    }
}