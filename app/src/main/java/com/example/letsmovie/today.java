package com.example.letsmovie;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;



public class today extends Fragment implements View.OnClickListener {

    TextView Filmname, Filmduration,Filmname1, Filmduration1,Filmname2, Filmduration2,Filmname3, Filmduration3,Filmname4, Filmduration4,Filmname5, Filmduration5;
    Button b1,b2,b3,b4,b5,b6;
TextView synopsis1, synopsis2, synopsis3,synopsis4,synopsis5, cast1,cast2,cast3,cast4,cast5;

    ImageButton img1,img2;

   // SendMessage SM;
    public today() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(
                R.layout.fragment_today, container, false);
        return rootView;


        // Inflate the layout for this fragment
    }
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

       b1 = (Button) view.findViewById(R.id.frozenbutton);
        b1.setOnClickListener(this);

        b2 = (Button) view.findViewById(R.id.FordButton);
        b2.setOnClickListener(this);
        b3 = (Button) view.findViewById(R.id.ItButton);
        b3.setOnClickListener(this);

        b4 = (Button) view.findViewById(R.id.Evilbutton);
        b4.setOnClickListener(this);
        b5 = (Button) view.findViewById(R.id.AvengersButton);
        b5.setOnClickListener(this);
        b6 = (Button) view.findViewById(R.id.JokerButton);
        b6.setOnClickListener(this);

        Filmname = (TextView) view.findViewById(R.id.frozentext);
        Filmduration= (TextView) view.findViewById(R.id.frozen2);
        Filmname1 = (TextView) view.findViewById(R.id.fordText);
        Filmduration1= (TextView) view.findViewById(R.id.ford2);
        Filmname2 = (TextView) view.findViewById(R.id.ItText);
        Filmduration2= (TextView) view.findViewById(R.id.It2);
        Filmname3 = (TextView) view.findViewById(R.id.evilText);
        Filmduration3= (TextView) view.findViewById(R.id.evil2);
        Filmname4 = (TextView) view.findViewById(R.id.AvengersText);
        Filmduration4= (TextView) view.findViewById(R.id.Avengers2);
        Filmname5 = (TextView) view.findViewById(R.id.JokerText);
        Filmduration5= (TextView) view.findViewById(R.id.Joker2);








//

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.frozenbutton:
                String Name = Filmname.getText().toString();

                String Time = Filmduration.getText().toString();
