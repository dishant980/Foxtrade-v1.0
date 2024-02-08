package com.fxt.exchange;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class profile extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    private String code;
    private String name;
     private String withdrawal;
     private String income_percent;
     ProgressBar progressBar;
   private TextView incomeValueText;
    private int deposite;
    private SharedPreferences sharedPrefManager;
    private SharedPreferences.Editor editor;

    private Button invest_button , add_fund;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        
        sharedPrefManager=getSharedPreferences("MyPref",MODE_PRIVATE);
        editor=sharedPrefManager.edit();

        code=sharedPrefManager.getString("code",null);
        name = sharedPrefManager.getString("name", null);
        income_percent=sharedPrefManager.getString("income_percent",null);

//        TextView refer=findViewById(R.id.refer);
//        TextView profile_name=findViewById(R.id.name);
//
        invest_button=findViewById(R.id.invest_funds);
        add_fund=findViewById(R.id.add_funds);
//
//        TextView with_draw=findViewById(R.id.with_draw);
//        progressBar=findViewById(R.id.pro_bar);
//        incomeValueText=findViewById(R.id.incomeValueText);
//
//        profile_name.setText(name);
//
//        int incomePercent = Integer.parseInt(income_percent);
//
//        progressBar.setProgress(incomePercent);
//        incomeValueText.setText(incomePercent + "%");
//
//
//
//        refer.setText(code);
//        int deposite=sharedPrefManager.getInt("deposite",0);
//
//        TextView depo_0=findViewById(R.id.depo_0);
//        depo_0.setText("$"+String.valueOf(deposite));
//
//        withdrawal = sharedPrefManager.getString("withdrawal",null);
//        with_draw.setText("$"+String.valueOf(withdrawal));
//
//
//


//        bottomNavigationView=findViewById(R.id.bottam_navigator);
//        bottomNavigationView.setSelectedItemId(R.id.profile);
//
        ImageView copy=findViewById(R.id.copy);
//
//        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                int itemId = item.getItemId();
//                if (itemId == R.id.profile)
//                {
//                    overridePendingTransition(R.anim.slide_out_left,R.anim.slide_out_right);
//                    return true;
//                }
//                else if (itemId == R.id.teams){
//                    startActivity(new Intent(getApplicationContext(), teams.class));
//                    overridePendingTransition(R.anim.slide_out_left,R.anim.slide_out_right);
//                    return true;
//                }
//
//                else if (itemId == R.id.menu1) {
//                    startActivity(new Intent(getApplicationContext(), menu_1.class));
//                    overridePendingTransition(R.anim.slide_out_left,R.anim.slide_out_right);
//                    return true;
//
//                }
//                else if (itemId==R.id.shop) {
//                    startActivity(new Intent(getApplicationContext(), shop.class));
//                    overridePendingTransition(R.anim.slide_out_left, R.anim.slide_out_right);
//                    return true;
//                }
//                else if (itemId==R.id.finance) {
//                    startActivity(new Intent(getApplicationContext(), finance.class));
//                    overridePendingTransition(R.anim.slide_out_left, R.anim.slide_out_right);
//                    return true;
//                }
//                return false;
//            }
//        });

//        copy.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ClipboardManager clipboardManager= null;
//                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
//                    clipboardManager = (ClipboardManager)getSystemService(ClipboardManager.class);
//                }
//                ClipData clipData=ClipData.newPlainText("Copy",refer.getText().toString());
//                clipboardManager.setPrimaryClip(clipData);
//                Toast.makeText(profile.this,"Copied",Toast.LENGTH_LONG).show();
//
//            }
//        });
//
        invest_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),self_investment.class);
                startActivity(intent);
            }
        });

        add_fund.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),add_fund.class);
                startActivity(intent);
            }
        });
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
            actionBar.setCustomView(R.layout.custom_bar_name);
            actionBar.setDisplayHomeAsUpEnabled(true);

        }


    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}