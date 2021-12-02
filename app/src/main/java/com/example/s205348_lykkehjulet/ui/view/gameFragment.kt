package com.example.s205348_lykkehjulet.ui.view

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.s205348_lykkehjulet.ui.view.items.Keyboard
import com.example.s205348_lykkehjulet.ui.view.items.LetterBox
import com.example.s205348_lykkehjulet.ui.view.items.WheelItem
import com.example.s205348_lykkehjulet.ui.viewmodel.HiddenWordsViewModel


class gameFragment {

    @ExperimentalFoundationApi
    @Composable
    fun SetupGameFragment(){
        val viewModel = HiddenWordsViewModel()
        viewModel.prepareBoxes()
        GameFragment(viewModel)
    }


    //TODO: I photoshop lav et lykkehjul, noter græderne da disse somehow skal bruges til
    // at finde frem til hvad den lander på
    // Lav også en trekant (kan laves i compose)







    @ExperimentalFoundationApi
    @Preview(showBackground = true)
    @Composable
    fun GameFragment(viewModel: HiddenWordsViewModel = HiddenWordsViewModel()) {
        val health by remember { mutableStateOf(viewModel.health) }
        val score by remember { mutableStateOf(viewModel.score) }

        Column(modifier = Modifier.fillMaxSize()) {

            LetterBox(viewModel)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = health.value.toString(),
                    modifier = Modifier.padding(20.dp, 10.dp, 0.dp, 0.dp),
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = score.value.toString(),
                    modifier = Modifier.padding(0.dp, 10.dp, 20.dp, 0.dp),
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            //Spinning wheel & its button
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentSize(align = Alignment.Center),
                verticalArrangement = Arrangement.Center
            ) {
                val clicked by remember { mutableStateOf(viewModel.canSpin) }

                WheelItem(viewModel)
                Box(modifier = Modifier.align(Alignment.CenterHorizontally).padding(top=10.dp)
                    .background(color = Color.Green)) {
                    Button(
                        onClick = {
                            viewModel.wheelDirection.value = !viewModel.wheelDirection.value
                            viewModel.canSpin.value = !viewModel.canSpin.value
                            viewModel.canChooseLetter.value = true
                        },

                        enabled = clicked.value
                    ) {
                        Text(text = "Spin the wheel!")
                    }
                }
            }
        }

        Keyboard(viewModel)

        //viewModel.letterChosen('A')
        //viewModel.letterChosen('C')
    }
}