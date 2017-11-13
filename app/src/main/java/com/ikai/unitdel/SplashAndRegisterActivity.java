package com.ikai.unitdel;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;


public class SplashAndRegisterActivity extends AppCompatActivity {

    private static boolean OPEN_WELCOME_FRAGMENT = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_and_register);

        // Code to set custom text font style from assets folder.
        Typeface typeface = Typeface.createFromAsset(getAssets(),
                "SilentReaction.ttf");
        ((TextView) this.findViewById(R.id.slogan)).setTypeface(typeface);



    }

}
