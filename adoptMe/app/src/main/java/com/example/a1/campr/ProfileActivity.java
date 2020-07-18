package com.example.a1.campr;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.IOException;

public class ProfileActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    private static final int RESULT_REQUEST = 1;
    private static final String TAG = "ProfileActivity";
    private FirebaseStorage storage = FirebaseStorage.getInstance();
    private Uri selectedImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);



        mAuth = FirebaseAuth.getInstance();

        TextView next = findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseUser currentUser = mAuth.getCurrentUser();
                User user = new User(currentUser.getUid());
                TextView mName = findViewById(R.id.profile_edit_name);
                TextView mCity = findViewById(R.id.profile_edit_city);
                user.userName = mName.getText().toString();
                user.userCity = mCity.getText().toString();
                DatabaseReference userRef = database.getReference("users/"+currentUser.getUid());
                userRef.setValue(user);
                StorageReference userPicRef = storage.getReference().child("users")
                        .child(mAuth.getCurrentUser().getUid());
                userPicRef.putFile(selectedImage);
                Intent intent = new Intent(ProfileActivity.this, PreferencesActivity.class);
                startActivity(intent);
                finish();
            }
        });

        ImageView avatar = findViewById(R.id.profile_avatar);
        avatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, RESULT_REQUEST);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == Activity.RESULT_OK)
            switch (requestCode) {
                case RESULT_REQUEST:
                    selectedImage = data.getData();
                    /*StorageReference storageRef = storage.getReference();
                    StorageReference usersRef = storageRef.child("users");
                    StorageReference currUserRef = usersRef.child(mAuth.getCurrentUser().getUid());
                    currUserRef.putFile(selectedImage);*/
                    try {
                        Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), selectedImage);
                        ImageView imageView = findViewById(R.id.profile_avatar);
                        imageView.setImageBitmap(bitmap);
                    } catch (IOException e) {
                        Log.i(TAG, "Some exception " + e);
                    }
                    break;
            }
    }

}
