package com.maaz.newsapp_project.Fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.maaz.newsapp_project.Adapter;
import com.maaz.newsapp_project.ApiUtilities;
import com.maaz.newsapp_project.Models.NewsApiResponse;
import com.maaz.newsapp_project.Models.NewsHeadlines;
import com.maaz.newsapp_project.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SportsFragment extends Fragment {
    public String api_key = "5d2b3f9a18a9464f945f8880e8937122";

    private ArrayList<NewsHeadlines> arrayListOfSports;
    private RecyclerView SportsRecyclerView;
    Adapter adapter;
    String country = "in";

    @SuppressLint("MissingInflatedId")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sports_fragment, null);

        arrayListOfSports = new ArrayList<>();

        SportsRecyclerView = view.findViewById(R.id.sportsRecyclerView);
        SportsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        adapter = new Adapter(getContext(), arrayListOfSports);
        SportsRecyclerView.setAdapter(adapter);

        getCategoryNews();


        return view;
    }

    private void getCategoryNews() {
        ApiUtilities
                .getApiInterface()
                .getCategoryNews(country, "sports", 100, api_key)
                .enqueue(new Callback<NewsApiResponse>() {
                    @Override
                    public void onResponse(Call<NewsApiResponse> call, Response<NewsApiResponse> response) {
                        if (response.isSuccessful()) {
                            arrayListOfSports.addAll(response.body().getArticles()); // add all articles array to arrayList
                            adapter.notifyDataSetChanged();  // then change the ui.
                        }
                    }

                    @Override
                    public void onFailure(Call<NewsApiResponse> call, Throwable t) {

                    }
                });
    }
}
