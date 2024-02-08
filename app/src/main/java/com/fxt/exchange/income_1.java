package com.fxt.exchange;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class income_1 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.income);

        CardView return0=findViewById(R.id.return0);
        CardView  coroi=findViewById(R.id.coroi);
        CardView founder=findViewById(R.id.founder);
        CardView ledger_1=findViewById(R.id.ledger_1);
//
//        bottomNavigationView=findViewById(R.id.bottam_navigator);
//       bottomNavigationView.setSelectedItemId(R.id.income_123);
//       bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//           @Override
//           public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//               int itemId = item.getItemId();
//               if (itemId == R.id.profile)
//               {
//                   startActivity(new Intent(getApplicationContext(), profile.class));
//                   return true;
//               }
//               else if (itemId == R.id.dashboard){
//                   startActivity(new Intent(getApplicationContext(), dashboard.class));
//                   return true;
//               }
//
//               else if (itemId == R.id.menu1) {
//                   return true;
//
//               } else if (itemId == R.id.sign_out) {
//                   startActivity(new Intent(getApplicationContext(), signout.class));
//                   return true;
//               }
//               return false;
//           }
//       });
       return0.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent = new Intent(income_1.this, roi_1.class);
               startActivity(intent);


           }
       });
       return0.setOnTouchListener(new View.OnTouchListener() {
           @Override
           public boolean onTouch(View v, MotionEvent event) {
               int action = event.getAction();
               if (action == MotionEvent.ACTION_DOWN) {
                   v.setScaleX(0.95f);
                   v.setScaleY(0.95f);

               } else if (action == MotionEvent.ACTION_UP) {
                   v.animate().cancel();
                   v.animate().scaleX(1f).setDuration(1000).start();
                   v.animate().scaleY(1f).setDuration(1000).start();

               }

               return false;
           }

       });
       coroi.setOnClickListener(new View.OnClickListener() {
           @Override
          public void onClick(View v) {
               Intent intent=new Intent(income_1.this, comissiononroi.class);
               startActivity(intent);

           }
       });

       founder.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent=new Intent(income_1.this, founderclub.class);
               startActivity(intent);

           }
       });
       ledger_1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent= new Intent(income_1.this,ledger.class);
               startActivity(intent);

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

