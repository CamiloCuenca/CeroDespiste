package com.servicerca.cerodespiste.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.servicerca.cerodespiste.R

@Composable
fun GameScreen(
    current_score: String = stringResource(R.string.current_score),
    score: String = stringResource(R.string.score),
    round: String = stringResource(R.string.round),
    sequence: String = stringResource(R.string.whatch_sequence),
    start_game: String = stringResource(R.string.start_game)
){

    // SOLO UI por ahora
    val currentRound = 1
    val maxRounds = 10

    Column(
        modifier = Modifier
            .padding(vertical = 100.dp, horizontal = 16.dp)
            .fillMaxHeight()
            .fillMaxWidth()
    ) {

        Column {

            Text(
                text = current_score,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.tertiary,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            Row {
                Text(
                    text = score,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.headlineLarge,
                    modifier = Modifier.padding(bottom = 20.dp),
                    color = MaterialTheme.colorScheme.primary
                )
            }

            Text(
                text = "$round $currentRound OF $maxRounds",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.tertiary,
            )

            Spacer(modifier = Modifier.height(8.dp))

            LinearProgressIndicator(
                progress = { currentRound / maxRounds.toFloat() },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(6.dp),
                color = MaterialTheme.colorScheme.primary,
                trackColor = Color.Gray
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Card(
            shape = RoundedCornerShape(30.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFF1C1F26)),
            modifier = Modifier.fillMaxWidth()
                .padding(top = 15.dp)
        ) {
            Text(
                text = sequence,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                color = Color.White,
                textAlign = TextAlign.Center
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        // BOTONES DE COLORES
        Column {

            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
                    .padding(vertical = 20.dp)
            ) {
                ColorButton(Color(0xFF00F260))
                ColorButton(Color(0xFFFF1744))
            }

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
                    .padding(bottom = 30.dp)
            ) {
                ColorButton(Color(0xFF1DE9B6))
                ColorButton(Color(0xFFFFD600))
            }
        }

        Button(
            onClick = { },
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp)
                .shadow(
                    elevation = 20.dp,
                    shape = RoundedCornerShape(30.dp),
                    ambientColor = Color(0xFF2DE2E6),
                    spotColor = Color(0xFF2DE2E6)
                ),
            shape = RoundedCornerShape(30.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF2DE2E6)
            )
        ) {
            Text(
                text = start_game,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        }
    }
}

@Composable
fun ColorButton(color: Color) {
    Box(
        modifier = Modifier
            .size(140.dp)
            .shadow(
                elevation = 20.dp,
                shape = RoundedCornerShape(24.dp),
                ambientColor = color,
                spotColor = color
            )
            .background(
                color = color,
                shape = RoundedCornerShape(24.dp)
            )
    )
}

@Preview(showBackground = true)
@Composable
fun GameScreenPreview(){
    GameScreen()
}