package com.mrg.apitask;

import static android.content.ContentValues.TAG;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class  Repositry {
    private static Repositry Instance;
    private ArrayList<MyList> dataSet =new ArrayList<MyList>();
    public static Repositry getInstance(){
        if(Instance == null){
            Instance = new Repositry();

        }
        return Instance;
    }

    public Call<List<MyList>> GetData(){

        Call<List<MyList>> call = RetrofitHandler.getInstance().getApi().getPhotos();
    return  call;
    }
}
