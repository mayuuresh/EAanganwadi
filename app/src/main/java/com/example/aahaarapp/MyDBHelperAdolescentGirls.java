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
    private static final String cycle = "Cycle";
    private static final String iron = "Iron";
    private static final String hemo = "Hemoglobin";
    private static final String serrvice = "Service";
    private static final String unit = "Height_Unit";
    private static final String height = "Height";
    private static final String weight = "Weight";


    public MyDBHelperAdolescentGirls(@Nullable Context context) {
        super(context,DB_NAME,null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query_reg = "CREATE TABLE " + TABLE_NAME + " ("
                + mobileNo + " TEXT PRIMARY KEY, "
                + name + "TEXT" + dob + "TEXT" + yob + "TEXT"
                + father + " TEXT"+mother+"TEXT"+cycle+"TEXT"+iron+"TEXT"+hemo+"TEXT"+serrvice+"TEXT"+unit+"TEXT"+weight+"TEXT)";
        db.execSQL(query_reg);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public void registeruser(String name1,String dob1,String yob1,String mobile1,String father1,String mother1)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(mobileNo, mobile1);
        values.put(name,name1 );
        values.put(dob,dob1);
        values.put(yob,yob1);
        values.put(father,father1);
        values.put(mother,mother1);
        values.put(cycle,"");
        values.put(iron,"");
        values.put(hemo,"");
        values.put(serrvice,"");
        values.put(unit,"");
        values.put(height,"");
        values.put(weight,"");

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
    public void updateColumns(String id,String cycle1,
                             String iron1,String hemo1,String serrvice1,String unit1,String height1,String weight1)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(cycle,cycle1);
        values.put(iron,iron1);
        values.put(hemo,hemo1);
        values.put(serrvice,serrvice1);
        values.put(unit,unit1);
        values.put(height,height1);
        values.put(weight,weight1);

        db.update(TABLE_NAME, values, mobileNo + " = ?", new String[]{id});
        db.close();
    }
}
