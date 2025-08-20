package com.example.calculator.ui.components

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.calculator.R
import com.example.calculator.ui.theme.CalculatorTheme

@Composable
fun AppEditField(
    @StringRes label: Int,
    value: String,
    onChange: (String) -> Unit
) {
    OutlinedTextField(
        modifier = Modifier.padding(30.dp),
        label = {
            Text(
                text = stringResource(label)
            )
        },
        value = value,
        onValueChange = onChange,
        singleLine = true,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number,
            imeAction = ImeAction.Done
        )
    )
}

@Preview
@Composable
private fun Preview() {
    CalculatorTheme {
        AppEditField(
            R.string.input_degrees,
            "23",
            {}
        )
    }
}