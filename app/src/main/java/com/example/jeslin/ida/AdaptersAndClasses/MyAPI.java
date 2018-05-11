package com.example.jeslin.ida.AdaptersAndClasses;

import android.app.Application;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by JeSLiN on 22-09-2017.
 */

public class MyAPI  extends Application {

    public static final String BASE_URL = "http://iroidtech.com/ida/api/";
    private static Retrofit retrofit = null;

    @Override
    public void onCreate() {
        super.onCreate();

    }

    public static Retrofit getClient() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

}
