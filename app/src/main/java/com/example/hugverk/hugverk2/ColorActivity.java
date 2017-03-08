package com.example.hugverk.hugverk2;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.attr.button;

/**
 * Created by Gunnsteinn on 08/03/17.
 */

public class ColorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_activity);

        //ColorDatabaseController.initdb();

        TextView colorTextView = (TextView) findViewById(R.id.color_textview);
        ColorDrawable textViewColor = (ColorDrawable) colorTextView.getBackground();
        final AppColor appcolor = new AppColor(String.valueOf(textViewColor.getColor()));

        //rgb_button, hex_button, colorname_button
        Button rgbButton = (Button) findViewById(R.id.rgb_button);

        rgbButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(ColorActivity.this, appcolor.getRgb() , Toast.LENGTH_LONG).show();
            }
        });

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
    }
}
