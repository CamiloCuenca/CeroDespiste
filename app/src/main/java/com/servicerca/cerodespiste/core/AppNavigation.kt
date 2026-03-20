package com.servicerca.cerodespiste.core

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.servicerca.cerodespiste.Screens.WelcomeScreen
import com.servicerca.cerodespiste.Screens.GameScreen
import com.servicerca.cerodespiste.Screens.ResultScreen

@Composable
fun AppNavigation() {
    // Estado de la navegación, permite controlar la navegación entre pantallas
    val navController = rememberNavController()

    // Un Surface que ocupa toda la pantalla y se adapta al tema de la aplicación
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        NavHost(
            navController = navController, // Controlador de navegación
            startDestination = MainRoutes.Welcome // Pantalla de inicio, esta es la primer pantalla que se muestra al iniciar la aplicación
        ) {

            composable<MainRoutes.Welcome> {
                WelcomeScreen (
                    onStartGame = {
                        navController.navigate(DashboardRoutes.GameScreen)
                    }
                )

            }

            // Registrar los destinos del dashboard en el NavHost principal para que las rutas de DashboardRoutes sean encontradas
            composable<DashboardRoutes.GameScreen> {
                GameScreen()
            }

            composable<DashboardRoutes.Results> {
                ResultScreen()
            }

        }
    }
}
