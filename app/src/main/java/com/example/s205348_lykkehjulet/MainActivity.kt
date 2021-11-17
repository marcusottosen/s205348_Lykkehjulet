package com.example.s205348_lykkehjulet

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.example.s205348_lykkehjulet.ui.theme.S205348_LykkehjuletTheme
import com.example.s205348_lykkehjulet.ui.view.defaultButton
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.s205348_lykkehjulet.ui.view.LetterBox
import com.example.s205348_lykkehjulet.ui.viewmodel.HiddenWordsViewModel

//import com.example.s205348_lykkehjulet.ui.viewmodel.HiddenWordsViewModel

class MainActivity : ComponentActivity() {
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            S205348_LykkehjuletTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    DefaultPreview()
                }
            }
        }
    }
}



@Composable
fun MyButton() {
    Column(
        // we are using column to align our
        // imageview to center of the screen.
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        // below line is use to get
        // the context for our app.
        //val context = ContextAmbient.current

        // below line is use to create a button.
        Button(
            onClick = { },
            contentPadding = PaddingValues(
                start = 20.dp,
                top = 12.dp,
                end = 20.dp,
                bottom = 12.dp
            )
        )
        {
            Text(text = "click on me!", color = Color.White)
        }
    }
}


@ExperimentalFoundationApi
@Preview(showBackground = true, widthDp = 500, heightDp = 1000)
@Composable
fun DefaultPreview() {
    S205348_LykkehjuletTheme {
        //defaultButton(text = "ehh", checked = false, onClick = { Unit })
        MyButton()
        val hiddenWord  = HiddenWordsViewModel()
        hiddenWord.createAvailableBoxesArray()
        LetterBox(boxValue = hiddenWord.makeFullWordArray(hiddenWord.getRandomWord()))

    }
}