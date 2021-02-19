package com.example.miner_clicker.data2

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.miner_clicker.data2.ore.Ore
import com.example.miner_clicker.data2.ore.OreDAO
import com.example.miner_clicker.data2.player.Player
import com.example.miner_clicker.data2.player.PlayerDAO
import com.example.miner_clicker.data2.shopItem.ShopItem
import com.example.miner_clicker.data2.shopItem.ShopItemDAO
import com.example.miner_clicker.data2.storage.Storage
import com.example.miner_clicker.data2.storage.StorageDAO
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(entities = [Storage::class, ShopItem::class, Player::class, Ore::class], version = 1, exportSchema = false)
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