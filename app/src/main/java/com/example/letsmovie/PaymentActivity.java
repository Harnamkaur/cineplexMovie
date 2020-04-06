package com.example.letsmovie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Arrays;

public class PaymentActivity extends AppCompatActivity {

    String seatvalue;
    int countval;
    int price;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        Intent i = getIntent();

        seatvalue = i.getStringExtra("seatslist");
        countval = i.getIntExtra("seatprice",1);

        price = countval * 7 ;

        TextView textView = findViewById(R.id.seattext3);
        TextView textView3 = findViewById(R.id.seatprice);

        textView.setText(seatvalue);
        textView3.setText(String.valueOf(price));




    }
}
