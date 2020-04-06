package com.example.letsmovie;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ConfirmationActivity extends AppCompatActivity {


    String seatvalue;
    int countval;
    int price;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);


        Intent i = getIntent();

        seatvalue = i.getStringExtra("seatslist");
        countval = i.getIntExtra("seatprice",1);

        price = countval * 7 ;

        TextView textView = findViewById(R.id.Seatnos);
        TextView textView3 = findViewById(R.id.price);

        textView.setText(seatvalue);
        textView3.setText(String.valueOf(price));





    }

    public void getdirections(View view) {

        Intent i = new Intent(ConfirmationActivity.this,MapsActivity.class);
        startActivity(i);
    }

    public void backtomain(View view) {
        Intent i = new Intent(ConfirmationActivity.this,MainActivity.class);
        startActivity(i);
    }
}
