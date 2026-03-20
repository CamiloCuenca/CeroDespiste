package com.servicerca.cerodespiste.ui.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit

@Composable
fun NeonText(
    text: String,
    fontSize: TextUnit,
    modifier: Modifier = Modifier,
    color: Color? = null,
    fontWeight: FontWeight = FontWeight.Normal,
    glowRadius: Float = 15f
) {
    val actualColor = color ?: MaterialTheme.colorScheme.primary
    Text(
        text = text,
        color = actualColor,
        fontSize = fontSize,
        fontWeight = fontWeight,
        modifier = modifier,
        style = TextStyle(
            shadow = Shadow(
                color = actualColor,
                offset = Offset.Zero,
                blurRadius = glowRadius
            )
        )
    )
}
