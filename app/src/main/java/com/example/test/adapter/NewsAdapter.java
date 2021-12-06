package com.example.test.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.test.BottomListener;
import com.example.test.BottomSheet;
import com.example.test.R;
import com.example.test.model.News;


import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> implements BottomListener {
    private final Context context;
   ArrayList<News> newsArrayList;
   BottomListener bottomListener;

    public NewsAdapter(Context context, ArrayList<News> newsArrayList,BottomListener bottomListener) {
        this.context = context;
        this.newsArrayList = newsArrayList;
        this.bottomListener = bottomListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item,parent,false);
       return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
         News news = newsArrayList.get(position);
         holder.textView.setText(news.getTitle());
        holder.description.setText(news.getDescription());
        Glide.with(context)
                .load(news.getUrlImage())
               .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
       return  newsArrayList.size();
    }

    @Override
    public void onClicked(int position) {

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imageView;
        private final  TextView textView;
        private final TextView description;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
           imageView =itemView.findViewById(R.id.ImgViewCover);
           textView =itemView.findViewById(R.id.title);
           description = itemView.findViewById(R.id.desc);
           itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    BottomSheet bottomSheetDialog = new BottomSheet(context);
                    View view = LayoutInflater.from(context).inflate(R.layout.bottom_sheet, null);
                    bottomSheetDialog.setContentView(view);
                    TextView description = view.findViewById(R.id.bottom_text);
                    description.setText(newsArrayList.get(getPosition()).getDescription());
                    bottomSheetDialog.show();
                }
            });
        }
    }
}
