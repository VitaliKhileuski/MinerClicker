package com.example.miner_clicker.data2.player

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.miner_clicker.data2.player.Player
import com.example.miner_clicker.data2.storage.Storage


@Dao
interface PlayerDAO {

@Insert(onConflict = OnConflictStrategy.IGNORE)
suspend  fun AddPlayer(player : Player)
@Query("SELECT * FROM player_table ORDER BY id ASC")
fun ReadAllData() : LiveData<List<Player>>

    @Update
    suspend fun updatePlayer(player : Player)
    @Delete
    fun deletePlayer(vararg players : Player)

    @Query("DELETE FROM player_table WHERE id=:id")
    fun deletePlayerById(id: Int)

    @Query("DELETE FROM player_table")
    suspend fun deleteAllData()
}