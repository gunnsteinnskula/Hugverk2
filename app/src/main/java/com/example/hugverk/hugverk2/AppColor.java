package com.example.hugverk.hugverk2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Date;

public class AppColor{

    private String hex;
    private String rgb;
    private String colorName;
    private String colorHue;
    //private Date thedate;

    public AppColor(String hex, String rgb, String colorName, String colorHue){
        this.hex = hex;
        this.rgb = rgb;
        this.colorName = colorName;
        this.colorHue = colorHue;

    }

    public String getHex(){
        return this.hex;
    }

    public String getRgb(){
        return this.rgb;
    }

    public String getColorName(){
        return this.colorName;
    }

    public void setColor(String colorName){
        this.colorName = colorName;
    }

    public String getHue(){
        return this.colorHue;
    }

    /*
    public Date getDate(){
        Date date;
        return date;
    }
    */

}
