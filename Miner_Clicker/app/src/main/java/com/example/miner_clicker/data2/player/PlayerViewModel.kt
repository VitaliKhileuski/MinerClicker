package com.example.miner_clicker.data2.player

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.miner_clicker.data2.GameDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PlayerViewModel(application : Application) : AndroidViewModel(application) {

    val allData: LiveData<List<Player>>
    private var _money = MutableLiveData<Int>()
    public val money: LiveData<Int> = _money
    private val repository: PlayerRepository

    init {
        val playerDao = GameDatabase.getDatabase(application).playerDAO()
        repository = PlayerRepository(playerDao)
        allData = repository.readAllData
        //_money.value = allData.value?.get(0)?.money
    }

    fun addPlayer(player: Player) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addPlayer(player)
        }
    }

    fun deleteAllData() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllData()
        }
    }

    fun deletePlayerById(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deletePlayerByIndex(id)
        }
    }

    fun updatePlayer(player : Player) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updatePlayer(player)
        }
    }
    fun updateMoney(id: Int, money : Int) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateMoney(id,money)
        }
    }
}