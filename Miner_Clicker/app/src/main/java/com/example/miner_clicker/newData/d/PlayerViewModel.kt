package com.example.miner_clicker.newData.d

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.miner_clicker.data2.player.Player
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PlayerViewModel(application : Application) : AndroidViewModel(application) {
    private val readAllData: LiveData<List<Player>>
    private val repository: PlayerRepository

    init {
        val playerDao = PlayerDatabase.getDatabase(application).PlayerDAO()
        repository = PlayerRepository(playerDao)
        readAllData = repository.readAllData
    }

    fun addPlayer(player: Player) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addPlayer(player)
        }
    }
}