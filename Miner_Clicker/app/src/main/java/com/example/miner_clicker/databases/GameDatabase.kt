package com.example.miner_clicker.databases

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.miner_clicker.databases.ore.Ore
import com.example.miner_clicker.databases.ore.OreDAO
import com.example.miner_clicker.databases.player.Player
import com.example.miner_clicker.databases.player.PlayerDAO
import com.example.miner_clicker.databases.shopItem.ShopItem
import com.example.miner_clicker.databases.shopItem.ShopItemDAO
import com.example.miner_clicker.databases.storage.StorageItem
import com.example.miner_clicker.databases.storage.StorageDAO

@Database(entities = [StorageItem::class, ShopItem::class, Player::class, Ore::class], version = 1, exportSchema = false)
abstract class GameDatabase() : RoomDatabase() {

    abstract fun storageDAO(): StorageDAO
    abstract fun shopItemDAO(): ShopItemDAO
    abstract fun playerDAO(): PlayerDAO
    abstract fun oreDAO(): OreDAO

    companion object {
        @Volatile
        private var INSTANCE: GameDatabase? = null

        fun getDatabase(context: Context): GameDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                        context.applicationContext,
                        GameDatabase::class.java,
                        "game_database"
                )
                        .fallbackToDestructiveMigration()
                        .addCallback(WordDatabaseCallback())
                        .build()
                INSTANCE = instance
                return instance
            }
        }

        private class WordDatabaseCallback : RoomDatabase.Callback() {

            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
            }
        }
    }
}