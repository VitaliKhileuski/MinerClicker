package com.example.miner_clicker.data2

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "storage_table")
data class Storage(
        @PrimaryKey(autoGenerate = true)
        val id : Int,
        val mineral : String,
        val numberOfMineral : Int,
        val Capacity : Int

)