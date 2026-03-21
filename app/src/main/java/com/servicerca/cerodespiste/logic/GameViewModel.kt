package com.servicerca.cerodespiste.logic

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class GameViewModel : ViewModel() {

    private val _state = MutableStateFlow(GameState())
    val state = _state.asStateFlow()

    private val MAX_SEQUENCE = 10

    // Tiempo de inicio del juego (milis)
    private var startTimeMillis: Long = 0L

    fun startGame() {
        _state.value = GameState()
        startTimeMillis = System.currentTimeMillis()
        addNewColor()
    }

    private fun addNewColor() {
        val currentSeq = _state.value.sequence
        if (currentSeq.size >= MAX_SEQUENCE) {
            // Juego completado => finalizar y calcular tiempo
            finishGame()
            return
        }

        val nextColor = (0..3).random()
        _state.update { it.copy(
            sequence = currentSeq + nextColor,
            isUserTurn = false
        ) }
        playSequence()
    }

    private fun playSequence() {
        viewModelScope.launch {
            delay(500) // Pausa inicial
            _state.value.sequence.forEach { color ->
                // Actualización del estado para iluminar el color
                _state.update { it.copy(activeColor = color) }
                delay(600) // Tiempo que brilla el color

                _state.update { it.copy(activeColor = null) }
                delay(250) // Restricción: Pausa entre elementos
            }
            // Habilita el turno del usuario tras la animación
            _state.update { it.copy(isUserTurn = true, userIndex = 0) }
        }
    }

    fun onColorClicked(colorId: Int) {
        val currentState = _state.value
        // Restricción: No se permite entrada si no es el turno o si el juego terminó
        if (!currentState.isUserTurn || currentState.isGameOver) return

        // Compara el clic con el elemento correspondiente en la secuencia
        if (colorId == currentState.sequence[currentState.userIndex]) {
            val nextIndex = currentState.userIndex + 1
            if (nextIndex == currentState.sequence.size) {
                // Ronda superada: aumenta puntaje y añade color
                _state.update { it.copy(score = it.score + 1, isUserTurn = false) }
                addNewColor()
            } else {
                // Acierto parcial: incrementa el índice para el siguiente clic
                _state.update { it.copy(userIndex = nextIndex) }
            }
        } else {
            // Error: El juego termina inmediatamente
            _state.update { it.copy(isGameOver = true, isUserTurn = false) }
            finishGame()
        }
    }

    private fun finishGame() {
        val elapsed = if (startTimeMillis > 0L) System.currentTimeMillis() - startTimeMillis else 0L
        _state.update { it.copy(isGameOver = true, isUserTurn = false, playTimeMillis = elapsed) }
    }

}