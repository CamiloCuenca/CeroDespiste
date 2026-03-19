package com.servicerca.cerodespiste.core


import kotlinx.serialization.Serializable

sealed class MainRoutes {

    @Serializable
    data object Welcome : MainRoutes()
    @Serializable
    data object Home : MainRoutes()



}