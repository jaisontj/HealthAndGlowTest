package com.jaison.healthandglowproductlisting.network;


import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Jaison on 01/03/16.
 */
public class RequestHeaders implements Interceptor {
    private static RequestHeaders instance;

    public static RequestHeaders getInstance() {
        if (instance == null)
            instance = new RequestHeaders();
        return instance;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();
        Request.Builder requestBuilder = original.newBuilder()
                .addHeader("Content-Type", "application/json");
        Request request = requestBuilder.method(original.method(), original.body()).build();
        return chain.proceed(request);
    }
}
