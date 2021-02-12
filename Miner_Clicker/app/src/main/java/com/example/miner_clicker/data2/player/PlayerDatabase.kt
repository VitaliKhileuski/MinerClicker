package com.example.miner_clicker.data2.player

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Player::class], version = 1, exportSchema = false)
 abstract  class PlayerDatabase() : RoomDatabase() {
     abstract fun PlayerDAO() : PlayerDAO


     companion object {
         @Volatile
         private var INSTANCE : PlayerDatabase? = null
         fun getDatabase(context : Context) : PlayerDatabase {
             val tempInstance = INSTANCE
             if(tempInstance != null){
                 return tempInstance
             }
             synchronized(this){
                 val instance = Room.databaseBuilder(
                         context.applicationContext,
                         PlayerDatabase::class.java,
                         "player_database"
                 ).build()
                 INSTANCE = instance
                 return instance
             }
         }
     }

}