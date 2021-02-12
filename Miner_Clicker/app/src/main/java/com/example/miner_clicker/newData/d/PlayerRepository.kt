package com.example.miner_clicker.newData.d

import androidx.lifecycle.LiveData
import com.example.miner_clicker.data2.player.Player
import com.example.miner_clicker.data2.player.PlayerDAO

class PlayerRepository(private val playerDao : PlayerDAO) {

    val readAllData : LiveData<List<Player>> = playerDao.ReadAllData()

    suspend fun addPlayer(player : Player){
        playerDao.AddPlayer(player)
    }


}