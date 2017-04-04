package com.example.hugverk.hugverk2;

import android.database.Cursor;
import android.graphics.Color;

import java.util.List;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Gunnsteinn on 08/03/17.
 */

public class ColorDatabaseController {

    static SQLiteDatabase mydatabase = SQLiteDatabase.openOrCreateDatabase("colordb",null);

    public static void initdb(){
        mydatabase.execSQL("CREATE TABLE IF NOT EXISTS daycolor(daycolor VARCHAR);");
        mydatabase.execSQL("INSERT INTO daycolor VALUES('green');");
        mydatabase.execSQL("CREATE TABLE IF NOT EXISTS favcolor(favcolor VARCHAR);");
        mydatabase.execSQL("INSERT INTO favcolor VALUES('green');");
        mydatabase.execSQL("CREATE TABLE IF NOT EXISTS namecolor(namecolor VARCHAR);");
        mydatabase.execSQL("INSERT INTO namecolor VALUES('Blue thunder rain');");
        mydatabase.execSQL("CREATE TABLE IF NOT EXISTS history(history VARCHAR);");
        mydatabase.execSQL("INSERT INTO history VALUES('green');");

    }
/*
    public AppColor getHistory(){
        Cursor resultSet = mydatabase.rawQuery("Select * from history",null);
        resultSet.moveToFirst();
        String history = resultSet.getString(0);
        return new AppColor(history);
    }
    */

    public void storeColor(AppColor AppColor){
        String name = AppColor.getColorName();
        mydatabase.execSQL("INSERT INTO history VALUES('history','" + name + "');");

    }

    public void removeFromHistory(AppColor AppColor){

    }

    public void setFavorite(AppColor AppColor){

    }
/*
    public AppColor getFavorite(){
        Cursor resultSet = mydatabase.rawQuery("Select * from favcolor",null);
        resultSet.moveToFirst();
        String favcolor = resultSet.getString(0);
        return new AppColor(favcolor);
    }


    public AppColor getDayColor(){

        Cursor resultSet = mydatabase.rawQuery("Select * from daycolor",null);
        resultSet.moveToFirst();
        String thedaycolor = resultSet.getString(0);
        return new AppColor(thedaycolor);
    }
*/
    public static String getName(String hex){
        Cursor resultSet = mydatabase.rawQuery("Select * from namecolor",null);
        resultSet.moveToFirst();
        return resultSet.getString(0);

    }

    public String getHue(Color color){
        String hue = color.toString();
        return hue;
    }

    public Color getSimilarColor(Color color){
        return color;
    }


}
