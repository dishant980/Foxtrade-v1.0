package com.fxt.exchange;

import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
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


    public class referral_list extends AppCompatActivity {
    private int Id;
    SharedPreferences sharedPrefManager;
    SharedPreferences.Editor editor;
    private RecyclerView recyclerView;
    private ProgressDialog progressDialog;
    SearchView search;

    private myadapter adapter;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_referral_list);


            sharedPrefManager = getSharedPreferences("MyPref", MODE_PRIVATE);
            editor = sharedPrefManager.edit();
            Id= sharedPrefManager.getInt("id",0);

            recyclerView=findViewById(R.id.recycle);
            search=findViewById(R.id.search);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            please_wait pleaseWait= new please_wait(referral_list.this);
            pleaseWait.setCancelable(false);

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    pleaseWait.show();

                    UserId userId = new UserId();
                    userId.setId(Id);

                    Call<ResponseModel> referlistResponseCall = ApiClient.getuserService().fetch_referrals_with_id(userId);
                    referlistResponseCall.enqueue(new Callback<ResponseModel>() {
                        @Override
                        public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                            pleaseWait.dismiss();
                            if (response.isSuccessful()) {
                                ResponseModel data = response.body();
                                List<ResponseModel.Child> childrenList = data.getChildren();
                                adapter = new myadapter(childrenList);
                                recyclerView.setAdapter(adapter);
                            } else {
                                Toast.makeText(referral_list.this, "No Data Available", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<ResponseModel> call, Throwable t) {
                            pleaseWait.dismiss();
                            Log.e("Network Error", "Error: " + t.getMessage());
                        }
                    });

                    recyclerView.setAdapter(adapter);
                }
            }, 2000);


            search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    return false;
                }
                @Override
                public boolean onQueryTextChange(String newText) {
                    if (adapter!=null) {
                        adapter.getFilter().filter(newText);
                    }
                    return false;
                }});

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        }
        @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}
