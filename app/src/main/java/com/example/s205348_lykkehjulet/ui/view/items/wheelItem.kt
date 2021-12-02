package com.example.s205348_lykkehjulet.ui.view.items

import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.s205348_lykkehjulet.R
import com.example.s205348_lykkehjulet.ui.viewmodel.HiddenWordsViewModel
import kotlinx.coroutines.delay
import kotlin.random.Random

/**
 * The spinning wheel
 */
@Composable
fun WheelItem(viewModel: HiddenWordsViewModel = HiddenWordsViewModel()) {
    val direction by remember { mutableStateOf(viewModel.wheelDirection) }
    val rotateAnimation = animateFloatAsState(
        targetValue = getRandomDegrees(direction.value),
        animationSpec = tween(durationMillis = 5000)
    )
    Image(
        painter = painterResource(id = R.drawable.img_spinningwheel),
        contentDescription = null,
        contentScale = ContentScale.Fit,
        modifier = Modifier
            .width(250.dp)
            .graphicsLayer { rotationZ = rotateAnimation.value }
    )
}

fun getRandomDegrees(direction: Boolean): Float {
    var num=0F
    if (direction)
        num = Random.nextInt(5000, 5360).toFloat()
    else
        num = Random.nextInt(0, 360).toFloat()
    println("getrandomdegrees:::: $num")
    return num
}

