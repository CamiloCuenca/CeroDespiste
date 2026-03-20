package com.servicerca.cerodespiste.Screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun WelcomeScreen(){
    Column() {
        Text(text = "Bienvenido a Cero Despite ")
    }
}



@Composable
@Preview
fun WelcomeScreenPreview(){
    WelcomeScreen()
}