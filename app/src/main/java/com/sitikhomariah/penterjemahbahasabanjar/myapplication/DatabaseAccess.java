package com.sitikhomariah.penterjemahbahasabanjar.myapplication;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.sitikhomariah.penterjemahbahasabanjar.myapplication.entity.Subjek;

import java.util.ArrayList;
import java.util.List;

public class DatabaseAccess {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database;
    private static DatabaseAccess instance;

    /**
     * Private constructor to aboid object creation from outside classes.
     *
     * @param context
     */
    private DatabaseAccess(Context context) {
        this.openHelper = new DatabaseOpenHelper(context);
    }

    /**
     * Return a singleton instance of com.sitikhomariah.penterjemahbahasabanjar.penterjemahbahasa.DatabaseAccess.
     *
     * @param context the Context
     * @return the instance of DabaseAccess
     */
    public static DatabaseAccess getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseAccess(context);
        }
        return instance;
    }

    /**
     * Open the database connection.
     */
    public void open() {
        this.database = openHelper.getWritableDatabase();
    }

    /**
     * Close the database connection.
     */
    public void close() {
        if (database != null) {
            this.database.close();
        }
    }

    /**
     * Read all quotes from the database.
     *
     * @return a List of quotes
     */
    public List<Subjek> cekSubjekBanjar(String kata) {
        List<Subjek> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM SUBJEK where Banjar ="+kata.toLowerCase(), null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            list.add(new Subjek(cursor.getInt(0), cursor.getString(1), cursor.getString(2)));
            cursor.moveToNext();
        }

        cursor.close();
        return list;
    }

    public List<String> cekSubjekBanjadr(String kata) {
        List<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM SUBJEK where Banjar ="+kata.toLowerCase(), null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            list.add(cursor.getString(0));
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }
}
