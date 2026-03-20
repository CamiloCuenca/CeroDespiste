package com.servicerca.cerodespiste.logic

import androidx.lifecycle.ViewModel
import com.servicerca.cerodespiste.core.utils.ValidatedField

class WelcomeViewModel : ViewModel() {

    val name = ValidatedField("") { value ->
        when {
            value.isEmpty() -> "El nombre es obligatoria"
            else -> null
        }
    }

    fun resetForm() {
        name.reset()

    }

    // Inicia el juego: muestra errores, valida y si es válido invoca el callback con el nombre
    fun startGame(onNavigate: (String) -> Unit) {
        name.touch()
        if (name.isValid) {
            onNavigate(name.value)
        }
    }

}