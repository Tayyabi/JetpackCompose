package com.xyron.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ExposedDropdownMenuBox
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.xyron.jetpackcompose.ui.theme.JetpackComposeTheme

class DropDownActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DropDown()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class, ExperimentalMaterial3Api::class)
@Composable
fun DropDown(){

    val list = listOf("one","two","three","four")
    var selectedText by remember {
        mutableStateOf(list[0])
    }

    var isExpanded by remember {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp)
            .padding(top = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ExposedDropdownMenuBox(
            expanded = isExpanded,
            onExpandedChange = { isExpanded = !isExpanded}
        ) {

            OutlinedTextField(
                value = selectedText,
                onValueChange = {},
                readOnly = true,
                label = { Text(text = "City") },
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded) }
            )

            ExposedDropdownMenu(expanded = isExpanded, onDismissRequest = { isExpanded = false }) {

                list.forEachIndexed { index, text ->

                    DropdownMenuItem(
                        text = { Text(text = text) },
                        onClick = {
                            selectedText = list[index]
                            isExpanded = false
                        },
                        contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding
                    )
                }
            }
        }

        Text(text = "Currently Selected $selectedText")
    }
}

@Preview(showBackground = true)
@Composable
fun DropDownPreview() {
    JetpackComposeTheme {
        DropDown()
    }
}