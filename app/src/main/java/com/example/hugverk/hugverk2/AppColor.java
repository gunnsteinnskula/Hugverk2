package com.example.hugverk.hugverk2;

import java.io.IOException;

import static android.graphics.Color.parseColor;

// AppColor is a class that is used for storing all the color information
// It's initialized a Int array containing rgb values in the range 0-255
// Automatically calculates the hex and Android Int color values
// It features get functions to Hex, Rgb, Name etc...
// It features set function for the colorname, useful for the API color name call
public class AppColor{

    // Private variables containing Appcolor information
    private String hex;
    private String rgb;
    private String colorName;
    private Integer colorInt;

    public AppColor(Integer[] rgb) throws IOException {
        // Sets the hex variable calculated from the RGB values
        this.hex = String.format( "#%02x%02x%02x", rgb[0], rgb[1], rgb[2]).toUpperCase();
        // Sets the rgb variable in a neatly formatted string
        this.rgb = String.format( "RGB (%s, %s, %s)", rgb[0], rgb[1], rgb[2] );

        this.colorName = "Loading";
        this.colorInt = parseColor(this.hex);
    }
    // Returns String hex value with # in front
    public String getHex() { return this.hex; }

    // Returns String hex value without # in front.
    public String getCleanHex() { return this.hex.replace("#", ""); }

    // Returns String RGB values neatly formated
    public String getRGB() { return this.rgb; }

    // Returns String name of the color in a string, default is Loading
    public String getColorName() { return this.colorName; }

    // Returns Int for Android color use
    public Integer getInt(){
        return this.colorInt;
    }

    // Sets the colorName string of the Object, usefull for API name feature
    public void setColorName(String colorName){
        this.colorName = colorName;
    }

}
