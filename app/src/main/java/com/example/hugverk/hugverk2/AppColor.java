package com.example.hugverk.hugverk2;

import java.io.IOException;

import static android.graphics.Color.parseColor;

public class AppColor{

    private String hex;
    private String rgb;
    private String colorName;
    private Integer colorInt;

    public AppColor(Integer[] rgb) throws IOException {
        this.hex = String.format( "#%02x%02x%02x", rgb[0], rgb[1], rgb[2]).toUpperCase();
        this.rgb = String.format( "RGB (%s, %s, %s)", rgb[0], rgb[1], rgb[2] );

        this.colorName = "Loading";
        this.colorInt = parseColor(this.hex);
    }


    public String getHex() { return this.hex; }

    public String getCleanHex() {
        String clean = this.hex;
        return clean.replace("#", "");
    }


    public String getRGB(){ return this.rgb; }

    public String getColorName(){ return this.colorName; }

    public Integer getInt(){
        return this.colorInt;
    }

    public void setColorName(String colorName){
        this.colorName = colorName;
    }

}
