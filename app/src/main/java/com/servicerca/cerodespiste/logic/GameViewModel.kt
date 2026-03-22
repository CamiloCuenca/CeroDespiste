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

    private var startTimeMillis: Long = 0L

    fun startGame() {
        _state.value = GameState()
        startTimeMillis = System.currentTimeMillis()
        addNewColor()
    }

    private fun addNewColor() {
        val currentSeq = _state.value.sequence

        if (currentSeq.size >= MAX_SEQUENCE) {
            finishGame()
            return
        }

        val nextColor = (0..3).random()

        _state.update {
            it.copy(
                sequence = currentSeq + nextColor,
                isUserTurn = false
            )
        }

        playSequence()
    }

    private fun playSequence() {

        viewModelScope.launch {

            delay(500)

            _state.value.sequence.forEach { color ->

                _state.update { it.copy(activeColor = color) }

                delay(600)

                _state.update { it.copy(activeColor = null) }

                delay(250)
            }

            _state.update {
                it.copy(
                    isUserTurn = true,
                    userIndex = 0
                )
            }
        }
    }

    fun onColorClicked(colorId: Int) {

        val currentState = _state.value

        if (!currentState.isUserTurn || currentState.isGameOver) return

        if (colorId == currentState.sequence[currentState.userIndex]) {

            val nextIndex = currentState.userIndex + 1

            if (nextIndex == currentState.sequence.size) {

                _state.update {
                    it.copy(
                        score = it.score + 1,
                        isUserTurn = false
                    )
                }

                // ✅ Espera 1 segundo antes de la siguiente ronda
                viewModelScope.launch {
                    delay(1000)
                    addNewColor()
                }

            } else {

                _state.update { it.copy(userIndex = nextIndex) }
            }

        } else {

            _state.update {
                it.copy(
                    isGameOver = true,
                    isUserTurn = false
                )
            }

            finishGame()
        }
    }

    private fun finishGame() {

        val elapsed =
            if (startTimeMillis > 0L)
                System.currentTimeMillis() - startTimeMillis
            else
                0L

        _state.update {
            it.copy(
                isGameOver = true,
                isUserTurn = false,
                playTimeMillis = elapsed
            )
        }
    }
}