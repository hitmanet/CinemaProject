package com.example.hitmanet.cinemaproject.Models;

/**
 * Created by Hitmanet on 19.02.2018.
 */

public class MovieWish {
    private String movieTitle;

    public MovieWish(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }
}
