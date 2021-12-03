package com.example.s205348_lykkehjulet

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import com.example.s205348_lykkehjulet.ui.theme.S205348_LykkehjuletTheme

//import com.example.s205348_lykkehjulet.ui.viewmodel.HiddenWordsViewModel

class MainActivity : ComponentActivity() {
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            S205348_LykkehjuletTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Navigation()

                }
            }
        }
    }
}