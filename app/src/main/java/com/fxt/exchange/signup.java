package com.fxt.exchange;


import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class signup extends AppCompatActivity {


    EditText username;
    EditText useremail;
    EditText userpassword;
    EditText userphone;
    EditText refercode;
    EditText confirmpassword;
    Button registration;
    TextView textView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        TextView tv = findViewById(R.id.textView2);
         username = findViewById(R.id.name);
         useremail = findViewById(R.id.email);
         refercode = findViewById(R.id.referred_by);
         userpassword = findViewById(R.id.password);
         userphone=findViewById(R.id.phone);

        confirmpassword = findViewById(R.id.etpass2);
        Button registration = findViewById(R.id.registration);


        tv.setOnClickListener(new View.OnClickListener() {
            @Override
             public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), login.class);
                startActivity(intent);
            }
        });

        registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register_user();
            }
        });


    }

    private void register_user() {
        String name = username.getText().toString();
        String email = useremail.getText().toString();
        String referredBy = refercode.getText().toString();
        String password = userpassword.getText().toString();
        String confirmPassword = confirmpassword.getText().toString();
        String phone_number = userphone.getText().toString().trim();

        if (name.isEmpty()||email.isEmpty()||referredBy.isEmpty()||password.isEmpty()||confirmPassword.isEmpty()
        ||phone_number.isEmpty()){
            Toast.makeText(this, "Please Fill All the Fields", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            Toast.makeText(this, "Please Enter Valid Email", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!confirmPassword.equals(password)){
            Toast.makeText(this, "Password and Confirm Password do not Matched", Toast.LENGTH_SHORT).show();
            return;
        }

        if (phone_number.length() != 10){
            Toast.makeText(this, "Phone number must be 10 digits", Toast.LENGTH_SHORT).show();
        }
        RegisterRequest registerRequest= new RegisterRequest();
        registerRequest.setName(username.getText().toString());
        registerRequest.setEmail(useremail.getText().toString());
        registerRequest.setReferred_by(refercode.getText().toString());
        registerRequest.setPassword(userpassword.getText().toString());
        registerRequest.setPhone_number(userphone.getText().toString());


        LoadingDialog loadingDialog = new LoadingDialog(signup.this);
        loadingDialog.setCancelable(false);
        loadingDialog.show();
        Call<RegisterResponse> registerResponseCall=ApiClient.getuserService().register(registerRequest);
        registerResponseCall.enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                loadingDialog.dismiss();
                if (response.isSuccessful()) {
                    RegisterResponse registerResponse = response.body();
                    if (registerResponse != null) {
                        Toast.makeText(signup.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                        username.setText("");
                        useremail.setText("");
                        refercode.setText("");
                        userpassword.setText("");
                        userphone.setText("");
                        confirmpassword.setText("");
                        Intent intent=new Intent(signup.this, login.class);
                        startActivity(intent);

                    } else {
                        loadingDialog.dismiss();
                        Toast.makeText(signup.this, "Error: Server failed to Register", Toast.LENGTH_SHORT).show();
                    }
                } else {

                    Toast.makeText(signup.this, "Error: " + response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {
                loadingDialog.dismiss();
                Toast.makeText(signup.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
