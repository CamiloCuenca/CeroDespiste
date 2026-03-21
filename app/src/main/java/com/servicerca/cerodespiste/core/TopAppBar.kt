package com.servicerca.cerodespiste.core

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.servicerca.cerodespiste.R
import com.servicerca.cerodespiste.ui.components.NeonText

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun TopAppBar(
    title: String,
){
    CenterAlignedTopAppBar(
        modifier = Modifier.fillMaxWidth(),

        navigationIcon = {
            Image(
                painter = painterResource(id = R.drawable.icono),
                contentDescription = "Logo",
                modifier = Modifier
                    .padding(start = 8.dp)
                    .size(50.dp)
            )
        },

        title = {
            NeonText(
                text = "Cero Despiste",
                color = MaterialTheme.colorScheme.primary,
                fontSize = 24.sp,
                fontWeight = FontWeight.ExtraBold,
                glowRadius = 20f,
            )
        },

        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.surface,
            titleContentColor = MaterialTheme.colorScheme.onSurface
        )
    )
}