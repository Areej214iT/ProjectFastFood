package com.example.myfoodapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myfoodapp.Adapters.MainAdapter;
import com.example.myfoodapp.Models.MainModel;
import com.example.myfoodapp.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;


public class Login extends AppCompatActivity {
    Button btn_llogin;
    EditText et_lusername, et_lpassword;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



        et_lusername = (EditText)findViewById(R.id.et_lusername);
        et_lpassword = (EditText)findViewById(R.id.et_lpassword);

        btn_llogin = (Button)findViewById(R.id.btn_llogin);


        btn_llogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent message = new Intent(Login.this, MainActivity.class);
                startActivity(message);
            }
        });
    }
}
