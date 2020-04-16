package com.debin.retrofitmvp.network;

import com.debin.retrofitmvp.model.Cake;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Api {
    // reed/739df99e9d96700f17604a3971e701fa/raw/1d4dd9c5a0ec758ff5ae92b7b13fe4d57d34e1dc/waracle_cake-android-client
    @GET("t-reed/{api_key_first}/raw/{api_key_second}/waracle_cake-android-client")
    Call<ArrayList<Cake>> getCakes(@Path("api_key_first") String apiKeyFirst,
                                   @Path("api_key_second") String apiKeySecond) ;
}
