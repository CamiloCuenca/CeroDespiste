package com.servicerca.cerodespiste.core

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.NavType
import com.servicerca.cerodespiste.Screens.WelcomeScreen

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
                    onStartGame = { playerName ->
                        navController.navigate(MainRoutes.User.createRoute(playerName))
                    }
                )

            }

            // Registrar el contenedor de usuario (con Scaffold que tiene TopAppBar y BottomNavigationBar)
            composable(
                route = MainRoutes.User.route,
                arguments = listOf(navArgument("player") { type = NavType.StringType })
            ) { backStackEntry ->
                val player = backStackEntry.arguments?.getString("player") ?: "Jugador"
                UserScreen(onLogout = {
                    // Volver a la pantalla de bienvenida al cerrar sesión
                    navController.popBackStack(MainRoutes.Welcome.route, inclusive = false)
                }, playerName = player)
            }

        }
    }
}
