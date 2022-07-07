package com.example.tourguide;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class dbmanager extends SQLiteOpenHelper {
    private static String dbname="tourist.db";
    public dbmanager(@Nullable Context context) {
        super(context,dbname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String qry = "create table Tourist(username TEXT primary key,password TEXT)";
        db.execSQL(qry);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Tourist");
        onCreate(db);

    }
    public  Boolean inserData(String username , String password){
        SQLiteDatabase db  = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username",username);
        contentValues.put("password",password);
        long result = db.insert("Tourist",null,contentValues);
        if (result==-1) return  false;
        else
            return true;
    }
    public Boolean checkusername(String username){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from Tourist where username= ?",new String[]{username});
        if(cursor.getCount()>0)
            return  true;
        else return  false;
    }
    public Boolean checkusernamepassword(String username, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from Tourist where username=? and password=?",new String[]{username,password});
        if(cursor.getCount()>0)
        return true;
        else
            return false;
    }
//    public String addRecord(String t1, String t2){
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues cv= new ContentValues();
//        cv.put("EMAIL",t1);
//        cv.put("PASSWORD",t2);
//        long res = db.insert("TBL_TOURIST",null,cv);
//        if (res==-1)
//            return "failed";
//        else
//            return "sucessfully";
//    }
}
