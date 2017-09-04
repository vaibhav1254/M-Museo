package com.example.pd_pc.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by _vaibbhavv_ on 8/30/2017.
 */

public class TravellerDBHelper {

    public final String DATABASE_NAME = "students.db";
    public final int DATABASE_VERSION = 1;
    public final String TABLE_NAME = "student";
    public final String COLUMN_ID = "id";
    public final String COLUMN_NAME = "name";
    public final String COLUMN_NUMBER = "number";
    public final String COLUMN_EMAIL = "email";
    public final String COLUMN_PASSWORD = "password";
    public final String COLUMN_CONFIRMPASSWORD = "confirmpassword";


    public final String CREATE_TABLE = "create table " + TABLE_NAME + " ( " + COLUMN_ID + " integer auto_increment," + COLUMN_NAME + " text," + COLUMN_NUMBER + " text," + COLUMN_EMAIL + " text," + COLUMN_PASSWORD + " text," + COLUMN_CONFIRMPASSWORD + " text);";


    TravellerOpenHelper openHelper;
    Context context;
    SQLiteDatabase db;

    public TravellerDBHelper(Context context) {
        this.context = context;
        openHelper = new TravellerOpenHelper(context);
        db = openHelper.getWritableDatabase();
    }

    // add new traveller to table

    public void addTraveller(Traveller traveller) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, traveller.getName());
        values.put(COLUMN_NUMBER, traveller.getNumber());
        values.put(COLUMN_EMAIL, traveller.getEmail());
        values.put(COLUMN_PASSWORD, traveller.getPassword());
        values.put(COLUMN_CONFIRMPASSWORD, traveller.getConfirmpassword());

        long response = db.insert(TABLE_NAME,null,values);
        if (response != -1) {
            if (COLUMN_NAME.toString().length()!=0 && COLUMN_NUMBER.toString().length()!=0 && COLUMN_EMAIL.toString().length()!=0 && COLUMN_PASSWORD.toString().length()!=0 && COLUMN_CONFIRMPASSWORD.toString().length()!=0){
                Toast.makeText(context, "Added Successfully", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(context, "Something went wrong", Toast.LENGTH_SHORT).show();
        }
    }


    // Get Password by name

    String getPassword(String name) {

        Cursor cursor = db.query(TABLE_NAME, null, COLUMN_NAME + "=?", new String[]{name}, null, null, null);
        if (cursor != null && cursor.moveToFirst()) {

            return cursor.getString(cursor.getColumnIndex(COLUMN_PASSWORD));
        } else {
            return null;
        }
    }
        // Inner Class
        class TravellerOpenHelper extends SQLiteOpenHelper {


            public TravellerOpenHelper(Context context) {
                super(context, DATABASE_NAME, null, DATABASE_VERSION);
            }

            @Override
            public void onCreate(SQLiteDatabase db) {

                db.execSQL(CREATE_TABLE);
            }

            @Override
            public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

            }


        }

    }
