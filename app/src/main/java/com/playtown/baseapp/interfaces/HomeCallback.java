package com.playtown.baseapp.interfaces;


import android.widget.ImageView;

public interface HomeCallback {

    void onItemClick(int position);

    void onItemClickWithView(int adapterPosition, ImageView image);

}
