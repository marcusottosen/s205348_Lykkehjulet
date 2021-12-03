package com.example.s205348_lykkehjulet.ui.view.items

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun DefaultButton(
    text: String,
    onClick: () -> Unit,
) {
    Button(
        modifier = Modifier.padding(vertical = 24.dp),
        onClick = {
            onClick.invoke()
        }
    ) {
        Text(text)
    }
}


