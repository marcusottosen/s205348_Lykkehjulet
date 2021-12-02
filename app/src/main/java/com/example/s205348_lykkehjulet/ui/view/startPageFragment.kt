package com.example.s205348_lykkehjulet.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.s205348_lykkehjulet.Screen
import com.example.s205348_lykkehjulet.R
import com.example.s205348_lykkehjulet.ui.view.items.DefaultButton

@Composable
fun getStartScreen(navController: NavController) {
    Column(
        // we are using column to align our
        // imageview to center of the screen.
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "Welcome to the Wheel of Fortune!",
            fontWeight = FontWeight.SemiBold,
            fontSize = 24.sp
        )

        Image(
            painter = painterResource(id = R.drawable.startpagewheel),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier.width(250.dp)
        )

        DefaultButton(
            text = "Start Game",
            onClick = {
                navController.navigate(Screen.GameScreen.route)
            })
    }
}