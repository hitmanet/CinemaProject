package com.example.hitmanet.cinemaproject.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.hitmanet.cinemaproject.Models.ClickAdd;
import com.example.hitmanet.cinemaproject.Models.LoadList;
import com.example.hitmanet.cinemaproject.Models.Movie;
import com.example.hitmanet.cinemaproject.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import static android.app.PendingIntent.getActivity;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
        private  ClickAdd[] aClick;
        private  String[] aName;
        private  String[] aFilmDesc;
        private List<Movie> movies = LoadList.getMovies();
        public ImageView[] aIV;
        public MyAdapter(Context context) {

            aName = new String[movies.size()];
            for (int i = 0; i < movies.size(); i++) {
                aName[i] = movies.get(i).getName();
            }
            aFilmDesc = new String[movies.size()];
            for (int i = 0; i < movies.size(); i++) {
                aFilmDesc[i] = movies.get(i).getAbout();
            }

            aClick = new ClickAdd[movies.size()];

            for (int i = 0; i < movies.size(); i++) {
                aClick[i] = new ClickAdd(i);
            }

            aIV = new ImageView[movies.size()];
            for (int i = 0; i < movies.size(); i++) {
                aIV[i] = new ImageView(context);
            }
            for (int i = 0; i < movies.size(); i++) {
                Picasso.with(context)
                        .load("http://image.tmdb.org/t/p/w185"+movies.get(i).getImgUrl())
                        .error(R.drawable.ic_launcher_background)
                        .placeholder(R.drawable.ic_launcher_background)
                        .into(aIV[i]);
            }
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, parent, false);
            return new ViewHolder(itemView);

        }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.movieTitle.setText(aName[position % aName.length]);
        holder.description.setText(aFilmDesc[position % aFilmDesc.length]);
        holder.addButton.setOnClickListener(aClick[position]);
        holder.imageView.setImageDrawable(aIV[position].getDrawable());
    }


    @Override
        public int getItemCount() {
            return movies.size();
        }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView movieTitle;
        ImageView imageView;
        Button addButton;
        TextView description;


        ViewHolder(View itemView) {
            super(itemView);
            movieTitle = (TextView) itemView.findViewById(R.id.movie_name2);
            imageView = (ImageView) itemView.findViewById(R.id.card_image);
            addButton = (Button) itemView.findViewById(R.id.action_button);
            description = (TextView) itemView.findViewById(R.id.mov);

        }


    }
    }







