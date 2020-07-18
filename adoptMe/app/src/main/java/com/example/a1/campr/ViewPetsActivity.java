package com.example.a1.campr;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
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
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.LinkedList;

public class ViewPetsActivity extends AppCompatActivity {
    private TextView name, gender, info;
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private FirebaseStorage storage = FirebaseStorage.getInstance();
    private User user;
    private Pets pet;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pets);

        Spinner spinner_species = findViewById(R.id.sp_species);
        spinner_species.setVisibility(View.GONE);
        Spinner spinner_age = findViewById(R.id.sp_age);
        spinner_age.setVisibility(View.GONE);
        Spinner spinner_adoption_fee = findViewById(R.id.sp_fee);
        spinner_adoption_fee.setVisibility(View.GONE);
        Spinner spinner_gender = findViewById(R.id.sp_gender);
        spinner_gender.setVisibility(View.GONE);
        TextView sp_species = findViewById(R.id.spin_species);
        sp_species.setVisibility(View.GONE);
        TextView sp_gender = findViewById(R.id.spin_gender);
        sp_gender.setVisibility(View.GONE);
        TextView sp_age = findViewById(R.id.spin_age);
        sp_age.setVisibility(View.GONE);
        TextView sp_fee = findViewById(R.id.spin_fee);
        sp_fee.setVisibility(View.GONE);
    }

    @Override
    public void onStart() {
        super.onStart();

        final String id = getIntent().getExtras().getString("pet_id");
        DatabaseReference petRef = database.getReference().child("pets").child(id);
        final StorageReference petPicRef = storage.getReference().child("pets").child(id);

        petRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                pet = dataSnapshot.getValue(Pets.class);
                name = findViewById(R.id.textView);
                name.setInputType(InputType.TYPE_NULL);
                name.setBackground(null);
                name.setText(pet.getName());
                gender = findViewById(R.id.textView2);
                gender.setInputType(InputType.TYPE_NULL);
                gender.setBackground(null);
                //gender.setSingleLine(false);
                //gender.setGravity(Gravity.CENTER);
                //String s = pet.getGender();
                gender.setText(pet.getGender());
                info = findViewById(R.id.textView3);
                info.setInputType(InputType.TYPE_NULL);
                info.setBackground(null);
                info.setSingleLine(false);
                info.setText(pet.getInfo());
                petPicRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        ImageView petPic = findViewById(R.id.imageView);
                        GlideApp.with(ViewPetsActivity.this).load(uri).into(petPic);
                    }
                });
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        Button goBack = findViewById(R.id.button_right);
        goBack.setText("Go back");
        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        final Button deletePet = findViewById(R.id.button);
        deletePet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StorageReference deletePetPic = storage.getReference().child("pets").child(id);
                deletePetPic.delete();
                DatabaseReference deleteMyPet = database.getReference().child("pets").child(id);
                deleteMyPet.removeValue();
                DatabaseReference userRef = database.getReference().child("users").child(mAuth.getCurrentUser().getUid());
                userRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        user = dataSnapshot.getValue(User.class);
                        LinkedList<String> tmp = new LinkedList<>(user.listedPets);
                        tmp.remove(id);
                        DatabaseReference listedPetsRef = database.getReference().child("users")
                                .child(mAuth.getCurrentUser().getUid()).child("listedPets");
                        listedPetsRef.setValue(tmp);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
                finish();
            }
        });

        final ImageView edit = findViewById(R.id.edit_pet);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edit.setEnabled(false);
                Intent intent = new Intent(ViewPetsActivity.this, EditPet.class);
                intent.putExtra("pet_id", id);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }
}
