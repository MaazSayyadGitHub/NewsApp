package com.maaz.newsapp_project;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.maaz.newsapp_project.Models.NewsHeadlines;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private Context context;
    private ArrayList<NewsHeadlines> modelClassArrayList;

    public Adapter(Context context, ArrayList<NewsHeadlines> modelClassArrayList) {
        this.context = context;
        this.modelClassArrayList = modelClassArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.recyclerview_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        NewsHeadlines headlines = modelClassArrayList.get(position);

        holder.cardView.setOnClickListener(v -> {
            Intent intent = new Intent(context, WebViewActivity.class);
            intent.putExtra("url", headlines.getUrl());
            context.startActivity(intent);
        });

        holder.mTime.setText("PublishedAt :" + headlines.getPublishedAt());
        holder.mAuthor.setText("Author :"+ headlines.getAuthor());
        holder.mContent.setText(headlines.getDescription());
        holder.mHeading.setText(headlines.getTitle());

        try {
            Picasso.get().load(headlines.getUrlToImage()).into(holder.imageView);
        } catch (Exception e){
            Toast.makeText(context, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public int getItemCount() {
        return modelClassArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView mHeading, mContent, mAuthor, mTime;
        CardView cardView;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mHeading = itemView.findViewById(R.id.main_heading);
            mContent = itemView.findViewById(R.id.content);
            mAuthor = itemView.findViewById(R.id.auther);
            imageView = itemView.findViewById(R.id.imageView);
            cardView = itemView.findViewById(R.id.cardView);
            mTime = itemView.findViewById(R.id.publishedAt);

        }
    }
}
