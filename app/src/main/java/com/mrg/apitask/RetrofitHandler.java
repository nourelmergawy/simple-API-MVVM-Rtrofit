package com.mrg.apitask;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitHandler {
   private BaseApi api;
   private static RetrofitHandler instance = null;

    public RetrofitHandler() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BaseApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api = retrofit.create(BaseApi.class);

    }
    public  static synchronized RetrofitHandler getInstance(){
        if (instance == null){
            instance =new RetrofitHandler();
        }
        return instance;
    }

    public BaseApi getApi() {
        return api;
    }
}
