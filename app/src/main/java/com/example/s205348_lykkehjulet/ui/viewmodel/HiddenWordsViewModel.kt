package com.example.s205348_lykkehjulet.ui.viewmodel

import com.example.s205348_lykkehjulet.data.model.HiddenWord

/*class HiddenWordsViewModel {

    private val usedWords: MutableList<Int> = ArrayList()
    private val hiddenWord = HiddenWord.values()
    private val availableBoxes: MutableList<Int> = ArrayList()


    fun createAvailableBoxesArray() {
        for (i in 14..24)
            availableBoxes.add(i)

        for (i in 27..37)
            availableBoxes.add(i)
        println("lenght of availableBoxes: ${availableBoxes.size}")
    }

    //TODO 2d array af nummer og bogstav
    fun wordTo2DArray() {
        val word = getRandomWord()
        if (word!=null) {
            println("random number: $word")
        }
    }

    private fun getRandomWord(): String? {
        if (!usedWords.size.equals(hiddenWord.size)) {
            var wordNum: Int = (0..hiddenWord.size-1).random()

            while (usedWords.size < hiddenWord.size
                //&& !usedWords.contains(wordNum)
            //&& hiddenWord[wordNum].toString().length <= availableBoxes.size - 1
            ) {
                wordNum = (0..hiddenWord.size-1).random()
            }
            usedWords.add(wordNum)
            println("$wordNum added!")
            println(hiddenWord[wordNum].toString())
            return hiddenWord[wordNum].toString()
        } else {
            println("AHHHH NULL")
            return null
        }
    }
}*/