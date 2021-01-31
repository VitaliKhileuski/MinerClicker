package com.example.miner_clicker.models.gameComponents

import com.example.miner_clicker.models.Mineral
import com.example.miner_clicker.R

    data class StorageItem(var mineral : Mineral = Mineral("gold", R.mipmap.ic_pickaxe),
                           var numberOfMineral : Int = 0,
                           var capacity : Int = 0)