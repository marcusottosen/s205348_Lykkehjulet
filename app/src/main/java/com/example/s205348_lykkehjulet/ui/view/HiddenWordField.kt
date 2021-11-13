package com.example.s205348_lykkehjulet.ui.view

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@ExperimentalFoundationApi
@Composable
fun LetterBox() { //2D array med $it og tilsvarende bogstav: foundLetters:Array<Array<Int>>,

    val found = intArrayOf(5, 6, 7)
    val edges = intArrayOf(0, 12, 39, 51)
    val numbers = (0..51).toList()

    val bgColor = intArrayOf(0, 0, 0, 0)


    LazyVerticalGrid(
        cells = GridCells.Fixed(13),
        modifier = Modifier.padding(top = 20.dp)
    ) {
        items(numbers) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                if (edges.contains(it)) {
                    bgColor[0] = 0                                  //Bør være i theme>color?
                    bgColor[1] = 0
                    bgColor[2] = 0
                    bgColor[3] = 0
                } else if (!found.contains(it)) {
                    bgColor[0] = 52
                    bgColor[1] = 152
                    bgColor[2] = 219
                    bgColor[3] = 255
                } else {
                    bgColor[0] = 231
                    bgColor[1] = 76
                    bgColor[2] = 60
                    bgColor[3] = 255
                }

                Box(
                    modifier = Modifier
                        .height(50.dp)
                        .padding(1.dp)
                        .border(
                            width = 1.dp,
                            color = Color(bgColor[0], bgColor[1], bgColor[2], bgColor[3])
                        )
                        .background(Color(bgColor[0], bgColor[1], bgColor[2], bgColor[3]))
                        .align(Alignment.CenterHorizontally)
                ) {
                    Text(
                        text = "$it",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight()
                            .padding(top = 10.dp),
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}





                /*if (edges.contains(it)) { // fjerner de 4 hjørner
                    Box(
                        modifier = Modifier
                            .height(50.dp)
                            .padding(1.dp)
                            .border(width = 1.dp, color = Color.Transparent)
                            .background(Color(bgColor[0], bgColor[1], bgColor[2], bgColor[3]))
                            .align(Alignment.CenterHorizontally)
                    )
                } else if (!found.contains(it)) { //bogstaverne
                    Box(
                        modifier = Modifier
                            .height(50.dp)
                            .padding(1.dp)
                            .border(width = 1.dp, color = Color(41, 128, 185))
                            .background(Color(52, 152, 219))
                            .align(Alignment.CenterHorizontally)
                    ) {
                        Text(
                            text = "$it",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .fillMaxWidth()
                                .fillMaxHeight()
                                .padding(top = 10.dp),
                            textAlign = TextAlign.Center
                        )
                    }
                }  else { //resten
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Box(
                            modifier = Modifier
                                .height(50.dp)
                                .padding(1.dp)
                                .border(width = 1.dp, color = Color(41, 128, 185))
                                .background(Color(231, 76, 60))
                                .align(Alignment.CenterHorizontally)
                        ) {
                            Text(
                                text = "$it",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .fillMaxHeight()
                                    .padding(top = 10.dp),
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                }
            }
        }
    }
}*/




/*Column(
    verticalArrangement = Arrangement.Center,
    modifier = Modifier.wrapContentSize(Alignment.Center).padding(horizontal = 10.dp, vertical = 20.dp)
) {
    for (col in 1 until 5) {
        LazyVerticalGrid(
            cells = GridCells.Fixed(13),

        ) {
            items(13) { index ->
                Box (
                    modifier = Modifier
                        .height(50.dp)
                        .padding(1.dp).border(width = 1.dp, color = Color(41, 128, 185))
                        .background(Color(52, 152, 219))
                        .align(Alignment.CenterHorizontally)
                        .shadow(elevation = 3.dp),
                ){
                    Text(
                        text = "A $it",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.fillMaxWidth().fillMaxHeight().padding(top = 10.dp),
                        textAlign = TextAlign.Center)
                }
            }
        }
    }
}*/