package com.example.miner_clicker.data2.storage

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.miner_clicker.data2.GameDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class StorageViewModel(application: Application) : AndroidViewModel(application) {

    val allData: LiveData<List<Storage>>
    private val repository: StorageRepository

    init {
        val storageDao = GameDatabase.getDatabase(application).storageDAO()
        repository = StorageRepository(storageDao)
        allData = repository.allStorageItems
    }

    fun addStorage(storage: Storage) = viewModelScope.launch(Dispatchers.IO) {
        repository.addStorage(storage)
    }

    fun deleteAllData() = viewModelScope.launch(Dispatchers.IO) {
        repository.deleteAllData()
    }

    fun deleteById(id: Int) = viewModelScope.launch(Dispatchers.IO) {
        repository.deleteStorageItemByIndex(id)
    }
    fun updateAllData(storageItems : List<Storage>) = viewModelScope.launch(Dispatchers.IO){

        repository.updateAllData(storageItems)
    }
}
