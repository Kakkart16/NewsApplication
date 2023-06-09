package com.example.newspilot;

public class ModelClass {
    private String author;
    private String description;
    private String publishedAt;
    private String title;
    private String url;
    private String urlToImage;

    public ModelClass(String author2, String title2, String description2, String url2, String urlToImage2, String publishedAt2) {
        this.author = author2;
        this.title = title2;
        this.description = description2;
        this.url = url2;
        this.urlToImage = urlToImage2;
        this.publishedAt = publishedAt2;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author2) {
        this.author = author2;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title2) {
        this.title = title2;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description2) {
        this.description = description2;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url2) {
        this.url = url2;
    }

    public String getUrlToImage() {
        return this.urlToImage;
    }

    public void setUrlToImage(String urlToImage2) {
        this.urlToImage = urlToImage2;
    }

    public String getPublishedAt() {
        return this.publishedAt;
    }

    public void setPublishedAt(String publishedAt2) {
        this.publishedAt = publishedAt2;
    }
}
