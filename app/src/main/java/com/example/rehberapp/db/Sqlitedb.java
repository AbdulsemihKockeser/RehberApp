package com.example.rehberapp.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.rehberapp.model.User;

import java.util.ArrayList;
import java.util.List;

public class Sqlitedb extends SQLiteOpenHelper {

    final static String DATABASE_NAME = "rehberdb";
    final static int VERSION = 1;
    final static String TABLE_USER = "user";
    final static String ID = "ID";
    final static String AD = "AD";
    final static String SOYAD = "SOYAD";
    final static String TELEFON_NO = "TELEFON_NO";
    final static String FAX = "FAX";
    final static String ADRES = "ADRES";
    final static String FOTO = "FOTO";

    List<User> list;

    public Sqlitedb(@Nullable Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_USER + "(" +
                ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                AD + " TEXT," +
                SOYAD + " TEXT," +
                TELEFON_NO + " TEXT," +
                FAX + " TEXT," +
                ADRES + " TEXT," +
                FOTO + " INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        onCreate(db);
    }


    public List<User> getList() {
        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_USER, null);

        list = new ArrayList<>();

        if (cursor.moveToFirst()) {
            do {
                list.add(new User(cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4),
                        cursor.getString(5),
                        cursor.getInt(6)));
            } while (cursor.moveToNext());

        }
        cursor.close();

        return list;
    }

    public void addUser(User user) {

        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(AD, user.getAd());
        values.put(SOYAD, user.getSoyad());
        values.put(TELEFON_NO, user.getTelefonNo());
        values.put(FAX, user.getFax());
        values.put(ADRES, user.getAdress());
        values.put(FOTO, user.getFoto());

        db.insert(TABLE_USER, null, values);
    }


    public void updateUser(User user) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(AD, user.getAd());
        values.put(SOYAD, user.getSoyad());
        values.put(TELEFON_NO, user.getTelefonNo());
        values.put(FAX, user.getFax());
        values.put(ADRES, user.getAdress());
        values.put(FOTO, user.getFoto());
        db.update(TABLE_USER, values, ID + " = ?", new String[]{String.valueOf(user.getID())});
    }

    public void DeleteUser(User user) {
        SQLiteDatabase db = getWritableDatabase();
        db.delete(TABLE_USER, ID + "= ?", new String[]{String.valueOf(user.getID())});
    }

}
