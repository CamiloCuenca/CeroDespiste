package com.servicerca.cerodespiste.core

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.servicerca.cerodespiste.Screens.WelcomeScreen
import com.servicerca.cerodespiste.core.UserScreen

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
            startDestination = MainRoutes.Welcome.route // Pantalla de inicio, esta es la primer pantalla que se muestra al iniciar la aplicación
        ) {

            composable(route = MainRoutes.Welcome.route) {
                WelcomeScreen (
                    onStartGame = {
                        navController.navigate(MainRoutes.User.route)
                    }
                )

            }

            // Registrar el contenedor de usuario (con Scaffold que tiene TopAppBar y BottomNavigationBar)
            composable(route = MainRoutes.User.route) {
                UserScreen(onLogout = {
                    // Volver a la pantalla de bienvenida al cerrar sesión
                    navController.popBackStack(MainRoutes.Welcome.route, inclusive = false)
                })
            }

        }
    }
}
