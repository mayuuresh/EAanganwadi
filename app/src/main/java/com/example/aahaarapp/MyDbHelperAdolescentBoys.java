package com.example.aahaarapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class MyDbHelperAdolescentBoys extends SQLiteOpenHelper {

    private static final String DB_NAME = "AdolescentBoys";
    private static final int DB_VERSION = 1;

    private static final String TABLE_NAME = "Adolescentboys";
    private static final String name = "Name";
    private static final String dob = "Dob";
    private static final String yob = "Yob";
    private static final String father = "Father";
    private static final String mother = "Mother";

    private static final String mobileNo = "Mobile_No";
    private static final String supplement = "Supplement";
    private static final String energy = "Energy";
    private static final String protin = "Protin";
    private static final String fat = "Fat";
    private static final String solids = "Food_Solids";
    private static final String hemo = "Hemoglobin";
    private static final String service = "Service";
    private static final String vaccination = "Vaccination";


    public MyDbHelperAdolescentBoys(@Nullable Context context) {
        super(context,DB_NAME,null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query_reg = "CREATE TABLE " + TABLE_NAME + " ("
                + mobileNo + " TEXT PRIMARY KEY, "
                + name + " TEXT, "
                + dob + " TEXT, "
                + yob + " TEXT, "
                + father + " TEXT, "
                + mother + " TEXT, "
                + supplement + " TEXT, "
                + energy + " TEXT, "
                + protin + " TEXT, "
                + fat + " TEXT, "
                + solids + " TEXT, "
                + hemo + " TEXT, "
                + service + " TEXT, "
                + vaccination + " TEXT )";

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
        values.put(supplement," ");
        values.put(energy," ");
        values.put(protin," ");
        values.put(fat," ");
        values.put(solids," ");
        values.put(hemo," ");
        values.put(service," ");
        values.put(vaccination," ");

        db.insert(TABLE_NAME, null, values);
        db.close();
    }
    public void updateColumns(String id,String cycle1, String iron1, String hemo1, String serrvice1, String unit1, String height1, String weight1, String item)
    {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(supplement,cycle1);
        values.put(energy,iron1);
        values.put(protin,hemo1);
        values.put(fat,serrvice1);
        values.put(solids,unit1);
        values.put(hemo,height1);
        values.put(service,weight1);
        values.put(vaccination,item);

        db.update(TABLE_NAME, values, mobileNo + " = ?", new String[]{id});
        db.close();
    }
    public Cursor readAllData(String number)
    {
        String query = "SELECT * FROM " + TABLE_NAME + " WHERE " + mobileNo + " = " + number;
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
        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query,null);
        return cursor;
    }
}
