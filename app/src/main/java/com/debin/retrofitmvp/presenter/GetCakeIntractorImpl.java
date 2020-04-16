package com.debin.retrofitmvp.presenter;

import android.util.Log;

import com.debin.retrofitmvp.BuildConfig;
import com.debin.retrofitmvp.contract.MainContract;
import com.debin.retrofitmvp.model.Cake;
import com.debin.retrofitmvp.network.RetrofitInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetCakeIntractorImpl implements MainContract.GetCakeIntractor {

    private static final String TAG = "GetCakeIntractorImpl";
    @Override
    public void getCakeArrayList(final OnFinishedListener onFinishedListener) {

        RetrofitInstance.getApi().getCakes(BuildConfig.API_KEY_FIRST,
                BuildConfig.API_KEY_SECOND)
                .enqueue(new Callback<ArrayList<Cake>>() {
                    @Override
                    public void onResponse(Call<ArrayList<Cake>> call, Response<ArrayList<Cake>> response) {
                        onFinishedListener.onFinished(response.body());
                        if(response.raw().cacheResponse()!=null) {
                            // true: response was served from cache
                            Log.i(TAG,"Response from cache");
                        } else if (response.raw().networkResponse() != null
                                && response.raw().networkResponse() == null) {
                            // true: response was served from network/server
                            Log.i(TAG,"Response from server");
                        }
                    }

                    @Override
                    public void onFailure(Call<ArrayList<Cake>> call, Throwable t) {
                        onFinishedListener.onFailure(t);

                    }
                });


    }
}
