package com.movie.app.common.presenter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;

import com.movie.app.R;
import com.movie.app.common.model.NavigationItem;
import com.movie.app.common.ui.HomeFragment;
import com.movie.app.common.utils.FragmentHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by COMPUTER on 10/29/2017.
 */

public class NavigationDrawrPresenterImpl implements NavigationDrawerContract.NavigationDrawerPresenter {
    private NavigationDrawerContract.NavigationDrawerView mView;

    @Override
    public void setView(NavigationDrawerContract.NavigationDrawerView view) {
        mView = view;
    }

    @Override
    public void clearView() {
        mView = null;
    }

    @Override
    public List<NavigationItem> getNavigationItems(Context context) {
        List<NavigationItem> navigationList = new ArrayList<>();
        List<String> titles = Arrays.asList(context.getResources().getStringArray(R.array.navigation_titles));
        for (String title : titles) {
            NavigationItem item = new NavigationItem();
            item.title = title;
            if (title.equalsIgnoreCase("Top Rated")) {
                item.icon = R.drawable.icn_menu_top_rated;
            } else if (title.equalsIgnoreCase("Upcoming")) {
                item.icon = R.drawable.icn_menu_upcoming;
            } else {
                item.icon = R.drawable.icn_menu_popular;
            }
            navigationList.add(item);
        }

        return navigationList;
    }

    @Override
    public void onNavigationItemSelected(List<NavigationItem> navigationList, int pos, FragmentManager fragmentManager, AppCompatActivity activity, int containerId) {
        if (activity.findViewById(R.id.container) != null) {
            if (fragmentManager.findFragmentById(R.id.container) == null) {
                HomeFragment fragment = HomeFragment.getInstance(navigationList, pos);
                FragmentHelper.replaceFragment(activity, containerId, fragment);
                fragment.setView(mView);

            } else {
                Fragment fragment = fragmentManager.findFragmentById(R.id.container);
                if(fragment != null && fragment instanceof HomeFragment) {
                    ((HomeFragment) fragment).moveToSelectedTab(pos);
                }
            }
        }

    }

    @Override
    public void closeDrawer(DrawerLayout drawer) {
        drawer.closeDrawer(GravityCompat.START);
    }

    @Override
    public boolean isDrawerOpen(DrawerLayout drawer) {
        return drawer.isDrawerOpen(GravityCompat.START);
    }


}
