package com.movie.app.movies.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.movie.app.R;
import com.movie.app.movies.model.MovieItem;
import com.movie.app.movies.presenter.MoviePresenterImpl;
import com.movie.app.movies.presenter.MoviesContract;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by COMPUTER on 11/1/2017.
 */

public class MovieListFragment extends Fragment implements MoviesContract.MovieListView {
    private static final String NAV_TITLE = "navigation_TITLE";
    private RecyclerView mRecyclerView;
    private String mSecTitle;
    private List<MovieItem> mMovieList = new ArrayList<>();
    private int mPageNum = 1;
    private MoviePresenterImpl mPresenter;
    private View mLoader;

    public static Fragment getInstance(String title) {
        MovieListFragment fragment = new MovieListFragment();
        Bundle bundle = new Bundle();
        bundle.putString(NAV_TITLE, title);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mSecTitle = (String) getArguments().get(NAV_TITLE);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.movie_list_fragment, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        mLoader = view.findViewById(R.id.loader);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        initPresenter();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setAdapter();
        fetchMovieList();

    }

    private void fetchMovieList() {
        if(mPresenter != null) {
            showLoader();
            mPresenter.getMovieDetails(mSecTitle, getResources().getString(R.string.api_key), mPageNum);
        }
    }

    private void initPresenter() {
        mPresenter = new MoviePresenterImpl();
        mPresenter.setView(this);
    }

    private void setAdapter() {
        mRecyclerView.setAdapter(new MovieListAdapter(mMovieList));
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.clearView();
    }

    private void hideLoader() {
        if (mLoader != null) {
            mLoader.setVisibility(View.GONE);
        }
    }

    private void showLoader() {
        if (mLoader != null) {
            mLoader.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void showNetworkError(String errorMsg) {
        //showSnackBar(errorMsg);
        Log.d("MovieListing", errorMsg);
    }


    @Override
    public void updateMoviesList(List<MovieItem> results) {
        if(results != null && mMovieList != null) {
            int pos = mMovieList.size();
            mMovieList.addAll(results);
            mRecyclerView.getAdapter().notifyItemInserted(pos);
            mPageNum++;
            hideLoader();
        }
    }
}
