package com.example.miner_clicker.databases.player

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "player_table")
data class Player(
        @PrimaryKey(autoGenerate = true)
        val id : Int,
        var money : Int,
        val gems : Int,
        val pickaxeId : Int

)
