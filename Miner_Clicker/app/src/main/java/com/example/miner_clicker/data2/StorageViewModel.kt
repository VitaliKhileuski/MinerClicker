package com.example.miner_clicker.data2

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.miner_clicker.data2.Storage
import com.example.miner_clicker.data2.StorageDatabase
import com.example.miner_clicker.data2.StorageRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class StorageViewModel(application: Application) : AndroidViewModel(application) {
    public val readAllData: LiveData<List<Storage>>
    public val repository: StorageRepository

    init {
        val storageDao = StorageDatabase.getDatabase(application).storageDAO()
        repository = StorageRepository(storageDao)
        readAllData = repository.readAllData
    }

    fun addStorage(storage: Storage) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addStorage(storage)
        }
    }

    fun deleteAllData() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllData()
        }
    }

    fun deleteById(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteStorageItemByIndex(id)
        }
    }
}
