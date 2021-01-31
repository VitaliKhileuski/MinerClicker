package com.example.miner_clicker.dataBase

import android.provider.BaseColumns
import com.example.miner_clicker.dataBase.tables.PlayerTable
import com.example.miner_clicker.dataBase.tables.StorageTable

object DataBaseInfo :BaseColumns {
    public const val DATABASE_VERSION : Int = 3
    public const val DATABASE_NAME : String = "player.db"

    public const val CREATE_TABLE_PLAYER = "CREATE TABLE IF NOT EXISTS ${PlayerTable.TABLE_NAME} (" +
            "${BaseColumns._ID} INTEGER PRIMARY KEY," +
            "${PlayerTable.COLUMN_NAME_MONEY} INTEGER," +
            "${PlayerTable.COLUMN_NAME_GEMS} INTEGER)"

    public const val CREATE_TABLE_STORAGE = "CREATE TABLE IF NOT EXISTS ${StorageTable.TABLE_NAME} (" +
            "${BaseColumns._ID} INTEGER PRIMARY KEY," +
            "${StorageTable.COLUMN_NAME_MINERAL} TEXT," +
            "${StorageTable.COLUMN_NAME_AMOUNT} INTEGER," +
            "${StorageTable.COLUMN_NAME_CAPACITY} INTEGER)"



    const val SQL_DELETE_PLAYER = "DROP TABLE IF EXISTS ${PlayerTable.TABLE_NAME}"
    const val SQL_DELETE_STORAGE = "DROP TABLE IF EXISTS ${StorageTable.TABLE_NAME}"
}