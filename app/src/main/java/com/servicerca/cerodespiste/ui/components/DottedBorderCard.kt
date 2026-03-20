package com.servicerca.cerodespiste.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import androidx.compose.material3.MaterialTheme

@Composable
fun DottedBorderCard(
    modifier: Modifier = Modifier,
    borderColor: Color? = null,
    content: @Composable () -> Unit
) {
    val actualBorder = borderColor ?: MaterialTheme.colorScheme.primary
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(16.dp))
            .background(MaterialTheme.colorScheme.surface)
            .drawBehind {
                val stroke = Stroke(
                    width = 4.dp.toPx(),
                    pathEffect = PathEffect.dashPathEffect(floatArrayOf(8.dp.toPx(), 8.dp.toPx()), 0f)
                )
                drawRoundRect(
                    color = actualBorder,
                    size = Size(size.width, size.height),
                    cornerRadius = CornerRadius(16.dp.toPx(), 16.dp.toPx()),
                    style = stroke
                )
            }
            .padding(2.dp)
    ) {
        content()
    }
}
