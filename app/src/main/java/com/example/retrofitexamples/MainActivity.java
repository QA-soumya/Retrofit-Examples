package com.example.retrofitexamples;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private static final String TAG="mainActivity";
    private static final String BASE_URL="https://run.mocky.io/";
    TextView txt;
    apiInterface apiInterface1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt = findViewById(R.id.textView);
        txt.setText("Hello World");
        HttpLoggingInterceptor logging;
        logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiInterface apiInterface1 = retrofit.create(apiInterface.class);
        Call<Todo> call = apiInterface1.getTodo();
        call.enqueue(new Callback<Todo>() {
            @Override
            public void onResponse(Call<Todo> call, Response<Todo> response) {
                // Checking the responses
                if(response.isSuccessful()){
                    txt.setText(response.body().getTitle());
                }
               // Log.e("tag","On Response");
            }

            @Override
            public void onFailure(Call<Todo> call, Throwable t) {
                //Log.e("tag","onFailure");
               // t.printStackTrace();
            }
        });



    }
}