package com.example.s205348_lykkehjulet

sealed class Screen(val route: String){
    object StartScreen : Screen("startPage")
    object GameScreen : Screen("gameFragment")
    object LoseScreen : Screen("LoseFragment")
    object WinScreen : Screen("WinFragment")
}
