package com.servicerca.cerodespiste.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.MaterialTheme

@Composable
fun StatItem(
    modifier: Modifier = Modifier,
    label: String,
    valueTitle: String,
    valueColor: Color? = null
) {
    val actualValueColor = valueColor ?: MaterialTheme.colorScheme.primary
    androidx.compose.foundation.layout.Column(
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Text(
            text = label.uppercase(),
            color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.8f),
            fontSize = 10.sp,
            fontWeight = FontWeight.Bold,
            letterSpacing = 1.sp
        )
        Spacer(modifier = Modifier.height(4.dp))
        NeonText(
            text = valueTitle,
            fontSize = 20.sp,
            color = actualValueColor,
            fontWeight = FontWeight.Bold,
            glowRadius = 10f
        )
    }
}

@Composable
fun ProgressBarSegmented(
    modifier: Modifier = Modifier,
    totalSegments: Int,
    filledSegments: Int,
    segmentColor: Color? = null
) {
    val actualSegmentColor = segmentColor ?: MaterialTheme.colorScheme.primary
    Row(modifier = modifier) {
        for (i in 0 until totalSegments) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(4.dp)
                    .background(if (i < filledSegments) actualSegmentColor else MaterialTheme.colorScheme.surfaceVariant)
            )
            if (i < totalSegments - 1) {
                Spacer(modifier = Modifier.width(4.dp))
            }
        }
    }
}

@Composable
fun ProgressBarSolid(
    modifier: Modifier = Modifier,
    progress: Float,
    color: Color? = null
) {
    val actualColor = color ?: MaterialTheme.colorScheme.primary
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(4.dp)
            .background(MaterialTheme.colorScheme.surfaceVariant)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(progress)
                .height(4.dp)
                .background(actualColor)
        )
    }
}
