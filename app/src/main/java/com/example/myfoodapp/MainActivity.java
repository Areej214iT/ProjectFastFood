package com.example.myfoodapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myfoodapp.Adapters.MainAdapter;
import com.example.myfoodapp.Models.MainModel;
import com.example.myfoodapp.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {


    ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<MainModel> list = new ArrayList<>();
        //burgers
        list.add(new MainModel(R.drawable.burger, "Cheesy Burger","10","Chicken Burger with extra cheese"));
        list.add(new MainModel(R.drawable.b2, " BBQ Burger","15","Angus beef, lettuce, grilled ham, avocado, queso fresco, jalapenos, chipotle mayo"));
        list.add(new MainModel(R.drawable.b3, "Mexi Burger","12","Angus beef, lettuce, tomato, onions, pickles, mayo"));
        list.add(new MainModel(R.drawable.b4, "Kimchi","8","Korean BBQ style Angus beef, lettuce, onions, kimchi, fried egg, cheddar, garlic mayo"));
        list.add(new MainModel(R.drawable.b5, "Crunch Burger","5","Angus beef, house-made chili, queso, onions, pickles"));
        //pizza
        list.add(new MainModel(R.drawable.pizza, "Pizza Rustissa","10","Angus beef, house-made chili, queso, onions, pickles"));
        list.add(new MainModel(R.drawable.p1, "New York-Style Pizza","10","New York-style pizza usually features tomato sauce and mozzarella cheese. New York pizza with condiments, like oregano, red pepper flakes, Parmesan cheese, and garlic powder."));
        list.add(new MainModel(R.drawable.p2, "Chicago Pizza ","12","Chicago pizza are ground beef, sausage, pepperoni, onion, mushrooms, and green peppers, placed underneath the tomato sauce."));
        list.add(new MainModel(R.drawable.p4, "Greek Pizza","15","Topped with cheese, which is usually a mix of mozzarella and cheddar or provolone. It may feature a variety of non-Greek or Greek toppings, such as feta cheese, black olives, and red onion."));
        list.add(new MainModel(R.drawable.p5, "Detroit Pizza","18","Detroit pizza traditionally features pepperoni, brick cheese (usually Wisconsin brick cheese), and tomato sauce. Other typical toppings include mushrooms and olives."));

        MainAdapter adapter =new MainAdapter(list , this);
        binding.recyclerview.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.recyclerview.setLayoutManager(layoutManager);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.ordersmenu:
                Toast.makeText(MainActivity.this,"Going in see the Order ." ,Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, OrderActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}