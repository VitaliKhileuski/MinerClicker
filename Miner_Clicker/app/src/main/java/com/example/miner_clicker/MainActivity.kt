package com.example.miner_clicker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.example.miner_clicker.adapters.ViewPagerAdapter
import com.example.miner_clicker.fragments.*
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    lateinit var viewPager: ViewPager
    lateinit var tabs: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        SetUpTabs()
        Set()

    }



    private fun SetUpTabs(){
        val adapter=ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(ShopFragment(),"Shop")
        adapter.addFragment(StorageFragment(),"storage")
        adapter.addFragment(DrillFragment(), "Drill")
        adapter.addFragment(ExchangeFragment(), "Exchange")
        viewPager = findViewById(R.id.viewPager)
        viewPager.adapter = adapter
        tabs = findViewById(R.id.tabs)
        tabs.setupWithViewPager(viewPager)

        tabs.getTabAt(0)!!.setIcon(R.drawable.ic_baseline_shopping_cart_24)
        tabs.getTabAt(1)!!.setIcon(R.drawable.ic_baseline_storage_24)
        tabs.getTabAt(2)!!.setIcon(R.drawable.ic_baseline_construction_24)
        tabs.getTabAt(3)!!.setIcon(R.drawable.ic_baseline_account_balance_24)
    }

   private fun Set(){
       val adapter=ViewPagerAdapter(supportFragmentManager)
       adapter.addFragment(FirstViewPagerFragment())
       viewPager=findViewById(R.id.firstViewPager)
       viewPager.adapter=adapter

   }
}