package com.example.letsmovie;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class tomorrow extends Fragment  implements View.OnClickListener {

    TextView Filmname, Filmduration,Filmname1, Filmduration1,Filmname2, Filmduration2,Filmname3, Filmduration3,Filmname4, Filmduration4,Filmname5, Filmduration5;
    Button b1,b2,b3,b4,b5,b6;
    TextView synopsis1, synopsis2, synopsis3,synopsis4,synopsis5, cast1,cast2,cast3,cast4,cast5;

    ImageButton img1,img2;

    public tomorrow() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_tomorrow, container, false);
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
                i2.putExtra("synopsis","Seven young outcasts in Derry, Maine, are about to face their worst nightmare -- an ancient, shape-shifting evil that emerges from the sewer every 27 years to prey on the town's children. Banding together over the course of one horrifying summer, the friends must overcome their own personal fears to battle the murderous, bloodthirsty clown known as Pennywise.");
                i2.putExtra("cast","Jaeden Lieberher as Bill Denbrough" +
                        "\n Bill Skarsgård as It / Pennywise The Dancing Clown / Bob Gray" +  "\n Sophia Lillis as Beverly Marsh");

                i2.putExtra("image",R.drawable.ittrailer);
                startActivity(i2);
                break;


            case R.id.Evilbutton:
                String Name3 = Filmname3.getText().toString();

                String Time3 = Filmduration3.getText().toString();
                Intent i3 = new Intent(getActivity(),FilmDescription.class);
                i3.putExtra("name", Name3);
                i3.putExtra("time",Time3);
                i3.putExtra("synopsis","As a beautiful young woman of pure heart, Maleficent (Angelina Jolie) has an idyllic life in a forest kingdom. When an invading army threatens the land, Maleficent rises up to become its fiercest protector. However, a terrible betrayal hardens her heart and twists her into a creature bent on revenge. She engages in an epic battle with the invading king's successor, then curses his newborn daughter, Aurora -- realizing only later that the child holds the key to peace in the kingdom.");
                i3.putExtra("cast","Angelina Jolie as Maleficent" + "\n Elle Fanning as Aurora" + "\n Sharlto Copley as Stefan");

                i3.putExtra("image",R.drawable.mailficienttrailer);
                startActivity(i3);
                break;

            case R.id.AvengersButton:
                String Name4 = Filmname4.getText().toString();

                String Time4 = Filmduration4.getText().toString();
                Intent i4 = new Intent(getActivity(),FilmDescription.class);
                i4.putExtra("name", Name4);
                i4.putExtra("time",Time4);
                i4.putExtra("synopsis","Adrift in space with no food or water, Tony Stark sends a message to Pepper Potts as his oxygen supply starts to dwindle. Meanwhile, the remaining Avengers -- Thor, Black Widow, Captain America and Bruce Banner -- must figure out a way to bring back their vanquished allies for an epic showdown with Thanos -- the evil demigod who decimated the planet and the universe.");
                i4.putExtra("cast","Robert Downey Jr. as Tony Stark / Iron Man " + "\n Chris Evans as Steve Rogers / Captain America"+"\nMark Ruffalo as Bruce Banner / Hulk"+"\nChris Hemsworth as Thor"+"\nScarlett Johansson as Natasha Romanoff / Black Widow"+"\n Josh Brolin as Thanos");

                i4.putExtra("image",R.drawable.avengerstrailer);
                startActivity(i4);
                break;

            case R.id.JokerButton:
                String Name5 = Filmname5.getText().toString();

                String Time5 = Filmduration5.getText().toString();
                Intent i5 = new Intent(getActivity(),FilmDescription.class);
                i5.putExtra("name", Name5);
                i5.putExtra("time",Time5);
                i5.putExtra("synopsis","Forever alone in a crowd, failed comedian Arthur Fleck seeks connection as he walks the streets of Gotham City. Arthur wears two masks -- the one he paints for his day job as a clown, and the guise he projects in a futile attempt to feel like he's part of the world around him. Isolated, bullied and disregarded by society, Fleck begins a slow descent into madness as he transforms into the criminal mastermind known as the Joker.");
                i5.putExtra("cast","Joaquin Phoenix as Arthur Fleck / Joker" + "\n Robert De Niro as Murray Franklin"
                        + "\n Zazie Beetz as Sophie Dumond"+ "\n Frances Conroy as Penny Fleck:");

                i5.putExtra("image",R.drawable.jokertrailer);
                startActivity(i5);
                break;
            default:
                break;
        }

    }






}
