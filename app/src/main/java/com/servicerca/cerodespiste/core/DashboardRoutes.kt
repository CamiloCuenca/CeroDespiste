package com.servicerca.cerodespiste.core

import kotlinx.serialization.Serializable

sealed class DashboardRoutes {



    @Serializable
    data object GameScreen : DashboardRoutes()

    @Serializable
    data object Results : DashboardRoutes()

}