package com.example.miner_clicker.databases.ore

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface OreDAO {

@Insert(onConflict = OnConflictStrategy.IGNORE)
suspend  fun addOre(ore : Ore)
@Query("SELECT * FROM ore_table ORDER BY id ASC")
fun readAllData() : LiveData<List<Ore>>

    @Update
    suspend fun updateOre(ore : Ore)
    @Delete
    fun deleteOre(vararg ore : Ore)

    @Query("DELETE FROM ore_table WHERE id=:id")
    fun deleteOreById(id: Int)

    @Query("DELETE FROM ore_table")
    suspend fun deleteAllData()

}