package com.example.miner_clicker.data2.shopItem

import androidx.lifecycle.LiveData

class ShopItemRepository(private val shopItemDao: ShopItemDAO) {

    val allShopItems : LiveData<List<ShopItem>> = shopItemDao.allShopItems()

    suspend fun addShopItem(shopItem: ShopItem){
        shopItemDao.addShopItem(shopItem)
    }

    suspend fun deleteAllData(){
        shopItemDao.deleteAllData()
    }
}