package com.example.letsmovie;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import de.hdodenhof.circleimageview.CircleImageView;

public class profileupdate extends AppCompatActivity  {

    private static final int CHOOSE_IMAGE = 101;
    ImageView imageView;
    private FirebaseAuth mAuth;
    EditText name,email,phone,creditcard,expiry,cvv;
    Uri uriProfileImage;
    ProgressBar progressBar;
    private CircleImageView profilepic;
    Button buttonUpload;
    String profileImageurl,userUid;
    private FirebaseFirestore db;
    private StorageReference mStorageRef;
    private static final int GalleryPick= 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profileupdate);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        mStorageRef = FirebaseStorage.getInstance().getReference("profilepics");
        mAuth = FirebaseAuth.getInstance();
        db= FirebaseFirestore.getInstance();
        name = findViewById(R.id.nameedit);
        phone = findViewById(R.id.phoneedit);
        buttonUpload = findViewById(R.id.button_update);
        creditcard = findViewById(R.id.creditcardedit);
        expiry = findViewById(R.id.expiryedit);
        cvv = findViewById(R.id.cvvedit);
        profilepic = findViewById(R.id.profile_image);
      //  imageView=(ImageView) findViewById(R.id.profilepicedit);
        mStorageRef = FirebaseStorage.getInstance().getReference();
        progressBar = findViewById(R.id.profileprogress);

        profilepic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               Intent galleryIntent = new Intent();
               galleryIntent.setAction(Intent.ACTION_GET_CONTENT);
               galleryIntent.setType("images/*");
               startActivityForResult(galleryIntent,GalleryPick);


            }
        });

        SharedPreferences myPref = getSharedPreferences("UserUid",MODE_PRIVATE);
        userUid = myPref.getString("uid","");
        System.out.println("uiddd is");
        System.out.println(userUid);


        buttonUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               // FileUploader();
                uploadinfo();

            }
        });
    }




//


    private boolean validateInputs(String name1, String phone1, String credicard1, String expiry1, String cvv1)
    {
        if (name1.isEmpty())
        {
            name.setError("Name Required");
            name.requestFocus();
            return true;
        }
        if (phone1.isEmpty())
        {
            phone.setError("Phone Required");
            phone.requestFocus();
            return true;
        }
        if (credicard1.isEmpty())
        {
            creditcard.setError("Credit Card number is Required");
            creditcard.requestFocus();
            return true;
        }
        if (expiry1.isEmpty())
        {
            expiry.setError("Expiry date is Required");
            expiry.requestFocus();
            return true;
        }
        if (cvv1.isEmpty())
        {
            cvv.setError("CVV Required");
            cvv.requestFocus();
            return true;
        }
        return  false;
    }



   private void uploadinfo (){


        if (uriProfileImage == null){
          //  if imageView.setImageURI();

            System.out.println("image is nulllll");
//       }else {


            String name1 = name.getText().toString().trim();
            String phone1 = phone.getText().toString().trim();
            String creditcard1 = creditcard.getText().toString().trim();
            String expiry1 = expiry.getText().toString().trim();
            String cvv1 = cvv.getText().toString().trim();


            if (!validateInputs(name1, phone1, creditcard1, expiry1, cvv1)) {
                CollectionReference dbProducts = db.collection("Users");

                DocumentReference ref = db.collection("Users").document();
                String refId = ref.getId();

                String uid = userUid.toString().trim();
                System.out.println("uid is" + uid);

                user user1 = new user(
                        name1,
                       phone1,
                      creditcard1,
                       cvv1, expiry1, refId, uid


                );

                dbProducts.document(userUid).set(user1).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(profileupdate.this, "User Information update", Toast.LENGTH_LONG).show();
                        Intent i = new Intent(profileupdate.this, Profile.class);
                        startActivity(i);

                    }
                })

//
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(profileupdate.this, "Error while updating", Toast.LENGTH_LONG).show();

                            }
                        });

            }
        }

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


    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if (requestCode == GalleryPick && resultCode== RESULT_OK && data !=null)
        {
            Uri imageUri = data.getData();
            CropImage.activity()
                    .setGuidelines(CropImageView.Guidelines.ON)
                    .setAspectRatio(1,1)
                    .start(this);
        }
        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);

        }



    }




}
