package com.servicerca.cerodespiste.core

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.compose.rememberNavController

@Composable
fun UserScreen(
    onLogout: () -> Unit
) {

    // Estados para la navegación y el título de la barra superior
    val navController = rememberNavController()
    var title by remember { mutableStateOf("Inicio usuario") }

    // Estructura Scaffold (barra superior, barra inferior y contenido)
    Scaffold(
        topBar = {
            // Barra superior con título y botón de cierre de sesión
            TopAppBar(
                title = title,
            )
        },
    ) { padding ->
        // Contenido principal gestionado por la navegación (NavHost)
        UserNavigation(
            navController = navController,
            padding = padding
        )

    }
}