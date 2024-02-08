package com.fxt.exchange;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class account1 extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.accounts1);


        View add_funds=findViewById(R.id.add_funds);
        View self_investment=findViewById(R.id.self_investment);
        View fund_transfer=findViewById(R.id.fund_transfer);
        View fund_history = findViewById(R.id.fund_history);

        fund_history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(account1.this,FundTransferHistory01Activity.class);
                startActivity(intent);
            }
        });

        add_funds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(account1.this, add_fund.class);
                startActivity(intent);

            }
        });

        self_investment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(account1.this,com.fxt.exchange.self_investment.class);
                startActivity(intent);

            }
        });
        fund_transfer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(account1.this,com.fxt.exchange.fund_transfer.class);
                startActivity(intent);

            }
       });


        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
            actionBar.setCustomView(R.layout.custom_account);
            actionBar.setDisplayHomeAsUpEnabled(true);

        }

    }


    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }

    }
