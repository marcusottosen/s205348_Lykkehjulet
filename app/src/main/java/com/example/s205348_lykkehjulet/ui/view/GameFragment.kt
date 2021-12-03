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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.s205348_lykkehjulet.Screen
import com.example.s205348_lykkehjulet.ui.view.items.Keyboard
import com.example.s205348_lykkehjulet.ui.view.items.LetterBox
import com.example.s205348_lykkehjulet.ui.view.items.Wheel
import com.example.s205348_lykkehjulet.ui.viewmodel.HiddenWordsViewModel


    @ExperimentalFoundationApi
    @Composable
    fun GameFragment(viewModel: HiddenWordsViewModel = HiddenWordsViewModel(),navController: NavController) {
        val health by remember { mutableStateOf(viewModel.health) }
        val score by remember { mutableStateOf(viewModel.score) }
        val clicked by remember { mutableStateOf(viewModel.canSpin) }


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
                    text = "Category: University Life",
                    modifier = Modifier.padding(0.dp, 10.dp, 0.dp, 0.dp),
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
                Wheel(viewModel)
                Box(modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 10.dp)
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

        if (health.value == 4 ){
            health.value = 5 // to stop infinite loop
            navController.navigate(Screen.LoseScreen.route)
        }
        println("number of letters found: ${viewModel.numOfLettersFound} and lenght of hidden word: ${viewModel.hiddenWord.length}")

        if (viewModel.numOfLettersFound >= viewModel.hiddenWord.length){
            viewModel.numOfLettersFound = 0 // to stop infinite loop
            navController.navigate(Screen.WinScreen.route)
        }
    }
