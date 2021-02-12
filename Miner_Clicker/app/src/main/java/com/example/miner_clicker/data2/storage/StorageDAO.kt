package com.example.miner_clicker.data2.storage

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.miner_clicker.data2.storage.Storage

@Dao
interface StorageDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend  fun AddStorage(storage : Storage)

    @Query("SELECT * FROM storage_table ORDER BY id ASC")
    fun ReadAllData() : LiveData<List<Storage>>

    @Delete
    fun deleteStorageItem(vararg storageItems : Storage)

    @Query("DELETE FROM storage_table WHERE id=:id")
    fun deleteStorageItem(id: Int)

    @Query("DELETE FROM storage_table")
    suspend fun deleteAllData()


}