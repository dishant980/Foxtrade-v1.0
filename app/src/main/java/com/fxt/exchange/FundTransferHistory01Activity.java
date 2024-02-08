package com.fxt.exchange;

import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FundTransferHistory01Activity extends AppCompatActivity {
    private fundAdapter fundAdapter;
    private int Id;
    private SharedPreferences sharedPrefManager;
    private SharedPreferences.Editor editor;
    private RecyclerView recyclerView;
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fund_transfer_history01);

        sharedPrefManager = getSharedPreferences("MyPref", MODE_PRIVATE);
        editor = sharedPrefManager.edit();

        Id= sharedPrefManager.getInt("id",0);

        recyclerView=findViewById(R.id.recycle6);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.setCancelable(false);
        progressDialog.show();

        UserId userId = new UserId();
        userId.setId(Id);

        Call<FundResponse> fundResponseCall=ApiClient.getuserService().fetchmyfund(userId);
        fundResponseCall.enqueue(new Callback<FundResponse>() {
            @Override
            public void onResponse(Call<FundResponse> call, Response<FundResponse> response) {
                progressDialog.dismiss();
                if (response.isSuccessful()) {

                    FundResponse fundResponse = response.body();
                    List<FundResponse.FundRequest> fundRequests = fundResponse.getFundRequests();
                    fundAdapter = new fundAdapter(fundRequests);
                    recyclerView.setAdapter(fundAdapter);
                    Animation slideInAnimation = AnimationUtils.loadAnimation(FundTransferHistory01Activity.this, R.anim.fall_down);
                    recyclerView.startAnimation(slideInAnimation);
                }
                 else {
                    Toast.makeText(FundTransferHistory01Activity.this, "No Data Available", Toast.LENGTH_SHORT).show();
                }
            }


            @Override
            public void onFailure(Call<FundResponse> call, Throwable t) {
                progressDialog.dismiss();
                Log.e("Network Error", "Error: " + t.getMessage());
            }
        });

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}