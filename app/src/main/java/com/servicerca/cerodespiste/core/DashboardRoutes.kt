package com.servicerca.cerodespiste.core

import android.net.Uri

sealed class DashboardRoutes(val route: String) {
    object GameScreen : DashboardRoutes("game")
    object Results : DashboardRoutes("results/{score}/{time}/{player}") {
        fun createRoute(score: String, time: String, player: String): String {
            // Encodar para que caracteres especiales no rompan la ruta
            return "results/${Uri.encode(score)}/${Uri.encode(time)}/${Uri.encode(player)}"
        }
    }
}