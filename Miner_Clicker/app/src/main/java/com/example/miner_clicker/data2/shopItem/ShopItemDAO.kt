package com.example.miner_clicker.data2.shopItem

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ShopItemDAO {

    @Insert
    suspend fun addShopItem(shopItem: ShopItem)

    @Query("SELECT * FROM shop_table ORDER BY id ASC")
    fun allShopItems() : LiveData<List<ShopItem>>

    @Query("DELETE FROM shop_table")
    suspend fun deleteAllData()
}