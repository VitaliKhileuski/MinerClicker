package com.example.miner_clicker.databases.ore

import androidx.lifecycle.LiveData

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