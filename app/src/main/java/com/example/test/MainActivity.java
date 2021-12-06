package com.example.test;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.test.adapter.NewsAdapter;
import com.example.test.model.News;
import com.example.test.viewmodel.NewsViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements BottomListener {
    private static final String TAG = MainActivity.class.getSimpleName();
    private BottomSheet bottomSheet;
    private ProgressBar progressBar;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayout;
    private NewsAdapter newsAdapter;
    NewsViewModel newsViewModel;
 private   ArrayList<News> newsArrayList = new ArrayList<>();
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

   init();
   getArticles();
       


    }
    private void init() {
        progressBar = findViewById(R.id.progress_bar);
        recyclerView = findViewById(R.id.recyclerView);
        linearLayout = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(linearLayout);
        newsAdapter = new NewsAdapter(MainActivity.this, newsArrayList,this);
        recyclerView.setAdapter(newsAdapter);
        newsViewModel = ViewModelProviders.of(this).get(NewsViewModel.class);

    }
    @SuppressLint("NotifyDataSetChanged")
    private void getArticles() {
        newsViewModel.getNewsResponseLiveData().observe(this,newsResponse ->{
            if(newsResponse != null && newsResponse.getNews()!=null
                    && !newsResponse.getNews().isEmpty()){
                progressBar.setVisibility(View.GONE);
                List<News> newsList = newsResponse.getNews();
                newsArrayList.addAll(newsList);
                newsAdapter.notifyDataSetChanged();

            }
        });
    }

    @Override
    public void onClicked(int pos){


    }
}