package com.example.test.retrofit;

import static com.example.test.costants.AppCostants.API_KEY;

import com.example.test.response.NewsResponse;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiRequest {
    @GET("top-headlines?country=ru&category=entertainment&apiKey=" + API_KEY)
    Call<NewsResponse> getTopHeadlines();
}
