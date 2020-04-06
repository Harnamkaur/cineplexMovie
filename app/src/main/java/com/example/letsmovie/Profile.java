package com.example.letsmovie;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import java.util.HashMap;
import java.util.Map;

import static com.example.letsmovie.R.id.creditcardshow;

public class Profile extends AppCompatActivity  {


//    ImageView imageView;
//    private FirebaseAuth mAuth;
    TextView name,email,phone,creditcard,expiry,cvv;
//    Uri uriProfileImage;
    private FirebaseFirestore db;
//    private StorageReference mStorageRef;
//    private DocumentReference profile  = db.document("Users");
//    CollectionReference dbProducts = db.collection("Users");
    private static final String TAG = "Profile";


    String userUid = "";
//    Map<>

    Map<String, String> mylist = new HashMap<String, String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        SharedPreferences myPref = getSharedPreferences("UserUid",MODE_PRIVATE);
        userUid = myPref.getString("uid","");
        System.out.println("uiddd is"+userUid);

//
//        mStorageRef = FirebaseStorage.getInstance().getReference("profilepics");
//        mAuth = FirebaseAuth.getInstance();
          db= FirebaseFirestore.getInstance();
        name = findViewById(R.id.nameshow);
       phone = findViewById(R.id.phoneshow);
        creditcard = findViewById(creditcardshow);
        expiry = findViewById(R.id.expiryshow);
        cvv = findViewById(R.id.cvvshow);
//        imageView=(ImageView) findViewById(R.id.profilepicshow);
//        mStorageRef = FirebaseStorage.getInstance().getReference();


        final DocumentReference docRef = db.collection("Users").document(userUid);

        docRef.addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot snapshot,
                                @Nullable FirebaseFirestoreException e) {
                if (e != null) {
                    Log.w(TAG, "Listen failed.", e);
                    return;
                }

                if (snapshot != null && snapshot.exists()) {
                    Log.d(TAG, "Current data: " + snapshot.getData());
//                   mylist.add(snapshot.getData());
                      String x = snapshot.getString("name");
                    String y = snapshot.getString("phone");
                    String z = snapshot.getString("credidtcard");

                    String a = snapshot.getString("expiry");
                    String b = snapshot.getString("cvv");
                      name.setText(x);
                     phone.setText(y);
                    creditcard.setText(z);
                    expiry.setText(a);
                    cvv.setText(b);

                } else {
                    Log.d(TAG, "Current data: null");
                }
            }
        });




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


    public void update(View view) {
        Intent i = new Intent(Profile.this,profileupdate.class);
        startActivity(i);
    }

    public void back(View view) {
        Intent i = new Intent(Profile.this,MainActivity.class);
        startActivity(i);
    }
}
