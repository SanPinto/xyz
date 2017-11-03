package com.movie.app.common.rest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by sangeetha on 3/11/17.
 */

public class RestApiResponseCallback<T> implements Callback<T> {

    private RestAPICallbackListner mCallback;

    public interface RestAPICallbackListner {

        void onResponseError(String Error);

        <T> void onResponseSuccess(T response);
    }


    public RestApiResponseCallback(RestAPICallbackListner listner) {
        mCallback = listner;
    }


    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if (mCallback != null) {
            mCallback.onResponseSuccess(response.body());
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        if (t != null) {
            mCallback.onResponseError(t.getMessage());
        }
    }
}
