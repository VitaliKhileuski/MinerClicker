package com.example.miner_clicker.dataBase

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.miner_clicker.R
import com.example.miner_clicker.dataBase.tables.OreTable
import com.example.miner_clicker.dataBase.tables.PlayerTable
import com.example.miner_clicker.dataBase.tables.ShopTable
import com.example.miner_clicker.dataBase.tables.StorageTable

class DataBaseHelper(context : Context): SQLiteOpenHelper(context,DataBaseInfo.DATABASE_NAME,
        null,DataBaseInfo.DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(DataBaseInfo.CREATE_TABLE_PLAYER)
        db?.execSQL(DataBaseInfo.CREATE_TABLE_STORAGE)
        db?.execSQL(DataBaseInfo.CREATE_TABLE_ORE)
        db?.execSQL(DataBaseInfo.CREATE_TABLE_SHOP)
        db?.insert(PlayerTable.TABLE_NAME,null, ContentValues().apply { put(PlayerTable.COLUMN_NAME_MONEY, 0)
            put(PlayerTable.COLUMN_NAME_GEMS, 0) })
        db?.insert(StorageTable.TABLE_NAME,null, ContentValues().apply { put(StorageTable.COLUMN_NAME_MINERAL, "stone")
            put(StorageTable.COLUMN_NAME_AMOUNT, 0)
            put(StorageTable.COLUMN_NAME_CAPACITY, 200) })
        db?.insert(StorageTable.TABLE_NAME,null, ContentValues().apply { put(StorageTable.COLUMN_NAME_MINERAL, "iron")
            put(StorageTable.COLUMN_NAME_AMOUNT, 0)
            put(StorageTable.COLUMN_NAME_CAPACITY, 50) })
        db?.insert(StorageTable.TABLE_NAME,null, ContentValues().apply { put(StorageTable.COLUMN_NAME_MINERAL, "gold")
            put(StorageTable.COLUMN_NAME_AMOUNT, 0)
            put(StorageTable.COLUMN_NAME_CAPACITY, 25) })
        db?.insert(StorageTable.TABLE_NAME,null, ContentValues().apply { put(StorageTable.COLUMN_NAME_MINERAL, "diamond")
            put(StorageTable.COLUMN_NAME_AMOUNT, 0)
            put(StorageTable.COLUMN_NAME_CAPACITY, 10) })
        db?.insert(OreTable.TABLE_NAME,null, ContentValues().apply { put(OreTable.COLUMN_NAME_LEVEL, 1)
            put(OreTable.COLUMN_NAME_MAX_HEALTH, 10)
            put(OreTable.COLUMN_NAME_CURRENT_HEALTH, 10)
            put(OreTable.COLUMN_NAME_CAPACITY, 5) })
        db?.insert(ShopTable.TABLE_NAME,null, ContentValues().apply { put(ShopTable.COLUMN_NAME_PRODUCT_NAME, "pick")
            put(ShopTable.COLUMN_NAME_PRODUCT_DESCRIPTION, "some description")
            put(ShopTable.COLUMN_NAME_PRODUCT_PRICE, 10)
            put(ShopTable.COLUMN_NAME_PRODUCT_DAMAGE, 5)
            put(ShopTable.COLUMN_NAME_PRODUCT_SOURCE, R.drawable.ic_baseline_account_balance_24) })
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL(DataBaseInfo.SQL_DELETE_PLAYER)
        db.execSQL(DataBaseInfo.SQL_DELETE_STORAGE)
        db.execSQL(DataBaseInfo.SQL_DELETE_ORE)
        db.execSQL(DataBaseInfo.SQL_DELETE_SHOP)
        db.execSQL(DataBaseInfo.SQL_DELETE_PICKAXE)
        onCreate(db)
    }

    override fun onOpen(db: SQLiteDatabase?) {
        super.onOpen(db)

    }


}