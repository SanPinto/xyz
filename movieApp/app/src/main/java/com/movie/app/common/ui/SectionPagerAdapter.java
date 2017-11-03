package com.movie.app.common.ui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.movie.app.common.model.NavigationItem;
import com.movie.app.movies.ui.MovieListFragment;

import java.util.List;

/**
 * Created by COMPUTER on 11/1/2017.
 */

class SectionPagerAdapter extends FragmentPagerAdapter {
    private List<NavigationItem> mNavList;

    public SectionPagerAdapter(FragmentManager manager,  List<NavigationItem> navList) {
        super(manager);
        mNavList = navList;
    }

    @Override
    public Fragment getItem(int position) {
        return MovieListFragment.getInstance(mNavList.get(position).title);
    }

    @Override
    public int getCount() {
        return mNavList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mNavList.get(position).title;
    }
}
