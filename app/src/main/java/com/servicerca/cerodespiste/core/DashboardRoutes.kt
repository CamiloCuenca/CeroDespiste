package com.servicerca.cerodespiste.core

import android.net.Uri

sealed class DashboardRoutes(val route: String) {
    object GameScreen : DashboardRoutes("game")
    object Results : DashboardRoutes("results/{score}/{time}/{round}/{player}") {
        fun createRoute(score: String, time: String, round: Int, player: String): String {
            // Encodar para que caracteres especiales no rompan la ruta
            return "results/${Uri.encode(score)}/${Uri.encode(time)}/${Uri.encode(round.toString())}/${Uri.encode(player)}"
        }
    }
}