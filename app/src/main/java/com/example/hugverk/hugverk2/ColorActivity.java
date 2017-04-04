package com.example.hugverk.hugverk2;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

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

        Button btn = (Button)findViewById(R.id.camera_button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ColorActivity.this, CameraActivity.class));
            }
        });
        //ColorDatabaseController.initdb();

/*
        TextView colorTextView = (TextView) findViewById(R.id.color_textview);
<<<<<<< Updated upstream
        ColorDrawable textViewColor = (ColorDrawable) colorTextView.getBackground();
=======
        ColorDrawable textViewColor = ((ColorDrawable) colorTextView.getBackground()).getColor();

        final AppColor appcolor = new AppColor(textViewColor.toString());
>>>>>>> Stashed changes
        final AppColor appcolor = new AppColor(String.valueOf(textViewColor.getColor()));

        */
        //rgb_button, hex_button, colorname_button

        Button rgbButton = (Button) findViewById(R.id.rgb_button);

        rgbButton.setOnClickListener(new View.OnClickListener(){
            int[] colorInt = (getBackgroundColor(findViewById(R.id.color_textview)));
            final AppColor appcolor = new AppColor(colorInt);
            @Override
            public void onClick(View v){
                Toast.makeText(ColorActivity.this,appcolor.getHex(colorInt) , Toast.LENGTH_LONG).show();
            }
        });
/*
        Button hexButton = (Button) findViewById(R.id.hex_button);

        hexButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(ColorActivity.this, appcolor.getHex() , Toast.LENGTH_LONG).show();
            }
        });

        Button colorNameButton = (Button) findViewById(R.id.colorname_button);

        colorNameButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(ColorActivity.this, appcolor.getColorName() , Toast.LENGTH_LONG).show();
            }
        });
        */
    }
}
