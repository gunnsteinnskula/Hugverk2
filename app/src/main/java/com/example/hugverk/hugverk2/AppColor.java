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

    public AppColor(int[] rgb){
        this.hex = "test";
        this.rgb = "Leyndó - kemur seinna";
        this.colorName = "kemur bráðum";
        this.colorHue = "Og bráðum";

        // Þett virkar ekki vegna þess að db krassar, þarf að skoða betur
        //this.colorName = ColorDatabaseController.getName(this.hex);

    }

    public String getHex(int[]rgb) {
        this.hex = String.format( "#%02x%02x%02x", rgb[0], rgb[1], rgb[2] );
        return this.hex.toString();
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
