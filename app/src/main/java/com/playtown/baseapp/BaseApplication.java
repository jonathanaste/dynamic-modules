package com.playtown.baseapp;

import android.app.Application;

import com.playtown.baseapp.controllers.RequestController;


public class BaseApplication extends Application {

    private static BaseApplication instance;
    public static RequestController requestController;

    public static BaseApplication getInstance() {
        if (instance == null) {
            instance = new BaseApplication();
        }
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        requestController = RequestController.getInstance(this);
    }

}
