package com.example.miner_clicker.dataBase

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.provider.ContactsContract
import com.example.miner_clicker.dataBase.tables.*
import com.example.miner_clicker.models.*
import com.example.miner_clicker.models.gameComponents.Player
import com.example.miner_clicker.models.gameComponents.Storage
import com.example.miner_clicker.models.gameComponents.StorageItem

class DataBase(context: Context) {
    val dbHelper : DataBaseHelper = DataBaseHelper(context)
    var dataBase : SQLiteDatabase? = null


    public fun OpenDataBase(){
        dataBase=dbHelper.writableDatabase
    }

    public fun InsertPlayerData(money: Int,gems: Int){
        val values : ContentValues = ContentValues().apply {
            put(PlayerTable.COLUMN_NAME_MONEY,money)
            put(PlayerTable.COLUMN_NAME_GEMS,gems)
        }
        dataBase?.insert(PlayerTable.TABLE_NAME,null,values)
    }

    public fun InsertStorageData(storageItem: StorageItem){
        val values : ContentValues = ContentValues().apply {
            put(StorageTable.COLUMN_NAME_MINERAL,storageItem.mineral.name)
            put(StorageTable.COLUMN_NAME_AMOUNT,storageItem.numberOfMineral)
            put(StorageTable.COLUMN_NAME_CAPACITY,storageItem.capacity)
        }
        dataBase?.insert(StorageTable.TABLE_NAME,null,values)
    }

    public fun InsertOreData(ore: Ore){
        val values : ContentValues = ContentValues().apply {
            put(OreTable.COLUMN_NAME_LEVEL,ore.level)
            put(OreTable.COLUMN_NAME_MAX_HEALTH,ore.maxHealth)
            put(OreTable.COLUMN_NAME_CURRENT_HEALTH,ore.currenthealth)
            put(OreTable.COLUMN_NAME_CAPACITY,ore.capacity)
        }
        dataBase?.insert(OreTable.TABLE_NAME,null,values)
    }

    public fun InsertShopData(pickaxe: Pickaxe){
        val values : ContentValues = ContentValues().apply {
            put(ShopTable.COLUMN_NAME_PRODUCT_NAME,pickaxe.name)
            put(ShopTable.COLUMN_NAME_PRODUCT_DESCRIPTION,pickaxe.descriprion)
            put(ShopTable.COLUMN_NAME_PRODUCT_PRICE,pickaxe.price)
            put(ShopTable.COLUMN_NAME_PRODUCT_DAMAGE,pickaxe.damage)
            put(ShopTable.COLUMN_NAME_PRODUCT_SOURCE,pickaxe.imageSource)
        }
        dataBase?.insert(ShopTable.TABLE_NAME,null,values)
    }

    public fun InsertPickaxeData(pickaxe: Pickaxe){
        val values : ContentValues = ContentValues().apply {
            put(PickaxeTable.COLUMN_NAME_PICKAXE_NAME, pickaxe.name)
            put(PickaxeTable.COLUMN_NAME_PICKAXE_PRICE, pickaxe.price)
            put(PickaxeTable.COLUMN_NAME_PICKAXE_DESCRIPTION, pickaxe.descriprion)
            put(PickaxeTable.COLUMN_NAME_PICKAXE_DAMAGE, pickaxe.damage)
            put(PickaxeTable.COLUMN_NAME_PICKAXE_IMAGE_SOURCE, pickaxe.imageSource)
        }
        dataBase?.insert(PickaxeTable.TABLE_NAME,null,values)
    }

    public fun ReadPlayerData() : Player{
        val player : Player = Player()
        val pickaxe : Pickaxe = Pickaxe()
        val cursor : Cursor? = dataBase?.query(PlayerTable.TABLE_NAME,null,null,null,null,null,null)

        while(cursor?.moveToNext()!!){
            player.money=cursor.getInt(cursor.getColumnIndex(PlayerTable.COLUMN_NAME_MONEY))
            player.gems=cursor.getInt(cursor.getColumnIndex(PlayerTable.COLUMN_NAME_GEMS))
        }
        cursor.close()

        val cursor2 : Cursor? = dataBase?.query(PickaxeTable.TABLE_NAME,null,null,null,null,null,null)
        while(cursor2?.moveToNext()!!){
            pickaxe.name=cursor2.getString(cursor2.getColumnIndex(PickaxeTable.COLUMN_NAME_PICKAXE_NAME))
            pickaxe.price=cursor2.getInt(cursor2.getColumnIndex(PickaxeTable.COLUMN_NAME_PICKAXE_PRICE))
            pickaxe.descriprion=cursor2.getString(cursor2.getColumnIndex(PickaxeTable.COLUMN_NAME_PICKAXE_DESCRIPTION))
            pickaxe.damage=cursor2.getInt(cursor2.getColumnIndex(PickaxeTable.COLUMN_NAME_PICKAXE_DAMAGE))
            pickaxe.imageSource=cursor2.getInt(cursor2.getColumnIndex(PickaxeTable.COLUMN_NAME_PICKAXE_IMAGE_SOURCE))
        }
        player.currentPickaxe = pickaxe
        cursor2.close()
        return player
    }

