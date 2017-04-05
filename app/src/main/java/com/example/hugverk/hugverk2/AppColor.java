package com.example.hugverk.hugverk2;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestHandle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

import javax.net.ssl.HttpsURLConnection;

import cz.msebera.android.httpclient.Header;

import static android.graphics.Color.parseColor;

public class AppColor{

    private String hex;
    private String rgb;
    private String colorName;
    private String colorHue;
    private Integer colorInt;

    public AppColor(Integer[] rgb) throws IOException {
        this.hex = String.format( "%02x%02x%02x", rgb[0], rgb[1], rgb[2] );
        this.rgb = String.format( "Red: %s, Green: %s, Blue: %s", rgb[0], rgb[1], rgb[2] );

        this.colorName = "Nafn";
        this.colorHue = "TODO";
        this.colorInt = parseColor("#"+this.hex);

        AsyncHttpClient client = new AsyncHttpClient();
        client.get("https://colornames.herokuapp.com/hex/abc123", new AsyncHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {

                if (responseBody == null) { return; }
                String response = new String(responseBody);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                if (responseBody == null) { return; }
                String response = new String(responseBody);
            }
        });

    }

    private void getNameFromServer() {

    }

    public String getHex() { return this.hex; }

    public String getRGB(){ return this.rgb; }

    public String getColorName(){ return this.colorName; }

    public void setColor(String colorName){
        this.colorName = colorName;
    }

    public String getHue(){
        return this.colorHue;
    }

    public Integer getInt(){
        return this.colorInt;
    }

}
