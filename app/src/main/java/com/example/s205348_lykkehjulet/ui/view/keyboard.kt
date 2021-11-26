package com.example.s205348_lykkehjulet.ui.view

import androidx.compose.animation.expandHorizontally
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.s205348_lykkehjulet.R

//TODO: Få knapperne til at virke. Knappens char skal sendes til gameFragment somehow

@ExperimentalFoundationApi
@Composable
fun Keyboard() {
    LazyVerticalGrid(
        cells = GridCells.Fixed(7),
        modifier = Modifier.padding(10.dp, 20.dp, 10.dp, 20.dp),
    ) {
        items(getAlphabet().toList()) { //For all items in array
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier.height(50.dp)
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
                            .fillMaxHeight()
                            .padding(top = 10.dp),
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}


fun getAlphabet():MutableList<Char>{
    val alphabet: MutableList<Char> = ArrayList()

    var letter = 'A'
    while (letter <= 'Z') {
        alphabet.add(letter)
        ++letter
    }
    return alphabet
}