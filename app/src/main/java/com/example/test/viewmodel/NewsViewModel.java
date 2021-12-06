package com.example.test.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.test.repository.NewsRepository;
import com.example.test.response.NewsResponse;

public class NewsViewModel extends AndroidViewModel {
private NewsRepository newsRepository;
private LiveData<NewsResponse> newsResponseLiveData;

    public NewsViewModel(@NonNull Application application) {
        super(application);
        newsRepository = new NewsRepository();
        this.newsResponseLiveData = newsRepository.getALlNews();
    }
    public LiveData<NewsResponse> getNewsResponseLiveData(){

        return newsResponseLiveData;
    }
}
