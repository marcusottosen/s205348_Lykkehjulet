package com.example.s205348_lykkehjulet.ui.view

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material.Card
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


@ExperimentalFoundationApi
@Composable //onLettersFoundChange: (Char) -> Unit
fun LetterBox(boxValueState: MutableList<Char>) { //boxValues: CharArray, lettersFound: MutableList<Int>

    //println("listevalues size ======== ${boxValues.size}")
    //val boxValues = mutableListOf(liste.value).apply {addAll(liste.value)}

    //val _boxValues = remember{ mutableStateOf(boxValues)}

    val boxValues = remember { boxValueState } as MutableList<Char>


    //var _boxValues = rememberSaveable{boxValues}
    //Default values
    val edges = intArrayOf(0, 12, 39, 51)
    var boxColor = colorResource(R.color.cornersAndBg)
    var i: Int = 0

    //println("lettsfound Size: ${lettersFound.size}")

    //println("boxValues======= ${_boxValues.value}")

    Card(elevation = 10.dp) {
        LazyVerticalGrid(
            //state = rememberLazyListState(),
            cells = GridCells.Fixed(13),
            modifier = Modifier.padding(10.dp, 20.dp, 10.dp, 20.dp)
        ) {
            items(boxValues) { boxValue ->//For all items in array
                //println("i is= $i")
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    if (edges.contains(i)) { //Corners
                        boxColor = colorResource(R.color.cornersAndBg)
                    }
                    if (boxValue == '#') { //if box does not contain a letter
                        boxColor = colorResource(R.color.noLetter)
                    } else if (boxValue == '?') { //Will contain letter later
                        boxColor = colorResource(R.color.notFound)
                    } else { //contains a letter which has been found
                        boxColor = colorResource(R.color.found)
                    }

                    //println("does $lettersFound contain $it ??")

                    Box(
                        modifier = Modifier
                            .height(50.dp)
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