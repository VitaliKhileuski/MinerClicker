package com.example.miner_clicker.dataBase.tables

import android.provider.BaseColumns

object StorageTable :BaseColumns {
    public const val TABLE_NAME : String = "Storage"
    public const val COLUMN_NAME_MINERAL : String = "Mineral"
    public const val COLUMN_NAME_AMOUNT : String = "Amount"
    public const val COLUMN_NAME_CAPACITY : String = "Capacity"

}