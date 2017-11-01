package com.movie.app.common.ui;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.movie.app.R;
import com.movie.app.common.model.NavigationItem;
import com.movie.app.common.presenter.NavigationDrawerContract;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by COMPUTER on 10/29/2017.
 */

public class HomeFragment extends Fragment implements ViewPager.OnPageChangeListener {
    private static final String NAVIGATION_LIST = "navigation_list";
    private static final String CLICKED_NAV_POS = "clicked_nav_pos";
    private ViewPager mPager;
    private TabLayout mSlidingTab;
    private List<NavigationItem> mNavList;
    private int mSelectedPos;
    private NavigationDrawerContract.NavigationDrawerView mNavDrawerView;


    public static HomeFragment getInstance(List<NavigationItem> navigationItemList, int pos) {
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
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        extractArguments();
    }

    private void extractArguments() {
        if(getArguments() != null) {
            mNavList = getArguments().getParcelableArrayList(NAVIGATION_LIST);
            mSelectedPos = getArguments().getInt(CLICKED_NAV_POS);
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
    }

    private void initViews(View view) {
        mSlidingTab = (TabLayout) view.findViewById(R.id.sliding_tab);
        mPager = (ViewPager) view.findViewById(R.id.viewpager);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setAdapter();
    }

    private void setAdapter() {
        SectionPagerAdapter adapter = new SectionPagerAdapter(getActivity().getSupportFragmentManager(), mNavList);
        mPager.setAdapter(adapter);
        mSlidingTab.setupWithViewPager(mPager);
        mPager.setCurrentItem(mSelectedPos);
        mPager.addOnPageChangeListener(this);
    }

    public void moveToSelectedTab(int pos) {
        if(mPager != null) {
            mPager.setCurrentItem(pos);
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        if(mNavDrawerView != null) {
            mNavDrawerView.updateNavDrawer(position);
        }

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    public void setView(NavigationDrawerContract.NavigationDrawerView view) {
        mNavDrawerView = view;
    }
}
