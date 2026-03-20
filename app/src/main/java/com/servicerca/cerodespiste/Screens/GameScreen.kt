package com.servicerca.cerodespiste.Screens

import android.media.AudioAttributes
import android.media.SoundPool
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.servicerca.cerodespiste.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun GameScreen(
    current_score: String = stringResource(R.string.current_score),
    score: String = stringResource(R.string.score),
    round: String = stringResource(R.string.round),
    sequenceText: String = stringResource(R.string.whatch_sequence),
    start_game: String = stringResource(R.string.start_game),
    ready: String = stringResource(R.string.ready),
    go: String = stringResource(R.string.go),
    game_over: String = stringResource(R.string.game_over),
    round_game_over: String = stringResource(R.string.round),
    score_game_over: String = stringResource(R.string.score_game_over),
    view_score: String = stringResource(R.string.vew_score),
) {

    val scope = rememberCoroutineScope()
    val context = LocalContext.current

    val maxRounds = 10

    var sequence by remember { mutableStateOf(listOf<Int>()) }
    var playerIndex by remember { mutableStateOf(0) }
    var highlighted by remember { mutableStateOf(-1) }
    var allowInput by remember { mutableStateOf(false) }
    var gameStarted by remember { mutableStateOf(false) }

    var showGameOver by remember { mutableStateOf(false) }

    var showCountdown by remember { mutableStateOf(false) }
    var countdown by remember { mutableStateOf(3) }

    var scoreValue by remember { mutableStateOf(0) }

    val currentRound = sequence.size

    // SONIDOS
    val soundPool = remember {

        val attributes = AudioAttributes.Builder()
            .setUsage(AudioAttributes.USAGE_GAME)
            .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
            .build()

        SoundPool.Builder()
            .setMaxStreams(4)
            .setAudioAttributes(attributes)
            .build()
    }

    val greenSound = remember { soundPool.load(context, R.raw.green, 1) }
    val redSound = remember { soundPool.load(context, R.raw.red, 1) }
    val blueSound = remember { soundPool.load(context, R.raw.blue, 1) }
    val yellowSound = remember { soundPool.load(context, R.raw.yellow, 1) }

    fun playSound(index: Int) {

        when (index) {
            0 -> soundPool.play(greenSound, 1f, 1f, 1, 0, 1f)
            1 -> soundPool.play(redSound, 1f, 1f, 1, 0, 1f)
            2 -> soundPool.play(blueSound, 1f, 1f, 1, 0, 1f)
            3 -> soundPool.play(yellowSound, 1f, 1f, 1, 0, 1f)
        }
    }

    fun playSequence() {

        scope.launch {

            allowInput = false

            for (color in sequence) {

                highlighted = color
                playSound(color)

                delay(500)

                highlighted = -1
                delay(300)
            }

            playerIndex = 0
            allowInput = true
        }
    }

    fun startGame() {

        scoreValue = 0
        gameStarted = true
        sequence = listOf((0..3).random())
        playSequence()
    }

    fun playerMove(index: Int) {

        if (!allowInput) return

        highlighted = index
        playSound(index)

        scope.launch {
            delay(200)
            highlighted = -1
        }

        if (sequence[playerIndex] == index) {

            playerIndex++

            if (playerIndex == sequence.size) {

                scoreValue += 100

                if (sequence.size == maxRounds) {
                    showGameOver = true
                    return
                }

                scope.launch {

                    delay(600)

                    sequence = sequence + (0..3).random()

                    playSequence()
                }
            }

        } else {

            allowInput = false
            showGameOver = true
        }
    }

    Column(
        modifier = Modifier
            .padding(vertical = 100.dp, horizontal = 16.dp)
            .fillMaxSize()
    ) {

        Column {

            Text(
                text = current_score,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            Text(
                text = scoreValue.toString(),
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.headlineLarge,
                modifier = Modifier.padding(bottom = 20.dp),
                color = MaterialTheme.colorScheme.primary
            )

            Text(
                text = "$round $currentRound OF $maxRounds",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface
            )

            Spacer(modifier = Modifier.height(8.dp))

            LinearProgressIndicator(
                progress = { currentRound / maxRounds.toFloat() },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(6.dp),
                color = MaterialTheme.colorScheme.primary,
                trackColor = MaterialTheme.colorScheme.surfaceVariant
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Card(
            shape = RoundedCornerShape(30.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 15.dp)
        ) {

            Text(
                text = sequenceText,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                color = MaterialTheme.colorScheme.onSurface,
                textAlign = TextAlign.Center
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Column {

            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 20.dp)
            ) {

                ColorButton(0, Color.Green, highlighted) { playerMove(it) }

                ColorButton(1, Color.Red, highlighted) { playerMove(it) }
            }

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 30.dp)
            ) {

                ColorButton(2, Color.Blue, highlighted) { playerMove(it) }

                ColorButton(3, Color.Yellow, highlighted) { playerMove(it) }
            }
        }

        if (!gameStarted) {

            Button(
                onClick = {

                    showCountdown = true
                    countdown = 3

                    scope.launch {

                        while (countdown > 0) {
                            delay(1000)
                            countdown--
                        }

                        delay(500)

                        showCountdown = false
                        startGame()
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp)
                    .shadow(
                        elevation = 20.dp,
                        shape = RoundedCornerShape(30.dp),
                        ambientColor = MaterialTheme.colorScheme.primary,
                        spotColor = MaterialTheme.colorScheme.primary
                    ),
                shape = RoundedCornerShape(30.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary
                )
            ) {

                Text(
                    text = start_game,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onPrimary
                )
            }
        }
    }

    if (showGameOver) {

        AlertDialog(
            onDismissRequest = {},
            confirmButton = {
                Button(
                    onClick = {

                        showGameOver = false
                        gameStarted = false
                        sequence = emptyList()
                        playerIndex = 0
                        scoreValue = 0

                    }
                ) {
                    Text(text = view_score)
                }
            },
            title = {
                Text(
                    text = game_over,
                    fontWeight = FontWeight.Bold
                )
            },
            text = {
                Text(
                    "$round_game_over $currentRound\n$score_game_over $scoreValue"
                )
            }
        )
    }

    if (showCountdown) {

        AlertDialog(
            onDismissRequest = {},
            confirmButton = {},
            title = {
                Text(
                    text = ready,
                    fontWeight = FontWeight.Bold
                )
            },
            text = {

                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {

                    Text(
                        text = if (countdown == 0) go else countdown.toString(),
                        style = MaterialTheme.typography.displayLarge,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }
        )
    }
}

@Composable
fun ColorButton(
    id: Int,
    color: Color,
    highlighted: Int,
    onClick: (Int) -> Unit
) {

    val active = highlighted == id
    val interactionSource = remember { MutableInteractionSource() }

    val displayColor =
        if (active)
            color.copy(
                red = (color.red + 0.5f).coerceAtMost(1f),
                green = (color.green + 0.5f).coerceAtMost(1f),
                blue = (color.blue + 0.5f).coerceAtMost(1f)
            )
        else color

    Box(
        modifier = Modifier
            .size(140.dp)
            .shadow(
                elevation = if (active) 60.dp else 20.dp,
                shape = RoundedCornerShape(24.dp),
                ambientColor = color,
                spotColor = color
            )
            .background(
                color = displayColor,
                shape = RoundedCornerShape(24.dp)
            )
            .clickable(
                interactionSource = interactionSource,
                indication = null
            ) {
                onClick(id)
            }
    )
}