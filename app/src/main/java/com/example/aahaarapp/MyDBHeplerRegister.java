package com.example.aahaarapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDBHeplerRegister extends SQLiteOpenHelper {

    private static final String DB_NAME = "Register";
    private static final int DB_VERSION = 1;

    private static final String TABLE_NAME_Reg = "register";
    private static final String Mobile_Number = "number";
    private static final String MPIN = "mpin";


    public MyDBHeplerRegister(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String query_reg = "CREATE TABLE " + TABLE_NAME_Reg + " ("
                + Mobile_Number + " TEXT PRIMARY KEY, "
                + MPIN + " TEXT)";

        db.execSQL(query_reg);

    }
    public void registeruser(String mobile,String mpin)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Mobile_Number, mobile);
        values.put(MPIN, mpin);
        db.insert(TABLE_NAME_Reg, null, values);
        db.close();
    }

    public Boolean checkNumber(String number)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from "+TABLE_NAME_Reg+" where "+Mobile_Number+" = ?",new String[]{number});

        if(cursor.getCount()>0)
        {
            return true;
        }
        else {
            return false;
        }
    }

    public Boolean checkmpin(String number,String mpin)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from "+TABLE_NAME_Reg+" where "+Mobile_Number+" = ? and "+MPIN+" = ?",new String[]{number,mpin});

        if(cursor.getCount()>0)
        {
            return true;
        }
        else {
            return false;
        }
    }

    public int updatePassword(String number, String mpin) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(MPIN, mpin);

        // Updating row(s) where username matches
        int rowsAffected = db.update(TABLE_NAME_Reg, values, Mobile_Number + " = ?", new String[]{number});
        db.close();
        return rowsAffected;

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


}
