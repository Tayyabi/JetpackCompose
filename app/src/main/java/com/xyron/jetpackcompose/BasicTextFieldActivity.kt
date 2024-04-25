package com.xyron.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text2.BasicTextField2
import androidx.compose.foundation.text2.input.InputTransformation
import androidx.compose.foundation.text2.input.TextFieldBuffer
import androidx.compose.foundation.text2.input.TextFieldCharSequence
import androidx.compose.foundation.text2.input.rememberTextFieldState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.xyron.jetpackcompose.ui.theme.JetpackComposeTheme

class BasicTextFieldActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    StudyBasicTextFields()
                }
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun StudyBasicTextFields() {

    var text1 by remember {
        mutableStateOf("")
    }

    var text2 by remember {
        mutableStateOf("")
    }

    val modifier = Modifier
        .fillMaxWidth()
        .background(Color.LightGray)
        .padding(16.dp)


    BasicTextField(
        value = text1,
        onValueChange = { text1 = it },
        modifier = modifier
    )

    val state = rememberTextFieldState()

    BasicTextField2(
        state = state,
        modifier = modifier,
        inputTransformation = AndroidInputTransformation,
        scrollState = rememberScrollState()
    )

}


@OptIn(ExperimentalFoundationApi::class)
object AndroidInputTransformation: InputTransformation {
    override fun transformInput(
        originalValue: TextFieldCharSequence,
        valueWithChanges: TextFieldBuffer
    ) {
        if (!"Android".contains(valueWithChanges.asCharSequence())){
            valueWithChanges.revertAllChanges()
        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview9() {
    JetpackComposeTheme {
        StudyBasicTextFields()
    }
}