package com.example.test.response;


import androidx.annotation.NonNull;

import com.example.test.model.News;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NewsResponse {
    @SerializedName("articles")
    @Expose
   private List<News> news;
    public List<News> getNews() {
        return news;
    }

    public void setNews(List<News> news) {
        this.news = news;
    }

    @NonNull
    @Override
    public String toString() {
        return "Response{" + "news = " + news +'}';

    }
    }

