package com.example.retrofitexamples;

import retrofit2.Call;
import retrofit2.http.GET;

public interface apiInterface {
    @GET("v3/f7cf5d3b-8c39-412e-8edb-9c14e3d7fbf2")
    Call<Todo>getTodo();
}
