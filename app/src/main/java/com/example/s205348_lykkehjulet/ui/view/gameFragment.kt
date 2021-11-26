package com.example.s205348_lykkehjulet.ui.view

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.s205348_lykkehjulet.ui.viewmodel.HiddenWordsViewModel

@ExperimentalFoundationApi
@Preview
@Composable
fun gameFragment(){
    val viewModel = HiddenWordsViewModel()


    Column(modifier = Modifier.fillMaxWidth()) {
        viewModel.drawBoxes()

        DefaultButton(
            text = "hello",
            onClick = {})

    }

    Column(
        modifier = Modifier.fillMaxSize()
            .wrapContentSize(align = Alignment.BottomCenter)
            .padding(bottom = 20.dp)) {
        Box(
            modifier = Modifier.fillMaxWidth().wrapContentSize(align = Alignment.BottomCenter),
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