package com.servicerca.cerodespiste.logic

data class GameState(
    val sequence: List<Int> = emptyList(),
    val userIndex: Int = 0,
    val isUserTurn: Boolean = false,
    val activeColor: Int? = null,
    val isGameOver: Boolean = false,
    val score: Int = 0,
    // tiempo de juego en milisegundos (0 = no calculado)
    val playTimeMillis: Long = 0L
)
