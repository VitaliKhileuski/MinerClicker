package com.example.miner_clicker.databases.storage

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface StorageDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addStorageItem(storageItem : StorageItem)

    @Query("SELECT * FROM storage_table ORDER BY id ASC")
    fun readAllData() : LiveData<List<StorageItem>>

    @Delete
    fun deleteStorageItem(vararg storageItems : StorageItem)

    @Query("DELETE FROM storage_table WHERE id=:id")
    fun deleteStorageItem(id: Int)

    @Query("DELETE FROM storage_table")
    suspend fun deleteAllData()
    @Update
    suspend fun updateAllData(storageItems : List<StorageItem>)


}