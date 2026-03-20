package com.servicerca.cerodespiste.core

sealed class DashboardRoutes(val route: String) {
    object GameScreen : DashboardRoutes("game")
    object Results : DashboardRoutes("results")
}