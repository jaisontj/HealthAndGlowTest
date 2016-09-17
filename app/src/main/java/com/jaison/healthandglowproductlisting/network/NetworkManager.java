package com.jaison.healthandglowproductlisting.network;

import android.util.Log;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by Jaison on 01/03/16.
 */
public class NetworkManager {

    private static final String BASE_URL = "http://119.81.82.197:9090/hngeCommerceWebservice/rest/";

    private static final String TAG = "Application Handler";

    private static ApiInterface apiInterface;

    public static void initialize() {
        createRetrofitObject();
    }

    private static void createRetrofitObject() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(RequestHeaders.getInstance())
                .addInterceptor(logging)
                .build();


        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(getBaseURL())
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiInterface = retrofit.create(ApiInterface.class);
    }

    public static String getBaseURL() {
        return BASE_URL;
    }

    public static ApiInterface getApiInterface() {
        if (apiInterface == null) {
            Log.i(TAG, "Api interface is null");
            createRetrofitObject();
        }
        return apiInterface;
    }
}
