package com.example.miner_clicker.adapters

import java.math.*
import kotlin.math.pow

class ConvertBigNumbers {
    companion object {
        private val letters: MutableList<String> = mutableListOf("k", "m", "b", "t", "q")
        private var letter: String = "a"
        private var stringNumber: String = ""
        private var preDotNumber: Double = 0.0
        private var afterDotNumber: String = ""

        fun ToString(number: Int): String {
            letter = getLetter(number)
            afterDotNumber = if (preDotNumber < 10) {
                number.toString()[1] + number.toString()[2].toString()
            } else {
                number.toString()[2] + number.toString()[3].toString()
            }
            stringNumber = preDotNumber.toInt().toString() + "." + afterDotNumber + letter
            return stringNumber
        }

        private fun getLetter(number: Int): String {
            var tempNumber: Int = number
            var index = 0
            while (tempNumber >= 1000) {
                tempNumber /= 1000
                index++
            }
            val k = 1000.0
            preDotNumber = number.toDouble() / (k.pow(index))
            return letters[index - 1]
        }
    }
}