package com.example.miner_clicker.dataBase

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DataBaseHelper(context : Context): SQLiteOpenHelper(context,DataBaseInfo.DATABASE_NAME,
        null,DataBaseInfo.DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(DataBaseInfo.CREATE_TABLE_PLAYER)
        db?.execSQL(DataBaseInfo.CREATE_TABLE_STORAGE)
        db?.execSQL(DataBaseInfo.CREATE_TABLE_ORE)
        db?.execSQL(DataBaseInfo.CREATE_TABLE_SHOP)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL(DataBaseInfo.SQL_DELETE_PLAYER)
        db.execSQL(DataBaseInfo.SQL_DELETE_STORAGE)
        db.execSQL(DataBaseInfo.SQL_DELETE_ORE)
        db.execSQL(DataBaseInfo.SQL_DELETE_SHOP)
        onCreate(db)
    }

    override fun onOpen(db: SQLiteDatabase?) {
        super.onOpen(db)

    }


}