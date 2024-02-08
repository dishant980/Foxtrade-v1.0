package com.fxt.exchange;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefManager {
    public static SharedPrefManager mInstance;
    public static Context mCtx;
    private static final String SHARED_PREF_NAME="Mypref";
    private static final String KEY_ID="id";
    private static final String KEY_NAME="name";
    private static final String KEY_EMAIL="email";
    private static final String KEY_CODE="refer_code";

    private SharedPrefManager(Context context){
        mCtx=context;
    }
    public static synchronized SharedPrefManager getInstance(Context context){
        if (mInstance==null){
            mInstance=new SharedPrefManager(context);
        }
        return mInstance;
    }
    public boolean userlogin(int id,String name, String email){
        SharedPreferences sharedPrefManager=mCtx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor= sharedPrefManager.edit();
        editor.putString(KEY_NAME,name);
        editor.putString(KEY_ID, String.valueOf(id));
        editor.putString(KEY_EMAIL,email);
        editor.apply();
        return true;
    }
    public boolean isLoggedIn() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_NAME, null) != null;
    }

    public String getname(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_NAME,null);
    }



}
