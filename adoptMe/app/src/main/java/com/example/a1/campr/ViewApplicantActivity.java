package com.example.a1.campr;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class ViewApplicantActivity extends AppCompatActivity {/*
    private TextView name, gender, info;
    private User user;
    private Button accept, decline;

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

        user = LoginActivity.myData.dataUsers.get(Integer.parseInt(getIntent().getExtras().getString("user_id")));
        String approved_value = getIntent().getExtras().getString("approved");
        name = findViewById(R.id.textView);
        name.setInputType(InputType.TYPE_NULL);
        name.setBackground(null);
        name.setText(user.userName);
        gender = findViewById(R.id.textView2);
        gender.setInputType(InputType.TYPE_NULL);
        gender.setBackground(null);
        gender.setText(user.userCity);
        info = findViewById(R.id.textView3);
        info.setInputType(InputType.TYPE_NULL);
        info.setBackground(null);
        info.setText(ApplicantsActivity.pet.applicantId.get(user.userID));
        accept = findViewById(R.id.button);
        decline = findViewById(R.id.button_right);

        if(!approved_value.equals("APPROVED") && !ApplicantsActivity.pet.approvedId.equals(user.userID)) {

            accept.setText("ACCEPT");
            accept.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    final AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                    LayoutInflater inflater = getLayoutInflater();
                    builder.setView(inflater.inflate(R.layout.dialog_approve, null))
                            .setPositiveButton(R.string.application_confirm, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    int index = LoginActivity.myData.dataUsers.get(LoginActivity.currentUser).listedPets.indexOf(ApplicantsActivity.pet);
                                    LoginActivity.myData.dataUsers.get(LoginActivity.currentUser).listedPets.get(index).approved = true;
                                    LoginActivity.myData.dataUsers.get(LoginActivity.currentUser).listedPets.get(index).approvedId = user.userID;
                                    info.setSingleLine(false);
                                    info.setText(LoginActivity.myData.dataUsers.get(Integer.parseInt(user.userID)).userContact);
                                    LoginActivity.myData.dataUsers.get(Integer.parseInt(user.userID)).appliedPets.put(ApplicantsActivity.pet.getPetId(), "approved");
                                    ApplicantsActivity.recyclerView.getAdapter().notifyDataSetChanged();

                                    accept.setText("Go back");
                                    accept.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            finish();
                                        }
                                    });

                                }
                            })
                            .setNegativeButton(R.string.cancel_dialog, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {

                                }
                            });
                    builder.create();
                    builder.show();
                }
            });

            decline.setText("Decline");
            decline.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ApplicantsActivity.pet.approved = false;
                    LoginActivity.myData.dataUsers.get(Integer.parseInt(user.userID)).appliedPets.put(ApplicantsActivity.pet.getPetId(), "declined");
                    ApplicantsActivity.pet.applicantId.remove(user.userID);
                    ApplicantsActivity.recyclerView.getAdapter().notifyDataSetChanged();
                    finish();
                }
            });
        }
        else {
            info.setSingleLine(false);
            info.setText(user.userContact);

            accept.setText("Go back");
            accept.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                }
            });

            decline.setText("Decline");
            decline.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ApplicantsActivity.pet.approved = false;
                    LoginActivity.myData.dataUsers.get(Integer.parseInt(user.userID)).appliedPets.put(ApplicantsActivity.pet.getPetId(), "declined");
                    ApplicantsActivity.pet.applicantId.remove(user.userID);
                    ApplicantsActivity.recyclerView.getAdapter().notifyDataSetChanged();
                    PetsFragment.recyclerView.getAdapter().notifyDataSetChanged();
                    finish();
                }
            });
        }
    }
*/
}