//                String Synopsis1 = synopsis1.getText().toString();
//                String Cast1 = cast1.getText().toString();
                Intent i = new Intent(getActivity(),FilmDescription.class);
                i.putExtra("name", Name);
                i.putExtra("time",Time);
                i.putExtra("synopsis","Elsa the Snow Queen has an extraordinary gift -- the power to create ice and snow. But no matter how happy she is to be surrounded by the people of Arendelle, Elsa finds herself strangely unsettled. After hearing a mysterious voice call out to her, Elsa travels to the enchanted forests and dark seas beyond her kingdom -- an adventure that soon turns into a journey of self-discovery.");
                i.putExtra("cast","Kristen Bell as Anna, \n Idina Menzel as Elsa, \n Josh Gad as Olaf, \n Jonathan Groff as Kristoff,\n Sterling K. Brown as Mattias");
                i.putExtra("image",R.drawable.frozentrailer);
                startActivity(i);
                break;

            case R.id.FordButton:
                String Name1 = Filmname1.getText().toString();

                String Time1 = Filmduration1.getText().toString();
                Intent i1 = new Intent(getActivity(),FilmDescription.class);
                i1.putExtra("name", Name1);
                i1.putExtra("time",Time1);
                i1.putExtra("synopsis","American automotive designer Carroll Shelby and fearless British race car driver Ken Miles battle corporate interference, the laws of physics and their own personal demons to build a revolutionary vehicle for the Ford Motor Co. Together, they plan to compete against the race cars of Enzo Ferrari at the 24 Hours of Le Mans in France in 1966.");
                i1.putExtra("cast","\n Christian Bale as Ken Miles," +
                        " \n Matt Damon as Carroll Shelby," +
                        "\n Jon Bernthal as Lee Iacocca," +
                        "\n Caitriona Balfe as Mollie Miles");

                i1.putExtra("image",R.drawable.fordtrailer);
                startActivity(i1);
                break;

            case R.id.ItButton:
                String Name2 = Filmname2.getText().toString();

                String Time2 = Filmduration2.getText().toString();
                Intent i2 = new Intent(getActivity(),FilmDescription.class);
                i2.putExtra("name", Name2);
                i2.putExtra("time",Time2);
                i2.putExtra("synopsis","Elsa the Snow Queen has an extraordinary gift -- the power to create ice and snow. But no matter how happy she is to be surrounded by the people of Arendelle, Elsa finds herself strangely unsettled. After hearing a mysterious voice call out to her, Elsa travels to the enchanted forests and dark seas beyond her kingdom -- an adventure that soon turns into a journey of self-discovery.");
                i2.putExtra("cast","Kristen Bell as Anna, Idina Menzel as Elsa, Josh Gad as Olaf, Jonathan Groff as Kristoff,Sterling K. Brown as Mattias");

                i2.putExtra("image",R.drawable.ittrailer);
                startActivity(i2);
                break;


            case R.id.Evilbutton:
                String Name3 = Filmname3.getText().toString();

                String Time3 = Filmduration3.getText().toString();
                Intent i3 = new Intent(getActivity(),FilmDescription.class);
                i3.putExtra("name", Name3);
                i3.putExtra("time",Time3);
                i3.putExtra("synopsis","Elsa the Snow Queen has an extraordinary gift -- the power to create ice and snow. But no matter how happy she is to be surrounded by the people of Arendelle, Elsa finds herself strangely unsettled. After hearing a mysterious voice call out to her, Elsa travels to the enchanted forests and dark seas beyond her kingdom -- an adventure that soon turns into a journey of self-discovery.");
                i3.putExtra("cast","Kristen Bell as Anna, Idina Menzel as Elsa, Josh Gad as Olaf, Jonathan Groff as Kristoff,Sterling K. Brown as Mattias");

                i3.putExtra("image",R.drawable.mailficienttrailer);
                startActivity(i3);
                break;

            case R.id.AvengersButton:
                String Name4 = Filmname4.getText().toString();

                String Time4 = Filmduration4.getText().toString();
                Intent i4 = new Intent(getActivity(),FilmDescription.class);
                i4.putExtra("name", Name4);
                i4.putExtra("time",Time4);
                i4.putExtra("synopsis","Elsa the Snow Queen has an extraordinary gift -- the power to create ice and snow. But no matter how happy she is to be surrounded by the people of Arendelle, Elsa finds herself strangely unsettled. After hearing a mysterious voice call out to her, Elsa travels to the enchanted forests and dark seas beyond her kingdom -- an adventure that soon turns into a journey of self-discovery.");
                i4.putExtra("cast","Kristen Bell as Anna, Idina Menzel as Elsa, Josh Gad as Olaf, Jonathan Groff as Kristoff,Sterling K. Brown as Mattias");

                i4.putExtra("image",R.drawable.avengerstrailer);
                startActivity(i4);
                break;

            case R.id.JokerButton:
                String Name5 = Filmname5.getText().toString();

                String Time5 = Filmduration5.getText().toString();
                Intent i5 = new Intent(getActivity(),FilmDescription.class);
                i5.putExtra("name", Name5);
                i5.putExtra("time",Time5);
                i5.putExtra("synopsis","Elsa the Snow Queen has an extraordinary gift -- the power to create ice and snow. But no matter how happy she is to be surrounded by the people of Arendelle, Elsa finds herself strangely unsettled. After hearing a mysterious voice call out to her, Elsa travels to the enchanted forests and dark seas beyond her kingdom -- an adventure that soon turns into a journey of self-discovery.");
                i5.putExtra("cast","Kristen Bell as Anna, Idina Menzel as Elsa, Josh Gad as Olaf, Jonathan Groff as Kristoff,Sterling K. Brown as Mattias");

                i5.putExtra("image",R.drawable.jokertrailer);
                startActivity(i5);
                break;
            default:
                break;
        }

    }



}
