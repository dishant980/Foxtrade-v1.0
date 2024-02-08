package com.fxt.exchange;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class dashboard extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;


    private SharedPreferences sharedPrefManager;
    private SharedPreferences.Editor editor;
    private String name;
    private String code;
    private int Id;
    ProgressDialog progressDialog;

    NestedScrollView nestedScrollView;
    private final int previousScrollY = 0;

    Toolbar toolbar;

    Button copy1_1,share;

    private int selectedItemId;
    private int originalColor;
    private int clickedColor;

    ImageView logo1;
    AlertDialog.Builder builder;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);

        sharedPrefManager = getSharedPreferences("MyPref", MODE_PRIVATE);
        editor = sharedPrefManager.edit();

        name = sharedPrefManager.getString("name", null);
        code = sharedPrefManager.getString("code", null);
        Id= sharedPrefManager.getInt("id",0);
        toolbar=findViewById(R.id.top_bar);
        logo1=findViewById(R.id.profile_logo);





        logo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(dashboard.this, profile.class);
                startActivity(intent);
            }
        });

        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.top_setting) {
                    startActivity(new Intent(getApplicationContext(), setting2.class));
                    overridePendingTransition(R.anim.slide_out_left, R.anim.slide_out_right);
                    return true;
                }

                return false;
            }
        });


//        TextView nameText = findViewById(R.id.nameText);
//        TextView codeText = findViewById(R.id.codeText);
//        TextView wallet_bal = findViewById(R.id.wallet_bal);
//        TextView ttb_bal = findViewById(R.id.ttb_bal);
//        TextView mtb_bal = findViewById(R.id.mtb_bal);
//        TextView rank_0 = findViewById(R.id.rank_0);
//
////        copy1_1=findViewById(R.id.copy_1);
////        share=findViewById(R.id.share);

//
//
//
//
////        SwitchMaterial switchMaterial=findViewById(R.id.switch1);
////        switchMaterial.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
////            @Override
////            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
////            if (!isChecked){
////                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
////                Toast.makeText(dashboard.this, "Light Mode", Toast.LENGTH_SHORT).show();
////            }else {
////                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
////                Toast.makeText(dashboard.this, "Night Mode", Toast.LENGTH_SHORT).show();
////            }
////            }
////        });
//
//        codeText.setText(code);
//        nameText.setText(name);
//        progressDialog = new ProgressDialog(this); // Initialize ProgressDialog
//        progressDialog.setMessage("Loading..."); // Set a message
//        progressDialog.setCancelable(false); // Set whether the dialog can be canceled
//
//        // Show the ProgressDialog
//        progressDialog.show();
//
//        UserId userId = new UserId();
//        userId.setId(Id);
//        Call<DashboardResponse> dashboardResponseCall = ApiClient.getuserService().fetchUserDashboardDetails(userId);
//        dashboardResponseCall.enqueue(new Callback<DashboardResponse>() {
//            @Override
//            public void onResponse(Call<DashboardResponse> call, Response<DashboardResponse> response) {
//                progressDialog.dismiss();
//                if (response.isSuccessful()) {
//
//                    DashboardResponse dashboardResponse=response.body();
//                    sharedPrefManager=getSharedPreferences("MyPref",MODE_PRIVATE);
//                    editor=sharedPrefManager.edit();
//                     double wallet=dashboardResponse.getWallet();
//                     wallet_bal.setText("$"+String.valueOf(wallet));
//                     String rank = dashboardResponse.getRank();
//                     rank_0.setText(rank);
//                     int totalteam=dashboardResponse.getTeam_business();
//                     ttb_bal.setText("$"+String.valueOf(totalteam));
//                     int monthly=dashboardResponse.getMonthly_team_business();
//                     mtb_bal.setText("$"+String.valueOf(monthly));
//                     int deposite=dashboardResponse.getDeposit();
//                     double withdrawal=dashboardResponse.getWithdrawal();
//                     int direct_business=dashboardResponse.getDirect_business();
//                     int trading_no=dashboardResponse.getTrading_no();
//
//                     String income_percent= String.valueOf(dashboardResponse.getIncome_percent());
//
//                     double com_on_roi= dashboardResponse.getCommission_on_roi();
//                     String founder=String.valueOf(dashboardResponse.getFounder_club());
//                     double roi= dashboardResponse.getRoi();
//                    editor.putInt("direct_business",direct_business);
//                     editor.putString("roi", String.valueOf(roi));
//                     editor.putString("founder", founder);
//                     editor.putString("com_on_roi", String.valueOf(com_on_roi));
//                     editor.putString("income_percent",income_percent);
//                     editor.putInt("deposite",deposite);
//                     editor.putString("withdrawal",String.valueOf(withdrawal));
//                     editor.putString("wallet",String.valueOf(wallet));
//                     editor.putInt("trading_no",trading_no);
//                     editor.apply();
//
//                }
//                else {
//                    progressDialog.dismiss();
//                    Log.e("Network Error", "Error: " + response.message());
//                }
//            }
//            @Override
//            public void onFailure(Call<DashboardResponse> call, Throwable t) {
//                progressDialog.dismiss();
//                Log.e("Network Error", "Error: " + t.getMessage());
//            }
//        });


        bottomNavigationView = findViewById(R.id.bottam_navigator);
        bottomNavigationView.setSelectedItemId(R.id.dash_home);

        originalColor = getResources().getColor(R.color.originalColor);
        clickedColor = getResources().getColor(R.color.clickedColor);

