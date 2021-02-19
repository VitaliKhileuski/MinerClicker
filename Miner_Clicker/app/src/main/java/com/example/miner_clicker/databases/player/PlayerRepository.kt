package com.example.miner_clicker.databases.player

import androidx.lifecycle.LiveData

class PlayerRepository(private val playerDao : PlayerDAO) {

    val readAllData : LiveData<List<Player>> = playerDao.ReadAllData()

    suspend fun addPlayer(player : Player){
        playerDao.AddPlayer(player)
    }
    suspend fun deleteAllData(){
        playerDao.deleteAllData()
    }
    suspend fun deletePlayerByIndex(id : Int){
        playerDao.deletePlayerById(id)
    }
    suspend fun updatePlayer(player : Player){
        playerDao.updatePlayer(player)
    }
    suspend fun updateMoney(id: Int,money : Int){
        playerDao.updateMoney(id,money)
    }

}