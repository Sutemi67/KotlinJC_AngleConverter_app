package com.example.calculator

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.calculator.ui.theme.CalculatorTheme
import com.example.calculator.ui.theme.headerTextStyle
import com.example.calculator.ui.theme.labelTextStyle
import java.util.Locale
import kotlin.math.floor

@Composable
fun Changer() {
    var inputText by remember { mutableStateOf("") }
    val degrees: Double = inputText.toDoubleOrNull() ?: 0.0

    val radian: Double = degrees * 0.01745
    val radianCalc = String.format(Locale.US, "%.2f", radian)

    val degreesCalc = floor(degrees)
    val minutesCalc = floor((degrees - degreesCalc) * 60)
    val secondsCalc = ((degrees - degreesCalc) * 60 - minutesCalc) * 60

    val roundSec = secondsCalc.toInt()
    val roundMin = minutesCalc.toInt()
    val roundDeg = degreesCalc.toInt()

    val grad: Double = degrees * 0.9
    val roundGrad = String.format(Locale.US, "%.2f", grad)

    val infiniteTransition = rememberInfiniteTransition()
    val color by infiniteTransition.animateColor(
        initialValue = Color.Gray,
        targetValue = Color.Gray,
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = 12000
                Color(0xFF04739F) at 3000
                Color(0xFF9F7304) at 6000
                Color(0xFF098301) at 9000
            },
        ),
    )
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = Brush.linearGradient(listOf(Color.Transparent, color)))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 50.dp)
                .padding(50.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Degrees calculator",
                style = headerTextStyle
            )
            Spacer(modifier = Modifier.height(30.dp))
            OutlinedTextField(
                label = {
                    Text(
                        text = stringResource(R.string.input_degrees),
                        style = labelTextStyle
                    )
                },
                value = inputText,
                onValueChange = { inputText = it },
                singleLine = true,
                modifier = Modifier
                    .background(Color.Transparent)
                    .fillMaxWidth(),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Done
                )
            )
            Spacer(modifier = Modifier.height(20.dp))

            ResultLine(stringResource(id = R.string.radian, radianCalc))
            ResultLine(stringResource(id = R.string.minutes, roundDeg, roundMin, roundSec))
            ResultLine(stringResource(id = R.string.grad, roundGrad))
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun VE() {
    CalculatorTheme {
        Changer()
    }
}