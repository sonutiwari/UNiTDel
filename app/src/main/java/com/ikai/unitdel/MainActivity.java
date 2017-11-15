package com.ikai.unitdel;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.ikai.unitdel.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //// TODO: 11/15/2017  create function to talk with other views
    public void sendMessage(View view){
        //response onclick
        Intent intent = new Intent(this, BillDetails.class);
        TextView textView = (TextView) findViewById(R.id.consumer_name);
        String message = textView.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}
