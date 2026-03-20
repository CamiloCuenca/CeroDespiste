package com.servicerca.cerodespiste.core

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
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

    // Crear la barra de navegación inferior usando los colores del tema
    NavigationBar(
        modifier = Modifier.fillMaxWidth(),
        containerColor = MaterialTheme.colorScheme.surfaceVariant,
        contentColor = MaterialTheme.colorScheme.onSurfaceVariant
    ){
        // Iteramos cada item de navegación definido en Destination
        Destination.entries.forEach { destination ->

            // Verificar si el item está seleccionado
            val isSelected = currentDestination?.route == destination.route.route

            // Colores según estado usando roles del tema
            val selectedColor = MaterialTheme.colorScheme.primary
            val unselectedColor = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.75f)

            NavigationBarItem(
                label = {
                    // Etiqueta del item de navegación con color según estado
                    Text(
                        text = destination.label,
                        color = if (isSelected) selectedColor else unselectedColor
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
                    // Icono del item de navegación con tint según estado
                    Icon(
                        imageVector = destination.icon,
                        contentDescription = destination.label,
                        tint = if (isSelected) selectedColor else unselectedColor
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
    SCORE(DashboardRoutes.Results, "Score", Icons.Default.List),

}