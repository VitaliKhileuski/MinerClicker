package com.example.miner_clicker.databases.storage

import androidx.lifecycle.LiveData


class StorageRepository(private val storageDao : StorageDAO) {

    val allStorageItems : LiveData<List<StorageItem>> = storageDao.readAllData()

    suspend fun addStorage(storageItem : StorageItem){
        storageDao.addStorageItem(storageItem)
    }
    suspend fun deleteAllData(){
        storageDao.deleteAllData()
    }
    suspend fun deleteStorageItemByIndex(id : Int){
        storageDao.deleteStorageItem(id)
    }
    suspend fun updateAllData(storageItems : List<StorageItem>){
        storageDao.updateAllData(storageItems)
    }



}