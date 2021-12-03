package com.example.s205348_lykkehjulet.ui.viewmodel

import androidx.compose.runtime.*
import androidx.navigation.NavController
import com.example.s205348_lykkehjulet.data.model.HiddenWords
import com.example.s205348_lykkehjulet.data.model.WheelItems


class HiddenWordsViewModel() {


    private val hiddenWords = HiddenWords.values()
    var arrayOfHiddenWord: MutableList<Char> = mutableListOf()
    var wordGuessingArray: MutableList<Char> = mutableListOf()
    var wordGuessingArrayState = mutableStateOf(wordGuessingArray)
    private val availableBoxes: MutableList<Int> = mutableListOf()

    var hiddenWord: String = ""
    var numOfLettersFound = 0
    var lastDegrees = 0F

    var currentWheelItem: String = "GET100"
    var wheelDirection: MutableState<Boolean> = mutableStateOf(true)
    var canSpin: MutableState<Boolean> = mutableStateOf(true)
    var canChooseLetter: MutableState<Boolean> = mutableStateOf(false)

    var score: MutableState<Int> = mutableStateOf(0)
    var health: MutableState<Int> = mutableStateOf(5)


    fun createAvailableBoxesArray() {
        for (i in 13..24)
            availableBoxes.add(i)

        for (i in 27..37)
            availableBoxes.add(i)
    }

    private fun findRandomWord() {
        var wordNum = 0

        for (i in 0..hiddenWords.size) {
            wordNum = (0..hiddenWords.size - 1).random()
            if (hiddenWords[wordNum].toString().length <= availableBoxes.size - 1
            ) {
                break
            }
        }
        wordToList(hiddenWords[wordNum].phrase)
        hiddenWord = hiddenWords[wordNum].phrase
    }

    /**
     * Creates an array of each letter in the secret word
     */
    private fun wordToList(word: String) {
        for (letter in word) {
            if (arrayOfHiddenWord.size == availableBoxes.size / 2) {
                arrayOfHiddenWord.add('#')
                arrayOfHiddenWord.add('#')
            }
            arrayOfHiddenWord.add(letter)
        }
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
            if (letter == ' ' || letter == '-') {
                wordGuessingArray[availableBoxes[n]] = letter
                numOfLettersFound++
                n++
            } else {
                wordGuessingArray[availableBoxes[n]] = '?'
                n++
            }
        }
        return wordGuessingArray
    }

    /**
     * Resets values in order to play game again
     * A new object should be created instead, but that bugs out the whole fragment.
     * Prepares for a new game
     */
    fun prepareBoxes() {
        score.value = 0
        health.value = 5
        numOfLettersFound = 0
        wheelDirection.value = true
        canSpin.value = true
        canChooseLetter.value = false
        arrayOfHiddenWord.clear()
        wordGuessingArray.clear()
        availableBoxes.clear()

        createAvailableBoxesArray()
        findRandomWord()
        createWordGuessingArray(hiddenWord)
    }

    fun wheelSpun() {
        wheelDirection.value = !wheelDirection.value
        canSpin.value = !canSpin.value
        canChooseLetter.value = true

        if (WheelItems.valueOf(currentWheelItem) == WheelItems.BANKRUPT) {
            health.value = 0
        } else if (WheelItems.valueOf(currentWheelItem) == WheelItems.EXTRATURN) {
            health.value += 1
        } else if (WheelItems.valueOf(currentWheelItem) == WheelItems.MISSTURN) {
            health.value -= 1
        } else {
            score.value = score.value + WheelItems.valueOf(currentWheelItem).value
        }

    }

    /**
     * Checks if the chosen letter is in the hidden word and adds it to wordGuessingArray which holds data for all 52 boxes
     * Function makes sure the letters are inserted into the correct boxes
     * letterIndex = list of which index/indexes the current letter is in the current word
     */
    fun letterChosen(letter: Char) {
        canSpin.value = true
        canChooseLetter.value = false

        if (arrayOfHiddenWord.contains(letter)) { //if letter is in secret word
            for (i in 1..arrayOfHiddenWord.size) { //Go through whole array of boxes
                if (arrayOfHiddenWord[i - 1] != '\u0000' && arrayOfHiddenWord[i - 1] == letter) {
                    score.value = score.value + WheelItems.valueOf(currentWheelItem).value
                    val index = availableBoxes.first() + i
                    wordGuessingArray[index] = letter
                    numOfLettersFound++
                }
            }
        } else {
            health.value = health.value - 1
        }
    }
}