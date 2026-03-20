package com.servicerca.cerodespiste.core

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomNavigationBar(
    navController: NavHostController,
    titleTopBar: (String) -> Unit
){
    // Obtener la entrada actual de la pila de navegación
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    // Actualizar el título de la barra superior según la pantalla actual
    LaunchedEffect(currentDestination) {
        val destination = Destination.entries.find { it.route.route == currentDestination?.route }
        if (destination != null) {
            titleTopBar(destination.label)
        }
    }

    // Crear la barra de navegación inferior
    NavigationBar(
        modifier = Modifier.fillMaxWidth(),
    ){
        // Iteramos cada item de navegación definido en Destination
        Destination.entries.forEach { destination ->

            // Verificar si el item está seleccionado
            val isSelected = currentDestination?.route == destination.route.route

            NavigationBarItem(
                label = {
                    // Etiqueta del item de navegación
                    Text(
                        text = destination.label
                    )
                },
                onClick = {
                    // Navegar a la ruta correspondiente al item seleccionado
                    navController.navigate(destination.route.route){
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    // Icono del item de navegación
                    Icon(
                        imageVector = destination.icon,
                        contentDescription = destination.label
                    )
                },
                selected = isSelected
            )
        }
    }
}

// Definición de los items de navegación de la barra inferior
enum class Destination(
    val route: DashboardRoutes,
    val label: String,
    val icon: ImageVector,
){
    PLAY(DashboardRoutes.GameScreen, "Game", Icons.Default.PlayArrow ),
    SCORE(DashboardRoutes.Results, "Score", Icons.AutoMirrored.Filled.List),

}