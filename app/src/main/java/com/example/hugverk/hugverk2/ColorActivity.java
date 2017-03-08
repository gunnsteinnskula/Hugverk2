package com.example.hugverk.hugverk2;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
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

        ColorDatabaseController.initdb();

        Button colorButton = (Button) findViewById(R.id.color_button);
        ColorDrawable buttonColor = (ColorDrawable) colorButton.getBackground();
        final AppColor appcolor = new AppColor(buttonColor.toString());

        colorButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(ColorActivity.this, appcolor.getRgb() , Toast.LENGTH_SHORT).show();


            }
        });

    }
}
