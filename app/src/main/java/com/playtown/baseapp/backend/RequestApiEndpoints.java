package com.playtown.baseapp.backend;

import com.playtown.baseapp.models.Module;

import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface RequestApiEndpoints {

    @GET("public//?action=log_sms")
    Observable<ResponseBody> exampleCall(@Query("param1") String param1, @Query("param2") String param2);
    @GET("public//?action=get_home")
    Observable<HomeResponse> getHome();

}