package com.example.test.repository;


import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.test.response.NewsResponse;
import com.example.test.retrofit.ApiRequest;
import com.example.test.retrofit.RetrofitRequest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsRepository {
private static final String TAG = NewsRepository.class.getSimpleName();
private ApiRequest apiRequest;
public  NewsRepository(){
    apiRequest = RetrofitRequest.getRetrofitInstance().create(ApiRequest.class);
}
public LiveData<NewsResponse> getALlNews(){
final MutableLiveData<NewsResponse> data = new MutableLiveData<>();
apiRequest.getTopHeadlines()
        .enqueue(new Callback<NewsResponse>() {


            @Override
            public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
                if(response.body() != null){
                    data.setValue(response.body());

                }
            }

            @Override
            public void onFailure(@NonNull Call<NewsResponse> call, Throwable t) {
       data.setValue(null);
            }
        }) ;
        return data;
    }

}
