package com.servicerca.cerodespiste.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.servicerca.cerodespiste.ui.components.*
import com.servicerca.cerodespiste.ui.theme.*

@Composable
fun ResultScreen(
    playerName: String = "Player 1",
    score: String = "12,450",
    accuracy: String = "94%",
    multiplier: String = "x4.5",
    roundReached: String = "08",
    totalRounds: String = "10",
    intensity: String = "07",
    playtime: String = "04:22.05",
    fasterPercent: String = "+12%",
    onTryAgain: () -> Unit = {},
    onBackToHome: () -> Unit = {}
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = BackgroundDark
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(48.dp))

            // Title
            NeonText(
                text = "NEON MEMORY",
                color = NeonGreen,
                fontSize = 24.sp,
                fontWeight = FontWeight.ExtraBold,
                glowRadius = 20f,
                modifier = Modifier.padding(bottom = 32.dp)
            )

            Box(
                modifier = Modifier.fillMaxWidth()
            ) {
                // Card Border
                DottedBorderCard(
                    borderColor = BorderBlue,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 12.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 24.dp, vertical = 32.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        // Score Section
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = "FINAL SCORE",
                            color = LightText,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.SemiBold,
                            letterSpacing = 2.sp
                        )
                        NeonText(
                            text = score,
                            color = NeonCyan,
                            fontSize = 64.sp,
                            fontWeight = FontWeight.ExtraBold,
                            glowRadius = 30f,
                            modifier = Modifier.padding(vertical = 8.dp)
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceEvenly
                        ) {
                            StatItem(
                                label = "Accuracy",
                                valueTitle = accuracy,
                                valueColor = NeonYellow
                            )
                            // Vertical Divider
                            Box(
                                modifier = Modifier
                                    .width(1.dp)
                                    .height(40.dp)
                                    .background(Color(0xFF2A3441))
                            )
                            StatItem(
                                label = "Multiplier",
                                valueTitle = multiplier,
                                valueColor = NeonRed
                            )
                        }

                        Spacer(modifier = Modifier.height(32.dp))
                        
                        // Separator line
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(2.dp)
                                .background(Color(0xFF0077FF).copy(alpha = 0.5f))
                        )
                        
                        Spacer(modifier = Modifier.height(32.dp))

                        // Progress Section
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Column(modifier = Modifier.weight(1f)) {
                                Text(
                                    text = "PROGRESS",
                                    color = TextGray,
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight.Bold,
                                    letterSpacing = 1.sp
                                )
                                Spacer(modifier = Modifier.height(4.dp))
                                Row(verticalAlignment = Alignment.Bottom) {
                                    Text(
                                        text = roundReached,
                                        color = Color.White,
                                        fontSize = 32.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                    Text(
                                        text = " / $totalRounds",
                                        color = TextGray,
                                        fontSize = 16.sp,
                                        modifier = Modifier.padding(bottom = 4.dp)
                                    )
                                }
                                Text(
                                    text = "Round Reached",
                                    color = TextGray,
                                    fontSize = 12.sp
                                )
                                Spacer(modifier = Modifier.height(12.dp))
                                ProgressBarSolid(
                                    progress = 0.8f,
                                    color = NeonCyan,
                                    modifier = Modifier.padding(end = 16.dp)
                                )
                            }
                            Column(modifier = Modifier.weight(1f)) {
                                Text(
                                    text = "INTENSITY",
                                    color = TextGray,
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight.Bold,
                                    letterSpacing = 1.sp
                                )
                                Spacer(modifier = Modifier.height(4.dp))
                                Text(
                                    text = intensity,
                                    color = NeonYellow,
                                    fontSize = 32.sp,
                                    fontWeight = FontWeight.Bold
                                )
                                Text(
                                    text = "Max Sequence",
                                    color = TextGray,
                                    fontSize = 12.sp
                                )
                                Spacer(modifier = Modifier.height(12.dp))
                                ProgressBarSegmented(
                                    totalSegments = 5,
                                    filledSegments = 4,
                                    segmentColor = NeonYellow,
                                    modifier = Modifier.padding(end = 8.dp)
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(32.dp))
                        
                        // Playtime Box
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(12.dp))
                                .background(BackgroundDark.copy(alpha = 0.8f))
                                .padding(16.dp)
                        ) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                // Icon Mock
                                Box(
                                    modifier = Modifier
                                        .size(40.dp)
                                        .clip(RoundedCornerShape(20.dp))
                                        .background(Color(0xFF2A3441)),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text("⏱", fontSize = 16.sp)
                                }
                                Spacer(modifier = Modifier.width(16.dp))
                                Column {
                                    Text(
                                        text = "TOTAL PLAYTIME",
                                        color = TextGray,
                                        fontSize = 10.sp,
                                        fontWeight = FontWeight.Bold,
                                        letterSpacing = 1.sp
                                    )
                                    Text(
                                        text = playtime,
                                        color = Color.White,
                                        fontSize = 20.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                }
                                Spacer(modifier = Modifier.weight(1f))
                                Column(horizontalAlignment = Alignment.End) {
                                    Text(
                                        text = "NEW PERSONAL BEST!",
                                        color = TextGray,
                                        fontSize = 8.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                    NeonText(
                                        text = "$fasterPercent faster",
                                        color = NeonCyan,
                                        fontSize = 12.sp,
                                        fontWeight = FontWeight.Bold,
                                        glowRadius = 8f
                                    )
                                }
                            }
                        }

                        Spacer(modifier = Modifier.height(32.dp))

                        // Separator line
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(2.dp)
                                .background(Color(0xFF0077FF).copy(alpha = 0.5f))
                        )
                        
                        Spacer(modifier = Modifier.height(32.dp))

                        // Buttons
                        NeonButton(
                            text = "TRY AGAIN",
                            onClick = onTryAgain,
                            gradientColors = listOf(NeonCyan, NeonCyanGradientEnd),
                            glowColor = NeonCyan
                        )
                        
                        Spacer(modifier = Modifier.height(16.dp))
                        
                        SecondaryButton(
                            text = "BACK TO HOME",
                            onClick = onBackToHome
                        )
                    }
                }

                // GAME OVER Tag overlapping top-left
                Box(
                    modifier = Modifier
                        .padding(start = 24.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .background(NeonRed)
                        .padding(horizontal = 16.dp, vertical = 6.dp)
                ) {
                    Text(
                        text = "GAME OVER",
                        color = Color.White,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.ExtraBold,
                        letterSpacing = 1.sp
                    )
                }
            }
            
            Spacer(modifier = Modifier.height(32.dp))
            
            // Text to show the player name
            Text(
                text = "Player: $playerName",
                color = TextGray,
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal
            )
            
            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

@Composable
@Preview(showBackground = true)
fun ResultScreenPreview() {
    ResultScreen()
}