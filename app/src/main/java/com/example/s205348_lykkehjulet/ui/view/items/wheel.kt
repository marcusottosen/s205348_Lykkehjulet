package com.example.s205348_lykkehjulet.ui.view.items

import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.s205348_lykkehjulet.R
import com.example.s205348_lykkehjulet.ui.viewmodel.HiddenWordsViewModel
import kotlin.random.Random

/**
 * The spinning wheel with animation
 */
@Composable
fun Wheel(viewModel: HiddenWordsViewModel = HiddenWordsViewModel()) {
    val direction by remember { mutableStateOf(viewModel.wheelDirection) }
    val degrees = getRandomDegrees(direction.value, viewModel)

    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        //Draw the triangle
        Canvas(
            modifier = Modifier
                .size(10.dp)
        ) {
            val trianglePath = Path().apply {
                val height = size.height
                val width = size.width
                moveTo(0f, 0f)
                lineTo(width, 0f)
                lineTo(width / 2, height)
            }
            drawPath(trianglePath, color = Color.Black)
        }

        //The wheel of fortune and its animation
        val rotateAnimation = animateFloatAsState(
            targetValue = degrees,
            animationSpec = tween(durationMillis = 3000)
        )
        Image(
            painter = painterResource(id = R.drawable.img_spinningwheel),
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .width(200.dp)
                .graphicsLayer { rotationZ = rotateAnimation.value }
        )
    }
}

fun getRandomDegrees(
    direction: Boolean,
    viewModel: HiddenWordsViewModel = HiddenWordsViewModel()
): Float {
    var degrees: Float
    val lastDegrees = viewModel.lastDegrees

    if (direction)
        degrees = Random.nextInt(4000, 4360).toFloat()
    else
        degrees = Random.nextInt(0, 360).toFloat()

    //Gets rid of unwanted small rotation animations
    if (degrees < lastDegrees - 360F || degrees > lastDegrees + 360F || degrees == 0F)
        viewModel.lastDegrees = degrees
    else
        degrees = lastDegrees


    val wheelItemString = when (degrees.toInt()) {
        in 0..30 -> "EXTRATURN"
        in 30..60 -> "GET200"
        in 60..90 -> "GET500"
        in 90..120 -> "GET1000"
        in 120..150 -> "GET100"
        in 150..180 -> "BANKRUPT"
        in 180..210 -> "GET200"
        in 210..240 -> "GET500"
        in 240..270 -> "GET1000"
        in 270..300 -> "GET100"
        in 300..330 -> "MISSTURN"
        in 330..360 -> "GET500"

        in 4000..4030 -> "EXTRATURN"
        in 4030..4060 -> "GET200"
        in 4060..4090 -> "GET500"
        in 4090..4120 -> "GET1000"
        in 4120..4150 -> "GET100"
        in 4150..4180 -> "BANKRUPT"
        in 4180..4210 -> "GET200"
        in 4210..4240 -> "GET500"
        in 4240..4270 -> "GET1000"
        in 4270..4300 -> "GET100"
        in 4300..4330 -> "MISSTURN"
        in 4330..4360 -> "GET500"
        else -> "other"
    }
    viewModel.currentWheelItem = wheelItemString
    return -degrees
}

