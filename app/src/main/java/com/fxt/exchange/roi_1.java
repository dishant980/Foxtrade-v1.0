package com.fxt.exchange;

import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class roi_1 extends AppCompatActivity {
    private int Id;
    SharedPreferences sharedPrefManager;
    SharedPreferences.Editor editor;
    private RecyclerView recycle;
    private ProgressDialog progressDialog;
    SearchView search_roi;
    InvestmentAdapter investmentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roi1);

        sharedPrefManager = getSharedPreferences("MyPref", MODE_PRIVATE);
        editor = sharedPrefManager.edit();
        Id= sharedPrefManager.getInt("id",0);

        search_roi=findViewById(R.id.search_roi);
        recycle=findViewById(R.id.recycle3);
        recycle.setLayoutManager(new LinearLayoutManager(this));
        recycle.setAdapter(investmentAdapter);


        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.setCancelable(false);
        progressDialog.show();

        UserId userId = new UserId();
        userId.setId(Id);

        Call<InvestmentResponse> investmentResponseCall=ApiClient.getuserService().fetchmyRoi(userId);
        investmentResponseCall.enqueue(new Callback<InvestmentResponse>() {
            @Override
            public void onResponse(Call<InvestmentResponse> call, Response<InvestmentResponse> response) {
                progressDialog.dismiss();
                if (response.isSuccessful()){
                    InvestmentResponse InvestmentItem=response.body();
                    List<InvestmentResponse.InvestmentItem>investmentItems=InvestmentItem.getTransactions();
                    investmentAdapter=new InvestmentAdapter(investmentItems);
                    recycle.setAdapter(investmentAdapter);

                }
            }

            @Override
            public void onFailure(Call<InvestmentResponse> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(roi_1.this, "No Data Available", Toast.LENGTH_SHORT).show();
                Log.e("Network Error", "Error: " + t.getMessage());
            }
        });

        search_roi.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (investmentAdapter!=null){
                        investmentAdapter.getFilter().filter(newText);
                }
                return false;
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