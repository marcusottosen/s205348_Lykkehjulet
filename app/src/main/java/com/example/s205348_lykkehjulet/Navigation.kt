package com.example.s205348_lykkehjulet

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.s205348_lykkehjulet.ui.view.gameFragment
import com.example.s205348_lykkehjulet.ui.view.getStartScreen

@ExperimentalFoundationApi
@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.StartScreen.route){
        composable(route = Screen.StartScreen.route){
            getStartScreen(navController)
        }
        composable(
            route = Screen.GameScreen.route
        ){
            gameFragment()
        }
    }
}