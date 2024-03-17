package com.example.aahaarapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.EditText;

import androidx.annotation.Nullable;

public class MyDBHelperPregnantWomen extends SQLiteOpenHelper {

    private static final String DB_NAME = "Pregnant_Register";
    private static final int DB_VERSION = 1;

    private static final String TABLE_NAME_Reg = "pregnant_register";
    private static final String name = "Name";
    private static final String dob = "Dob";
    private static final String yob = "Yob";
    private static final String mobileNo = "Mobile_No";
    private static final String pregnancy = "First_Pregnancy";
    private static final String miscarriage = "Miscarriage";
    private static final String HeightUnit = "hunit";
    private static final String Height= "height";
    private static final String Weight = "weight";
    private static final String Hemoglobin = "hemoglobin";
    private static final String Nutritional_Supplements = "Nutrition";
    private static final String Energy= "energy";
    private static final String protein = "protein";
    private static final String vaccination = "Vaccination";
    public MyDBHelperPregnantWomen(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String Query = "CREATE TABLE " + TABLE_NAME_Reg + " ("
                + mobileNo + " TEXT PRIMARY KEY, "
                + name + " TEXT, "
                + dob + " TEXT, "
                + yob + " TEXT, "
                + pregnancy + " TEXT, "
                + miscarriage + " TEXT, "
                + HeightUnit + " TEXT, "
                + Height + " TEXT, "
                + Weight + " TEXT, "
                + Hemoglobin + " TEXT, "
                + Nutritional_Supplements + " TEXT, "
                + Energy + " TEXT, "
                + protein + " TEXT ,"
                + vaccination + " TEXT )";

        db.execSQL(Query);

    }
    public void registeruser(String name1,String dob1,String yob1,String mobile1,String pregnancy1,String miscarriage1)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(mobileNo, mobile1);
        values.put(name,name1 );
        values.put(dob,dob1);
        values.put(yob,yob1);
        values.put(pregnancy,pregnancy1);
        values.put(miscarriage,miscarriage1);
        values.put(HeightUnit, "");
        values.put(Height, "");
        values.put(Weight, "");
        values.put(Hemoglobin,"");
        values.put(Nutritional_Supplements, "");
        values.put(Energy, "");
        values.put(protein, "");
        values.put(vaccination, " ");

        db.insert(TABLE_NAME_Reg, null, values);
        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public Cursor readAllData(String number)
    {
        String query = "SELECT * FROM " + TABLE_NAME_Reg + " WHERE " + mobileNo + " = " + number;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null)
        {
            cursor = db.rawQuery(query,null);
        }
        return cursor;
    }
    public Cursor viewData()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME_Reg;
        Cursor cursor = db.rawQuery(query,null);
        return cursor;
    }

    public void updateColumns(String value, String radion, String value2, String value3, String value4, String value5, String value6, String value7,String item) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(HeightUnit, radion);
        values.put(Height, value2);
        values.put(Weight, value3);
        values.put(Hemoglobin,value4);
        values.put(Nutritional_Supplements, value5);
        values.put(Energy, value6);
        values.put(protein, value7);
        values.put(vaccination,item);

        db.update(TABLE_NAME_Reg, values, mobileNo + " = ?", new String[]{value});
        db.close();
    }
}
