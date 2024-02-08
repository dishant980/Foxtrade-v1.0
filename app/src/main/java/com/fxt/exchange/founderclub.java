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

public class founderclub extends AppCompatActivity {
    private int Id;
    private SharedPreferences sharedPrefManager;
    private SharedPreferences.Editor editor;
    private SearchView search_found;
    private RecyclerView recycle4;
    private FounderAdapter founderAdapter;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_founderclub);

        sharedPrefManager = getSharedPreferences("MyPref", MODE_PRIVATE);
        editor = sharedPrefManager.edit();
        Id= sharedPrefManager.getInt("id",0);


        search_found=findViewById(R.id.search_found);
        recycle4=findViewById(R.id.recycle4);
        recycle4.setLayoutManager(new LinearLayoutManager(this));
        recycle4.setAdapter(founderAdapter);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.setCancelable(false);
        progressDialog.show();

        UserId userId = new UserId();
        userId.setId(Id);

        Call<SalaryResponse> salaryResponseCall= ApiClient.getuserService().fetchmySalary(userId);
        salaryResponseCall.enqueue(new Callback<SalaryResponse>() {
            @Override
            public void onResponse(Call<SalaryResponse> call, Response<SalaryResponse> response) {
                progressDialog.dismiss();
                if (response.isSuccessful()){
                SalaryResponse salaryResponse=response.body();
                List<SalaryResponse.SalaryItem>salaryItems=salaryResponse.getTransactions();
                founderAdapter = new FounderAdapter(salaryItems);
                recycle4.setAdapter(founderAdapter);
            }   else {
                Toast.makeText(founderclub.this, "No Data Available", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<SalaryResponse> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(founderclub.this, "No Data Available", Toast.LENGTH_SHORT).show();
                Log.e("Network Error", "Error: " + t.getMessage());
            }
        });
        search_found.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (founderAdapter!=null){
                    founderAdapter.getFilter().filter(newText);
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