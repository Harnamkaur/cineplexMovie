package com.example.letsmovie;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import org.w3c.dom.Document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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




    public void update(View view) {
        Intent i = new Intent(Profile.this,profileupdate.class);
        startActivity(i);
    }
}
