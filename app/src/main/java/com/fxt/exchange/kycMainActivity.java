package com.fxt.exchange;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.OpenableColumns;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;

import com.hbb20.CountryCodePicker;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class kycMainActivity extends AppCompatActivity {
        private EditText name,lastname,phone,dob,state,city,address1,address2,pincode;
        private Button submit, btnImageFront,btnImageBack,btnPhoto;
        private TextView status_text;
        AppCompatAutoCompleteTextView country;
        LinearLayout layout;

        ImageView imageView;
        private AlertDialog alertDialog;
    private int Id;
    private SharedPreferences sharedPrefManager;
    private SharedPreferences.Editor editor;
    private ProgressDialog progressDialog;

    private static final int REQUEST_IMAGE_FRONT = 1;
    private static final int REQUEST_IMAGE_BACK = 2;
    private static final int REQUEST_PHOTO = 3;
    CountryCodePicker hbb;
    private Uri imageFrontUri;
    private Uri imageBackUri;
    private Uri photoUri;
    private String gender;
    private String documentType;
    private int selectedCountryId;
    LinearLayout personal_forum,address_forum;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kyc);
        RadioGroup radioGroup1 = findViewById(R.id.radioGroup);
        layout = findViewById(R.id.layout_kyc);

        name = findViewById(R.id.name1);
        lastname = findViewById(R.id.lastname1);
        phone = findViewById(R.id.etphonenumber);
        hbb=findViewById(R.id.countyCodePicker1);
        dob = findViewById(R.id.dob);
        RadioButton male = findViewById(R.id.radioMale);
        RadioButton female = findViewById(R.id.radioFemale);
        RadioButton other=findViewById(R.id.radioother);


        country = findViewById(R.id.country);
        state = findViewById(R.id.state);
        city = findViewById(R.id.city);
        pincode=findViewById(R.id.pincode);
        address1 = findViewById(R.id.address1);
        address2 = findViewById(R.id.address2);

        RadioGroup RadioGroup2=findViewById(R.id.radioGroup2);
        RadioButton nationid = findViewById(R.id.radio_national);
        RadioButton passport = findViewById(R.id.radio_passport);
        RadioButton dl = findViewById(R.id.radio_driving);
        submit = findViewById(R.id.submit);

        status_text = findViewById(R.id.status_text);

        btnImageFront = findViewById(R.id.materialButton);
        btnImageBack = findViewById(R.id.materialButton2);
        imageView=findViewById(R.id.imageView);
        btnPhoto = findViewById(R.id.chosse);


        personal_forum=findViewById(R.id.personal_forum);
        address_forum=findViewById(R.id.address_forum);


        address_forum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                state.setFocusable(true);
                state.setFocusableInTouchMode(true);
                city.setFocusable(true);
                city.setFocusableInTouchMode(true);
                pincode.setFocusable(true);
                pincode.setFocusableInTouchMode(true);
                address1.setFocusable(true);
                address2.setFocusableInTouchMode(true);
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.showSoftInput(address_forum, InputMethodManager.SHOW_IMPLICIT);


            }
        });


        personal_forum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name.setFocusableInTouchMode(true);
                name.setFocusable(true);
                lastname.setFocusableInTouchMode(true);
                lastname.setFocusable(true);
                phone.setFocusableInTouchMode(true);
                phone.setFocusable(true);

                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.showSoftInput(personal_forum, InputMethodManager.SHOW_IMPLICIT);
            }
        });



        sharedPrefManager = getSharedPreferences("MyPref", MODE_PRIVATE);
        editor = sharedPrefManager.edit();
        Id = sharedPrefManager.getInt("id", 0);

        UserId userId = new UserId();
        userId.setId(Id);

        Call<KycStatusResponse> kycStatusResponseCall = ApiClient.getuserService().verifyStatus(userId);
        kycStatusResponseCall.enqueue(new Callback<KycStatusResponse>() {
            @Override
            public void onResponse(Call<KycStatusResponse> call, Response<KycStatusResponse> response) {
                if (response.isSuccessful()) {
                    KycStatusResponse kycStatusResponse = response.body();
                    String status = kycStatusResponse.getKycStatus();
                    status_text.setText("KYC Status " + String.valueOf(status));

                    if ("pending".equalsIgnoreCase(status)) {
                        layout.setVisibility(View.VISIBLE);
                        status_text.setVisibility(View.GONE);

                        List<KycStatusResponse.Country> countriesList = kycStatusResponse.getCountries();
                        List<String> countryNames = new ArrayList<>();
                        for (KycStatusResponse.Country country : countriesList) {
                            countryNames.add(country.getName());
                        }

                        ArrayAdapter<String> adapter = new ArrayAdapter<>(kycMainActivity.this, android.R.layout.simple_spinner_item, countryNames);
                        country.setAdapter(adapter);

                    } else {
                        layout.setVisibility(View.GONE);
                    }
                } else {
                }
            }

            @Override
            public void onFailure(Call<KycStatusResponse> call, Throwable t) {
                Log.e("Network Error", "Error: " + t.getMessage());
            }
        });




        radioGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (male.isChecked()){
                    gender=male.getText().toString().trim();
                } else if (female.isChecked()) {
                    gender=female.getText().toString().trim();
                } else if (other.isChecked()) {
                    gender=other.getText().toString().trim();                    
                }else {
                    Toast.makeText(kycMainActivity.this, "Please select the Gender", Toast.LENGTH_SHORT).show();
                }
            }
        });


            RadioGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    if (dl.isChecked()){
                        documentType=dl.getText().toString().trim();
                    } else if (nationid.isChecked()) {
                            documentType=nationid.getText().toString().trim();                        
                    } else if (passport.isChecked()) {
                        documentType=passport.getText().toString().trim();
                    }else {
                        Toast.makeText(kycMainActivity.this, "Please select the type of\n ID Proof Document", Toast.LENGTH_SHORT).show();
                    }
                }
            });



        dob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();

                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        kycMainActivity.this,
                        (view, year1, monthOfYear, dayOfMonth) -> {
                            if (year1 < 2004) {
                                dob.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year1);
                            } else {
                                Toast.makeText(kycMainActivity.this, "Please select a birth year before 2004", Toast.LENGTH_SHORT).show();
                            }
                        }, year, month, day);

                datePickerDialog.show();
            }
        });


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                        if (TextUtils.isEmpty(name.getText().toString().trim())
                        || TextUtils.isEmpty(lastname.getText().toString().trim())
                        || TextUtils.isEmpty(phone.getText().toString().trim())
                        || TextUtils.isEmpty(dob.getText().toString().trim())
                        || TextUtils.isEmpty(country.getText().toString().trim())
                        || TextUtils.isEmpty(state.getText().toString().trim())
                        || TextUtils.isEmpty(city.getText().toString().trim())
                        || TextUtils.isEmpty(address1.getText().toString().trim()))
                         {
                    Toast.makeText(kycMainActivity.this, "Please fill all the Fields", Toast.LENGTH_SHORT).show();
                } else {
                    showConfirmationDialog();
                }
            }
        });

        btnImageBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery(REQUEST_IMAGE_BACK);

            }
        });
        btnImageFront.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery(REQUEST_IMAGE_FRONT);
            }
        });

        btnPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            openGallery(REQUEST_PHOTO);
            }
        });

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("KYC Verification");


    }

    private void openGallery(int request_code) {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/*");
        startActivityForResult(intent, request_code);
    }
    protected void onActivityResult(int request_code, int resultcode, Intent data){
        super.onActivityResult(request_code,resultcode , data);

        if (resultcode == RESULT_OK) {
            if (data != null && data.getData() != null) {
                Uri selectedImageUri = data.getData();
                String fileName = getFileName(selectedImageUri);
                fileName=fileName.trim();

                switch (request_code) {
                    case REQUEST_IMAGE_FRONT:
                        imageFrontUri = selectedImageUri;
                        btnImageFront.setText(fileName);
                        break;

                    case REQUEST_IMAGE_BACK:
                        imageBackUri = selectedImageUri;
                        btnImageBack.setText(fileName);
                        break;

                    case REQUEST_PHOTO:
                        photoUri = selectedImageUri;
                        btnPhoto.setText(fileName);
                        imageView.setImageURI(photoUri);
                        break;
                }
            }
        }
    }
    private String getFileName(Uri uri) {
        String result = null;
        if (uri.getScheme().equals("content")) {
            try (Cursor cursor = getContentResolver().query(uri, null, null, null, null)) {
                if (cursor != null && cursor.moveToFirst()) {
                    result = cursor.getString(cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME));
                }
            }
        }
        if (result == null) {
            result = uri.getLastPathSegment();
        }
        return result;
    }



    private void showConfirmationDialog() {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Confirm Submission");
            builder.setMessage("Are you sure you want to submit your details?");
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    submit_kyc();
                }
            });
            builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                }
            });

            builder.create().show();
        }


    private void submit_kyc() {
        KycRegister kycRegister = new KycRegister();
        String countryCode = hbb.getSelectedCountryCode().toString();
        String phoneNumber = phone.getText().toString().trim();
        String phoneNumberWithCountryCode = countryCode + phoneNumber;


        kycRegister.setFname(name.getText().toString().trim());
        kycRegister.setLname(lastname.getText().toString().trim());
        kycRegister.setPhone_no(phoneNumberWithCountryCode);
        kycRegister.setDob(dob.getText().toString().trim());
        kycRegister.setGender(gender);
        kycRegister.setId(Id);
        kycRegister.setCountry(country.getText().toString().trim());
        kycRegister.setCity(city.getText().toString());
        kycRegister.setState(state.getText().toString());
        kycRegister.setAddress1(address1.getText().toString());
        kycRegister.setAddress2(address2.getText().toString());
        kycRegister.setPincode(Integer.parseInt(pincode.getText().toString()));
        kycRegister.setDoc_type(documentType);
        kycRegister.setDoc_image_back(String.valueOf(imageBackUri).trim());
        kycRegister.setDoc_image_front(String.valueOf(imageFrontUri).trim());
        kycRegister.setPhoto(String.valueOf(photoUri).trim());

        Call<SubmitKycResponse> submitKycResponseCall = ApiClient.getuserService().submitResponse(kycRegister);
        submitKycResponseCall.enqueue(new Callback<SubmitKycResponse>() {
            @Override
            public void onResponse(Call<SubmitKycResponse> call, Response<SubmitKycResponse> response) {
                if (response.isSuccessful()) {
                    SubmitKycResponse kycResponse = response.body();
                    String status_2 = kycResponse.getKycStatus();
                    status_text.setText(status_2);
                    name.setText("");
                    lastname.setText("");
                    phone.setText("");
                    dob.setText("");
                    country.setText("");
                    city.setText("");
                    state.setText("");
                    address1.setText("");
                    address2.setText("");
                    btnImageFront.setText("Select Image Front");
                    btnImageBack.setText("Select Image Back");
                    btnPhoto.setText("Select Profile Photo");
                    Toast.makeText(kycMainActivity.this, "Kyc Submitted Successful", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(kycMainActivity.this, "Error while submitting kyc", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<SubmitKycResponse> call, Throwable t) {
                Toast.makeText(kycMainActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
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