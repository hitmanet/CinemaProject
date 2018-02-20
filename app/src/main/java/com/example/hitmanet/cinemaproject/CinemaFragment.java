
package com.example.hitmanet.cinemaproject;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.support.v4.app.Fragment;


import com.example.hitmanet.cinemaproject.Adapters.MyAdapter;
import com.example.hitmanet.cinemaproject.Interface.GetApi;
import com.example.hitmanet.cinemaproject.Models.Movie;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;




public class CinemaFragment extends Fragment {
    private static final String BASE_URL = "https://api.themoviedb.org/3/movie/";

    private MyAdapter Adapter;
    private LinearLayoutManager mLayoutManager;
    private  List<Movie> movies;
    private ProgressBar mpb;;
    private GetApi api;
    private  Retrofit retrofit;
    private static final String TAG = "MyApp";

    private int pageNumber;




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        setRetainInstance(true);
        movies = new ArrayList<>();

        pageNumber = getArguments() != null ? getArguments().getInt("num") : 1;


    }



    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView mRecyclerView = (RecyclerView) inflater.inflate(
                R.layout.fragment_cinema, container, false);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this.getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        Adapter = new MyAdapter(mRecyclerView.getContext());
        mRecyclerView.setAdapter(Adapter);

        return mRecyclerView;

    }



    public static void loadfilms() {
    }
}












