package com.example.project5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.project5.adapter.ProductAdapter
import com.example.project5.model.Products

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var mainView:RecyclerView = findViewById(R.id.recycler_view)

        var productList = ArrayList<Products>()
        productList.add(Products(R.drawable.salt,"Fine Grain Sugar","20.00", "1"))
        productList.add(Products(R.drawable.oil,"Sunflower Oil","20.00", "2"))
        productList.add(Products(R.drawable.bread,"Bread","10.00", "2"))

        var prodcutAdapter = ProductAdapter(productList)

        mainView.layoutManager = LinearLayoutManager(this)

        mainView.adapter = prodcutAdapter
    }
}
