package com.example.miner_clicker.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.miner_clicker.models.Pickaxe
import com.example.miner_clicker.R
import com.example.miner_clicker.databases.shopItem.ShopItem

class ShopRecyclerAdapter() : RecyclerView.Adapter<ShopRecyclerAdapter.ViewHolder>() {

    private var shopItems : List<ShopItem> = emptyList()

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val productName: TextView = itemView.findViewById(R.id.product_name)
        val productDescription: TextView = itemView.findViewById(R.id.product_description)
        val productImage: ImageView = itemView.findViewById(R.id.product_image)
        val productBuyButton: Button = itemView.findViewById(R.id.product_buying_button)

        init {
            productBuyButton.setOnClickListener { v: View ->

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.shop_view_item, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.productName.text = shopItems[position].name
        holder.productDescription.text = shopItems[position].description
        //holder.productImage.setImageResource(shopItems[position].imageSource)
        //holder.productBuyButton.text = shopItems[position]

    }

    override fun getItemCount(): Int {
        return shopItems.count()
    }

    public fun setData(shopItems: List<ShopItem>) {
        this.shopItems = shopItems
        notifyDataSetChanged()
    }
}