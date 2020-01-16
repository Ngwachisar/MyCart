package com.example.project5.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.project5.R
import com.example.project5.model.Products
import kotlinx.android.synthetic.main.inner_view.view.*

class ProductViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
    var image = itemView.findViewById<ImageView>(R.id.img_image)
    var name = itemView.findViewById<TextView>(R.id.txt_name)
    var price = itemView.findViewById<TextView>(R.id.txt_price)
    var qty = itemView.findViewById<TextView>(R.id.txt_weight)
    var decrease = itemView.findViewById<Button>(R.id.btn_decrease)
    var increase = itemView.findViewById<Button>(R.id.btn_increase)
}

class ProductAdapter (var productList:ArrayList<Products>):RecyclerView.Adapter<ProductViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.inner_view,parent,false)
        return ProductViewHolder(view)
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.image.setImageResource(productList[position].image)
        holder.name.text = productList[position].name
        holder.price.text = "Price : $" + productList[position].price
        holder.qty.text = productList[position].qty

        holder.decrease.setOnClickListener{
            var count:Int = holder.qty.text.toString().toInt()
            if(count >0){
                count --
                holder.qty.text = count.toString()
            }
        }

        holder.increase.setOnClickListener{
            var count:Int = holder.qty.text.toString().toInt()
            count ++
            holder.qty.text = count.toString()
        }
    }
}