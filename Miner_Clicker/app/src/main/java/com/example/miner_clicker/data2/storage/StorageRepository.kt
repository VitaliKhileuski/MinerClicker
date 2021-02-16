package com.example.miner_clicker.data2.storage

import androidx.lifecycle.LiveData
import com.example.miner_clicker.data2.storage.Storage
import com.example.miner_clicker.data2.storage.StorageDAO


class StorageRepository(private val storageDao : StorageDAO) {

    val allStorageItems : LiveData<List<Storage>> = storageDao.readAllData()

    suspend fun addStorage(storage : Storage){
        storageDao.addStorage(storage)
    }
    suspend fun deleteAllData(){
        storageDao.deleteAllData()
    }
    suspend fun deleteStorageItemByIndex(id : Int){
        storageDao.deleteStorageItem(id)
    }


}