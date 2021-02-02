package com.example.miner_clicker.dataBase

import android.provider.BaseColumns
import com.example.miner_clicker.dataBase.tables.*
import com.example.miner_clicker.models.Ore

object DataBaseInfo :BaseColumns {
    public const val DATABASE_VERSION : Int = 10
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

    public const val CREATE_TABLE_ORE = "CREATE TABLE IF NOT EXISTS ${OreTable.TABLE_NAME} (" +
            "${BaseColumns._ID} INTEGER PRIMARY KEY," +
            "${OreTable.COLUMN_NAME_LEVEL} INTEGER," +
            "${OreTable.COLUMN_NAME_MAX_HEALTH} INTEGER," +
            "${OreTable.COLUMN_NAME_CURRENT_HEALTH} INTEGER,"+
            "${OreTable.COLUMN_NAME_CAPACITY} INTEGER)"

    public const val CREATE_TABLE_SHOP = "CREATE TABLE IF NOT EXISTS ${ShopTable.TABLE_NAME} (" +
            "${BaseColumns._ID} INTEGER PRIMARY KEY," +
            "${ShopTable.COLUMN_NAME_PRODUCT_NAME} TEXT," +
            "${ShopTable.COLUMN_NAME_PRODUCT_DESCRIPTION} TEXT," +
            "${ShopTable.COLUMN_NAME_PRODUCT_PRICE} INTEGER,"+
            "${ShopTable.COLUMN_NAME_PRODUCT_DAMAGE} INTEGER,"+
            "${ShopTable.COLUMN_NAME_PRODUCT_SOURCE} INTEGER)"

    public const val CREATE_TABLE_PICKAXE = "CREATE TABLE IF NOT EXISTS ${PickaxeTable.TABLE_NAME} (" +
            "${BaseColumns._ID} INTEGER PRIMARY KEY," +
            "${PickaxeTable.COLUMN_NAME_PICKAXE_NAME} TEXT," +
            "${PickaxeTable.COLUMN_NAME_PICKAXE_PRICE} INTEGER," +
            "${PickaxeTable.COLUMN_NAME_PICKAXE_DESCRIPTION} TEXT,"+
            "${PickaxeTable.COLUMN_NAME_PICKAXE_DAMAGE} INTEGER,"+
            "${PickaxeTable.COLUMN_NAME_PICKAXE_IMAGE_SOURCE} INTEGER)"

    const val SQL_DELETE_PLAYER = "DROP TABLE IF EXISTS ${PlayerTable.TABLE_NAME}"
    const val SQL_DELETE_STORAGE = "DROP TABLE IF EXISTS ${StorageTable.TABLE_NAME}"
    const val SQL_DELETE_ORE = "DROP TABLE IF EXISTS ${OreTable.TABLE_NAME}"
    const val SQL_DELETE_SHOP = "DROP TABLE IF EXISTS ${ShopTable.TABLE_NAME}"
    const val SQL_DELETE_PICKAXE = "DROP TABLE IF EXISTS ${PickaxeTable.TABLE_NAME}"
}