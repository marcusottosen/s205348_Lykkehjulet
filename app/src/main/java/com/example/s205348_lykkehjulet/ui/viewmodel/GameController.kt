package com.example.s205348_lykkehjulet.ui.viewmodel

import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.ViewGroup
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
import androidx.recyclerview.widget.RecyclerView
import com.example.s205348_lykkehjulet.ui.view.LetterBox
import com.example.s205348_lykkehjulet.ui.view.DefaultButton
import java.util.concurrent.TimeUnit

class GameController {
    val hiddenWord  = HiddenWordsViewModel()

    @ExperimentalFoundationApi
    @Composable
    fun GameController(){
        //RunWordGuessing()
        GetButton()
    }


    @ExperimentalFoundationApi
    @Composable
    fun RunWordGuessing() {
        hiddenWord.createAvailableBoxesArray()

        var lettersFound = intArrayOf(14, 15, 18) //TODO make right


      //  LetterBox(
      //      boxValues = hiddenWord.makeFullWordArray(hiddenWord.getRandomWord()),
      //      lettersFound = lettersFound
      //  )
    }



    @ExperimentalFoundationApi
    @Composable
    fun GetButton(){
        val getNewWord = remember { mutableStateOf(false)}
        println("getButton")

        Column(
            // we are using column to align our
            // imageview to center of the screen.
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            DefaultButton(text = "Find new word",
                onClick = { getNewWord.value = true })
        }

        if (getNewWord.value){
            println("NEW WORD FOUND1")
            RunWordGuessing()
            getNewWord.value=true
            println("NEW WORD FOUND2")
        } else
            println("nope")
    }
}
