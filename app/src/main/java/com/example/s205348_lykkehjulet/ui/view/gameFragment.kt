package com.example.s205348_lykkehjulet.ui.view

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.s205348_lykkehjulet.ui.viewmodel.HiddenWordsViewModel

@ExperimentalFoundationApi
@Preview (showBackground = true)
@Composable
fun gameFragment(){
    val viewModel = HiddenWordsViewModel()


    Column(modifier = Modifier.fillMaxWidth()) {

        viewModel.drawBoxes()

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
            .padding(bottom = 20.dp)) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize(align = Alignment.BottomCenter),
            Alignment.BottomCenter
        ) {
            Keyboard()
        }
    }

    println("RUN TJEK")
    viewModel.letterChosen('A')
    viewModel.letterChosen('B')
    viewModel.letterChosen('C')
    viewModel.letterChosen('D')
    viewModel.letterChosen('S')
    viewModel.letterChosen('O')
    viewModel.letterChosen('E')
    viewModel.letterChosen('T')
    println("SLUT TJEK")

}