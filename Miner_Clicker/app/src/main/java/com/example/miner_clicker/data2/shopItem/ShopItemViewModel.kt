package com.example.miner_clicker.data2.shopItem

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.miner_clicker.data2.GameDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShopItemViewModel(application: Application) : AndroidViewModel(application) {

    val allShopItems : LiveData<List<ShopItem>>
    private val repository : ShopItemRepository

    init {
        val shopItemDao = GameDatabase.getDatabase(application).shopItemDAO()
        repository = ShopItemRepository(shopItemDao)
        allShopItems = repository.allShopItems
    }

    fun addShopItem(shopItem: ShopItem) = viewModelScope.launch(Dispatchers.IO) {
        repository.addShopItem(shopItem)
    }

    fun deleteAllData() = viewModelScope.launch(Dispatchers.IO) {
        repository.deleteAllData()
    }
}