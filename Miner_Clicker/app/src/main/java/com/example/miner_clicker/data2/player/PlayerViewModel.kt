package com.example.miner_clicker.data2.player

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.miner_clicker.data2.GameDatabase
import com.example.miner_clicker.data2.player.Player
import com.example.miner_clicker.data2.player.PlayerDatabase
import com.example.miner_clicker.data2.player.PlayerRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PlayerViewModel(application : Application) : AndroidViewModel(application) {
    public val readAllData: LiveData<List<Player>>
    private val repository: PlayerRepository

    init {
        val playerDao = GameDatabase.getDatabase(application).playerDAO()
        repository = PlayerRepository(playerDao)
        readAllData = repository.readAllData
    }

    fun addPlayer(player: Player) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addPlayer(player)
        }
    }
}