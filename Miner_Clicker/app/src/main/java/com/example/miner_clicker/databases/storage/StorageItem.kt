package com.example.miner_clicker.databases.storage

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "storage_table")
data class StorageItem(
        @PrimaryKey(autoGenerate = true)
        val id : Int,
        val mineral : String,
        var numberOfMineral : Int,
        val Capacity : Int

)