    public fun ReadStorageData() : Storage{
        val storage : Storage = Storage()
        val cursor : Cursor? = dataBase?.query(StorageTable.TABLE_NAME,null,null,null,null,null,null)

        while(cursor?.moveToNext()!!){
            val name : String = cursor.getString(cursor.getColumnIndex(StorageTable.COLUMN_NAME_MINERAL))
            val amount : Int = cursor.getInt(cursor.getColumnIndex(StorageTable.COLUMN_NAME_AMOUNT))
            val capacity : Int = cursor.getInt(cursor.getColumnIndex(StorageTable.COLUMN_NAME_CAPACITY))
            when(name){
                "stone" -> storage.storageItems.add(StorageItem(Stone(),amount,capacity))
                "iron" -> storage.storageItems.add(StorageItem(Iron(),amount,capacity))
                "gold" -> storage.storageItems.add(StorageItem(Gold(),amount,capacity))
                "diamond" -> storage.storageItems.add(StorageItem(Diamond(),amount,capacity))
            }
        }
        cursor.close()
        return storage
    }

    public fun ReadPOreData() : Ore{
        val ore : Ore = Ore()
        val cursor : Cursor? = dataBase?.query(OreTable.TABLE_NAME,null,null,null,null,null,null)

        while(cursor?.moveToNext()!!){
            ore.level=cursor.getInt(cursor.getColumnIndex(OreTable.COLUMN_NAME_LEVEL))
            ore.maxHealth=cursor.getInt(cursor.getColumnIndex(OreTable.COLUMN_NAME_MAX_HEALTH))
            ore.currenthealth=cursor.getInt(cursor.getColumnIndex(OreTable.COLUMN_NAME_CURRENT_HEALTH))
            ore.capacity=cursor.getInt(cursor.getColumnIndex(OreTable.COLUMN_NAME_CAPACITY))

        }
        cursor.close()
        return ore
    }

    public fun ReadShopData() : MutableList<Pickaxe>{
        val shop = mutableListOf<Pickaxe>()
        val cursor : Cursor? = dataBase?.query(ShopTable.TABLE_NAME,null,null,null,null,null,null)

        while(cursor?.moveToNext()!!){
            val pickaxe : Pickaxe = Pickaxe()
            pickaxe.name=cursor.getString(cursor.getColumnIndex(ShopTable.COLUMN_NAME_PRODUCT_NAME))
            pickaxe.descriprion=cursor.getString(cursor.getColumnIndex(ShopTable.COLUMN_NAME_PRODUCT_DESCRIPTION))
            pickaxe.price=cursor.getInt(cursor.getColumnIndex(ShopTable.COLUMN_NAME_PRODUCT_PRICE))
            pickaxe.damage=cursor.getInt(cursor.getColumnIndex(ShopTable.COLUMN_NAME_PRODUCT_DAMAGE))
            pickaxe.imageSource=cursor.getInt(cursor.getColumnIndex(ShopTable.COLUMN_NAME_PRODUCT_SOURCE))
            shop.add(pickaxe)
        }
        cursor.close()
        return shop
    }


    public fun DeleteAllRows(TABLE_NAME : String){
        dataBase?.delete(TABLE_NAME,null,null)
    }

    public fun CloseDataBase(){
        dbHelper.close()
    }
    public fun UpdateMoney(money: Int){
        val values : ContentValues = ContentValues().apply {
            put(PlayerTable.COLUMN_NAME_MONEY,money)
        }

        dataBase?.update(PlayerTable.TABLE_NAME,values,null,null)
    }
    public fun UpdateGems(gems : Int){
        val values : ContentValues = ContentValues().apply {
            put(PlayerTable.COLUMN_NAME_GEMS,gems)
        }
        dataBase?.update(PlayerTable.TABLE_NAME,values,null,null)
    }
    public fun UpdateOreCurrentHealth(currentHealth: Int) {
        val values: ContentValues = ContentValues().apply {
            put(OreTable.COLUMN_NAME_CURRENT_HEALTH, currentHealth)
        }
        dataBase?.update(OreTable.TABLE_NAME,values,null,null)
    }

    public fun UpdateOre(ore : Ore){
        val values : ContentValues = ContentValues().apply {
            put(OreTable.COLUMN_NAME_LEVEL,ore.level)
            put(OreTable.COLUMN_NAME_MAX_HEALTH,ore.maxHealth)
            put(OreTable.COLUMN_NAME_CURRENT_HEALTH,ore.currenthealth)
            put(OreTable.COLUMN_NAME_CAPACITY,ore.capacity)
        }
        dataBase?.update(OreTable.TABLE_NAME,values,null,null)
    }
    public fun UpdateStorage(storage : Storage){
        for(i in 1..4) {
            val values : ContentValues = ContentValues().apply {
                put(StorageTable.COLUMN_NAME_AMOUNT,storage.storageItems[i-1].numberOfMineral)
            }
            dataBase?.update(StorageTable.TABLE_NAME,values,"_id = $i",null)
        }

        }
    }
