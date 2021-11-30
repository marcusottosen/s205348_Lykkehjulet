package com.example.s205348_lykkehjulet.ui.viewmodel

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.*
import androidx.compose.runtime.snapshots.SnapshotStateList
import com.example.s205348_lykkehjulet.data.model.HiddenWords
import com.example.s205348_lykkehjulet.ui.view.LetterBox


class HiddenWordsViewModel {

    private val usedWords: MutableList<Int> = ArrayList()
    private val hiddenWords = HiddenWords.values()
    var hiddenWordArray: MutableList<Char> = ArrayList()


    //var LettersFound: MutableList<Int> = ArrayList()
    var LettersUsed: MutableList<Char> = ArrayList()
    var LettersFound = mutableListOf<Char>('A','B','E')

    //var LetterTest by mutableStateOf(LettersFound)
    var wordGuessingArray: MutableList<Char> = ArrayList()
    //var wordGuessingArray by mutableStateOf(CharArray)
    var randomWord: String = ""

    //var charAr = "MONOPOLIST".toCharArray()
    //val state: SnapshotStateList<CharArray> = mutableStateListOf(charAr)


    private val availableBoxes: MutableList<Int> = ArrayList()



    fun createAvailableBoxesArray() {
        for (i in 14..24)
            availableBoxes.add(i)

        for (i in 27..37)
            availableBoxes.add(i)
    }

    fun findRandomWord() {
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

            makeWordToList(hiddenWords[wordNum].toString())

            randomWord = hiddenWords[wordNum].toString()
        } else {
            println("AHHHH NULL \\ All available words has been found!")

        }
    }

    /**
     * Creates an array of each letter in the secret word
     */
    fun makeWordToList(word:String) {
        //var i = 0

        for (letter in word){
            hiddenWordArray.add(letter)
        }

        /*for (letter in word) {
                print(letter)
                hiddenWordArray[availableBoxes[i]]=letter
            i++
        }*/
        println("HIDDENWORDARRAY!! = $hiddenWordArray")
    }

    /**
     * Creates array with the length of all the boxes (52) and adds letters to the correct boxes
     * # = box will never contain a letter
     * ? = box will contain a letter
     */
    fun createWordGuessingArray(word:String):MutableList<Char>{
        var n = 0

        for (i in 0..51){
            wordGuessingArray.add('#')
        }

        for (letter in word){
            wordGuessingArray[availableBoxes[n]]='?'
            n++
        }
        return wordGuessingArray
    }

    @ExperimentalFoundationApi
    @Composable
    fun DrawBoxes(){
        createAvailableBoxesArray()



        findRandomWord()
        createWordGuessingArray(randomWord)
        //val mList: List<Char> by remember {  mutableStateOf (listOf()) }
        //val boxarray by remember{mutableStateListOf(wordGuessingArray)}
        //var boxarray by mutableStateListOf(wordGuessingArray)

        //val LetterTestt = mutableListOf<Int>().apply {addAll(LettersFound)}

        //LetterTest = LettersFound

        //TODO: få letterbox til at opdatere når wordGuessingArray ændres

        println("LETTERSFOUND=== $LettersFound")

        LetterBox(
            boxValueState = wordGuessingArray,
            //onLettersFoundChange = {LettersFound = it}
        //makeWordArray(getRandomWord())
        )
    }

    /**
     * Checks if the chosen letter is in the hidden word and adds to the LettersFound list
     */
    fun letterChosen(letter: Char) {
        println("$letter letter clicked")
        LettersUsed.add(letter)
        LettersFound.add(letter)
        wordGuessingArray.add(letter)
        println("hidden word array!== $hiddenWordArray which is ${hiddenWordArray.size} long")
        println("Word Guessing array!== $wordGuessingArray which is ${wordGuessingArray.size} long")
        println("Letters Found array!== $LettersFound which is ${LettersFound.size} long")

        if (hiddenWordArray.contains(letter)) {
            println("do I run??")
            val letterIndex: MutableList<Int> = ArrayList()
            for (i in 1..hiddenWordArray.size){
                if (hiddenWordArray[i-1] != '\u0000' && hiddenWordArray[i-1] == letter){
                    letterIndex.add(i)
                    println("$letter is in the hidden word at ${i+13}!!")
                }
            }
            for (index in letterIndex){
                wordGuessingArray[14+index] = letter
            }
            println("LETTERS HAS BEEN ADDED: $wordGuessingArray")

            /*for (i in 1..hiddenWordArray.size) {
                if (hiddenWordArray[i-1] != '\u0000' && hiddenWordArray[i-1] ==letter) {
                    println("$letter is in the hidden word at $i!!")
                    LettersFound.add(letter)
                }
            }*/
        } else {
            // Letter not found in word
            // life -1
        }
    }
}













