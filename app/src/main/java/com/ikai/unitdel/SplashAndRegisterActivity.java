package com.ikai.unitdel;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class SplashAndRegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_and_register);

        // Code to set custom text font style from assets folder.
        Typeface typeface = Typeface.createFromAsset(getAssets(),
                "SilentReaction.ttf");
        ((TextView) this.findViewById(R.id.slogan)).setTypeface(typeface);

        // Run Database check up to ensure whether user is availabke in database
        // or not to know whether to show welcome screen or register screen
        SQLiteHandler sqliteHandler = new SQLiteHandler(this);
        SQLiteDatabase database = sqliteHandler.getReadableDatabase();
        Cursor cursor = null;

        try{
            cursor = database.query(SQLiteHandler.TABLE_NAME, null, null, null, null, null, null);
            cursor.moveToNext();
            if(cursor.getCount() > 0) {
                // Get user name from database
                String name = cursor.getString(cursor.getColumnIndex(SQLiteHandler.NAME));

                // Get current Date
                Date d=new Date();
                SimpleDateFormat sdf=new SimpleDateFormat("HH:mm:ss");
                String currentDateTimeString = sdf.format(d);

                // Receive greeting message from the function.
                String greetingMessage = getWishingMessageId(currentDateTimeString);

                // Inflate the register or welcome screen view to insert by checking
                // whether name is present in database or not.

            }
        } catch (Exception e) {
            // Do some appropriate work here like logging.
            Log.d("Cursor Error", "There is some error during cursor getting result.");
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    /**
     *
     * @param timeString This contains the current time as a string.
     * @return It return the id to show the appropriate greeting message like:
     *          1 -> Good Morning
     *          2 -> Good Afternoon
     *          3 -> Good Evening
     *          4 -> Good Night
     */
    private String getWishingMessageId(String timeString) {
        // String that contains the greeting message.
        String greetingMessage = null;

        // Parse the timeString into hours, minutes and seconds.
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        try {
            Date date = dateFormat.parse(timeString);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            int hours = calendar.get(Calendar.HOUR);
            int minutes = calendar.get(Calendar.MINUTE);
            int seconds = calendar.get(Calendar.SECOND);

            // Make greeting string depending on time duration of a day.
            if (isInRange(hours, minutes, seconds, 5, 12)) {
                greetingMessage = "Good Morning";
            } else if (isInRange(hours, minutes, seconds, 12, 18)) {
                greetingMessage = "Good Afternoon";
            } else if (isInRange(hours, minutes, seconds, 18, 22)) {
                greetingMessage = "Good Evening";
            } else {
                greetingMessage = "Good Night";
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return greetingMessage;
    }

    /**
     * @param hours Contains the hours in the current time
     * @param minutes Contains the minutes in the current time
     * @param seconds Contains the seconds in the current time
     * @param min Contains the least minimum possible value.
     * @param max Contains the maximum possible value.
     * @return It return a boolean value whether hours, minutes and seconds are in
     *          that range or not
     */
    private boolean isInRange(int hours, int minutes, int seconds, int min, int max) {
        return (hours >= min) && ((hours < max) |
                (hours == max && minutes == 0 && seconds == 0));
    }
}
