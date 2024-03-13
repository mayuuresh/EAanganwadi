package com.example.aahaarapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDbHelperAwc extends SQLiteOpenHelper {

    private static final String DB_NAME = "Awc";
    private static final int DB_VERSION = 1;

    private static final String TABLE_NAME_awc = "awc";
    private static final String date = "date";
    private static final String time = "time";
    public MyDbHelperAwc(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override

        public void onCreate(SQLiteDatabase db) {
            String query_awc = "CREATE TABLE " + TABLE_NAME_awc + " ("
                    + time + " TEXT PRIMARY KEY , "
                    + date + " TEXT ) ";

            db.execSQL(query_awc);
        }



public MyDbHelperAwc(@Nullable Context context)
    {
        super(context,DB_NAME,null,DB_VERSION);

    }

    public void dateTime(String date1,String time1)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(date, date1);
        values.put(time, time1);
        db.insert(TABLE_NAME_awc, null, values);
        db.close();
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public Cursor viewData()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME_awc;
        Cursor cursor = db.rawQuery(query,null);
        return cursor;
    }
}
