package com.fxt.exchange;

import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class self_investment extends AppCompatActivity {
    private int Id;
    private String wallet;
    SharedPreferences sharedPrefManager;
    SharedPreferences.Editor editor;
    private ProgressDialog progressDialog;
    TextView self_txt;
    SelfAdapter selfAdapter;
    RecyclerView recycler5;
    Button invest_button;
    EditText edit_save;
    LinearLayout layout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_self_investment);

        sharedPrefManager = getSharedPreferences("MyPref", MODE_PRIVATE);
        editor = sharedPrefManager.edit();
        Id= sharedPrefManager.getInt("id",0);

        wallet=sharedPrefManager.getString("wallet",null );

        self_txt=findViewById(R.id.self_txt);
        recycler5=findViewById(R.id.recycler5);
        layout=findViewById(R.id.linear_lay);
        invest_button=findViewById(R.id.invest_button);
        edit_save=findViewById(R.id.edit_save);


        TextView view=findViewById(R.id.wal_bal);
        view.setText(wallet+"$");

        recycler5.setLayoutManager(new LinearLayoutManager(this));


            progressDialog = new ProgressDialog(this);
            progressDialog.setMessage("Loading...");
            progressDialog.setCancelable(false);
            progressDialog.show();

            UserId userId = new UserId();
            userId.setId(Id);



            Call<UserWalletResponse>userWalletResponseCall=ApiClient.getuserService().fetchmyInvestment(userId);
        userWalletResponseCall.enqueue(new Callback<UserWalletResponse>() {
            @Override
            public void onResponse(Call<UserWalletResponse> call, Response<UserWalletResponse> response) {
                progressDialog.dismiss();
                if (response.isSuccessful()){
                    UserWalletResponse userWalletResponse = response.body();
                    UserWalletResponse.UserWalletBalance userWalletBalance =userWalletResponse.getUserWalletBalance();

                    String txt_msg= userWalletBalance.getInvestedMessage();
                    self_txt.setText(String.valueOf(txt_msg));

                    if (txt_msg == null || txt_msg.isEmpty()) {
                        layout.setVisibility(View.VISIBLE);
                    } else {
                        layout.setVisibility(View.VISIBLE);
                    }


                    List<UserWalletResponse.FundRequest> fundRequests= userWalletResponse.getFundRequests();
                    selfAdapter = new SelfAdapter(fundRequests);
                    recycler5.setAdapter(selfAdapter);
                    Animation slideInAnimation = AnimationUtils.loadAnimation(self_investment.this, R.anim.scale_in);
                    recycler5.startAnimation(slideInAnimation);

                    }
                else {
                    Toast.makeText(self_investment.this, "", Toast.LENGTH_SHORT).show();
                }
                }



            @Override
            public void onFailure(Call<UserWalletResponse> call, Throwable t) {
                progressDialog.dismiss();
                Log.e("Network Error", "Error: " + t.getMessage());
            }
        });

        invest_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            if (TextUtils.isEmpty(edit_save.getText().toString().trim())){
                Toast.makeText(self_investment.this, "Add Amount to invest", Toast.LENGTH_SHORT).show();
            }
            else {
                invest_funds();
            }
            }
        });
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
            actionBar.setCustomView(R.layout.self_bar_layout);
            actionBar.setDisplayHomeAsUpEnabled(true);

        }

    }

    private void invest_funds() {

            self_investment_funds selfInvestmentFunds= new self_investment_funds();
            selfInvestmentFunds.setInvestAmount(edit_save.getText().toString().trim());
            selfInvestmentFunds.setUserId(Integer.parseInt(String.valueOf(Id)));
            selfInvestmentFunds.setPreviousInvestment(String.valueOf(0));
            selfInvestmentFunds.setMinimumDeposite(String.valueOf(100));
            selfInvestmentFunds.setWalletBalance(String.valueOf(wallet));
            progressDialog.show();
            Call<SelfinvestmentResponse>selfinvestmentResponseCall=ApiClient.getuserService().saveSelfInvestment(selfInvestmentFunds);
            selfinvestmentResponseCall.enqueue(new Callback<SelfinvestmentResponse>() {
                @Override
                public void onResponse(Call<SelfinvestmentResponse> call, Response<SelfinvestmentResponse> response) {
                        progressDialog.dismiss();
                    if (response.isSuccessful()){
                        SelfinvestmentResponse selfinvestmentResponse= response.body();
                        int status=selfinvestmentResponse.getStatus();
                        if (status==200){
                            edit_save.setText("");
                            Toast.makeText(self_investment.this, "Self Investment Successful", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            progressDialog.dismiss();
                            Toast.makeText(self_investment.this, "Failed to Save Funds", Toast.LENGTH_SHORT).show();
                        }
                    }
                }

                @Override
                public void onFailure(Call<SelfinvestmentResponse> call, Throwable t) {
                    progressDialog.dismiss();
                    Log.e("Network Error", "Error: " + t.getMessage());
                }
            });
    }


    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }


    }
