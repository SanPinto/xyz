package com.movie.app.common.rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by sangeetha on 3/11/17.
 */

public class ApiClient {
    public static String BASE_URL = "http://api.themoviedb.org/3/";
    private Retrofit mRetrofit;
    private static ApiClient sInstance;

    private ApiClient() {

    }

    public static ApiClient getInstance() {
        if (sInstance == null) {
            sInstance = new ApiClient();
        }
        return sInstance;
    }


    public Retrofit getApiClient() {
        if (mRetrofit == null) {
            mRetrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return mRetrofit;
    }
}
