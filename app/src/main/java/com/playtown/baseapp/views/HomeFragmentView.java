package com.playtown.baseapp.views;


import com.playtown.baseapp.utils.ResponseErrorType;
import com.playtown.baseapp.models.Module;

import java.util.ArrayList;

public interface HomeFragmentView extends MvpView {
    void hideProgressBar();

    void onError(ResponseErrorType noInternetConnection);

    void onHttpError(int errorCode, String meg);

    void onDataUpdate(ArrayList<Module> prizes);

    void onBodyOk();

    void onPostError();
}
