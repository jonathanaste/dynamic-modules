package com.playtown.baseapp.views;


public interface Presenter<T> {
    void attachMvpView(T mvpView);
    void detachMvpView();
}
