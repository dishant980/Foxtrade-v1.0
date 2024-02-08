package com.fxt.exchange;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class fund_transfer extends AppCompatActivity {


    private int Id;
    private String wallet;
    private SharedPreferences sharedPrefManager;
    private SharedPreferences.Editor editor;
    private ProgressDialog progressDialog;

    private TextView wallet_bb,beneficiary_name;
    private Button Transfer_fund;
    private CheckBox checkboxTransferToAdmin;

    private EditText referCode , Transfer_amount , remark;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fund_transfer);

        sharedPrefManager = getSharedPreferences("MyPref", MODE_PRIVATE);
        editor = sharedPrefManager.edit();

        Id= sharedPrefManager.getInt("id",0);
        wallet=sharedPrefManager.getString("wallet",null );



        wallet_bb=findViewById(R.id.wallet_balance);
        beneficiary_name=findViewById(R.id.beneficiary_name);

        referCode=findViewById(R.id.referCode);
        Transfer_fund=findViewById(R.id.Transfer_fund);

        Transfer_amount=findViewById(R.id.Transfer_amount);
        remark=findViewById(R.id.remark);

        checkboxTransferToAdmin=findViewById(R.id.checkbox_transfer_to_admin);
        wallet_bb.setText("$"+wallet);

        LinearLayout linearLayout=findViewById(R.id.lin_lay);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.setCancelable(false);

        checkboxTransferToAdmin.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                referCode.setEnabled(!isChecked);
                beneficiary_name.setEnabled(!isChecked);
                if (isChecked){
                    linearLayout.setVisibility(View.GONE);
                }else {
                    linearLayout.setVisibility(View.VISIBLE);
                }
            }
        });





        referCode.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String referCode = s.toString();
                if (!referCode.isEmpty()) {
                    getBeneficiaryName(referCode);
                }else {
                    beneficiary_name.setText("");
                }
            }
        });

        Transfer_fund.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isCheckboxChecked = checkboxTransferToAdmin.isChecked();

                if (isCheckboxChecked) {
                    if (TextUtils.isEmpty(Transfer_amount.getText().toString().trim())
                            || TextUtils.isEmpty(remark.getText().toString().trim())) {
                        Toast.makeText(fund_transfer.this, "Please fill all the Field", Toast.LENGTH_SHORT).show();
                    } else {
                        transfer_fund();
                    }
                } else {

                    if (TextUtils.isEmpty(referCode.getText().toString())
                            || TextUtils.isEmpty(Transfer_amount.getText().toString().trim())
                            || TextUtils.isEmpty(remark.getText().toString().trim())) {
                        Toast.makeText(fund_transfer.this, "Please fill all the Field", Toast.LENGTH_SHORT).show();
                    } else {
                        transfer_fund();
                    }
                }
            }
        });

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
            actionBar.setCustomView(R.layout.action_bar_layout);
            actionBar.setDisplayHomeAsUpEnabled(true);

        }




    }

    public void transfer_fund() {
            FundTransferRequest transferRequest = new FundTransferRequest();

            transferRequest.setTransferAmount(Transfer_amount.getText().toString());
            transferRequest.setTransferToAdmin(checkboxTransferToAdmin.isChecked() ? 1 : 0);
        if (checkboxTransferToAdmin.isChecked()) {
            transferRequest.setBeneficiaryName("Admin");
        }else {
            transferRequest.setBeneficiaryReferCode(referCode.getText().toString());
            transferRequest.setBeneficiaryName(beneficiary_name.getText().toString());
        }

        transferRequest.setRemarks(remark.getText().toString());
        transferRequest.setUserId(Integer.parseInt(String.valueOf(Id)));
        transferRequest.setWalletBalance(String.valueOf(wallet));
        progressDialog.show();

        Call<FundTransferResponse> fundTransferResponseCall = ApiClient.getuserService().saveTransferFunds(transferRequest);
            fundTransferResponseCall.enqueue(new Callback<FundTransferResponse>() {
                @Override
                public void onResponse(Call<FundTransferResponse> call, Response<FundTransferResponse> response) {
                    progressDialog.dismiss();

                    if (response.isSuccessful()) {
                        FundTransferResponse fundTransferRequest = response.body();
                        int status = fundTransferRequest.getStatus();
                        if (status == 200) {
                            Transfer_amount.setText("");
                            remark.setText("");
                            referCode.setText("");
                            Toast.makeText(fund_transfer.this, "Funds Transferred Successfully", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(fund_transfer.this, "Failed to Transfer Funds", Toast.LENGTH_SHORT).show();
                        }

                    } else {
                        Toast.makeText(fund_transfer.this, "Failed to Transfer Funds", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<FundTransferResponse> call, Throwable t) {
                    progressDialog.dismiss();
                    Log.e("Network Error", "Error: " + t.getMessage());
                }
            });
        }



    private void getBeneficiaryName(String referCode) {

        Call<BeneficiaryResponse> beneficiaryResponseCall = ApiClient.getuserService().getBeneficiaryName(referCode);
        beneficiaryResponseCall.enqueue(new Callback<BeneficiaryResponse>() {
            @Override
            public void onResponse(Call<BeneficiaryResponse> call, Response<BeneficiaryResponse> response) {

                if (response.isSuccessful()) {
                    BeneficiaryResponse beneficiaryResponse = response.body();
                    String name = beneficiaryResponse.getName();
                    beneficiary_name.setText(name);

                    FundTransferRequest transferRequest = new FundTransferRequest();
                    if (checkboxTransferToAdmin.isChecked()){
                        transferRequest.setBeneficiaryName("Admin");
                    }
                    else {
                        transferRequest.setBeneficiaryName(name);
                    }

                } else {
                    Toast.makeText(fund_transfer.this, "Failed to get Beneficiary Name", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<BeneficiaryResponse> call, Throwable t) {
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
