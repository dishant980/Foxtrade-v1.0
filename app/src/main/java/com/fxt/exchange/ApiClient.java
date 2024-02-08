package com.fxt.exchange;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {



    static Retrofit getRetrofit(){
        HttpLoggingInterceptor httpLoggingInterceptor=new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient=new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
        Retrofit retrofit=new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://192.168.1.6:80/api/")
                .client(okHttpClient)
                .build();
                 return retrofit;
    }

    public static UserService getuserService(){
        UserService userService = getRetrofit().create(UserService.class);
        return userService;
    }




    }

