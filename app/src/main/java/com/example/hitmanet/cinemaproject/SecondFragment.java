package com.example.hitmanet.cinemaproject;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.session.PlaybackState;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.hitmanet.cinemaproject.Adapters.MyAdapter;


import com.example.hitmanet.cinemaproject.Models.ClickDel;
import com.example.hitmanet.cinemaproject.Models.DBHelper;
import com.example.hitmanet.cinemaproject.Models.Movie;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;



/**
 * Created by Hitmanet on 19.02.2018.
 */

public class SecondFragment extends Fragment {

    private LinearLayoutManager mLayoutManager;
    private static final String TAG = "MyApp";
    private DBHelper helper;
    private SQLiteDatabase db;
    private Cursor cursor;
    static List<String> films;
    static List<Integer> listId;
    static MyAdapterTwo adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView mRecyclerView = (RecyclerView) inflater.inflate(
                R.layout.fragment_cinema, container, false);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this.getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        adapter = new MyAdapterTwo(mRecyclerView.getContext());
        mRecyclerView.setAdapter(adapter);
        loadfilms();
        return mRecyclerView;


    }

    public static void loadfilms() {
        films = new ArrayList<>();
        listId = new ArrayList<>();
        SQLiteDatabase sql = MainActivity.dbHelper.getWritableDatabase();
        Cursor cursor = sql.query(DBHelper.TABLE_NAME, null, null, null, null, null, null);

        if (cursor.moveToFirst()) {
            int idIndex = cursor.getColumnIndex(DBHelper.KEY_ID);
            int nameIndex = cursor.getColumnIndex(DBHelper.KEY_NAME);
            do {
                films.add(cursor.getString(nameIndex));
                listId.add(cursor.getInt(idIndex));
            } while (cursor.moveToNext());
        }
        cursor.close();
        adapter.notifyDataSetChanged();
    }

    static class MyAdapterTwo extends RecyclerView.Adapter<MyAdapterTwo.ViewHolder> {
        private Context context;
        private String[] aName;
        private ClickDel[] delClicks;

        public MyAdapterTwo(Context context) {
            this.context = context;

        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.wish_card, parent, false);
            return new ViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            delClicks = new ClickDel[films.size()];
            aName = new String[films.size()];
            for (int i = 0; i < films.size(); i++) {
                aName[i] = films.get(i);
            }
            for (int i = 0; i < films.size(); i++) {
                delClicks[i] = new ClickDel(i, SecondFragment.listId.get(i));
            }
            holder.movieTitle.setText(aName[position % aName.length]);
            holder.delButton.setOnClickListener(delClicks[position]);

        }




        @Override
        public int getItemCount() {
            return films.size();
        }

        static class ViewHolder extends RecyclerView.ViewHolder {
            TextView movieTitle;
            Button delButton;


            ViewHolder(View itemView) {
                super(itemView);
                movieTitle = (TextView) itemView.findViewById(R.id.movie_name2);
                delButton = (Button) itemView.findViewById(R.id.delete_button);

            }


        }
    }
}
