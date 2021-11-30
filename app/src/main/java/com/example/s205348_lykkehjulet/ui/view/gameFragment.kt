package com.example.s205348_lykkehjulet.ui.view

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.s205348_lykkehjulet.R
import com.example.s205348_lykkehjulet.ui.viewmodel.HiddenWordsViewModel


 class gameFragment {


    @ExperimentalFoundationApi
    //@Preview(showBackground = true)
    @Composable
    fun runGameFragment() {
        val viewModel = HiddenWordsViewModel()

        println("RUNGAMEFRAGMENT HAS BEEN RUN")
        Column(modifier = Modifier.fillMaxWidth()) {

            viewModel.DrawBoxes()

            Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Health: 5",
                    modifier = Modifier.padding(20.dp, 10.dp, 0.dp, 0.dp),
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "score: 100",
                    modifier = Modifier.padding(0.dp, 10.dp, 20.dp, 0.dp),
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }


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
                    modifier = Modifier.padding(10.dp, 20.dp, 10.dp, 20.dp),
                ) {
                    items(getAlphabet().toList()) { //For all items in array
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Button(
                                onClick = { viewModel.letterChosen(it) },
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
        }

      //  println("RUN TJEK")
        viewModel.letterChosen('A')
      //  viewModel.letterChosen('B')
        viewModel.letterChosen('C')
      //  viewModel.letterChosen('D')
      //  viewModel.letterChosen('S')
      //  viewModel.letterChosen('O')
      //  viewModel.letterChosen('E')
      //  viewModel.letterChosen('T')
      //  println("SLUT TJEK")

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

   // fun letterClicked(letter: Char){
   //     viewModel.letterChosen(letter)
   // }
}