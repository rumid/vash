package com.rumid.vash.application;

import retrofit2.Retrofit;

public class RestClientConfiguration {
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .build();

    SteamAPIService service = retrofit.create(SteamAPIService.class);
}
