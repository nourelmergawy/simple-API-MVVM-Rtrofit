package com.mrg.apitask;

import static android.content.ContentValues.TAG;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiViewModel extends ViewModel {
     MutableLiveData<List<MyList>> mutableLiveData = new MutableLiveData<>();
    private Repositry repositry;

    public void init(){
        if(mutableLiveData != null){
            return;
        }
        repositry = Repositry.getInstance();

    }
    public void getData(){
        Repositry.getInstance().GetData().enqueue(new Callback<List<MyList>>() {
            @Override
            public void onResponse(Call<List<MyList>> call, Response<List<MyList>> response) {
                mutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<MyList>> call, Throwable t) {
                Log.d(TAG, "onFailure: "+t);
//                Toast.makeText(context.getApplicationContext(), "failure", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
