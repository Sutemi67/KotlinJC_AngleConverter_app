package com.example.calculator

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.calculator.ui.theme.regularTextStyle

@Composable
fun ResultLine(text: String) {
    Text(
        text = text,
        modifier = Modifier
            .fillMaxWidth(),
//            .padding(vertical = 5.dp),
        textAlign = TextAlign.Start,
        style = regularTextStyle
    )
}

@Preview(showBackground = true)
@Composable
fun Hd() {
    ResultLine(stringResource(R.string.grad))
}