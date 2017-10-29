package com.movie.app.common.presenter;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.movie.app.common.model.NavigationItem;

import java.util.List;

/**
 * Created by COMPUTER on 10/29/2017.
 */

public class NavigationDrawerContract extends BaseContract{

    public interface NavigationDrawerPresenter extends BasePresenter<NavigationDrawerView> {

        List<NavigationItem> getNavigationItems(Context context);

        void onNavigationItemSelected(List<NavigationItem> navigationList, int pos, FragmentManager fragmentManager, AppCompatActivity activity, int containerId);
    }

    public interface NavigationDrawerView {

    }
}
