package com.servicerca.cerodespiste.core

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.servicerca.cerodespiste.Screens.GameScreen

import com.servicerca.cerodespiste.Screens.HomeScreen
import com.servicerca.cerodespiste.Screens.ResultScreen

@Composable
fun UserNavigation(
    navController: NavHostController,
    padding: PaddingValues
){

    NavHost(
        navController = navController,
        startDestination = DashboardRoutes.GameScreen
    ) {



        composable<DashboardRoutes.GameScreen> {
              GameScreen()
        }

        composable<DashboardRoutes.Results> {
            ResultScreen()
        }


    }

}