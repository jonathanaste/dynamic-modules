package com.playtown.baseapp.presenters;


import com.playtown.baseapp.BaseApplication;
import com.playtown.baseapp.backend.HomeResponse;
import com.playtown.baseapp.utils.ResponseErrorType;
import com.playtown.baseapp.backend.CustomObserver;
import com.playtown.baseapp.models.Module;
import com.playtown.baseapp.views.HomeFragmentView;

import java.util.ArrayList;

public class HomeFragmentPresenter extends BasePresenter<HomeFragmentView> {

    private CustomObserver<HomeResponse> observer = new CustomObserver<HomeResponse>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {
            mvpView.hideProgressBar();
            super.onError(e);
        }

        @Override
        public void onNoInternetConnection() {
            mvpView.onError(ResponseErrorType.noInternetConnection);
        }

        @Override
        public void onUnknownError() {
            mvpView.onError(ResponseErrorType.uknownError);
        }

        @Override
        public void onTimeOut() {
            mvpView.onError(ResponseErrorType.timeOut);
        }

        @Override
        public void onHttpErrorCode(int errorCode, String meg) {
            mvpView.onHttpError(errorCode, meg);
        }

        @Override
        public void onNext(HomeResponse modules) {
            super.onNext(modules);
            mvpView.onDataUpdate(modules.getModules());
        }
    };

    public void getHome() {
        compositeSubscription.add(BaseApplication.requestController.getHome().subscribe(observer));
    }

}
