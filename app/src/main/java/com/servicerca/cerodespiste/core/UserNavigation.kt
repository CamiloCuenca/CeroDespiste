package com.servicerca.cerodespiste.core

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.NavType
import com.servicerca.cerodespiste.Screens.GameScreen

import com.servicerca.cerodespiste.Screens.ResultScreen

@Composable
fun UserNavigation(
    navController: NavHostController,
    padding: PaddingValues,
    playerName: String = "Jugador"
){

    NavHost(
        navController = navController,
        startDestination = DashboardRoutes.GameScreen.route
    ) {

        composable(route = DashboardRoutes.GameScreen.route) {
              GameScreen(
                  onResult = { scoreText, timeText, round -> navController.navigate(DashboardRoutes.Results.createRoute(scoreText, timeText, round, playerName)) },
                  contentPadding = padding
              )
        }

        composable(
            route = DashboardRoutes.Results.route,
            arguments = listOf(
                navArgument("score") { type = NavType.StringType },
                navArgument("time") { type = NavType.StringType },
                navArgument("round") { type = NavType.IntType },
                navArgument("player") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val score = backStackEntry.arguments?.getString("score") ?: "0"
            val time = backStackEntry.arguments?.getString("time") ?: "00:00.00"
            val round = backStackEntry.arguments?.getInt("round") ?: 0
            val player = backStackEntry.arguments?.getString("player") ?: playerName

            ResultScreen(
                score = score,
                playtime = time,
                player = player,
                round = round,
                onTryAgain = { navController.navigate(DashboardRoutes.GameScreen.route) },
                contentPadding = padding
            )
        }


    }

}