package com.example.aahaarapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDBHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "Issues";
    private static final int DB_VERSION = 1;

    //Issues Database
    private static final String TABLE_NAME = "issues";
    private static final String ID_COL = "id";
    private static final String NAME_COL = "name";
    private static final String Mobile_COL = "mobile";
    private static final String Email_COL = "email";
    private static final String Subject_COL = "subject";
    private static final String Issue_COL = "issue";

    //Register Database
    private static final String TABLE_NAME_Reg = "register";
    private static final String Mobile_Number = "number";
    private static final String MPIN = "mpin";




    public MyDBHelper(Context context) {
        super(context, DB_NAME , null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Issues Database
        String queryIssues = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME_COL + " TEXT,"
                + Mobile_COL + " TEXT,"
                + Email_COL + " TEXT,"
                + Subject_COL + " TEXT,"
                + Issue_COL + " TEXT)";
        db.execSQL(queryIssues);

        // Create Register Database
        String queryRegister = "CREATE TABLE " + TABLE_NAME_Reg + " ("
                + Mobile_Number + " TEXT PRIMARY KEY, "
                + MPIN + " TEXT)";
        db.execSQL(queryRegister);


    }

    public void addNewCourse(String name, String mobile, String email, String subject,String issue) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME_COL, name);
        values.put(Mobile_COL, mobile);
        values.put(Email_COL, email);
        values.put(Subject_COL, subject);
        values.put(Issue_COL, issue);
        db.insert(TABLE_NAME, null, values);
        db.close();
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
