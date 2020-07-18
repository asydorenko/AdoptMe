package com.example.a1.campr;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.util.Pair;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

/*public class ViewPetsFavorite extends AppCompatActivity implements ApplyMsgDialog.ApplyMsgListener {
    private TextView name, gender, info;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pets);

        ImageView edit = findViewById(R.id.edit_pet);
        edit.setVisibility(View.GONE);

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

        Pets pet = getIntent().getParcelableExtra("parcel_data");
        pet = AdopterActivity.myChosenPets.get(pet.getPetId());
        name = findViewById(R.id.textView);
        name.setInputType(InputType.TYPE_NULL);
        name.setBackground(null);
        name.setText(pet.getName());
        gender = findViewById(R.id.textView2);
        gender.setInputType(InputType.TYPE_NULL);
        gender.setBackground(null);
        gender.setSingleLine(false);
        gender.setGravity(Gravity.CENTER);
        String s = pet.getGender() + "\n" + pet.city;
        gender.setText(s);
        info = findViewById(R.id.textView3);
        info.setInputType(InputType.TYPE_NULL);
        info.setBackground(null);
        info.setText(pet.getInfo());
        ImageView image = findViewById(R.id.imageView);
        image.setImageBitmap(pet.getPetPic());

        final String applied_value = getIntent().getExtras().getString("applied_value");
        if(!applied_value.equals("APPLIED") && !applied_value.equals("APPROVED") && !applied_value.equals("DECLINED")) {

            Button remove = findViewById(R.id.button_right);
            remove.setText("Remove");
            remove.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Pets pet = getIntent().getParcelableExtra("parcel_data");
                    AdopterActivity.myChosenPets.remove(pet.getPetId());
                    LoginActivity.myData.dataUsers.get(LoginActivity.currentUser).chosenPets.remove(pet);
                    FavoriteFragment.recyclerView.getAdapter().notifyDataSetChanged();
                    finish();
                }
            });

            Button apply = findViewById(R.id.button);
            apply.setText("Apply");
            apply.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    DialogFragment dialog = new ApplyMsgDialog();
                    dialog.show(getSupportFragmentManager(), "apply");
                }
            });
        }
        else {
            if(applied_value.equals("APPROVED")) {
                int owner = Integer.parseInt(pet.getOwnerId());
                //info.setSingleLine(false);
                //info.setText(info.getText().toString() + "\n\n" + LoginActivity.myData.dataUsers.get(owner).userContact);
                String ss = gender.getText().toString() + "\n" + info.getText().toString();
                gender.setText(ss);
                info.setSingleLine(false);
                info.setText(LoginActivity.myData.dataUsers.get(owner).userContact);
            }

            Button remove = findViewById(R.id.button);
            remove.setText("Remove");
            remove.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Pets pet = getIntent().getParcelableExtra("parcel_data");
                    AdopterActivity.myChosenPets.remove(pet.getPetId());
                    LoginActivity.myData.dataUsers.get(LoginActivity.currentUser).chosenPets.remove(pet);
                    //remove from lister's pet arraylist
                    int index = LoginActivity.myData.dataUsers.get(Integer.parseInt(pet.getOwnerId())).listedPets.indexOf(pet);
                    LoginActivity.myData.dataUsers.get(Integer.parseInt(pet.getOwnerId())).listedPets.get(index).applicantId.remove(Integer.toString(LoginActivity.currentUser));
                    if(applied_value.equals("APPROVED")) {
                        LoginActivity.myData.dataUsers.get(Integer.parseInt(pet.getOwnerId())).listedPets.get(index).approved = false;
                    }
                    FavoriteFragment.recyclerView.getAdapter().notifyDataSetChanged();
                    finish();
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
        }
    }

    @Override
    public void onDialogPositiveClick(DialogFragment dialog) {
        Pets pet = getIntent().getParcelableExtra("parcel_data");
        pet = AdopterActivity.myChosenPets.get(pet.getPetId());
        EditText message = dialog.getDialog().findViewById(R.id.edit_msg);
        pet.applicantId.put(Integer.toString(LoginActivity.currentUser), message.getText().toString());
        AdopterActivity.myChosenPets.put(pet.getPetId(), pet);
        int index = LoginActivity.myData.dataUsers.get(Integer.parseInt(pet.getOwnerId())).listedPets.indexOf(pet);
        LoginActivity.myData.dataUsers.get(Integer.parseInt(pet.getOwnerId())).listedPets.get(index).applicantId.put(Integer.toString(LoginActivity.currentUser), message.getText().toString());
        LoginActivity.myData.dataUsers.get(LoginActivity.currentUser).appliedPets.put(pet.getPetId(), "applied");
        FavoriteFragment.recyclerView.getAdapter().notifyDataSetChanged();
        finish();
    }

    /*@Override
    public void onDialogNegativeClick(DialogFragment dialog) {

    }*//*

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }*/
//}
