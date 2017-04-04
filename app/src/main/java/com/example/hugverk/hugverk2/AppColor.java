package com.example.hugverk.hugverk2;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class AppColor{

    private String hex;
    private String rgb;
    private String colorName;
    private String colorHue;

    public AppColor(int[] rgb) throws IOException {
        this.hex = String.format( "%02x%02x%02x", rgb[0], rgb[1], rgb[2] );
        this.rgb = String.format( "R: %s, G: %s, B %s", rgb[0], rgb[1], rgb[2] );

        this.colorName = "Nafn";
        this.colorHue = "TODO";

    }

    private String getNameFromServer() {
        final String[] response = new String[1];
        AsyncHttpClient client = new AsyncHttpClient();
        client.get("https://colornames.herokuapp.com/hex/abc123", new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {

                if (responseBody == null) { return; }
                response[0] = new String(responseBody);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                if (responseBody == null) { return; }
                response[0] = new String(responseBody);
            }
        });
        return response[0];
    }

    public String getHex() { return this.hex.toString(); }

    public String getRGB(){
        return this.rgb.toString();
    }

    public String getColorName(){ return this.colorName.toString(); }

    public void setColor(String colorName){
        this.colorName = colorName;
    }

    public String getHue(){
        return this.colorHue;
    }



}
