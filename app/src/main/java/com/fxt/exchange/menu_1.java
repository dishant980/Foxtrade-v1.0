package com.fxt.exchange;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class menu_1 extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    CardView cardView;
    ImageButton showButton;
    LinearLayout hiddenlayout;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    int direct_business;
    private boolean isHidden;
    final Animation fade_out = new AlphaAnimation(1.0f, 0.0f);
    final Animation slide_up = new AlphaAnimation(1.0f, 0.0f);



    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu1);


        CardView income123= findViewById(R.id.income_123);
        CardView account1=findViewById(R.id.account_1);
        CardView setting2=findViewById(R.id.setting);
     //   Button depo3=findViewById(R.id.depo3);
        CardView refer=findViewById(R.id.menu_referral);
        CardView support= findViewById(R.id.support_123);
        CardView direct_b=findViewById(R.id.directb);
       // Button invest=findViewById(R.id.invest_fund1);
        ImageView acc=findViewById(R.id.acc_img);
        TextView acc1=findViewById(R.id.acc_text);
        ImageView acc2=findViewById(R.id.acc_img1);
        TextView acc3=findViewById(R.id.acc_text1);
        ImageView acc4=findViewById(R.id.acc_img2);
        TextView acc5=findViewById(R.id.acc_text2);
        ImageView acc6=findViewById(R.id.acc_img3);
        TextView acc7=findViewById(R.id.acc_text3);
        ImageView acc8=findViewById(R.id.acc_img4);
        TextView acc9=findViewById(R.id.acc_text4);
        ImageView acc10=findViewById(R.id.acc_img5);
        TextView acc11=findViewById(R.id.acc_text5);
       // TextView direct=findViewById(R.id.direct_bus);



//        cardView=findViewById(R.id.card_view);
//
//        showButton=findViewById(R.id.image_button);
//        hiddenlayout=findViewById(R.id.layout_expand);

        sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        editor=sharedPreferences.edit();

        double roi = Double.parseDouble(sharedPreferences.getString("roi", "0"));
        String founder = sharedPreferences.getString("founder", "0");
        double com_on_roi = Double.parseDouble(sharedPreferences.getString("com_on_roi", "0"));
        direct_business=sharedPreferences.getInt("direct_business",0);

      //  direct.setText("$"+direct_business);

//        TextView com_roi=findViewById(R.id.com_roi);
//        com_roi.setText("$"+com_on_roi);
//
//        TextView found=findViewById(R.id.found_clb);
//        found.setText("$"+founder);
//
//        TextView roi_1=findViewById(R.id.roi_1);
//        roi_1.setText("$"+roi);


//        isHidden = sharedPreferences.getBoolean("isHidden", false);
//        if (isHidden) {
//            hiddenlayout.setVisibility(View.VISIBLE);
//            showButton.setImageResource(R.drawable.baseline_arrow_drop_down_24);
//        } else {
//            hiddenlayout.setVisibility(View.GONE);
//            showButton.setImageResource(R.drawable.baseline_keyboard_arrow_up_24);
//        }


//        showButton.setOnClickListener(v -> {
//            boolean isHidden = hiddenlayout.getVisibility() == View.VISIBLE;
//
//            if (hiddenlayout.getVisibility()==View.VISIBLE){
//                TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
//                hiddenlayout.setVisibility(View.GONE);
//                showButton.setImageResource(R.drawable.baseline_arrow_drop_down_24);
//            } else {
//                TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
//                hiddenlayout.setVisibility(View.VISIBLE);
//                showButton.setImageResource(R.drawable.baseline_keyboard_arrow_up_24);
//            }
//
//        });

//        cardView.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//
//                int action = event.getAction();
//                if (action == MotionEvent.ACTION_DOWN) {
//                    v.setScaleX(0.95f);
//                    v.setScaleY(0.95f);
//
//                } else if (action == MotionEvent.ACTION_UP) {
//                    v.animate().cancel();
//                    v.animate().scaleX(1f).setDuration(1000).start();
//                    v.animate().scaleY(1f).setDuration(1000).start();
//
//                }
//
//                return false;
//            }
//
//        });





