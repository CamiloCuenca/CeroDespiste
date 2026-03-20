package com.servicerca.cerodespiste.core

sealed class MainRoutes(val route: String) {
    object Welcome : MainRoutes("welcome")
    object User : MainRoutes("user")
}