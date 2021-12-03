package com.example.s205348_lykkehjulet

sealed class Screen(val route: String){
    object StartScreen : Screen("getStartScreen")
    object GameScreen : Screen("GameFragment")
    object LoseScreen : Screen("LoseGameFragment")
    object WinScreen : Screen("WinFragment")
    object ViewWordsScreen : Screen("ViewWordsFragment")
}
