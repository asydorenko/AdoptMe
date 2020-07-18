package com.example.a1.campr;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class PreferencesActivity extends AppCompatActivity {
    private static final String TAG = "PreferencesActivity";
    private User user;
    private FirebaseAuth mAuth;
    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    Spinner spinner_species;
    Spinner spinner_age;
    Spinner spinner_adoption_fee;
    Spinner spinner_gender;
    ArrayAdapter<CharSequence> adapter_species;
    ArrayAdapter<CharSequence> adapter_age;
    ArrayAdapter<CharSequence> adapter_gender;
    ArrayAdapter<CharSequence> adapter_adoption_fee;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preference);

        spinner_species = findViewById(R.id.spinner_species);
        adapter_species = ArrayAdapter.createFromResource(getBaseContext(), R.array.species, android.R.layout.simple_spinner_item);
        adapter_species.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner_species.setAdapter(adapter_species);

        spinner_gender = findViewById(R.id.spinner_gender);
        adapter_gender = ArrayAdapter.createFromResource(getBaseContext(), R.array.gender, android.R.layout.simple_spinner_item);
        adapter_gender.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner_gender.setAdapter(adapter_gender);

        spinner_age = findViewById(R.id.spinner_age);
        adapter_age = ArrayAdapter.createFromResource(getBaseContext(), R.array.age, android.R.layout.simple_spinner_item);
        adapter_age.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner_age.setAdapter(adapter_age);

        spinner_adoption_fee = findViewById(R.id.spinner_fee);
        adapter_adoption_fee = ArrayAdapter.createFromResource(getBaseContext(), R.array.fee, android.R.layout.simple_spinner_item);
        adapter_adoption_fee.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner_adoption_fee.setAdapter(adapter_adoption_fee);

        mAuth = FirebaseAuth.getInstance();
        final DatabaseReference usersRef = database.getReference().child("users").child(mAuth.getCurrentUser().getUid());
        usersRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                user = dataSnapshot.getValue(User.class);
                if (user.pSpecies.equals("All")) {
                    spinner_species.setSelection(0);
                } else if (user.pSpecies.equals("Cats")) {
                    spinner_species.setSelection(1);
                } else if (user.pSpecies.equals("Dogs")) {
                    spinner_species.setSelection(2);
                } else if (user.pSpecies.equals("Reptiles")) {
                    spinner_species.setSelection(3);
                } else if (user.pSpecies.equals("Other")) {
                    spinner_species.setSelection(4);
                }

                if (user.pGender.equals("All")) {
                    spinner_gender.setSelection(0);
                } else if (user.pGender.equals("Male")) {
                    spinner_gender.setSelection(1);
                } else if (user.pGender.equals("Female")) {
                    spinner_gender.setSelection(2);
                }

                if (user.pAge.equals("All")) {
                    spinner_age.setSelection(0);
                } else if (user.pAge.equals("<1")) {
                    spinner_age.setSelection(1);
                } else if (user.pAge.equals("1 - 3")) {
                    spinner_age.setSelection(2);
                } else if (user.pAge.equals("4 - 7")) {
                    spinner_age.setSelection(3);
                } else if (user.pAge.equals("8 - 10")) {
                    spinner_age.setSelection(4);
                } else if (user.pAge.equals("10+")) {
                    spinner_age.setSelection(5);
                }

                if (user.pFee.equals("All")) {
                    spinner_adoption_fee.setSelection(0);
                } else if (user.pFee.equals("Free")) {
                    spinner_adoption_fee.setSelection(1);
                } else {
                    spinner_adoption_fee.setSelection(2);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
                Toast.makeText(PreferencesActivity.this, "Failed to load post.",
                        Toast.LENGTH_SHORT).show();
            }
        });

        TextView getStarted = findViewById(R.id.getstarted);
        getStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                usersRef.child("pSpecies").setValue(spinner_species.getSelectedItem().toString());
                usersRef.child("pGender").setValue(spinner_gender.getSelectedItem().toString());
                usersRef.child("pAge").setValue(spinner_age.getSelectedItem().toString());
                usersRef.child("pFee").setValue(spinner_adoption_fee.getSelectedItem().toString());
                Intent intent;
                Switch userSwitch = findViewById(R.id.adopter_switch);
                if(userSwitch.isChecked()) {
                    usersRef.child("loginAsAdopter").setValue(true);
                    intent = new Intent(PreferencesActivity.this, AdopterActivity.class);
                }
                else {
                    usersRef.child("loginAsAdopter").setValue(false);
                    intent = new Intent(PreferencesActivity.this, ListerActivity.class);
                }
                startActivity(intent);
                finish();
            }
        });






    }

    /*@Override
    public void onStart() {
        super.onStart();

        /*mAuth = FirebaseAuth.getInstance();
        DatabaseReference usersRef = database.getReference().child("users").child(mAuth.getCurrentUser().getUid());
        usersRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                user = dataSnapshot.getValue(User.class);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
                Toast.makeText(PreferencesActivity.this, "Failed to load post.",
                        Toast.LENGTH_SHORT).show();
            }
        });*/

        /*ValueEventListener postListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Get Post object and use the values to update the UI
                User user = dataSnapshot.getValue(User.class);
                // [START_EXCLUDE]
                TextView textView = findViewById(R.id.textView13);
                textView.setText(user.pSpecies);
                // [END_EXCLUDE]
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
                // [START_EXCLUDE]
                Toast.makeText(PreferencesActivity.this, "Failed to load post.",
                        Toast.LENGTH_SHORT).show();
                // [END_EXCLUDE]
            }
        };*/
    //}
}
