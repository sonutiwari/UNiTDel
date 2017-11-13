package com.ikai.unitdel;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by shiv on 12/11/17.
 */

class SQLiteHandler extends SQLiteOpenHelper {
    public final static String TABLE_NAME  = "user_info";
    public final static String NAME  = "name";
    public final static String MOBILE_NO = "mobile_no" ;
    public final static int ID = 1;
    public SQLiteHandler(Context context) {
        super(context,"user.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "create table " + TABLE_NAME +" ( " + ID +
                " integer primary key autoincrement, "
                + NAME +" text, "
                + MOBILE_NO + " text);";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
