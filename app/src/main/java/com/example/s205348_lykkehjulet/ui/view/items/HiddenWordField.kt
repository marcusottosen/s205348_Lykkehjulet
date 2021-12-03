package com.example.s205348_lykkehjulet.ui.view.items

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.s205348_lykkehjulet.R
import com.example.s205348_lykkehjulet.ui.viewmodel.HiddenWordsViewModel


@ExperimentalFoundationApi
@Composable
fun LetterBox(viewModel: HiddenWordsViewModel = HiddenWordsViewModel()) {
    val boxValue by remember { mutableStateOf(viewModel.wordGuessingArrayState) }

    val edges = intArrayOf(0, 12, 39, 51)
    var boxColor: Color
    var i = 0

    Card(elevation = 10.dp) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize(align = Alignment.Center),
            verticalArrangement = Arrangement.Center
        ) {
            LazyVerticalGrid(
                cells = GridCells.Fixed(13),
                modifier = Modifier.padding(10.dp, 20.dp, 10.dp, 20.dp)
            ) {
                items(boxValue.value) { boxValue ->//For all items in array
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        if (edges.contains(i)) { //Hide corners
                            boxColor = colorResource(R.color.cornersAndBg)
                        } else if (boxValue == '#') { //if box cannot contain a letter
                            boxColor = colorResource(R.color.noLetter)
                        } else if (boxValue == '?') { //Will contain a letter
                            boxColor = colorResource(R.color.notFound)
                        } else { //contains a letter which has been found
                            boxColor = colorResource(R.color.found)
                        }

                        Box(
                            modifier = Modifier
                                .height(45.dp)
                                .padding(1.dp)
                                .background(boxColor)
                                .align(Alignment.CenterHorizontally)
                        ) {
                            if (boxValue != '#' && boxValue != '?') { //If letter should be in the box, display text
                                Text(
                                    text = "$boxValue",
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .fillMaxHeight()
                                        .padding(top = 10.dp),
                                    textAlign = TextAlign.Center
                                )
                            } else {
                                Text(
                                    text = "",
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .fillMaxHeight()
                                )
                            }

                        }
                    }
                    i++
                }
            }
        }
    }
}