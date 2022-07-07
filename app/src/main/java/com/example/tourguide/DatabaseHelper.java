//package com.example.tourguide;
//
//import android.content.ContentValues;
//import android.content.Context;
//import android.database.Cursor;
//import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteOpenHelper;
//
//import androidx.annotation.Nullable;
//
//public class DatabaseHelper extends SQLiteOpenHelper {
//    public DatabaseHelper(@Nullable Context context) {
//        super(context, "login.db" ,null, 1);
//    }
//
//    @Override
//    public void onCreate(SQLiteDatabase db) {
//        db.execSQL("CREATE TABLE Tourist(email TEXT PRIMARY KEY ,password TEXT)");
//
//    }
//
//    @Override
//    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        db.execSQL("DROP TABLE IF EXISTS Tourist");
//
//    }
//    public Boolean insertData(String email , String password){
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues contentValues = new ContentValues();
//        contentValues.put("email",email);
//        contentValues.put("password",password);
//        long result = db.insert("Tourist",null,contentValues);
//        if (result==-1){
//            return false;
//        }else {
//            return true;
//        }
//
//
//    }
//    public Boolean checkemailpassword(String email , String password){
//        SQLiteDatabase db = this.getWritableDatabase();
//        Cursor cursor = db.rawQuery("SELECT*FROM Tourist WHERE email = ? AND password=?",new String[]{email,password} );
//        if (cursor.getCount()>0){
//            return true;
//        }else {
//            return false;
//        }
//    }
//}
