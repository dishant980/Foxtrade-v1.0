package com.fxt.exchange;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class directbusiness extends AppCompatActivity {

    private int Id , trading_no;
    private SharedPreferences sharedPrefManager;
    private SharedPreferences.Editor editor;

    private TextView trading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_directbusiness);

        sharedPrefManager = getSharedPreferences("MyPref", MODE_PRIVATE);
        editor = sharedPrefManager.edit();

        Id= sharedPrefManager.getInt("id",0);
        trading_no=sharedPrefManager.getInt("trading_no",0);
        trading=findViewById(R.id.trading);

        trading.setText(String.valueOf(trading_no));

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
    }
