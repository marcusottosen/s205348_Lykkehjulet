package com.example.s205348_lykkehjulet.ui.viewmodel

import androidx.compose.runtime.*
import com.example.s205348_lykkehjulet.data.model.HiddenWords


class HiddenWordsViewModel {


    private val usedWords: MutableList<Int> = ArrayList()
    private val hiddenWords = HiddenWords.values()
    var arrayOfHiddenWord: MutableList<Char> = ArrayList()


    var wordGuessingArray: MutableList<Char> = ArrayList()

    var wordGuessingArrayState = mutableStateOf(wordGuessingArray)

    //var wordGuessingArray by mutableStateOf(CharArray)
    var hiddenWord: String = ""

    var wheelDirection: MutableState<Boolean> = mutableStateOf(true)
    var canSpin: MutableState<Boolean> = mutableStateOf(true)

    var canChooseLetter: MutableState<Boolean> = mutableStateOf(false)
    var score: MutableState<Int> = mutableStateOf(0)
    var health: MutableState<Int> = mutableStateOf(5)

    private val availableBoxes: MutableList<Int> = ArrayList()


    fun createAvailableBoxesArray() {
        for (i in 13..24)
            availableBoxes.add(i)

        for (i in 27..37)
            availableBoxes.add(i)
    }

    private fun findRandomWord() {
        if (!usedWords.size.equals(hiddenWords.size)) {
            var wordNum: Int = 0 //(0..hiddenWords.size-1).random()

            for (i in 0..hiddenWords.size) {
                wordNum = (0..hiddenWords.size - 1).random()
                if (!usedWords.contains(wordNum)
                    && hiddenWords[wordNum].toString().length <= availableBoxes.size - 1
                ) {
                    break
                }
            }

            usedWords.add(wordNum)
            println(hiddenWords[wordNum].toString())

            wordToList(hiddenWords[wordNum].phrase)
            hiddenWord = hiddenWords[wordNum].phrase
        } else {
            println("AHHHH NULL \\ All available words has been found!")

        }
    }

    /**
     * Creates an array of each letter in the secret word
     */
    private fun wordToList(word: String) {
        for (letter in word) {
            arrayOfHiddenWord.add(letter)
        }
        println("HIDDENWORDARRAY = $arrayOfHiddenWord")
    }

    /**
     * Creates array with the length of all the boxes (52) and adds letters to the correct boxes
     * # = box will never contain a letter
     * ? = box will contain a letter
     */
    private fun createWordGuessingArray(word: String): MutableList<Char> {
        var n = 1

        for (i in 0..51) {
            wordGuessingArray.add('#')
        }

        for (letter in word) {
            wordGuessingArray[availableBoxes[n]] = '?'
            n++
        }
        return wordGuessingArray

    }


    fun prepareBoxes() {
        createAvailableBoxesArray()
        findRandomWord()
        createWordGuessingArray(hiddenWord)
    }

    /**
     * Checks if the chosen letter is in the hidden word and adds it to wordGuessingArray which holds data for all 52 boxes
     * Function makes sure the letters are inserted into the correct boxes
     * letterIndex = list of which index/indexes the current letter is in the current word
     */

    fun letterChosen(letter: Char) {
        canSpin.value = true
        canChooseLetter.value = false

        println("$letter letter clicked")
        //LettersUsed.add(letter)
        //LettersFound.add(letter)
        //println("hidden word array!== $hiddenWordArray which is ${hiddenWordArray.size} long")
        //println("Word Guessing array!== $wordGuessingArray which is ${wordGuessingArray.size} long")
        //println("Letters Found array!== $LettersFound which is ${LettersFound.size} long")

        if (arrayOfHiddenWord.contains(letter)) { //if letter is in secret word
            //val letterIndex: MutableList<Int> = ArrayList() //letterIndex.add(i)
            for (i in 1..arrayOfHiddenWord.size) { //Goes through whole array of boxes
                if (arrayOfHiddenWord[i - 1] != '\u0000' && arrayOfHiddenWord[i - 1] == letter) {
                    score.value = score.value + 100
                    val index = availableBoxes.first() + i
                    if (index > 24) {
                        wordGuessingArray[index + 2] = letter
                    } else {
                        wordGuessingArray[index] = letter
                    }
                }
            }
        } else {
            health.value = health.value - 1
        }
    }
}