package com.servicerca.cerodespiste.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.servicerca.cerodespiste.ui.components.*

@Composable
fun ResultScreen(
    score: String = "12,450",
    playtime: String = "04:22.05",
    onTryAgain: () -> Unit = {},
    contentPadding: PaddingValues = PaddingValues()
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(contentPadding)
                .systemBarsPadding()
                .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(10.dp))

            Box(
                modifier = Modifier.fillMaxWidth()
            ) {
                // Card Border
                DottedBorderCard(
                    borderColor = MaterialTheme.colorScheme.primary,
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
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.SemiBold,
                            letterSpacing = 2.sp
                        )
                        NeonText(
                            text = score,
                            color = MaterialTheme.colorScheme.primary,
                            fontSize = 64.sp,
                            fontWeight = FontWeight.ExtraBold,
                            glowRadius = 30f,
                            modifier = Modifier.padding(vertical = 8.dp)
                        )

                        Text(
                            text = "Nombre Juagdor",  //TODO @CAMILOCUENCA  actualizar cuando tengamso lo de nombre
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.SemiBold,
                            letterSpacing = 2.sp
                        )

                        Spacer(modifier = Modifier.height(16.dp))



                        Spacer(modifier = Modifier.height(32.dp))

                        // Separator line
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(2.dp)
                                .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.5f))
                        )

                        Spacer(modifier = Modifier.height(32.dp))


                        // Playtime Box
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(12.dp))
                                .background(MaterialTheme.colorScheme.surface.copy(alpha = 0.8f))
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
                                        .background(MaterialTheme.colorScheme.surfaceVariant),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text("⏱", fontSize = 16.sp, color = MaterialTheme.colorScheme.onSurface)
                                }
                                Spacer(modifier = Modifier.width(16.dp))
                                Column {
                                    Text(
                                        text = "TOTAL PLAYTIME",
                                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                                        fontSize = 10.sp,
                                        fontWeight = FontWeight.Bold,
                                        letterSpacing = 1.sp
                                    )
                                    Text(
                                        text = playtime,
                                        color = MaterialTheme.colorScheme.onSurface,
                                        fontSize = 20.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                }
                                Spacer(modifier = Modifier.weight(1f))

                            }
                        }

                        Spacer(modifier = Modifier.height(32.dp))

                        // Separator line
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(2.dp)
                                .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.5f))
                        )

                        Spacer(modifier = Modifier.height(32.dp))

                        // Buttons
                        NeonButton(
                            text = "TRY AGAIN",
                            onClick = onTryAgain,
                            gradientColors = listOf(
                                MaterialTheme.colorScheme.primary,
                                MaterialTheme.colorScheme.primary.copy(alpha = 0.8f)
                            ),
                            glowColor = MaterialTheme.colorScheme.primary
                        )

                        Spacer(modifier = Modifier.height(16.dp))


                    }
                }


            }

            Spacer(modifier = Modifier.height(32.dp))



            Spacer(modifier = Modifier.height(24.dp))


            Spacer(modifier = Modifier.height(contentPadding.calculateBottomPadding()))
        }
    }
}

@Composable
@Preview(showBackground = true)
fun ResultScreenPreview() {
    com.servicerca.cerodespiste.ui.theme.CeroDespisteTheme {
        ResultScreen()
    }
}