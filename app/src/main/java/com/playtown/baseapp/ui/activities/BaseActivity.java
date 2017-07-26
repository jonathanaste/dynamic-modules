package com.playtown.baseapp.ui.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public abstract class BaseActivity extends AppCompatActivity {

    protected abstract void initViews();

    protected abstract void initListeners();

    protected abstract void setupViews();

}
