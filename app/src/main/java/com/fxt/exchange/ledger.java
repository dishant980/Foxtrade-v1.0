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

public class ledger extends AppCompatActivity {
    private int Id;
    private SharedPreferences sharedPrefManager;
    private SharedPreferences.Editor editor;
    private RecyclerView recycler_view;
    private ProgressDialog progressDialog;
    SearchView search1;
    private LedgerAdapter ledgerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ledger);

        sharedPrefManager = getSharedPreferences("MyPref", MODE_PRIVATE);
        editor = sharedPrefManager.edit();
        Id= sharedPrefManager.getInt("id",0);




        search1=findViewById(R.id.search1);
        recycler_view=findViewById(R.id.recycle1);
        recycler_view.setLayoutManager(new LinearLayoutManager(this));
        recycler_view.setAdapter(ledgerAdapter);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.setCancelable(false);
        progressDialog.show();

        UserId userId = new UserId();
        userId.setId(Id);

        Call<TransactionResponse> transactionResponseCall=ApiClient.getuserService().fetchMyWalletLedger(userId);
            transactionResponseCall.enqueue(new Callback<TransactionResponse>() {
                @Override
                public void onResponse(Call<TransactionResponse> call, Response<TransactionResponse> response) {
                    progressDialog.dismiss();
                    if (response.isSuccessful()){
                        TransactionResponse data=response.body();
                        List<TransactionResponse.TransactionItem>transactions=data.getTransactions();
                        ledgerAdapter= new LedgerAdapter(transactions);
                        recycler_view.setAdapter(ledgerAdapter);

                        }
                    else
                    {
                        progressDialog.dismiss();
                        Toast.makeText(ledger.this, "No Data Availabe", Toast.LENGTH_SHORT).show();

                    }
                }

                @Override
                public void onFailure(Call<TransactionResponse> call, Throwable t) {
                    progressDialog.dismiss();
                    Toast.makeText(ledger.this, "No Data Available", Toast.LENGTH_SHORT).show();
                    Log.e("Network Error", "Error: " + t.getMessage());
                }
            });
            search1.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    if (ledgerAdapter!=null) {
                        ledgerAdapter.getFilter().filter(newText);
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