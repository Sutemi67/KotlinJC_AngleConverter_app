package com.example.calculator.ui.components

import android.content.Context
import com.example.calculator.R
import kotlin.math.floor

class Calculations {
    fun getGrads(degrees: Double, context: Context): String {
        val grad: Double = degrees * 0.9
        val roundGrad = String.format(locale = null, format = "%.2f", grad)
        return context.getString(R.string.grad, roundGrad)
    }

    fun getMinutes(degrees: Double, context: Context): String {
        val degreesCalc = floor(degrees)
        val minutesCalc = floor((degrees - degreesCalc) * 60)
        val secondsCalc = ((degrees - degreesCalc) * 60 - minutesCalc) * 60

        val roundSec = secondsCalc.toInt().toString()
        val roundMin = minutesCalc.toInt().toString()
        val roundDeg = degreesCalc.toInt().toString()

        return context.getString(R.string.minutes, roundDeg, roundMin, roundSec)
    }

    fun getRadians(degrees: Double, context: Context): String {
        val radian: Double = degrees * 0.01745
        val radianCalc = String.format(locale = null, format = "%.2f", radian)
        return context.getString(R.string.radian, radianCalc)
    }
}