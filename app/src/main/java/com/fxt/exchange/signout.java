package com.fxt.exchange;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class signout extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    AlertDialog.Builder builder;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signout);

//        bottomNavigationView=findViewById(R.id.bottam_navigator);
//        bottomNavigationView.setSelectedItemId(R.id.sign_out);
        builder= new AlertDialog.Builder(this);
//
//        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                int itemId = item.getItemId();
//                if (itemId == R.id.profile)
//                {
//                    startActivity(new Intent(getApplicationContext(), profile.class));
//                    overridePendingTransition(R.anim.slide_out_left,R.anim.slide_out_right);
//                    return true;
//                }
//                else if (itemId == R.id.dashboard){
//                    startActivity(new Intent(getApplicationContext(), dashboard.class));
//                    overridePendingTransition(R.anim.slide_out_left,R.anim.slide_out_right);
//                    return true;
//                }
//
//                else if (itemId == R.id.menu1) {
//                    startActivity(new Intent(getApplicationContext(), menu_1.class));
//                    overridePendingTransition(R.anim.slide_out_left,R.anim.slide_out_right);
//                    return true;
//
//                } else if (itemId == R.id.sign_out) {
//                    overridePendingTransition(R.anim.slide_out_left,R.anim.slide_out_right);
//                    return true;
//
//                }
//                return false;
//            }
//        });
//
        builder.setTitle("Alert!!").setMessage("Do you really want to Logout")
                .setCancelable(false).setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        preferences=getSharedPreferences("MyPref",MODE_PRIVATE);
                        editor=preferences.edit();
                        editor.clear().commit();
                        editor.apply();
                        Intent intent=new Intent(getApplicationContext(), login.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                        finish();

                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(getApplicationContext(), dashboard.class));
                        finish();
                        dialog.cancel();
                    }
                })
                .show();

    }
}
