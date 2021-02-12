package com.example.miner_clicker.data2.player

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.miner_clicker.data2.player.Player


@Dao
interface PlayerDAO {

@Insert(onConflict = OnConflictStrategy.IGNORE)
suspend  fun AddPlayer(player : Player)
@Query("SELECT * FROM player_table ORDER BY id ASC")
fun ReadAllData() : LiveData<List<Player>>


}