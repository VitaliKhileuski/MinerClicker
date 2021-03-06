package com.example.miner_clicker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.ViewPager
import com.example.miner_clicker.adapters.ViewPagerAdapter
import com.example.miner_clicker.databases.ore.Ore
import com.example.miner_clicker.databases.ore.OreViewModel
import com.example.miner_clicker.databases.player.Player
import com.example.miner_clicker.databases.player.PlayerViewModel
import com.example.miner_clicker.databases.shopItem.ShopItem
import com.example.miner_clicker.databases.shopItem.ShopItemViewModel
import com.example.miner_clicker.databases.storage.StorageItem
import com.example.miner_clicker.databases.storage.StorageViewModel
import com.example.miner_clicker.databinding.ActivityMainBinding
import com.example.miner_clicker.fragments.*
import com.example.miner_clicker.viewModels.MainActivityViewModel
import com.google.android.material.tabs.TabLayout


class MainActivity : AppCompatActivity() {
    lateinit var viewPager: ViewPager
    lateinit var tabs: TabLayout
    private lateinit var mStorageViewModel: StorageViewModel
    private lateinit var mShopItemViewModel: ShopItemViewModel
    private lateinit var mPlayerViewModel: PlayerViewModel
    private lateinit var mOreViewModel: OreViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding =
                DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        binding.viewModel = MainActivityViewModel()
        mStorageViewModel = ViewModelProvider(this).get(StorageViewModel::class.java)
        mShopItemViewModel = ViewModelProvider(this).get(ShopItemViewModel::class.java)
        mPlayerViewModel = ViewModelProvider(this).get(PlayerViewModel::class.java)
        mOreViewModel = ViewModelProvider(this).get(OreViewModel::class.java)
       //mShopItemViewModel.addShopItem(ShopItem(1, "stone pickaxe", "this pickaxe is made from stone", 5, 10))
        //mPlayerViewModel.addPlayer(Player(1,10000,10,1))
        //mStorageViewModel.addStorageItem(StorageItem(1,"stone",0,200))
        //mStorageViewModel.addStorageItem(StorageItem(2,"iron",0,50))
        //mStorageViewModel.addStorageItem(StorageItem(3,"gold",0,25))
        //mStorageViewModel.addStorageItem(StorageItem(4,"diamond",0,10))
        //mOreViewModel.addOre(Ore(1,10,10,5,1))

        SetUpTabs()
        Set()
    }

    private fun SetUpTabs() {
        //Adding tabs in adapter for ViewPager
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(ShopFragment(mShopItemViewModel), "Shop")
        adapter.addFragment(StorageFragment(mStorageViewModel), "storage")
        adapter.addFragment(DrillFragment(), "Drill")
        adapter.addFragment(ExchangeFragment(), "Exchange")

        //Binding adapter to ViewPager
        viewPager = findViewById(R.id.viewPager)
        viewPager.adapter = adapter

        //Adding icons for tabs in ViewPager
        tabs = findViewById(R.id.tabs)
        tabs.setupWithViewPager(viewPager)
        tabs.getTabAt(0)!!.setIcon(R.drawable.ic_baseline_shopping_cart_24)
        tabs.getTabAt(1)!!.setIcon(R.drawable.ic_baseline_storage_24)
        tabs.getTabAt(2)!!.setIcon(R.drawable.ic_baseline_construction_24)
        tabs.getTabAt(3)!!.setIcon(R.drawable.ic_baseline_account_balance_24)
    }

    private fun Set() {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(MainGameActionFragment(mStorageViewModel, mPlayerViewModel,mOreViewModel))
        viewPager = findViewById(R.id.firstViewPager)
        viewPager.adapter = adapter
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

}