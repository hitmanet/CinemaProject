package com.example.hitmanet.cinemaproject.Interface;

import com.example.hitmanet.cinemaproject.Models.Movie;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Hitmanet on 19.02.2018.
 */

public interface GetApi {
    @GET("550?api_key=3f9f2a6ac8ab84deac0aceec8a59a3af")
    Call<List<Movie>> Movies();
}
