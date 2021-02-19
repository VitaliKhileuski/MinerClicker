package com.example.miner_clicker.data2.shopItem

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shop_table")
data class ShopItem(
        @PrimaryKey(autoGenerate = true)
        val id: Int,
        val name: String,
        val description: String,
        val damage: Int,
        val price: Int
)