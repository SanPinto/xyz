package com.movie.app.common.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by COMPUTER on 10/28/2017.
 */

public class NavigationItem implements Parcelable{
    public String title;
    public int icon;

    protected NavigationItem(Parcel in) {
        title = in.readString();
        icon = in.readInt();
    }

    public NavigationItem() {

    }

    public static final Creator<NavigationItem> CREATOR = new Creator<NavigationItem>() {
        @Override
        public NavigationItem createFromParcel(Parcel in) {
            return new NavigationItem(in);
        }

        @Override
        public NavigationItem[] newArray(int size) {
            return new NavigationItem[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(title);
        parcel.writeInt(icon);
    }
}
