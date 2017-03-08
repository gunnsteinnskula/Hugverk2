package com.example.hugverk.hugverk2;

import android.graphics.Color;

import java.util.List;

/**
 * Created by Gunnsteinn on 08/03/17.
 */

public class ColorDatabaseController {
    private String dbName;
    private Color AppColor;
    private List<AppColor> colorlist;

    public ColorDatabaseController(String dbName) {
        this.dbName = dbName;
    }

    public List getHistory(){

        return colorlist;
    }

    public void storeColor(Color AppColor){

    }

    public void removeFromHistory(Color AppColor){

    }

    public void setFavorite(Color AppColor){

    }

    public List<AppColor> getFavorite(){

        return colorlist;
    }

    public Color getDayColor(){

        return AppColor;
    }

    public String getName(Color color){
        String name = new String;

        return name;
    }

    public String getHue(Color color){
        String hue = new String;
        hue = color.toString();
        return hue;
    }

    public Color getSimilarColor(Color color){
        return color;
    }


}
