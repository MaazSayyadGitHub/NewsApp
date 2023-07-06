package com.maaz.newsapp_project;

import com.maaz.newsapp_project.Models.NewsApiResponse;
import com.maaz.newsapp_project.Models.NewsHeadlines;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    String BASE_URL = "https://newsapi.org/v2/";

    // get All news
    @GET("top-headlines")
    Call<NewsApiResponse> getNews(
            @Query("country") String country,
            @Query("pageSize") int pageSize,
            @Query("apiKey") String apiKey
    );

    // get only category news
    @GET("top-headlines")
    Call<NewsApiResponse> getCategoryNews(
            @Query("country") String country,
            @Query("category") String category,
            @Query("pageSize") int pageSize,
            @Query("apiKey") String apiKey
    );
}
