package com.playtown.baseapp.utils;


import android.content.Context;
import android.graphics.Typeface;

public class Typefaces {

    public static Typeface getTitleLatoTypeface(Context context){
        return Typeface.createFromAsset(context.getAssets(),"Lato-Bold.ttf");
    }

    public static Typeface getFooterLatoTypeface(Context context){
        return Typeface.createFromAsset(context.getAssets(),"Lato-Hairline.ttf");
    }

    public static Typeface getBodyLatoTypeface(Context context){
        return Typeface.createFromAsset(context.getAssets(),"Lato-Regular.ttf");
    }
}
