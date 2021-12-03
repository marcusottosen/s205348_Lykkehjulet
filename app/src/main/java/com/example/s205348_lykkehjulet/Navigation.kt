package com.example.s205348_lykkehjulet

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.s205348_lykkehjulet.ui.view.GameFragment
import com.example.s205348_lykkehjulet.ui.view.getStartScreen
import com.example.s205348_lykkehjulet.ui.view.items.LoseGameFragment
import com.example.s205348_lykkehjulet.ui.view.items.WinGameFragment
import com.example.s205348_lykkehjulet.ui.viewmodel.HiddenWordsViewModel

@ExperimentalFoundationApi
@Composable
fun Navigation(){
    val navController = rememberNavController()
    val viewModel = HiddenWordsViewModel()
    viewModel.prepareBoxes()

    NavHost(navController = navController, startDestination = Screen.StartScreen.route){

        composable(route = Screen.StartScreen.route){
            getStartScreen(navController)
        }

        composable(route = Screen.GameScreen.route){
            GameFragment(viewModel, navController)
        }

        composable(route = Screen.LoseScreen.route){
            LoseGameFragment(navController)
        }

        composable(route = Screen.WinScreen.route){
            WinGameFragment(navController)
        }
    }
}
