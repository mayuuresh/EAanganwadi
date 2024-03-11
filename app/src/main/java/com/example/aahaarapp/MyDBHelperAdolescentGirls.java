package com.example.aahaarapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDBHelperAdolescentGirls extends SQLiteOpenHelper {

    private static final String DB_NAME = "AdolescentGirls";
    private static final int DB_VERSION = 1;

    private static final String TABLE_NAME = "Adolescentgirls";
    private static final String name = "Name";
    private static final String dob = "Dob";
    private static final String yob = "Yob";
    private static final String father = "Father";
    private static final String mother = "Mother";

    private static final String mobileNo = "Mobile_No";
    public MyDBHelperAdolescentGirls(@Nullable Context context) {
        super(context,DB_NAME,null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query_reg = "CREATE TABLE " + TABLE_NAME + " ("
                + mobileNo + " TEXT PRIMARY KEY, "
                + name + "TEXT" + dob + "TEXT" + yob + "TEXT"
                + father + " TEXT"+mother+"TEXT)";
        db.execSQL(query_reg);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public void registeruser(String name1,String dob1,String yob1,String mobile1,String father,String mother)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(mobileNo, mobile1);
        values.put(name,name1 );
        values.put(dob,dob1);
        values.put(yob,yob1);
        values.put(father,father);
        values.put(mother,mother);
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public Cursor readAllData()
    {
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null)
        {
            cursor = db.rawQuery(query,null);
        }
        return cursor;
    }
}
