package com.servicerca.cerodespiste.Screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun GameScreen(){
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxHeight()
    ) {
        Column() {
            Text(
                text =
            )
            Row() {

            }
        }
    }
}


@Composable
@Preview (showBackground = true)
fun GameScreenPreview(){
    GameScreen()
}