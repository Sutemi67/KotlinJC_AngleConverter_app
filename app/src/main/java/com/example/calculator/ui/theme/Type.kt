package com.example.calculator.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.calculator.R

// Set of Material typography styles to start with
val Typography = Typography(
//    body1 = TextStyle(
//        fontFamily = FontFamily(Font(R.font.genos_light)),
//        fontWeight = FontWeight.Normal,
//        fontSize = 16.sp
//    )
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)

val regularTextStyle = TextStyle(
    fontFamily = FontFamily((Font(R.font.outfir_regular))),
    fontSize = 22.sp
)

val headerTextStyle = TextStyle(
    fontFamily = FontFamily((Font(R.font.outfit_bold))),
    fontSize = 28.sp
)

val labelTextStyle = TextStyle(
    fontFamily = FontFamily((Font(R.font.outfit_light))),
    fontSize = 13.sp
)