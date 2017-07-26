package com.playtown.baseapp.models;


import java.util.ArrayList;

public class Module {

    private String name;
    private String icon;
    private String type;
    private String categories;


    ArrayList<Element> elements;

    public String getName() {
        return name;
    }

    public String getIcon() {
        return icon;
    }

    public String getType() {
        return type;
    }

    public ArrayList<Element> getElements() {
        return elements;
    }

    public String getCategories() {
        return categories;
    }
}
