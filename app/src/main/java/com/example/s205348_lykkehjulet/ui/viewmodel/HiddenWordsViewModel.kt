package com.example.s205348_lykkehjulet.ui.viewmodel

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import com.example.s205348_lykkehjulet.data.model.HiddenWords
import com.example.s205348_lykkehjulet.ui.view.LetterBox

class HiddenWordsViewModel {

    private val usedWords: MutableList<Int> = ArrayList()
    private val hiddenWords = HiddenWords.values()
    private val availableBoxes: MutableList<Int> = ArrayList()


    fun createAvailableBoxesArray() {
        for (i in 14..24)
            availableBoxes.add(i)

        for (i in 27..37)
            availableBoxes.add(i)
    }

    //TODO OBS: Bør åbenbart være recyclerview?


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
        var hiddenWordArray = CharArray(51)
        var i: Int = 0

        for (letter in word) {
                print(letter)
                hiddenWordArray[availableBoxes[i]]=letter
            i++
        }
        println("")

        return hiddenWordArray
    }

    fun drawBoxes(){

    }
}