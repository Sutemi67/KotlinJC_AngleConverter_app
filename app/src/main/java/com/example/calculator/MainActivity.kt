package com.example.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculator.ui.theme.CalculatorTheme
import kotlin.math.floor

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculatorTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Changer()
                }
            }
        }
    }
}

@Composable
fun Changer() {
    var inputText by remember { mutableStateOf("") }
    val degrees: Double = inputText.toDoubleOrNull()?:0.0

    val radian: Double = degrees*0.01745
    val radianCalc = String.format("%.2f", radian)

    val degreesCalc = floor(degrees)
    val minutesCalc = floor((degrees - degreesCalc)*60)
    val secondsCalc = ((degrees - degreesCalc)* 60 - minutesCalc)*60

    val roundSec = secondsCalc.toInt()
    val roundMin = minutesCalc.toInt()
    val roundDeg = degreesCalc.toInt()

    val grad: Double = degrees*0.9
    val roundGrad = String.format("%.2f", grad)

    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = CenterHorizontally
    ) {
        Text(
            text = "Degrees calculator",
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp
        )
        Spacer(modifier = Modifier.height(20.dp))
        EditDegrees(label = R.string.input_degrees, value = inputText, onChange = {inputText=it})
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = stringResource(id = R.string.radian, radianCalc),
            fontSize = 30.sp,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(start = 20.dp))
        Text(
            text = stringResource(id = R.string.minutes, roundDeg, roundMin, roundSec),
            fontSize = 30.sp,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(start = 20.dp))
        Text(
            text = stringResource(id = R.string.grad, roundGrad),
            fontSize = 30.sp,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(start = 20.dp))
    }
}

@Composable
fun EditDegrees(
    @StringRes label:Int,
    value:String,
    onChange:(String)->Unit
) {
    TextField(
        label = {Text(text = stringResource(label))},
        value = value,
        onValueChange = onChange,
        singleLine = true,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number,
            imeAction = ImeAction.Done)
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    CalculatorTheme {
        Changer()
    }
}