package com.example.hitmanet.cinemaproject.Models;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;

import com.example.hitmanet.cinemaproject.CinemaFragment;
import com.example.hitmanet.cinemaproject.MainActivity;
import com.example.hitmanet.cinemaproject.SecondFragment;

/**
 * Created by Hitmanet on 19.02.2018.
 */

public class ClickAdd implements View.OnClickListener {
    private int id;

    public ClickAdd(int id){
        this.id = id;
    }

    @Override
    public void onClick(View v) {
        SQLiteDatabase db = MainActivity.dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(MainActivity.dbHelper.KEY_NAME, LoadList.getMovies().get(id).getName());
        db.insert(MainActivity.dbHelper.TABLE_NAME,null,contentValues);
        SecondFragment.loadfilms();
        MainActivity.tabs.getTabAt(1).select();
    }
}