//        direct_b.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent(menu_1.this,directbusiness.class);
//                startActivity(intent);
//
//            }
//        });
        support.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(menu_1.this, support1.class);
                startActivity(intent);

            }
        });

        refer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(menu_1.this, referral_list.class);
                startActivity(intent);

            }
        });


        setting2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(menu_1.this,setting2.class);
                startActivity(intent);


            }
        });

        account1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                        Intent intent= new Intent(menu_1.this,com.fxt.exchange.account1.class);
                        startActivity(intent);

                }



        });


        bottomNavigationView=findViewById(R.id.bottam_navigator);
       bottomNavigationView.setSelectedItemId(R.id.menu1);


       bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
           @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.dash_home)
                {
                    startActivity(new Intent(getApplicationContext(), dashboard.class));
                    overridePendingTransition(R.anim.slide_out_left,R.anim.slide_out_right);
                    return true;
                }
                else if (itemId == R.id.teams){
                    startActivity(new Intent(getApplicationContext(), teams.class));
                    overridePendingTransition(R.anim.slide_out_left,R.anim.slide_out_right);
                    return true;
                }

                else if (itemId == R.id.menu1) {
                    overridePendingTransition(R.anim.slide_out_right,R.anim.slide_out_left);
                    return true;

//                } else if (itemId == R.id.sign_out) {
//                    startActivity(new Intent(getApplicationContext(), signout.class));
//                    overridePendingTransition(R.anim.slide_out_left,R.anim.slide_out_right);
//                    return true;
                }

                else if (itemId==R.id.shop) {
                    startActivity(new Intent(getApplicationContext(), shop.class));
                    overridePendingTransition(R.anim.slide_out_left, R.anim.slide_out_right);
                    return true;
                }
                else if (itemId==R.id.finance) {
                    startActivity(new Intent(getApplicationContext(), finance.class));
                    overridePendingTransition(R.anim.slide_out_left, R.anim.slide_out_right);
                    return true;
                }
                return false;
            }
        });
//
//       // depo3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent= new Intent(menu_1.this, add_fund.class);
//                overridePendingTransition(R.anim.slide_out_left,R.anim.slide_out_right);
//                startActivity(intent);
//
//            }
//        });


        income123.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(menu_1.this, income_1.class);
                startActivity(intent);

            }
        });
//        invest.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(menu_1.this, self_investment.class);
//                overridePendingTransition(R.anim.slide_out_left,R.anim.slide_out_right);
//                startActivity(intent);
//
//            }
//        });
        direct_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(menu_1.this, directbusiness.class);
                startActivity(intent);
            }
        });
        acc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(menu_1.this,com.fxt.exchange.account1.class);
                startActivity(intent);
            }
        });
        acc1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(menu_1.this,com.fxt.exchange.account1.class);
                startActivity(intent);
            }


        });
        acc2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(menu_1.this, com.fxt.exchange.referral_list.class);
                startActivity(intent);
            }
        });
        acc3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(menu_1.this, com.fxt.exchange.referral_list.class);
                startActivity(intent);
            }
        });
        acc4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(menu_1.this, com.fxt.exchange.setting2.class);
                startActivity(intent);
            }
        });
        acc5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(menu_1.this, com.fxt.exchange.setting2.class);
                startActivity(intent);
            }
        });
        acc6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(menu_1.this, com.fxt.exchange.income_1.class);
                startActivity(intent);
            }
        });
        acc7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(menu_1.this, com.fxt.exchange.income_1.class);
                startActivity(intent);
            }
        });
        acc8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(menu_1.this, com.fxt.exchange.support1.class);
                startActivity(intent);
            }
        });
        acc9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(menu_1.this, com.fxt.exchange.support1.class);
                startActivity(intent);
            }
        });
        acc10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(menu_1.this, com.fxt.exchange.directbusiness.class);
                startActivity(intent);
            }
        });
        acc11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(menu_1.this, com.fxt.exchange.directbusiness.class);
                startActivity(intent);
            }
        });


    }
}