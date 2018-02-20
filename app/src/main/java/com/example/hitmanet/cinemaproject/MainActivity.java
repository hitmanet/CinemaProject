package com.example.hitmanet.cinemaproject;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;


import com.example.hitmanet.cinemaproject.Adapters.FragmentAdapter;
import com.example.hitmanet.cinemaproject.Models.DBHelper;
import com.example.hitmanet.cinemaproject.Models.LoadList;

public class MainActivity extends AppCompatActivity {
   public static DBHelper dbHelper;
   public static TabLayout tabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            LoadList load = new LoadList();
            load.start();
            setContentView(R.layout.activity_main);

            ViewPager viewPager = findViewById(R.id.viewpager);
            dbHelper = new DBHelper(this);
            try {
                load.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            setupViewPager(viewPager);
            tabs = findViewById(R.id.tabs);
            tabs.setupWithViewPager(viewPager);
        }
        private void setupViewPager(ViewPager viewPager) {
           FragmentAdapter adapter = new FragmentAdapter(getSupportFragmentManager());
            adapter.addFragment(new CinemaFragment(), "Кино");
            adapter.addFragment(new SecondFragment(), "Список желаемого");
            viewPager.setAdapter(adapter);
        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
    }

