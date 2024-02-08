package com.fxt.exchange;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Accountsetting extends AppCompatActivity {

    AlertDialog.Builder builder;

    private int Id;
    private String name;
    private String setEmail;

    private SharedPreferences sharedPrefManager;
    private SharedPreferences.Editor editor;
    private ProgressDialog progressDialog;

    private TextView name_user,email_user;

    private Button update_pass;

    private EditText current_pass,new_pass,confirm_pass;
    LinearLayout password_forum;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accountsetting);

        sharedPrefManager = getSharedPreferences("MyPref", MODE_PRIVATE);
        editor = sharedPrefManager.edit();

        email_user=findViewById(R.id.email_user);
        name_user=findViewById(R.id.name_user);




        Id= sharedPrefManager.getInt("id",0);
        name=sharedPrefManager.getString("name", null);
        setEmail=sharedPrefManager.getString("setEmail",null);
        name_user.setText(name);
        email_user.setText(setEmail);


        current_pass=findViewById(R.id.current_pass);
        new_pass=findViewById(R.id.new_pass);
        confirm_pass=findViewById(R.id.confirm_pass);
        update_pass=findViewById(R.id.update_pass);
        password_forum=findViewById(R.id.password_forum);



        Button button1=findViewById(R.id.delete123);

        builder= new AlertDialog.Builder(this);
        getSupportActionBar().setTitle("Account Setting");

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.setCancelable(false);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.setTitle("Alert!!").setMessage("Do you really want to delete your account")
                        .setCancelable(true).setPositiveButton("yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();

                            }
                        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                 dialog.cancel();
                            }
                        })
                        .show();

            }
        });

        update_pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if (TextUtils.isEmpty(current_pass.getText().toString().trim())
               || TextUtils.isEmpty(new_pass.getText().toString().trim())
               || TextUtils .isEmpty(confirm_pass.getText().toString().trim()))
                {
                   Toast.makeText(Accountsetting.this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
               }
               else {
                 save_password();
               }

            }
        });




        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }

    private void save_password(){

        updatePassword updatePassword=new updatePassword();
        updatePassword.setCurrentPassword(current_pass.getText().toString());
        updatePassword.setPassword(new_pass.getText().toString().trim());
        updatePassword.setConfirmPassword(confirm_pass.getText().toString().trim());
        updatePassword.setUserId(Id);


        progressDialog.show();
        Call<UpdatepasswordResponse> updatepasswordResponseCall=ApiClient.getuserService().savePassword(updatePassword);
        updatepasswordResponseCall.enqueue(new Callback<UpdatepasswordResponse>() {
            @Override
            public void onResponse(Call<UpdatepasswordResponse> call, Response<UpdatepasswordResponse> response) {
                progressDialog.dismiss();
                if (response.isSuccessful()){
                    UpdatepasswordResponse response1=response.body();
                    int status= response1.getStatus();
                    if (status==200){
                        current_pass.setText("");
                        new_pass.setText("");
                        confirm_pass.setText("");
                        Toast.makeText(Accountsetting.this, "Password Changed Successful", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        progressDialog.dismiss();
                        Toast.makeText(Accountsetting.this, "Unsuccessful", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<UpdatepasswordResponse> call, Throwable t) {
                progressDialog.dismiss();
                Log.e("Network Error", "Error: " + t.getMessage());

            }
        });

        password_forum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                current_pass.setFocusable(true);
                current_pass.setFocusableInTouchMode(true);
                new_pass.setFocusable(true);
                new_pass.setFocusableInTouchMode(true);
                confirm_pass.setFocusable(true);
                confirm_pass.setFocusableInTouchMode(true);

                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.showSoftInput(password_forum, InputMethodManager.SHOW_IMPLICIT);

            }
        });


    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }



    }
