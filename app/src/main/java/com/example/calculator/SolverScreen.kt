package com.example.calculator

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculator.ui.components.AppEditField
import com.example.calculator.ui.components.AppResultText
import com.example.calculator.ui.components.Calculations
import com.example.calculator.ui.theme.CalculatorTheme

@Composable
fun SolverScreen(modifier: Modifier = Modifier) {
    val calculations = LocalCalculations.current

    var inputText by remember { mutableStateOf("") }
    val degrees: Double = inputText.toDoubleOrNull() ?: 0.0

    Column(
        modifier = modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Degrees calculator",
            modifier = Modifier.padding(50.dp),
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp
        )
        Divider()
        AppEditField(
            label = R.string.input_degrees,
            value = inputText,
            onChange = { inputText = it })
        Spacer(modifier = Modifier.height(20.dp))
        AppResultText(calculations.getRadians(degrees, LocalContext.current))
        AppResultText(calculations.getMinutes(degrees, LocalContext.current))
        AppResultText(calculations.getGrads(degrees, LocalContext.current))
    }
}

@Preview
@Composable
fun VE() {
    CompositionLocalProvider(
        LocalCalculations provides Calculations()
    ) {
        CalculatorTheme {
            SolverScreen()
        }
    }
}