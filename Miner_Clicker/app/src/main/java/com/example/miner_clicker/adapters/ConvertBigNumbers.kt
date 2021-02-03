package com.example.miner_clicker.adapters
import java.math.*
import kotlin.math.pow

class ConvertBigNumbers {
    companion object{
       val Letters : MutableList<String> = mutableListOf("k","m","b","t","q")
        var letter : String = "a"
        var stringNumber : String =""
        var preDotNumber : Double = 0.0
        var afterDotNumber : String = ""

        fun ToString(number : Int) : String{
            letter= getLetter(number)
            afterDotNumber = if(preDotNumber<10){
                number.toString()[1]+ number.toString()[2].toString()
            } else {
                number.toString()[2]+number.toString()[3].toString()
            }
            stringNumber= preDotNumber.toInt().toString()+"."+ afterDotNumber+ letter

            return stringNumber
        }
        fun getLetter(number : Int) : String{
            var _number : Int = number
            var index : Int =0
            while(_number>=1000){
                _number/=1000
                index++
            }
            val k : Double = 1000.0
            preDotNumber=number.toDouble()/(k.pow(index))
            return Letters[index-1]
        }
    }
}