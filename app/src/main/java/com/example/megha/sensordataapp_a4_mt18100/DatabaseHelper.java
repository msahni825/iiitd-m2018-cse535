package com.example.megha.sensordataapp_a4_mt18100;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.hardware.Sensor;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Sensor.db";
    private static final String TABLE_SENSOR_ACC = "Accelerometer";
    private static final String TABLE_SENSOR_GYR = "Gyroscope";
    private static final String TABLE_SENSOR_ORI = "Orientation";
    private static final String TABLE_SENSOR_PRO = "Proximity";
    private static final String KEY_ID = "id";
    private static final String KEY_X = "";
    private static final String KEY_Y = "";
    private static final String KEY_Z = "";
    private static final String TIMESTAMP = "";

    private SQLiteDatabase dbase;

    public DatabaseHelper(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        dbase=this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {
        dbase = sqLiteDatabase;
        String acctable= "CREATE TABLE " + TABLE_SENSOR_ACC + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + KEY_X + " TEXT1, "
                + KEY_Y + " TEXT2, "
                + KEY_Z + "TEXT3, "
                + TIMESTAMP + "TIMESTAMP )";

        String gyrotable = "CREATE TABLE IF NOT EXISTS " + TABLE_SENSOR_GYR + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_X
                + " TEXT1, " + KEY_Y + " TEXT2, " + KEY_Z + "TEXT3, " + TIMESTAMP + "DATETIME)";
        String oritable = "CREATE TABLE IF NOT EXISTS " + TABLE_SENSOR_ORI + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_X
                + " TEXT1, " + KEY_Y + " TEXT2, " + KEY_Z + "TEXT3, " + TIMESTAMP + "DATETIME)";
        String protable = "CREATE TABLE IF NOT EXISTS " + TABLE_SENSOR_PRO + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_X
                + " TEXT1, " + KEY_Y + " TEXT2, " + KEY_Z + "TEXT3, " + TIMESTAMP + "DATETIME)";
        sqLiteDatabase.execSQL(acctable);
        sqLiteDatabase.execSQL(gyrotable);
        sqLiteDatabase.execSQL(oritable);
        sqLiteDatabase.execSQL(protable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1)
    {
        dbase.execSQL("DROP TABLE IF EXISTS " + TABLE_SENSOR_ACC);
        dbase.execSQL("DROP TABLE IF EXISTS " + TABLE_SENSOR_GYR);
        dbase.execSQL("DROP TABLE IF EXISTS " + TABLE_SENSOR_ORI);
        dbase.execSQL("DROP TABLE IF EXISTS " + TABLE_SENSOR_PRO);
        onCreate(dbase);
    }

    public void updatecolAcc(String x, String y, String z)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues c = new ContentValues();
        c.put(KEY_X , x);
        c.put(KEY_Y , y);
        c.put(KEY_Z , z);
//        c.put(TIMESTAMP , t);
//        String s = "" + id ;
        db.insert(TABLE_SENSOR_ACC , null , c);
        //db.update(TABLE_SENSOR_ACC, c ,KEY_X + " = ?" + "&&" + KEY_Y + " = ?" + "&&" + KEY_Z + " = ?" , new String[] {x , y , z});
        db.close();
    }
    public void updatecolGyr(int id , String x, String y, String z, String time)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues c = new ContentValues();
        c.put(KEY_X , x);
        c.put(KEY_Y , y);
        c.put(KEY_Z , z);
        c.put(TIMESTAMP , time);
        String s = "" + id ;
        db.insert(TABLE_SENSOR_GYR , s , c);
        db.close();
    }
    public void updatecolOri(int id , String x, String y, String z , String time)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues c = new ContentValues();
        c.put(KEY_X , x);
        c.put(KEY_Y , y);
        c.put(KEY_Z , z);
        c.put(TIMESTAMP , time);
        String s = "" + id ;
        db.insert(TABLE_SENSOR_ORI , s , c);
        db.close();
    }
    public void updatecolPro(int id , String x, String y, String z , String time)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues c = new ContentValues();
        c.put(KEY_X , x);
        c.put(KEY_Y , y);
        c.put(KEY_Z , z);
        c.put(TIMESTAMP , time);
        String s = "" + id ;
        db.insert(TABLE_SENSOR_PRO , s , c);
        db.close();
    }
}
