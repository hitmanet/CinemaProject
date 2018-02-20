package com.example.hitmanet.cinemaproject.Models;



import java.util.List;

/**
 * Created by Hitmanet on 17.02.2018.
 */

public class Movie {

    private String name;
    private String imgUrl;
    private String about;




    public Movie(String name, String imgUrl, String about) {

        this.name = name;
        this.imgUrl = imgUrl;
        this.about = about;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

}
