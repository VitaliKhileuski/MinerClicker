package com.example.miner_clicker.data2

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.miner_clicker.data2.player.Player
import com.example.miner_clicker.data2.player.PlayerDAO
import com.example.miner_clicker.data2.storage.Storage
import com.example.miner_clicker.data2.storage.StorageDAO

@Database(entities = [Storage::class, Player::class], version = 1, exportSchema = false)
abstract  class GameDatabase() : RoomDatabase() {

    abstract fun storageDAO() : StorageDAO
    abstract fun playerDAO() : PlayerDAO


    companion object {
        @Volatile
        private var INSTANCE : GameDatabase? = null

        fun getDatabase(context : Context) : GameDatabase {
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                        context.applicationContext,
                        GameDatabase::class.java,
                        "game_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }

}