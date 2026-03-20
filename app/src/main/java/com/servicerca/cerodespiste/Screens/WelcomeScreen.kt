package com.servicerca.cerodespiste.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.servicerca.cerodespiste.R

@Composable
fun WelcomeScreen(){

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        // Imagen de fondo
        Image(
            painter = painterResource(id = R.drawable.fondo), // Tu imagen en drawable
            contentDescription = null, // Fondo decorativo
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop // Ajusta para cubrir toda la pantalla
        )

        Column() {
            Text(text = "Bienvenido a Cero Despite ")
        }
    }

}



@Composable
@Preview
fun WelcomeScreenPreview(){
    WelcomeScreen()
}