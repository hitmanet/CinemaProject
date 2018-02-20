package com.example.hitmanet.cinemaproject.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.Menu;
import android.view.MenuItem;

import com.example.hitmanet.cinemaproject.CinemaFragment;
import com.example.hitmanet.cinemaproject.SecondFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hitmanet on 19.02.2018.
 */

public class FragmentAdapter extends FragmentPagerAdapter {
    private final List<Fragment> ListFragment = new ArrayList<>();
    private final List<String> ListFragmentTitle = new ArrayList<>();

    public FragmentAdapter(FragmentManager manager) {
        super(manager);
    }

    @Override
    public Fragment getItem(int position) {
        return ListFragment.get(position);
    }

    @Override
    public int getCount() {
        return ListFragment.size();
    }

    public void addFragment(Fragment fragment, String title) {
        ListFragment.add(fragment);
        ListFragmentTitle.add(title);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return ListFragmentTitle.get(position);
    }



}



