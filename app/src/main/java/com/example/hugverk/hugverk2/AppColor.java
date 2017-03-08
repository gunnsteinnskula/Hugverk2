package com.example.hugverk.hugverk2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Date;

public class AppColor extends AppCompatActivity {

    private String hex;
    private String rgb;
    private String colorName;
    private String colorHue;
    private Date thedate;

    public AppColor(String hex,String rgb,String colorName,String colorHue){
        this.hex = hex;
        this.rgb = rgb;
        this.colorName = colorName;
        this.colorHue = colorHue;
    }

    public String getHex(){

        return hex;
    }

    public String getRgb(){
        return rgb;
    }

    public String getColorName(String rgb){
        return colorName;
    }

    public void setColor(String colorName){

    }

    public String getHue(String colorName){
        return colorName;
    }

    /*
    public Date getDate(){
        Date date;
        return date;
    }
    */

    public String toString(){

        return colorName;
    }

    public String blendColors(String col1, String col2){
        return colorName;
    }

}
