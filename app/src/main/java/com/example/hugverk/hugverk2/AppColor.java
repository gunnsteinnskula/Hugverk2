package com.example.hugverk.hugverk2;

import java.io.IOException;

import static android.graphics.Color.parseColor;

public class AppColor{

    private String hex;
    private String rgb;
    private String colorName;
    private String colorHue;
    private Integer colorInt;

    public AppColor(Integer[] rgb) throws IOException {
        this.hex = String.format( "#%02x%02x%02x", rgb[0], rgb[1], rgb[2] );
        this.rgb = String.format( "Red: %s, Green: %s, Blue: %s", rgb[0], rgb[1], rgb[2] );

        this.colorName = "Loading";
        this.colorHue = "TODO";
        this.colorInt = parseColor(this.hex);

    }

    private void getNameFromServer() {

    }

    public String getHex() { return this.hex; }

    public String getCleanHex() {
        String clean = hex;
        return clean.replace("#", "");
    }


    public String getRGB(){ return this.rgb; }

    public String getColorName(){ return this.colorName; }

    public void setColorName(String colorName){
        this.colorName = colorName;
    }

    public String getHue(){
        return this.colorHue;
    }

    public Integer getInt(){
        return this.colorInt;
    }

}
