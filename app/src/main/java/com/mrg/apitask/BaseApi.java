package com.mrg.apitask;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface BaseApi {
    String BASE_URL = "https://jsonplaceholder.typicode.com/";
    @GET("photos")
    Call<List<MyList>> getPhotos();
}
