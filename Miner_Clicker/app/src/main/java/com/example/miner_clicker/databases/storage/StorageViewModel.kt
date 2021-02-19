package com.example.miner_clicker.databases.storage

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.miner_clicker.databases.GameDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class StorageViewModel(application: Application) : AndroidViewModel(application) {

    val allData: LiveData<List<StorageItem>>
    private val repository: StorageRepository

    init {
        val storageDao = GameDatabase.getDatabase(application).storageDAO()
        repository = StorageRepository(storageDao)
        allData = repository.allStorageItems
    }

    fun addStorageItem(storageItem: StorageItem) = viewModelScope.launch(Dispatchers.IO) {
        repository.addStorageItem(storageItem)
    }

    fun deleteAllData() = viewModelScope.launch(Dispatchers.IO) {
        repository.deleteAllData()
    }

    fun deleteById(id: Int) = viewModelScope.launch(Dispatchers.IO) {
        repository.deleteStorageItemByIndex(id)
    }
    fun updateAllData(storageItems : List<StorageItem>) = viewModelScope.launch(Dispatchers.IO){

        repository.updateAllData(storageItems)
    }
}
