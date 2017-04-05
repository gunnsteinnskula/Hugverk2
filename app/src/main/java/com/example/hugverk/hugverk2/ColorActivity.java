package com.example.hugverk.hugverk2;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;

/**
 * Created by Gunnsteinn on 08/03/17.
 */

public class ColorActivity extends AppCompatActivity {



    private Bitmap mBitmap;
    private Canvas mCanvas;
    private Rect mBounds;

    public void initIfNeeded() {
        if(mBitmap == null) {
            mBitmap = Bitmap.createBitmap(1,1, Bitmap.Config.ARGB_8888);
            mCanvas = new Canvas(mBitmap);
            mBounds = new Rect();
        }
    }

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

    public int[] getBackgroundColor(View view) {
        // The actual color, not the id.
        int colorInt = Color.BLACK;
        int[] rgbArray = new int[3];

        if(view.getBackground() instanceof ColorDrawable) {
            if(Build.VERSION.SDK_INT < Build.VERSION_CODES.HONEYCOMB) {
                initIfNeeded();

                // If the ColorDrawable makes use of its bounds in the draw method,
                // we may not be able to get the color we want. This is not the usual
                // case before Ice Cream Sandwich (4.0.1 r1).
                // Yet, we change the bounds temporarily, just to be sure that we are
                // successful.
                ColorDrawable colorDrawable = (ColorDrawable)view.getBackground();

                mBounds.set(colorDrawable.getBounds()); // Save the original bounds.
                colorDrawable.setBounds(0, 0, 1, 1); // Change the bounds.

                colorDrawable.draw(mCanvas);
                colorInt = mBitmap.getPixel(0, 0);

                colorDrawable.setBounds(mBounds); // Restore the original bounds.
            }
            else {
                colorInt = ((ColorDrawable)view.getBackground()).getColor();
            }
        }

        rgbArray[0] = Color.red(colorInt);
        rgbArray[1] = Color.blue(colorInt);
        rgbArray[2] = Color.green(colorInt);

        return rgbArray;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);
        int[] colorInt = (getBackgroundColor(findViewById(R.id.color_textview)));
        AppColor appcolor = null;

        try {
            appcolor = new AppColor(colorInt);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Button btn = (Button)findViewById(R.id.camera_button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ColorActivity.this, CameraActivity.class));
            }
        });


        Button rgbButton = (Button) findViewById(R.id.rgb_button);

        try {
            final AppColor finalAppcolor = appcolor;
            rgbButton.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    Toast.makeText(ColorActivity.this, finalAppcolor.getRGB() , Toast.LENGTH_LONG).show();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

        Button hexButton = (Button) findViewById(R.id.hex_button);
        final AppColor finalAppcolor1 = appcolor;
        hexButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(ColorActivity.this, finalAppcolor1.getHex() , Toast.LENGTH_LONG).show();
            }
        });
        Button colorNameButton = (Button) findViewById(R.id.colorname_button);
        final AppColor finalAppcolor2 = appcolor;
        colorNameButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(ColorActivity.this, finalAppcolor2.getColorName() , Toast.LENGTH_LONG).show();
            }
        });
    }
}
