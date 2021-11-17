package com.example.s205348_lykkehjulet.ui.viewmodel

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.s205348_lykkehjulet.ui.view.LetterBox
import com.example.s205348_lykkehjulet.ui.view.defaultButton

class GameController {
    val hiddenWord  = HiddenWordsViewModel()

    @ExperimentalFoundationApi
    @Composable
    fun GameController(){
        RunWordGuessing()
        GetButton()
    }


    @ExperimentalFoundationApi
    @Composable
    fun RunWordGuessing(){
        hiddenWord.createAvailableBoxesArray()

        var lettersFound = intArrayOf(14,15,18)
        LetterBox(
            boxValue = hiddenWord.makeFullWordArray(hiddenWord.getRandomWord()),
            lettersFound
        )
    }

    @ExperimentalFoundationApi
    @Composable
    fun GetButton(){
        val getNewWord = remember { mutableStateOf(true)}

        Column(
            // we are using column to align our
            // imageview to center of the screen.
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            defaultButton(text = "Find new word", checked = true, onClick = { getNewWord.value = true })
        }

        if (getNewWord.value){
            println("NEW WORD FOUND")
            RunWordGuessing()
            getNewWord.value=false
            println("NEW WORD FOUND")
        }
    }
}
//TODO Få defaultButton til at returnere en value somehow