package com.example.myfoodapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;

import com.example.myfoodapp.Adapters.MainAdapter;
import com.example.myfoodapp.Adapters.OrdersAdapter;
import com.example.myfoodapp.Models.MainModel;
import com.example.myfoodapp.Models.OrderModels;
import com.example.myfoodapp.databinding.ActivityDetailBinding;
import com.example.myfoodapp.databinding.ActivityOrder2Binding;


import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {


ActivityOrder2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityOrder2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        DatabaseHelper helper= new DatabaseHelper(this);
        ArrayList<OrderModels> list = helper.getOrders();
        OrdersAdapter adapter =new OrdersAdapter(list , this);

        binding.OrderRecyclerView.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.OrderRecyclerView.setLayoutManager(layoutManager);

    }
}