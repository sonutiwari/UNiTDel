package com.ikai.unitdel;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by ankor on 11/15/2017.
 */

public class BillDetails extends MainActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bill_details);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        // Capture the layout's TextView and set the string as its text
        TextView textView =(TextView) findViewById(R.id.consumer_name);
        textView.setText(message);
    }
}
