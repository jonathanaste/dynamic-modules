package com.playtown.baseapp.ui.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.playtown.baseapp.R;
import com.playtown.baseapp.utils.ResponseErrorType;
import com.playtown.baseapp.interfaces.HomeCallback;
import com.playtown.baseapp.models.Module;
import com.playtown.baseapp.presenters.HomeFragmentPresenter;
import com.playtown.baseapp.ui.adapters.HomeAdapter;
import com.playtown.baseapp.views.HomeFragmentView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DynamicModules extends BaseActivity implements HomeFragmentView, HomeCallback {

    private HomeFragmentPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        presenter = new HomeFragmentPresenter();
        presenter.attachMvpView(this);
        presenter.getHome();
        initViews();
        initListeners();
        setupViews();
    }

    @Override
    protected void initViews() {
    }

    @Override
    protected void initListeners() {
    }

    @Override
    protected void setupViews() {
    }

    @Override
    public void hideProgressBar() {
    }

    @Override
    public void onError(ResponseErrorType noInternetConnection) {

    }

    @Override
    public void onHttpError(int errorCode, String meg) {

    }

    @Override
    public void onDataUpdate(final ArrayList<Module> modules) {
        LayoutInflater vi = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        for (int i = 0; i < modules.size(); i++) {
            final View modelView = vi.inflate(R.layout.base_module, null);
            modelView.setId(i);
            HomeAdapter adapter = new HomeAdapter(this, this);
            RecyclerView localRecyclerViewModule = (RecyclerView) modelView.findViewById(R.id.module_recycler);
            LinearLayoutManager layoutManager = new LinearLayoutManager(this);
            localRecyclerViewModule.setLayoutManager(layoutManager);
            localRecyclerViewModule.setAdapter(adapter);
            localRecyclerViewModule.setHasFixedSize(true);
            adapter.setData(modules.get(i).getElements());
            TextView localViewAllModule = (TextView) modelView.findViewById(R.id.view_all);
            TextView localModuleName = (TextView) modelView.findViewById(R.id.module_name);
            ImageView localModuleImage = (ImageView) modelView.findViewById(R.id.module_image);

            localModuleName.setText(modules.get(i).getName());
            Picasso.with(this).load(modules.get(i).getIcon()).into(localModuleImage);

            final int finalI = i;
            localViewAllModule.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(DynamicModules.this, modules.get(finalI).getName(), Toast.LENGTH_SHORT).show();
                }
            });
            ((ViewGroup) findViewById(R.id.activity_home_content)).addView(modelView);
        }
    }

    @Override
    public void onBodyOk() {

    }

    @Override
    public void onPostError() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachMvpView();
    }

    @Override
    public void onItemClick(int position) {

    }

    @Override
    public void onItemClickWithView(int adapterPosition, ImageView image) {
        Toast.makeText(this, String.valueOf(adapterPosition), Toast.LENGTH_SHORT).show();
    }

}
