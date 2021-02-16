package com.example.miner_clicker.data2.ore

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ore_table")
data class Ore(
        @PrimaryKey(autoGenerate = true)
        val id: Int,
        val maxHealth: Int,
        val currentHealth: Int,
        val capacity: Int,
        val level: Int
)
