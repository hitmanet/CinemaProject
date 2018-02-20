
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
import com.example.hitmanet.cinemaproject.Models.Movie;

import java.util.ArrayList;
import java.util.List;






public class CinemaFragment extends Fragment {


    private MyAdapter Adapter;
    private LinearLayoutManager mLayoutManager;
    private  List<Movie> movies;
    private static final String TAG = "MyApp";

    private int pageNumber;







    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
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



}












