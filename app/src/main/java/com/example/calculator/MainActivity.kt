package com.example.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.calculator.ui.components.Calculations
import com.example.calculator.ui.theme.CalculatorTheme

val LocalCalculations = compositionLocalOf<Calculations> { error("no calculator provided") }

class MainActivity : ComponentActivity() {

    val calculations = Calculations()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CompositionLocalProvider(
                LocalCalculations provides calculations
            ) {
                CalculatorTheme {
                    Scaffold { innerPaddings ->
                        SolverScreen(modifier = Modifier.padding(innerPaddings))
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    CalculatorTheme {
        SolverScreen()
    }
}
