package com.example.test.model;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class News {
    @SerializedName("urlToImage")
    @Expose
    private String urlToImage;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("title")
    @Expose
    private String title;

    public String getUrlImage() {
        return urlToImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlToImage = urlImage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    @NonNull
    @Override
    public String toString(){
        return "News{" + "urlImage = '" + urlToImage + '\''+
                ", description='" + description + '\''+
                ", title='" + title + '\'' + '}';
    }
}
