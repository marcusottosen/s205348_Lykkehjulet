package com.example.s205348_lykkehjulet.ui.view.items

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.s205348_lykkehjulet.R
import com.example.s205348_lykkehjulet.ui.viewmodel.HiddenWordsViewModel

@ExperimentalFoundationApi
@Composable
fun Keyboard(viewModel: HiddenWordsViewModel = HiddenWordsViewModel()) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(align = Alignment.BottomCenter)
            .padding(bottom = 20.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize(align = Alignment.BottomCenter),
            Alignment.BottomCenter
        ) {
            LazyVerticalGrid(
                cells = GridCells.Fixed(7),
                modifier = Modifier.padding(10.dp, 10.dp, 10.dp, 0.dp),
            ) {
                items(getAlphabet().toList()) { //For all items in array
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        var buttonUsed by remember { mutableStateOf(true) }
                        val canChooseLetter by remember { mutableStateOf(viewModel.canChooseLetter) }

                        Button(
                            onClick = {
                                viewModel.letterChosen(it)
                                buttonUsed = !buttonUsed
                            },
                            enabled = if (!canChooseLetter.value) canChooseLetter.value else buttonUsed,
                            modifier = Modifier
                                .height(35.dp)
                                .padding(1.dp)
                                .background(colorResource(R.color.noLetter))
                                .align(Alignment.CenterHorizontally)
                        ) {
                            Text(
                                text = "$it",
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .fillMaxHeight(),
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                }
            }
        }
    }
}

fun getAlphabet(): MutableList<Char> {
    val alphabet: MutableList<Char> = ArrayList()

    var letter = 'A'
    while (letter <= 'Z') {
        alphabet.add(letter)
        ++letter
    }
    return alphabet
}