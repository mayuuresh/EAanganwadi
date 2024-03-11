package com.example.aahaarapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

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
    public MyDBHelperPregnantWomen(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query_reg = "CREATE TABLE " + TABLE_NAME_Reg + " ("
                + mobileNo + " TEXT PRIMARY KEY, "
                + name + "TEXT" + dob + "TEXT" + yob + "TEXT"
                + pregnancy + " TEXT"+miscarriage+"TEXT)";
        db.execSQL(query_reg);

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
        db.insert(TABLE_NAME_Reg, null, values);
        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public Cursor readAllData()
    {
        String query = "SELECT * FROM " + TABLE_NAME_Reg;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null)
        {
            cursor = db.rawQuery(query,null);
        }
        return cursor;
    }
}
