package com.servicerca.cerodespiste.core

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.compose.rememberNavController
import com.example.demoapp.features.dashboard.component.BottomNavigationBar
import com.example.demoapp.features.dashboard.component.TopAppBar
import com.example.demoapp.features.dashboard.navigation.UserNavigation

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
                logout = onLogout // Función para cerrar sesión, que se pasa desde el componente padre
            )
        },
        bottomBar = {
            // Barra de navegación inferior con iconos y títulos
            BottomNavigationBar(
                navController = navController,
                titleTopBar = {
                    title = it
                }
            )
        }
    ) { padding ->
        // Contenido principal gestionado por la navegación (NavHost)
        UserNavigation(
            navController = navController,
            padding = padding
        )

    }
}