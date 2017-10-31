package com.movie.app.common.ui;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.movie.app.R;
import com.movie.app.common.model.NavigationItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by COMPUTER on 10/29/2017.
 */

public class HomeFragment extends Fragment {
    private static final String NAVIGATION_LIST = "navigation_list";
    private static final String CLICKED_NAV_POS = "clicked_nav_pos";
    private View mSlidingTab;

    public static Fragment getInstance(List<NavigationItem> navigationItemList, int pos) {
        HomeFragment fragment = new HomeFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(NAVIGATION_LIST, (ArrayList<? extends Parcelable>) navigationItemList);
        bundle.putInt(CLICKED_NAV_POS, pos);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
    }

    private void initViews(View view) {
        mSlidingTab = view.findViewById(R.id.sliding_tab);
    }
}
