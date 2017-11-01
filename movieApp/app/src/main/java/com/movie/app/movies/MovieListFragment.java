package com.movie.app.movies;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.movie.app.R;

/**
 * Created by COMPUTER on 11/1/2017.
 */

public class MovieListFragment extends Fragment {
    private static final String NAV_TITLE = "navigation_TITLE";

    public static Fragment getInstance(String title) {
        MovieListFragment fragment = new MovieListFragment();
        Bundle bundle = new Bundle();
        bundle.putString(NAV_TITLE, title);
        fragment.setArguments(bundle);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.movie_list_fragment, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        TextView title = (TextView) getView().findViewById(R.id.title);
        if(getArguments() != null) {
            title.setText((CharSequence) getArguments().get(NAV_TITLE));
        }
    }
}
