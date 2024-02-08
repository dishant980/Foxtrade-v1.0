package com.fxt.exchange;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class shop extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    androidx.appcompat.widget.Toolbar toolbar;
    MenuItem menuItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);


        bottomNavigationView = findViewById(R.id.bottam_navigator);

        bottomNavigationView.setSelectedItemId(R.id.shop);
        toolbar = findViewById(R.id.top_bar);


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.shop) {
                    overridePendingTransition(R.anim.slide_out_left, R.anim.slide_out_right);
                    return true;
                } else if (itemId == R.id.dash_home) {
                    startActivity(new Intent(getApplicationContext(), dashboard.class));
                    overridePendingTransition(R.anim.slide_out_left, R.anim.slide_out_right);
                    return true;
                } else if (itemId == R.id.menu1) {
                    startActivity(new Intent(getApplicationContext(), menu_1.class));
                    overridePendingTransition(R.anim.slide_out_left, R.anim.slide_out_right);
                    return true;

                } else if (itemId == R.id.teams) {
                    startActivity(new Intent(getApplicationContext(), teams.class));
                    overridePendingTransition(R.anim.slide_out_left, R.anim.slide_out_right);
                    return true;
                }
                else if (itemId==R.id.finance) {
                    startActivity(new Intent(getApplicationContext(), finance.class));
                    overridePendingTransition(R.anim.slide_out_left, R.anim.slide_out_right);
                    return true;
                }
                return false;
            }
        });


    }
}