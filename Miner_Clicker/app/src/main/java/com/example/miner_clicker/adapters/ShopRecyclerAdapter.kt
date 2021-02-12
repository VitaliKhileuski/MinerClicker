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
<<<<<<< HEAD
import com.example.miner_clicker.models.gameComponents.Player

class ShopRecyclerAdapter(private var shopItems: MutableList<Pickaxe>) : RecyclerView.Adapter<ShopRecyclerAdapter.ViewHolder>() {
=======
import com.example.miner_clicker.dataBase.DataBase
import com.example.miner_clicker.fragments.MainGameActionFragment

class ShopRecyclerAdapter(private var shopItems: MutableList<Pickaxe>, val database : DataBase, var mainGameActionFragment: MainGameActionFragment) : RecyclerView.Adapter<ShopRecyclerAdapter.ViewHolder>() {
>>>>>>> 820f35bcbbaab7c57f0cc76146e0bf3b412ceb37

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val productName: TextView = itemView.findViewById(R.id.product_name)
        val productDescription: TextView = itemView.findViewById(R.id.product_description)
        val productImage: ImageView = itemView.findViewById(R.id.product_image)
        val productBuyButton: Button = itemView.findViewById(R.id.product_buying_button)
        var player : Player = Player()
        init {
            productBuyButton.setOnClickListener { v : View ->
                //player=database.ReadPlayerData()

                val position : Int = adapterPosition
                var pickaxe : Pickaxe = shopItems[position]
<<<<<<< HEAD
                if(player.money>=pickaxe.price){
                  //  database.DeleteAllRows("Pickaxe")
                    //database.InsertPickaxeData(pickaxe)
                    //database.UpdateMoney(player.money-pickaxe.price)
                }
=======
                mainGameActionFragment.binding.viewModel!!.updateMoneyAfterBuying(pickaxe)
>>>>>>> 820f35bcbbaab7c57f0cc76146e0bf3b412ceb37
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.shop_view_item, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.productName.text = shopItems[position].name
        holder.productDescription.text = shopItems[position].descriprion
        holder.productImage.setImageResource(shopItems[position].imageSource)
        holder.productBuyButton.text = shopItems[position].price.toString()

    }

    override fun getItemCount(): Int {
        return shopItems.count()
    }


}