package com.fxt.exchange;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class setting2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting2);
        CardView kyc_1=findViewById(R.id.kyc_1);
        CardView user_Setting=findViewById(R.id.user_Setting);
        CardView  acc=findViewById(R.id.add_acc);
        CardView logout=findViewById(R.id.logout);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), signout.class);
                startActivity(intent);
            }
        });


        kyc_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(setting2.this, kycMainActivity.class);
                startActivity(intent);

            }
        });

        user_Setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(setting2.this, Accountsetting.class);
                startActivity(intent);

            }
        });
        acc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(setting2.this, addaccount.class);
                startActivity(intent);

            }
        });
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
            actionBar.setCustomView(R.layout.custom_settings);
            actionBar.setDisplayHomeAsUpEnabled(true);

        }


    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
    }

