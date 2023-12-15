package com.xyron.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.xyron.jetpackcompose.ui.theme.JetpackComposeTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
class BottomSheetsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val sheetState = rememberModalBottomSheetState()
                    var isSheetOpen by rememberSaveable {
                        mutableStateOf(false)
                    }

                    val scaffoldState = rememberBottomSheetScaffoldState()
                    val scope = rememberCoroutineScope()
                    /*Box(modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Button(onClick = {
                            isSheetOpen = true
                        }) {
                            Text(text = "Open Sheet")
                        }
                    }*/



                    BottomSheetScaffold(
                        scaffoldState = scaffoldState,
                        sheetContent = {
                            Image(
                                painter = painterResource(id = R.drawable.ic_launcher_background),
                                contentDescription = null
                            )
                        },
                        sheetPeekHeight = 0.dp
                    ) {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Button(onClick = {
                                scope.launch {
                                    scaffoldState.bottomSheetState.expand()
                                }

                            }) {
                                Text(text = "Open Sheet")
                            }
                        }
                    }


                    /*if (isSheetOpen) {
                        ModalBottomSheet(
                            sheetState = sheetState,
                            onDismissRequest = {
                                isSheetOpen = false
                            }) {
                            Image(
                                painter = painterResource(id = R.drawable.ic_launcher_background),
                                contentDescription = null
                            )
                        }
                    }*/
                }
            }
        }
    }
}

@Composable
fun Greeting2(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview4() {
    JetpackComposeTheme {
        Greeting2("Android")
    }
}