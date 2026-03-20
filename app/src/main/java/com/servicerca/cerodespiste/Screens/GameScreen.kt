package com.servicerca.cerodespiste.Screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
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
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxHeight()
            .fillMaxWidth()
    ) {
        Column() {
            Text(
                text =  current_score,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.titleMedium
            )
            Row() {
                Text(
                    text =  score,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.headlineLarge
                )
            }
        }
        Card(
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
            colors = CardDefaults.cardColors(containerColor = Color.Gray),
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text =  sequence,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.headlineLarge
            )
        }
    }
}


@Composable
@Preview (showBackground = true)
fun GameScreenPreview(){
    GameScreen()
}