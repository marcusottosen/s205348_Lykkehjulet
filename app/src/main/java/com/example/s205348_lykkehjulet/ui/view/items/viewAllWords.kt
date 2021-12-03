package com.example.s205348_lykkehjulet.ui.view.items

import android.content.Context
import android.view.LayoutInflater
import android.widget.TextView
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController
import com.example.s205348_lykkehjulet.R
import androidx.annotation.DrawableRes

/*
@Composable
fun CustomView(){
    val selectedItem = remember { mutableStateOf(0) }

    AndroidView(
        viewBlock = { context: Context ->
            val view = LayoutInflater.from(context)
                .inflate(R.layout.view_all_words, null, false)
            val textView = view.findViewById<TextView>(R.id.text)
            // do whatever you want...
            view // return the view
        },

    )
}

@Composable
fun ViewAllWords(navController: NavController) {
    Column(Modifier.fillMaxSize()) {
        Text("Look at this CustomView!")
        CustomView()
    }
}

@Composable
fun AnExampleScreen(click: () -> Unit) {

    AndroidView(
        viewBlock = ::MyButtonView,
        modifier = Modifier.fillMaxWidth(),
    ) { button ->
        button.text = "Hello world!"
        button.setOnClickListener {
            click()
        }
    }
}

@Composable
fun rememberCustomView(): CustomView {
    val context = LocalContext.current
    return remember { CustomView(context).apply { /*...*/ } }
}
*/