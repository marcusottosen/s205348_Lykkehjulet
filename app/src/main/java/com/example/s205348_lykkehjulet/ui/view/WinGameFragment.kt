package com.example.s205348_lykkehjulet.ui.view.items

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.s205348_lykkehjulet.R
import com.example.s205348_lykkehjulet.Screen

@Composable
fun WinGameFragment(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "Congratulations you guessed the word! \n Who knew you had a curriculum eh?",
            fontWeight = FontWeight.SemiBold,
            fontSize = 18.sp,
            textAlign = TextAlign.Center
        )

        Image(
            painter = painterResource(id = R.drawable.img_win),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier.width(250.dp)
        )

        DefaultButton(
            text = "Play again",
            onClick = {
                navController.navigate(Screen.StartScreen.route)
            })
    }
}