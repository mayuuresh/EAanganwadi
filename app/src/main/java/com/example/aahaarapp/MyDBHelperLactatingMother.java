package com.example.aahaarapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDBHelperLactatingMother extends SQLiteOpenHelper {
    private static final String DB_NAME = "Lactating";
    private static final int DB_VERSION = 1;

    private static final String TABLE_NAME_Lac = "lactating";
    private static final String Name = "name";
    private static final String Date_Birth = "birthDate";
    private static final String Year_Birth = "birthYear";
    private static final String Mobile_number = "mobileNo";
    private static final String Delivery_Date = "deliveryDate";
    private static final String Gender = "gender";
    private static final String Height_Unit = "heightUnit";
    private static final String Height = "height";
    private static final String Weight = "weight";
    private static final String Hemoglobin = "hemoglobin";
    private static final String Provided_With = "provided";
    private static final String Health_Service = "healthService";


    public MyDBHelperLactatingMother(@Nullable Context context) {
        super(context,DB_NAME,null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query_lac = "CREATE TABLE " + TABLE_NAME_Lac + " ("
                + Mobile_number + " TEXT PRIMARY KEY , "
                + Name + " TEXT , "
                + Date_Birth + " TEXT ,"
                + Year_Birth + " TEXT , "
                + Delivery_Date + " TEXT , "
                + Gender + " TEXT , "
                + Height_Unit + " TEXT , "
                + Height + " TEXT , "
                + Weight + " TEXT , "
                + Hemoglobin + " TEXT , "
                + Provided_With + " TEXT , "
                + Health_Service + " TEXT ) ";

        db.execSQL(query_lac);
    }

    public void lactatingRegister(String name,String date_Birth,String year_Birth, String mobile,String delivery_Date, String gender)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Mobile_number, mobile);
        values.put(Name, name);
        values.put(Date_Birth, date_Birth);
        values.put(Year_Birth, year_Birth);
        values.put(Delivery_Date, delivery_Date);
        values.put(Gender, gender);
        values.put(Height_Unit,"");
        values.put(Height,"");
        values.put(Weight,"");
        values.put(Hemoglobin,"");
        values.put(Provided_With ,"");
        values.put(Health_Service ,"");

        db.insert(TABLE_NAME_Lac, null, values);
        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public Cursor readAllData()
    {
        String query = "SELECT * FROM " + TABLE_NAME_Lac;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null)
        {
            cursor = db.rawQuery(query,null);
        }
        return cursor;
    }

}
