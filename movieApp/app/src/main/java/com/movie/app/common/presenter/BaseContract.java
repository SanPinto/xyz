package com.movie.app.common.presenter;

/**
 * Created by COMPUTER on 10/29/2017.
 */

public class BaseContract {

    public interface BasePresenter<T> {

        void setView(T view);

        void clearView();
    }

}
