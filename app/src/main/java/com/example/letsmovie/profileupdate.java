package com.example.letsmovie;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.google.type.Date;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.xml.transform.Result;

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




//    private String getExtension(Uri uriProfileImage)
//    {
//        ContentResolver cr = getContentResolver();
//        MimeTypeMap mimeTypeMap = MimeTypeMap.getSingleton();
//        return mimeTypeMap.getExtensionFromMimeType(cr.getType(uriProfileImage));
//
//    }

//    private void FileUploader()
//    {
//        StorageReference reference = mStorageRef.child(System.currentTimeMillis()+"."+getExtension(uriProfileImage));
//
//        reference.putFile(uriProfileImage)
//                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
//                    @Override
//                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
//
//
//
//                    }
//
//                })
//                .addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception exception) {
//                        // Handle unsuccessful uploads
//                        // ...
//                    }
//                });
//    }


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

//            dbProducts.add(user1)
//                    .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
//                        @Override
//                        public void onSuccess(DocumentReference documentReference) {
//                            Toast.makeText(profileupdate.this, "User Information update",Toast.LENGTH_LONG).show();
//                        }
//                    })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(profileupdate.this, "Error while updating", Toast.LENGTH_LONG).show();

                            }
                        });

            }
        }

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
//
//    private void  (){
//
//        final StorageReference profileImageRef=
//                FirebaseStorage.getInstance().getReference("profile photos/"+System.currentTimeMillis()+".jpg");
//
//
//        if (uriProfileImage != null)
//        {
//            progressBar.setVisibility(View.VISIBLE);
//            profileImageRef.putFile(uriProfileImage).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
//                @Override
//                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
//                    progressBar.setVisibility(View.GONE);
//
//                    profileImageurl = taskSnapshot.getStorage().getDownloadUrl().toString();
//
//                }
//            })
//                    .addOnFailureListener(new OnFailureListener() {
//                        @Override
//                        public void onFailure(@NonNull Exception e) {
//                            progressBar.setVisibility(View.GONE);
//                            Toast.makeText(profileupdate.this,e.getMessage(),Toast.LENGTH_SHORT).show();
//                        }
//                    });
//        }else{
//            System.out.println("image is null");
//        }
//
//    }
//
//    private void showImageChooser(){
//        Intent i = new Intent();
//        i.setType("image/*");
//        i.setAction(Intent.ACTION_GET_CONTENT);
//        startActivityForResult(Intent.createChooser(i,"Select Profile Image"), CHOOSE_IMAGE);
//    }
//
//



}
