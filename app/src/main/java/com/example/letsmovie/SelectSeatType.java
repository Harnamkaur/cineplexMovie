package com.example.letsmovie;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class SelectSeatType extends AppCompatActivity implements View.OnClickListener {

    ViewGroup layout;

    String seats = "AAAAAAAAAA_/"
            + "_________________/"
            + "UUAAAAAAAA_/"
            + "_________________/"
            + "UUAAUUAAAA_/"
            + "_________________/"
            + "UUAAAUAAAA_/"
            + "_________________/";

    List<TextView> seatViewList = new ArrayList<>();
    int seatSize = 100;
    int seatGaping = 10;

    int STATUS_AVAILABLE = 1;
    int STATUS_BOOKED = 2;
    int count1 = 0;
    int clickcount = 0;

    String seletedcount = "";

    String[] seatsselected = {};
    String selectedIds = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_seat_type);

        TextView textView = findViewById(R.id.seattypename);
        TextView textView1 = findViewById(R.id.timeseat);

        Intent intent = getIntent();
        textView.setText(intent.getStringExtra("name"));
        textView1.setText(intent.getStringExtra("time"));

        layout = findViewById(R.id.layoutSeat);

        seats = "/" + seats;

        LinearLayout layoutSeat = new LinearLayout(this);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutSeat.setOrientation(LinearLayout.VERTICAL);
        layoutSeat.setLayoutParams(params);
        layoutSeat.setPadding(8 * seatGaping, 8 * seatGaping, 8 * seatGaping, 8 * seatGaping);
        layout.addView(layoutSeat);

        LinearLayout layout = null;

        int count = 0;

        for (int index = 0; index < seats.length(); index++) {
            if (seats.charAt(index) == '/') {
                layout = new LinearLayout(this);
                layout.setOrientation(LinearLayout.HORIZONTAL);
                layoutSeat.addView(layout);
            } else if (seats.charAt(index) == 'U') {
                count++;
                TextView view = new TextView(this);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(seatSize, seatSize);
                layoutParams.setMargins(seatGaping, seatGaping, seatGaping, seatGaping);
                view.setLayoutParams(layoutParams);
                view.setPadding(0, 0, 0, 2 * seatGaping);
                view.setId(count);
                view.setGravity(Gravity.CENTER);
                view.setBackgroundResource(R.drawable.ic_seats_booked);
                view.setTextColor(Color.WHITE);
                view.setTag(STATUS_BOOKED);
                view.setText(count + "");
                view.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 9);
                layout.addView(view);
                seatViewList.add(view);
                view.setOnClickListener(this);
            } else if (seats.charAt(index) == 'A') {
                count++;
                TextView view = new TextView(this);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(seatSize, seatSize);
                layoutParams.setMargins(seatGaping, seatGaping, seatGaping, seatGaping);
                view.setLayoutParams(layoutParams);
                view.setPadding(0, 0, 0, 2 * seatGaping);
                view.setId(count);
                view.setGravity(Gravity.CENTER);
                view.setBackgroundResource(R.drawable.ic_seats_book);
                view.setText(count + "");
                view.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 9);
                view.setTextColor(Color.BLACK);
                view.setTag(STATUS_AVAILABLE);
                layout.addView(view);
                seatViewList.add(view);
                view.setOnClickListener(this);
//            } else if (seats.charAt(index) == 'R') {
//                count++;
//                TextView view = new TextView(this);
//                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(seatSize, seatSize);
//                layoutParams.setMargins(seatGaping, seatGaping, seatGaping, seatGaping);
//                view.setLayoutParams(layoutParams);
//                view.setPadding(0, 0, 0, 2 * seatGaping);
//                view.setId(count);
//                view.setGravity(Gravity.CENTER);
//                view.setBackgroundResource(R.drawable.ic_seats_reserved);
//                view.setText(count + "");
//                view.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 9);
//                view.setTextColor(Color.WHITE);
//                view.setTag(STATUS_RESERVED);
//                layout.addView(view);
//                seatViewList.add(view);
//                view.setOnClickListener(this);
            } else if (seats.charAt(index) == '_') {
                TextView view = new TextView(this);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(seatSize, seatSize);
                layoutParams.setMargins(seatGaping, seatGaping, seatGaping, seatGaping);
                view.setLayoutParams(layoutParams);
                view.setBackgroundColor(Color.TRANSPARENT);
                view.setText("");
                layout.addView(view);
            }
        }
    }






    @Override
    public void onClick(View view) {

            clickcount++;

            count1 = clickcount;
//
//            System.out.println(count);

        if ((int) view.getTag() == STATUS_AVAILABLE) {
            if (selectedIds.contains(view.getId() + ",")) {
                selectedIds = selectedIds.replace(+view.getId() + ",", "");
                view.setBackgroundResource(R.drawable.ic_seats_book);







                String want = selectedIds;



                int selectedeseat = view.getId();


                System.out.println(selectedeseat);

                Toast.makeText(this, "seat" + seats + "is available", Toast.LENGTH_SHORT).show();

            } else {
                selectedIds = selectedIds + view.getId() + ",";
                view.setBackgroundResource(R.drawable.ic_seats_selected);


            }
        } else if ((int) view.getTag() == STATUS_BOOKED) {
            Toast.makeText(this, "Seat " + view.getId() + " is Booked", Toast.LENGTH_SHORT).show();


        }

    }
    public void bookSeats(View view)

    {




        System.out.println(count1);




        Intent i = new Intent(SelectSeatType.this, ConfirmationActivity.class);
        i.putExtra("seatslist",selectedIds);
        i.putExtra("seatprice",count1);
        startActivity(i);

    }


}



