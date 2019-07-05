package com.example.user.drgamsystech.utils;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient
{
    //public static final String BASE_URL = "http://192.168.1.9:80/GamRedoxer/api/Login/";
    public static final String BASE_URL = "http://192.168.1.9:80/GamRedoxer/api/User/";

    private static Retrofit retrofit = null;
    private static OkHttpClient okClient()
    {


        return new OkHttpClient.Builder()
                .connectTimeout(1, TimeUnit.SECONDS)
                .writeTimeout(1, TimeUnit.SECONDS)
                .readTimeout(1, TimeUnit.SECONDS)
                .build();

    }
    public static Retrofit getClient()
    {
        if(retrofit==null)
        {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(ApiClient.okClient())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

}
