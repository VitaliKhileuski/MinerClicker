package com.example.miner_clicker.data2.ore

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ore_table")
data class Ore(
        @PrimaryKey(autoGenerate = true)
        val id: Int,
        var maxHealth: Int,
        var currentHealth: Int,
        var capacity: Int,
        var level: Int
)
