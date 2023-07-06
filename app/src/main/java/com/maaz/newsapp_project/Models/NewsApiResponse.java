package com.maaz.newsapp_project.Models;

// this is api - https://newsapi.org/v2/top-headlines?country=us&apiKey=5d2b3f9a18a9464f945f8880e8937122

import java.util.List;

public class NewsApiResponse { // this is for whole api response
    // there are three parts in this api.
    // 1. this whole api object
    // 2. under this api, articles array
    // 3. under each article array, source object.

    String status;
    int totalResults;
    List<NewsHeadlines> articles; // this is articles array.

    public NewsApiResponse(String status, int totalResults, List<NewsHeadlines> articles) {
        this.status = status;
        this.totalResults = totalResults;
        this.articles = articles;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public List<NewsHeadlines> getArticles() {
        return articles;
    }

    public void setArticles(List<NewsHeadlines> articles) {
        this.articles = articles;
    }
}
