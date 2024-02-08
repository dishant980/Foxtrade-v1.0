package com.fxt.exchange;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class finance extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    Button button;
    private int originalButtonColor;
    ImageView slid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finance);

        slid=findViewById(R.id.slider);



        originalButtonColor = getResources().getColor(R.color.buttonColor);


        bottomNavigationView = findViewById(R.id.bottam_navigator);
        bottomNavigationView.setSelectedItemId(R.id.finance);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                onButtonClick(v);
//
//            }
//        });


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.finance) {
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
                } else if (itemId==R.id.shop) {
                    startActivity(new Intent(getApplicationContext(), shop.class));
                    overridePendingTransition(R.anim.slide_out_left, R.anim.slide_out_right);
                    return true;
                }
                return false;
            }
        });

    }

//    public void onButtonClick(View view) {
//        Button myButton = (Button) view;
//        myButton.setBackgroundColor(getResources().getColor(R.color.buttonColorClicked));
//        Intent intent= new Intent(getApplicationContext(), ledger.class);
//        startActivity(intent);
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        button.setBackgroundColor(originalButtonColor);
//    }



}