package com.example.hugverk.hugverk2;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.io.IOException;

public class ColorActivity extends AppCompatActivity {

    private Bitmap mBitmap;
    private Canvas mCanvas;
    private Rect mBounds;
    AppColor appcolor;

    // Copy String to Clipboard.
    public void toClip(String stuff){
        int sdk = android.os.Build.VERSION.SDK_INT;
        if(sdk < android.os.Build.VERSION_CODES.HONEYCOMB) {
            android.text.ClipboardManager clipboard = (android.text.ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
            clipboard.setText(stuff);
        } else {
            android.content.ClipboardManager clipboard = (android.content.ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
            android.content.ClipData clip = android.content.ClipData.newPlainText("Clipboard",stuff);
            clipboard.setPrimaryClip(clip);
        }
    }

    // Get array of RGB values from image.
    public static Integer[] rgbFromPicture(String path){
        Bitmap bitmap = null;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        options.inMutable = true;
        bitmap = BitmapFactory.decodeFile(path, options);
        Integer p = bitmap.getPixel(bitmap.getWidth()/2,bitmap.getHeight()/2);
        Integer R = (p >> 16) & 0xff;
        Integer G = (p >> 8) & 0xff;
        Integer B = p & 0xff;
        Integer[] returnarray = {0,0,0};
        returnarray[0] = R;
        returnarray[1] = G;
        returnarray[2] = B;
        return returnarray;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);

        // Get RGB value from image and create AppColor Object.
        Integer[] rgb = rgbFromPicture("/storage/emulated/0/Android/data/com.example.hugverk.hugverk2/files/pic.jpg");
        try {
            appcolor = new AppColor(rgb);

        } catch (IOException e) {
            e.printStackTrace();
        }

        // HTTP request to get Color Name and upadting the Appcolor object.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://colornames.herokuapp.com/hex/" + appcolor.getCleanHex();
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        appcolor.setColorName(response);
                        Button colorNameButton = (Button) findViewById(R.id.colorname_button);
                        colorNameButton.setText(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Volley", String.valueOf(error));
            }
        });
        queue.add(stringRequest);


        // Create onClick to open browser.
        Button info = (Button) findViewById(R.id.info_button);
        info.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("http://www.colorhexa.com/" + appcolor.getCleanHex());
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        // Create onClick to go Camera.
        Button btn = (Button)findViewById(R.id.camera_button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ColorActivity.this, CameraActivity.class));
            }
        });


        // Upadate Background color.
        findViewById(R.id.color_textview).setBackgroundColor(Color.parseColor(appcolor.getHex()));

        // OnClick for RGB button for copy to clipboard and set value.
        Button rgbButton = (Button) findViewById(R.id.rgb_button);
        rgbButton.setText(appcolor.getRGB());
        rgbButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(ColorActivity.this, "RGB value copied to clipboard" , Toast.LENGTH_LONG).show();
                toClip(appcolor.getRGB());
            }
        });

        // OnClick for HEX button for copy to clipboard and set value.
        Button hexButton = (Button) findViewById(R.id.hex_button);
        hexButton.setText(appcolor.getHex());
        hexButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(ColorActivity.this, "Hex value copied to clipboard" , Toast.LENGTH_LONG).show();
                toClip(appcolor.getHex());
            }
        });

        // OnClick for Color Name button for copy to clipboard and set value.
        Button colorNameButton = (Button) findViewById(R.id.colorname_button);
        colorNameButton.setText(appcolor.getColorName());
        colorNameButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(ColorActivity.this, "Color name copied to clipboard" , Toast.LENGTH_LONG).show();
                toClip(appcolor.getColorName());
            }
        });
    }
}
