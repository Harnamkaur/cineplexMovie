package com.example.letsmovie;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class ConfirmationActivity extends AppCompatActivity {


    String seatvalue;
    int countval;
    int price;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);
//add back button
getSupportActionBar().setDisplayShowHomeEnabled(true);
getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Intent i = getIntent();

        seatvalue = i.getStringExtra("seatslist");
        countval = i.getIntExtra("seatprice",1);

        price = countval * 7 ;

        TextView textView = findViewById(R.id.Seatnos);
        TextView textView3 = findViewById(R.id.price);

        textView.setText(seatvalue);
        textView3.setText(String.valueOf(price));





    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id =item.getItemId();
        if (id ==android.R.id.home){
            //ends the activity
            this.finish();
        }

        return super.onOptionsItemSelected(item);
    }

    public void onBackPressed()
    {
        super.onBackPressed();
        startActivity(new Intent(ConfirmationActivity.this, MainActivity.class));
        finish();

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
