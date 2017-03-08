package com.example.hugverk.hugverk2;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Date;

public class AppColor{

    private String hex;
    private String rgb;
    private String colorName;
    private String colorHue;
    //private Date thedate;

    public AppColor(String hex){
        int color = Color.parseColor("#123456");
        this.hex = hex;
        this.rgb = "Leyndó - kemur seinna";
        //this.rgb = rgb;
        //this.colorName = colorName;
        //this.colorHue = colorHue;
        this.colorName = ColorDatabaseController.getName(this.hex);

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
