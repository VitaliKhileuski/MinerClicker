package com.example.miner_clicker.databases.ore

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.miner_clicker.databases.GameDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class OreViewModel(application : Application) : AndroidViewModel(application) {

    val allData: LiveData<List<Ore>>
    private val repository: OreRepository

    init {
        val oreDao = GameDatabase.getDatabase(application).oreDAO()
        repository = OreRepository(oreDao)
        allData = repository.readAllData
    }

    fun addOre(ore: Ore) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addOre(ore)
        }
    }

    fun deleteAllData() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllData()
        }
    }

    fun deleteOreById(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteOreByIndex(id)
        }
    }

    fun updateOre(ore : Ore) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateOre(ore)
        }
    }
}