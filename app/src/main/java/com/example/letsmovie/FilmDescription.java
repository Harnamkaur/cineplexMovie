package com.example.letsmovie;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class FilmDescription extends AppCompatActivity  {

    TextView FileTitle, FileDuration;
    ImageButton imgbutton , imgbutton2;
String Name, Time;
    private Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film_description);


        Intent intent= getIntent();
         Name = intent.getStringExtra("name");
         Time = intent.getStringExtra("time");
        String Synopsis = intent.getStringExtra("synopsis");
        String Cast = intent.getStringExtra("cast");



        TextView textView =findViewById(R.id.FilmText);
        TextView textView1 =findViewById(R.id.SetTime);
        TextView textView2 =findViewById(R.id.synopsis);
        TextView textView3 =findViewById(R.id.cast);

        textView.setText(Name);
        textView1.setText(Time);
        textView2.setText(Synopsis);
        textView3.setText(Cast);


        imgbutton = (ImageButton) findViewById(R.id.playTrailer);
//        imgbutton.setOnClickListener(new View.OnClickListener() {
//          @Override
//          public void onClick(View view) {
//              switch (view.getId())
//              {
//
//              }
//        }
//    });
       Bundle bundle = getIntent().getExtras();
       if (bundle!= null)
       {

          int image = bundle.getInt("image");
           imgbutton.setImageResource(image);

       }




    }
    public void bookFilm(View view) {
        Intent i = new Intent(FilmDescription.this,SelectSeatType.class);
        i.putExtra("name",Name);
        i.putExtra("time",Time);

        startActivity(i);
    }

    public void trailerplay(View view) {

        Intent i = new Intent(FilmDescription.this,YoutubeVideos.class);
        i.putExtra("name",Name);
        startActivity(i);
    }



}
