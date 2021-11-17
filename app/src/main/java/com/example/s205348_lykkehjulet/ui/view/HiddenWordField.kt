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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.s205348_lykkehjulet.R


@ExperimentalFoundationApi
@Composable
fun LetterBox(boxValue: CharArray, lettersFound: IntArray) {

    //Default values
    val edges = intArrayOf(0, 12, 39, 51)
    var boxColor = colorResource(R.color.cornersAndBg)
    var i: Int = 0


    LazyVerticalGrid(
        cells = GridCells.Fixed(13),
        modifier = Modifier.padding(10.dp, 20.dp, 10.dp,0.dp)
    ) {
        items(boxValue.toList()) { //For all items in array
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                if (edges.contains(i)) { //Corners //alpha 0.0f
                    boxColor = colorResource(R.color.cornersAndBg)

                } else if (boxValue[i]=='\u0000') { //if box does not contain a letter
                    boxColor = colorResource(R.color.noLetter)
                } else if (lettersFound.contains(i)){
                    boxColor = colorResource(R.color.found)
                } else { //contains a letter
                    boxColor = colorResource(R.color.notFound)
                }//TODO Add FOUND

                Box(
                    modifier = Modifier
                        .height(50.dp)
                        .padding(1.dp)

                        .background(boxColor)
                        .align(Alignment.CenterHorizontally)
                ) {
                    if (lettersFound.contains(i)) {
                        Text(
                            text = "$it",
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
                                .padding(top = 10.dp)
                        )
                    }
                }
            }
            i++
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