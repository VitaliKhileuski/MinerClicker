package com.example.miner_clicker.dataBase

import android.provider.BaseColumns

object DataBaseInfo :BaseColumns {
    public const val TABLE_NAME : String = "Player"
    public const val COLUMN_NAME_MONEY : String = "Money"
    public const val COLUMN_NAME_GEMS : String = "Gems"
    public const val DATABASE_VERSION : Int = 1
    public const val DATABASE_NAME : String = "player.db"

    public const val CREATE_TABLE = "CREATE TABLE IF NOT EXISTS $TABLE_NAME (" +
            "${BaseColumns._ID} INTEGER PRIMARY KEY," +
            "$COLUMN_NAME_MONEY INTEGER," +
            "$COLUMN_NAME_GEMS INTEGER)"
}