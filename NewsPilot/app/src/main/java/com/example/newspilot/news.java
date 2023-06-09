package com.example.newspilot;

import java.util.ArrayList;

public class news {
    private ArrayList<ModelClass> articles;
    private String status;
    private String totalResults;

    public news(String status2, String totalResults2, ArrayList<ModelClass> articles2) {
        this.status = status2;
        this.totalResults = totalResults2;
        this.articles = articles2;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status2) {
        this.status = status2;
    }

    public String getTotalResults() {
        return this.totalResults;
    }

    public void setTotalResults(String totalResults2) {
        this.totalResults = totalResults2;
    }

    public ArrayList<ModelClass> getArticles() {
        return this.articles;
    }

    public void setArticles(ArrayList<ModelClass> articles2) {
        this.articles = articles2;
    }
}
