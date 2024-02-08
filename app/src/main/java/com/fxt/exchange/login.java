package com.fxt.exchange;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class login extends AppCompatActivity {


    private Button loginButton;
    private TextView signin;
    private EditText email,password;
    private SharedPreferences sharedPrefManager;
    private SharedPreferences.Editor editor;
    private TextView forgetpassword;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);


        sharedPrefManager=getSharedPreferences("MyPref",MODE_PRIVATE);
        editor=sharedPrefManager.edit();
        if (sharedPrefManager.contains("setEmail")){
            Intent intent=new Intent(login.this, dashboard.class);
            startActivity(intent);
            finish();
        }

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        loginButton = findViewById(R.id.login);
        signin=findViewById(R.id.signin);
        forgetpassword=findViewById(R.id.forgetpassword);
        forgetpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(login.this,com.fxt.exchange.forgetpassword.class);
                startActivity(intent);
            }
        });


        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),signup.class);
                startActivity(intent);
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(email.getText().toString()) || TextUtils.isEmpty(password.getText().toString())){
                    Toast.makeText(login.this, "Email/ Password Required", Toast.LENGTH_SHORT).show();
                }
                else
                {
                get_login();
                }
            }
        });


    }
    public void get_login() {

        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setEmail(email.getText().toString());
        loginRequest.setPassword(password.getText().toString());
        LoadingDialog loadingDialog = new LoadingDialog(login.this);
        loadingDialog.setCancelable(false);
        Call<LoginResponse> loginResponseCall = ApiClient.getuserService().userLogin(loginRequest);
        loginResponseCall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.isSuccessful()) {
                    LoginResponse loginResponse = response.body();
                    UserResponse userResponse = response.body();
                    User user = userResponse.getUser();
                    handleLoginSuccess(user, loginResponse);
                } else {
                    loadingDialog.dismiss();
                    Toast.makeText(login.this, "Login Failed. Please check your credentials.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                loadingDialog.dismiss();
                Toast.makeText(login.this, "Network error. Please try again later.", Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void handleLoginSuccess(User user, LoginResponse loginResponse) {
        sharedPrefManager = getSharedPreferences("MyPref", MODE_PRIVATE);
        editor = sharedPrefManager.edit();
        String name = user.getName();
        String code = String.valueOf(user.getRefer_code());
        String id=String.valueOf(user.getId());
        editor.putString("name", name);
        editor.putString("code", code);
        editor.putInt("id", Integer.parseInt(id));
        LoadingDialog loadingDialog = new LoadingDialog(login.this);
        loadingDialog.setCancelable(false);
        loadingDialog.show();
        Toast.makeText(login.this, "Login Successful", Toast.LENGTH_SHORT).show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                loadingDialog.dismiss();
                String setEmail = email.getText().toString();
                String setPassword = password.getText().toString();
                editor.putString("setEmail", setEmail);
                editor.putString("setPassword", setPassword);
                editor.putBoolean("isLoggedIn", true);
                editor.apply();
                Intent intent = new Intent(login.this, dashboard.class);
                startActivity(intent);
                finish();
            }
        }, 3000);
    }

}


