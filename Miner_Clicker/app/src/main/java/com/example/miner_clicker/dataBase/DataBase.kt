package com.example.miner_clicker.dataBase

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.provider.ContactsContract
import com.example.miner_clicker.models.gameComponents.Player

class DataBase(context: Context) {
    val dbHelper : DataBaseHelper = DataBaseHelper(context)
    var dataBase : SQLiteDatabase? = null


    public fun OpenDataBase(){
        dataBase=dbHelper.writableDatabase

    }
    public fun InsertPlayerData(money: Int,gems: Int){
        val values : ContentValues = ContentValues().apply {
            put(DataBaseInfo.COLUMN_NAME_MONEY,money)
            put(DataBaseInfo.COLUMN_NAME_GEMS,gems)
        }
        dataBase?.insert(DataBaseInfo.TABLE_NAME,null,values)
    }
    public fun ReadPlayerData() : Player{
        val player : Player = Player()
        val cursor : Cursor? = dataBase?.query(DataBaseInfo.TABLE_NAME,null,null,null,null,null,null)

        while(cursor?.moveToNext()!!){
            player.money=cursor.getColumnIndex(DataBaseInfo.COLUMN_NAME_MONEY)
            player.gems=cursor.getColumnIndex(DataBaseInfo.COLUMN_NAME_GEMS)
        }
        cursor.close()
        return player
    }
    public fun CloseDataBase(){
        dbHelper.close()
    }
}