//
//
////        Button copy_1 = findViewById(R.id.copy_1);
////        Button share = findViewById(R.id.share);
//
//
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.dash_home) {
                    startActivity(new Intent(getApplicationContext(), dashboard.class));
                    overridePendingTransition(R.anim.slide_out_left,R.anim.slide_out_right);
                    return true;
                }  else if (itemId == R.id.menu1) {
                    startActivity(new Intent(getApplicationContext(), menu_1.class));
                    overridePendingTransition(R.anim.slide_out_left,R.anim.slide_out_right);
                    return true;
                }
                else if (itemId==R.id.shop) {
                    startActivity(new Intent(getApplicationContext(), shop.class));
                    overridePendingTransition(R.anim.slide_out_left, R.anim.slide_out_right);
                    return true;
                }
                else if (itemId==R.id.finance) {
                    startActivity(new Intent(getApplicationContext(), finance.class));
                    overridePendingTransition(R.anim.slide_out_left, R.anim.slide_out_right);
                    return true;
                }
                else if (itemId==R.id.teams) {
                    startActivity(new Intent(getApplicationContext(), teams.class));
                    overridePendingTransition(R.anim.slide_out_left, R.anim.slide_out_right);
                    return true;
                }
                return false;
            }
        });


//        share.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent shareIntent = new Intent(Intent.ACTION_SEND);
//                shareIntent.setType("text/plain");
//                shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Insert Subject here");
//                String webUrl = "https://fxt.exchange";
//                String shareMessage = "Check out this website: " + webUrl;
//                shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
//                startActivity(Intent.createChooser(shareIntent, "Share via"));
//
//            }
//        });
//        copy1_1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent(dashboard.this, add_fund.class);
//                startActivity(intent);
//            }
//        });
//        share.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent(dashboard.this, self_investment.class);
//                startActivity(intent);
//            }
//        });
//        copy_1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ClipboardManager clipboardManager = null;
//                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
//                    clipboardManager = (ClipboardManager) getSystemService(ClipboardManager.class);
//                }
//                ClipData clipData = ClipData.newPlainText("Copy", codeText.getText().toString());
//                clipboardManager.setPrimaryClip(clipData);
//                Toast.makeText(dashboard.this, "Copied", Toast.LENGTH_LONG).show();
//
//            }
//        });



    }



}



