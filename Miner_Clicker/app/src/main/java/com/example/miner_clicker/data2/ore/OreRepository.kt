package com.example.miner_clicker.data2.ore

import androidx.lifecycle.LiveData
import com.example.miner_clicker.data2.player.Player
import com.example.miner_clicker.data2.player.PlayerDAO

class OreRepository(private val oreDao : OreDAO) {

    val readAllData : LiveData<List<Ore>> = oreDao.readAllData()

    suspend fun addOre(ore : Ore){
        oreDao.addOre(ore)
    }

    suspend fun deleteAllData(){
        oreDao.deleteAllData()
    }

    suspend fun deleteOreByIndex(id : Int){
        oreDao.deleteOreById(id)
    }

    suspend fun updateOre(ore : Ore){
        oreDao.updateOre(ore)
    }
}