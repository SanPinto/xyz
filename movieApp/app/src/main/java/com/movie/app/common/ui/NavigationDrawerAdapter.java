package com.movie.app.common.ui;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.movie.app.R;
import com.movie.app.common.model.NavigationItem;
import com.movie.app.common.views.TintableImageview;

import java.util.List;

/**
 * Created by COMPUTER on 10/28/2017.
 */

public class NavigationDrawerAdapter extends ArrayAdapter<NavigationItem> {
    private LayoutInflater mInflator;
    private List<NavigationItem> mNavList;


    public NavigationDrawerAdapter(@NonNull Context context, List<NavigationItem> navList) {
        super(context, 0, navList);
        mInflator = LayoutInflater.from(context);
        mNavList = navList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = mInflator.inflate(R.layout.nav_drawer_item, parent, false);
            holder.navTitle = (TextView) convertView.findViewById(R.id.nav_menu_title);
            holder.navIcon = (TintableImageview) convertView.findViewById(R.id.nav_menu_icon);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        setNavigationItem(holder, getItem(position));
        return convertView;
    }

    private void setNavigationItem(ViewHolder holder, NavigationItem item) {
        holder.navTitle.setText(item.title);
        holder.navIcon.setBackgroundResource(item.icon);
    }


    private static class ViewHolder {
        TextView navTitle;
        TintableImageview navIcon;
    }

    public List<NavigationItem> getNavigationList() {
        return mNavList;
    }
}
