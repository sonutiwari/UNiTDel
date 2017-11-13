package com.ikai.unitdel;

import android.app.Fragment;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by shiv on 13/11/17.
 */

public class SplashWelcomeMessage extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.splash_welcome_message_card_fragment, null);
        Context activityContext = getActivity();
        SQLiteHandler sqliteHandler = new SQLiteHandler(activityContext);
        SQLiteDatabase database = sqliteHandler.getReadableDatabase();
        Cursor cursor = null;
        boolean openThisFragment = false;
        try{
            cursor = database.query(SQLiteHandler.TABLE_NAME, null, null, null, null, null, null);
            cursor.moveToNext();
            if(cursor.getCount() > 0) {
                openThisFragment = true;
                String name = cursor.getString(cursor.getColumnIndex(SQLiteHandler.NAME));
                TextView username = (TextView)view.findViewById(R.id.user_name);
                Date d=new Date();
                SimpleDateFormat sdf=new SimpleDateFormat("hh:mm a");
                String currentDateTimeString = sdf.format(d);
                getWishingMessageId(currentDateTimeString);
            }
        } catch (Exception e) {

        } finally {
            if (cursor != null) {

            }
        }
        return view;
    }
    // Not implemented yet.
    private int getWishingMessageId(String timeString) {
        int id = 1;
        return id;
    }
}
