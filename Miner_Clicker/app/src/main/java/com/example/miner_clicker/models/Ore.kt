package com.example.miner_clicker.models

class Ore(var maxHealth:Int=0,var capacity:Int=0,var level:Int=0) {




    public fun SetNewLevel(){
        level+=1
        maxHealth+=25
    }

}