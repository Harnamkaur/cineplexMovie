package com.example.letsmovie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SelectCinemaSeat extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_cinema_seat);
    }

    public void reserve(View view) {
        Intent i = new Intent(SelectCinemaSeat.this,SelectSeatType.class);
      startActivity(i);

    }
}
