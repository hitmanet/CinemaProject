package com.example.hitmanet.cinemaproject.Models;

import android.database.sqlite.SQLiteDatabase;
import android.view.View;

import com.example.hitmanet.cinemaproject.CinemaFragment;
import com.example.hitmanet.cinemaproject.MainActivity;
import com.example.hitmanet.cinemaproject.SecondFragment;

/**
 * Created by Hitmanet on 19.02.2018.
 */

public class ClickDel implements View.OnClickListener{
    private int id;
    private int dbid;

    public ClickDel(int id, int dbid){
        this.id = id;
        this.dbid = dbid;
    }

    @Override
    public void onClick(View v) {
        SQLiteDatabase sql = MainActivity.dbHelper.getWritableDatabase();
        sql.delete(DBHelper.TABLE_NAME, DBHelper.KEY_ID +"="+ dbid, null);
        SecondFragment.loadfilms();
    }
}
