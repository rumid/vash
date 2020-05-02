package com.rumid.vash.application;

import retrofit2.http.GET;
import retrofit2.http.Path;

public interface SteamAPIService {
  @GET("users/{user}/repos")
  Call<List<Repo>> listRepos(@Path("user") String user);
}