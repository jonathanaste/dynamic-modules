package com.playtown.baseapp.utils;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

import com.playtown.baseapp.R;


public class TypefaceTextView extends android.support.v7.widget.AppCompatTextView {

    public TypefaceTextView(Context context) {
        super(context);
    }

    public TypefaceTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public TypefaceTextView(Context context, AttributeSet attrs,
                            int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        TypedArray a = getContext().obtainStyledAttributes(
                attrs,
                R.styleable.TypefaceTextView);

        try {

            CharSequence typeText = a.getString(R.styleable.TypefaceTextView_typeText);
            TypeText type = TypeText.valueOf(String.valueOf(typeText));
            switch (type){
                case title:
                    setTypeface(Typefaces.getTitleLatoTypeface(getContext()));
                    break;
                case body:
                    setTypeface(Typefaces.getBodyLatoTypeface(getContext()));
                    break;
                case footer:
                    setTypeface(Typefaces.getFooterLatoTypeface(getContext()));
                    break;
                default:
                    break;
            }
        } finally {
            a.recycle();
        }
    }

    private enum TypeText{
        title,
        body,
        footer
    }

}