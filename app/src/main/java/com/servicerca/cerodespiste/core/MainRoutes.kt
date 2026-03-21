package com.servicerca.cerodespiste.core

import android.net.Uri

sealed class MainRoutes(val route: String) {
    object Welcome : MainRoutes("welcome")
    object User : MainRoutes("user/{player}") {
        fun createRoute(player: String): String = "user/${Uri.encode(player)}"
    }
}