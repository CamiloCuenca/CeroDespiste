package com.servicerca.cerodespiste

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.servicerca.cerodespiste.core.AppNavigation
import com.servicerca.cerodespiste.ui.theme.CeroDespisteTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CeroDespisteTheme {
                AppNavigation()
            }
        }
    }
}
