package com.virtualbox.torchick.sitani.Network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Torchick on 27/03/2017.
 */

public class ApiClientGrafis {
//    public static final String BASE_URL = "https://api.myjson.com";
    public static final String BASE_URL = "https://sultra.bps.go.id";
    private static Retrofit retrofit = null;

    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

}
