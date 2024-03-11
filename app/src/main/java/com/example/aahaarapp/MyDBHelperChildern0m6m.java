package com.example.aahaarapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDBHelperChildern0m6m extends SQLiteOpenHelper{
    private static final String DB_NAME = "Children6m6mRegister";
    private static final int DB_VERSION = 1;

    private static final String TABLE_NAME_Child = "children3y6y";
    private static final String Name = "Name";
    private static final String Mother_Name = "MotherName";
    private static final String Mobile = "MobileNo";
    private static final String Weight = "Weight";
    private static final String Height_Unit = "HeightUnit";
    private static final String Height = "Height";
    private static final String Nutritional_Supplements = "NutritionalSupplements";
    private static final String Energy_Intake = "EnergyIntake";
    private static final String Protein_Intake = "ProteinIntake";
    private static final String Fat_Intake = "FatIntake";
    private static final String Food_Solids = "FoodSolids";
    private static final String Hemoglobin = "Hemoglobin";
    private static final String Health_Service = "HealthService";


    public MyDBHelperChildern0m6m(@Nullable Context context) {
        super(context, DB_NAME,null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query_child = "CREATE TABLE " + TABLE_NAME_Child + " ("
                + Mobile + " TEXT PRIMARY KEY , "
                + Name + " TEXT , "
                + Mother_Name + " TEXT ,"
                + Weight + " TEXT , "
                + Height_Unit + " TEXT , "
                + Height + " TEXT , "
                + Nutritional_Supplements + " TEXT , "
                + Energy_Intake + " TEXT , "
                + Protein_Intake + " TEXT , "
                + Fat_Intake + " TEXT , "
                + Food_Solids + " TEXT , "
                + Hemoglobin + " TEXT , "
                + Health_Service + " TEXT )";

        db.execSQL(query_child);
    }

    public void childrenRegister(String mobile,String name,String mother_name,String weight, String height_unit,String height)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Mobile,mobile);
        values.put(Name, name);
        values.put(Mother_Name, mother_name);
        values.put(Weight, weight);
        values.put(Height_Unit, height_unit);
        values.put(Height, height);
        values.put(Nutritional_Supplements,"");
        values.put(Energy_Intake,"");
        values.put(Protein_Intake,"");
        values.put(Fat_Intake,"");
        values.put(Food_Solids,"");
        values.put(Hemoglobin,"");
        values.put(Health_Service,"");


        db.insert(TABLE_NAME_Child, null, values);
        db.close();
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public void updateColumns(String id, String value1, String value2, String value3,String value4,String value5,String value6,String value7) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Nutritional_Supplements, value1);
        values.put(Energy_Intake, value2);
        values.put(Protein_Intake, value3);
        values.put(Fat_Intake, value4);
        values.put(Food_Solids, value5);
        values.put(Hemoglobin, value6);
        values.put(Health_Service, value7);
        db.update(TABLE_NAME_Child, values, Mobile + " = ?", new String[]{id});
        db.close();
    }

    public Cursor readAllData()
    {
        String query = "SELECT * FROM " + TABLE_NAME_Child;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null)
        {
            cursor = db.rawQuery(query,null);
        }
        return cursor;
    }
}
