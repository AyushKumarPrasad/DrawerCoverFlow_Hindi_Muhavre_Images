package com.example.ayushkumar.drawercoverflow.Model;

/**
 * Created by ayushkumar on 20/02/18.
 */

public class Movie
{
    public String title, summary, url;

    public Movie(String title, String url, String summary) {
        this.title = title;

        this.url = url;

        this.summary = summary;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }



    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
