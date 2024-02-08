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

public class comissiononroi extends AppCompatActivity {
    private int Id;
    private SharedPreferences sharedPrefManager;
    private SharedPreferences.Editor editor;
    private RecyclerView recycler_view1;
    private ProgressDialog progressDialog;
    private CommisionAdapter commisionAdapter;
    SearchView searchEdit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comissiononroi);


        sharedPrefManager = getSharedPreferences("MyPref", MODE_PRIVATE);
        editor = sharedPrefManager.edit();
        Id= sharedPrefManager.getInt("id",0);
        searchEdit=findViewById(R.id.searchEdit);

        recycler_view1=findViewById(R.id.recycler_view1);
        recycler_view1.setLayoutManager(new LinearLayoutManager(comissiononroi.this));
        recycler_view1.setAdapter(commisionAdapter);


        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.setCancelable(false);
        progressDialog.show();

        UserId userId = new UserId();
        userId.setId(Id);

        Call<CommissionResponse> commissionResponseCall=ApiClient.getuserService().fetchMyCommision(userId);
        commissionResponseCall.enqueue(new Callback<CommissionResponse>() {
            @Override
            public void onResponse(Call<CommissionResponse> call, Response<CommissionResponse> response) {
                progressDialog.dismiss();
                if (response.isSuccessful()){

                    CommissionResponse commissionResponse=response.body();
                    List<CommissionResponse.CommissionItem> transactions=commissionResponse.getTransactions();
                    commisionAdapter = new CommisionAdapter(transactions);
                    recycler_view1.setAdapter(commisionAdapter);
                }
                else
                {
                    progressDialog.dismiss();
                    Toast.makeText(comissiononroi.this, "No Data Available", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<CommissionResponse> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(comissiononroi.this, "No Data Available", Toast.LENGTH_SHORT).show();
                Log.e("Network Error", "Error: " + t.getMessage());
            }


        });

        searchEdit.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (commisionAdapter!=null) {
                    commisionAdapter.getFilter().filter(newText);
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