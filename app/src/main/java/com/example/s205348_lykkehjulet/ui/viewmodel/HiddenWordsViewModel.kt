package com.example.s205348_lykkehjulet.ui.viewmodel

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import com.example.s205348_lykkehjulet.data.model.HiddenWords
import com.example.s205348_lykkehjulet.ui.view.LetterBox


class HiddenWordsViewModel {

    private val usedWords: MutableList<Int> = ArrayList()
    private val hiddenWords = HiddenWords.values()
    var hiddenWordArray = CharArray(51)


    var LettersFound: MutableList<Int> = ArrayList()
    var LettersUsed: MutableList<Char> = ArrayList()

    var LetterTest by mutableStateOf(LettersFound)

    private val availableBoxes: MutableList<Int> = ArrayList()



    fun createAvailableBoxesArray() {
        for (i in 14..24)
            availableBoxes.add(i)

        for (i in 27..37)
            availableBoxes.add(i)
    }

    fun getRandomWord(): String {
        if (!usedWords.size.equals(hiddenWords.size)) {
            var wordNum: Int = 0 //(0..hiddenWords.size-1).random()

            for (i in 0..hiddenWords.size) {
                wordNum = (0..hiddenWords.size - 1).random()
                if (!usedWords.contains(wordNum)
                    && hiddenWords[wordNum].toString().length <= availableBoxes.size - 1){
                    break
                }
            }
            //LetterBox(makeFullWordArray(hiddenWords[wordNum].toString()))

            usedWords.add(wordNum)
            println(hiddenWords[wordNum].toString())
            return hiddenWords[wordNum].toString()
        } else {
            println("AHHHH NULL \\ All available words has been found!")
            return "null"
        }
    }

    /**
     * Creates an array with the lenght of all boxes and inserts the letters of the words into the correct index
     * Each index is a box
     */
    fun makeFullWordArray(word:String): CharArray{
        var i = 0

        for (letter in word) {
                print(letter)
                hiddenWordArray[availableBoxes[i]]=letter
            i++
        }
        return hiddenWordArray
    }

    @ExperimentalFoundationApi
    @Composable
    fun DrawBoxes(){
        createAvailableBoxesArray()
        val LetterTestt = remember{ mutableStateOf(LettersFound)}

        LetterTest = LettersFound
        LetterBox(
            boxValues = makeFullWordArray(getRandomWord()),
            lettersFound = LettersFound
            //onLettersFoundChange = {LettersFound = it}
        )
    }

    /**
     * Checks if the chosen letter is in the hidden word
     */
    fun letterChosen(letter: Char) {
        LettersUsed.add(letter)
        if (hiddenWordArray.contains(letter)) {
            for (i in 1..hiddenWordArray.size) {
                if (hiddenWordArray[i-1] != '\u0000' && hiddenWordArray[i-1] ==letter) {
                    println("$letter is in the hidden word at $i!!")
                    LettersFound.add(i-1)
                }
            }
        } else {
            // Letter not found in word
            // life -1
        }
    }
}













