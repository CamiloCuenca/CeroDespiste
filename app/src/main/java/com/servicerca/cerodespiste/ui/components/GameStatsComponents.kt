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
import com.servicerca.cerodespiste.ui.theme.TextGray

@Composable
fun StatItem(
    label: String,
    valueTitle: String,
    valueColor: Color,
    modifier: Modifier = Modifier
) {
    androidx.compose.foundation.layout.Column(
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Text(
            text = label.uppercase(),
            color = TextGray,
            fontSize = 10.sp,
            fontWeight = FontWeight.Bold,
            letterSpacing = 1.sp
        )
        Spacer(modifier = Modifier.height(4.dp))
        NeonText(
            text = valueTitle,
            color = valueColor,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            glowRadius = 10f
        )
    }
}

@Composable
fun ProgressBarSegmented(
    totalSegments: Int,
    filledSegments: Int,
    segmentColor: Color,
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier) {
        for (i in 0 until totalSegments) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(4.dp)
                    .background(if (i < filledSegments) segmentColor else Color(0xFF2A3441))
            )
            if (i < totalSegments - 1) {
                Spacer(modifier = Modifier.width(4.dp))
            }
        }
    }
}

@Composable
fun ProgressBarSolid(
    progress: Float,
    color: Color,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(4.dp)
            .background(Color(0xFF2A3441))
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(progress)
                .height(4.dp)
                .background(color)
        )
    }
}
