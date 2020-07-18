package com.example.a1.campr;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.IOException;

public class EditPet extends AppCompatActivity {
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private FirebaseStorage storage = FirebaseStorage.getInstance();
    private static final int RESULT_REQUEST = 1;
    private String id;
    private Pets pet;
    private TextView name, gender, info;
    private Boolean newImageLoaded = false;
    private Uri selectedImage;
    Spinner spinner_species;
    Spinner spinner_age;
    Spinner spinner_adoption_fee;
    Spinner spinner_gender;
    ArrayAdapter<CharSequence> adapter_species;
    ArrayAdapter<CharSequence> adapter_age;
    ArrayAdapter<CharSequence> adapter_gender;
    ArrayAdapter<CharSequence> adapter_adoption_fee;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pets);

        ImageView edit = findViewById(R.id.edit_pet);
        edit.setVisibility(View.GONE);

        spinner_species = findViewById(R.id.sp_species);
        adapter_species = ArrayAdapter.createFromResource(getBaseContext(),R.array.add_species,android.R.layout.simple_spinner_item);
        adapter_species.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner_species.setAdapter(adapter_species);

        spinner_gender = findViewById(R.id.sp_gender);
        adapter_gender = ArrayAdapter.createFromResource(getBaseContext(),R.array.add_gender,android.R.layout.simple_spinner_item);
        adapter_gender.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner_gender.setAdapter(adapter_gender);

        spinner_age = findViewById(R.id.sp_age);
        adapter_age = ArrayAdapter.createFromResource(getBaseContext(),R.array.add_age,android.R.layout.simple_spinner_item);
        adapter_age.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner_age.setAdapter(adapter_age);

        spinner_adoption_fee = findViewById(R.id.sp_fee);
        adapter_adoption_fee = ArrayAdapter.createFromResource(getBaseContext(),R.array.add_fee,android.R.layout.simple_spinner_item);
        adapter_adoption_fee.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner_adoption_fee.setAdapter(adapter_adoption_fee);

        final ImageView pet_pic = findViewById(R.id.imageView);
        id = getIntent().getExtras().getString("pet_id");

        final DatabaseReference petRef = database.getReference().child("pets").child(id);
        final StorageReference petPicRef = storage.getReference().child("pets").child(id);
        petRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                pet = dataSnapshot.getValue(Pets.class);
                name = findViewById(R.id.textView);
                name.setText(pet.getName());
                gender = findViewById(R.id.textView2);
                gender.setVisibility(View.GONE);
                info = findViewById(R.id.textView3);
                info.setText(pet.getInfo());
                petPicRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        GlideApp.with(EditPet.this).load(uri).into(pet_pic);
                    }
                });
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        pet_pic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, RESULT_REQUEST);
            }
        });

        Button cancel = findViewById(R.id.button_right);
        cancel.setText("Cancel");
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Button save = findViewById(R.id.button);
        save.setText("Save");
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pet.setName(name.getText().toString());
                pet.setSpecies(spinner_species.getSelectedItem().toString());
                pet.setGender(spinner_gender.getSelectedItem().toString());
                int age;
                if(spinner_age.getSelectedItem().toString().equals("<1")) {
                    age = 0;
                }
                else if(spinner_age.getSelectedItem().toString().equals("1 - 3")) {
                    age = 3;
                }
                else if(spinner_age.getSelectedItem().toString().equals("4 - 7")) {
                    age = 7;
                }
                else if(spinner_age.getSelectedItem().toString().equals("8 - 10")) {
                    age = 10;
                }
                else {
                    age = 100;
                }
                pet.setAge(age);
                pet.setFee(spinner_adoption_fee.getSelectedItem().toString());
                pet.setGender(spinner_gender.getSelectedItem().toString());
                pet.setSpecies(spinner_species.getSelectedItem().toString());
                pet.setInfo(info.getText().toString());
                petRef.setValue(pet);
                if(newImageLoaded) {
                    petPicRef.putFile(selectedImage);
                }
                PetsFragment.recyclerView.getAdapter().notifyDataSetChanged();
                finish();
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == Activity.RESULT_OK)
            switch (requestCode) {
                case RESULT_REQUEST:
                    newImageLoaded = true;
                    selectedImage = data.getData();
                    try {
                        Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), selectedImage);
                        ImageView imageView = findViewById(R.id.imageView);
                        imageView.setImageBitmap(bitmap);
                    } catch (IOException e) {
                        Log.i("TAG", "Some exception " + e);
                    }
                    break;
            }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }
}
