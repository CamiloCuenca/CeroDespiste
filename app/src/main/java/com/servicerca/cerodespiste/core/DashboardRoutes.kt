package com.servicerca.cerodespiste.core

import kotlinx.serialization.Serializable

sealed class DashboardRoutes {

    @Serializable
    data object HomeUser : DashboardRoutes()

    @Serializable
    data object Results : DashboardRoutes()

}