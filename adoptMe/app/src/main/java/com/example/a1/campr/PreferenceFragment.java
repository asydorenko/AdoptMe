package com.example.a1.campr;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

/*public class PreferenceFragment extends Fragment {
    private TextView mback;
    private View view;
    Spinner spinner_species;
    Spinner spinner_age;
    Spinner spinner_adoption_fee;
    Spinner spinner_gender;
    ArrayAdapter<CharSequence> adapter_species;
    ArrayAdapter<CharSequence> adapter_age;
    ArrayAdapter<CharSequence> adapter_gender;
    ArrayAdapter<CharSequence> adapter_adoption_fee;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_preference,container,false);
    }

    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);

        spinner_species = (Spinner) getActivity().findViewById(R.id.spinner_species);
        adapter_species = ArrayAdapter.createFromResource(getActivity().getBaseContext(),R.array.species,android.R.layout.simple_spinner_item);
        adapter_species.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner_species.setAdapter(adapter_species);

        spinner_gender = (Spinner) getActivity().findViewById(R.id.spinner_gender);
        adapter_gender = ArrayAdapter.createFromResource(getActivity().getBaseContext(),R.array.gender,android.R.layout.simple_spinner_item);
        adapter_gender.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner_gender.setAdapter(adapter_gender);

        spinner_age = (Spinner) getActivity().findViewById(R.id.spinner_age);
        adapter_age = ArrayAdapter.createFromResource(getActivity().getBaseContext(),R.array.age,android.R.layout.simple_spinner_item);
        adapter_age.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner_age.setAdapter(adapter_age);

        spinner_adoption_fee = (Spinner) getActivity().findViewById(R.id.spinner_fee);
        adapter_adoption_fee = ArrayAdapter.createFromResource(getActivity().getBaseContext(),R.array.fee,android.R.layout.simple_spinner_item);
        adapter_adoption_fee.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner_adoption_fee.setAdapter(adapter_adoption_fee);

        if(LoginActivity.myData.dataUsers.get(LoginActivity.currentUser).pSpecies.equals("All")) {
            spinner_species.setSelection(0);
        }
        else if(LoginActivity.myData.dataUsers.get(LoginActivity.currentUser).pSpecies.equals("Cats")) {
            spinner_species.setSelection(1);
        }
        else if(LoginActivity.myData.dataUsers.get(LoginActivity.currentUser).pSpecies.equals("Dogs")) {
            spinner_species.setSelection(2);
        }
        else if(LoginActivity.myData.dataUsers.get(LoginActivity.currentUser).pSpecies.equals("Reptiles")) {
            spinner_species.setSelection(3);
        }
        else if(LoginActivity.myData.dataUsers.get(LoginActivity.currentUser).pSpecies.equals("Other")) {
            spinner_species.setSelection(4);
        }

        if(LoginActivity.myData.dataUsers.get(LoginActivity.currentUser).pGender.equals("All")) {
            spinner_gender.setSelection(0);
        }
        else if(LoginActivity.myData.dataUsers.get(LoginActivity.currentUser).pGender.equals("Male")) {
            spinner_gender.setSelection(1);
        }
        else if(LoginActivity.myData.dataUsers.get(LoginActivity.currentUser).pGender.equals("Female")) {
            spinner_gender.setSelection(2);
        }

        if(LoginActivity.myData.dataUsers.get(LoginActivity.currentUser).pAge.equals("All")) {
            spinner_age.setSelection(0);
        }
        else if(LoginActivity.myData.dataUsers.get(LoginActivity.currentUser).pAge.equals("<1")) {
            spinner_age.setSelection(1);
        }
        else if(LoginActivity.myData.dataUsers.get(LoginActivity.currentUser).pAge.equals("1 - 3")) {
            spinner_age.setSelection(2);
        }
        else if(LoginActivity.myData.dataUsers.get(LoginActivity.currentUser).pAge.equals("4 - 7")) {
            spinner_age.setSelection(3);
        }
        else if(LoginActivity.myData.dataUsers.get(LoginActivity.currentUser).pAge.equals("8 - 10")) {
            spinner_age.setSelection(4);
        }
        else if(LoginActivity.myData.dataUsers.get(LoginActivity.currentUser).pAge.equals("10+")) {
            spinner_age.setSelection(5);
        }

        if(LoginActivity.myData.dataUsers.get(LoginActivity.currentUser).pFee.equals("All")) {
            spinner_adoption_fee.setSelection(0);
        }
        else if(LoginActivity.myData.dataUsers.get(LoginActivity.currentUser).pFee.equals("Free")) {
            spinner_adoption_fee.setSelection(1);
        }
        else {
            spinner_adoption_fee.setSelection(2);
        }

        EditText city = getActivity().findViewById(R.id.editText);
        city.setText(LoginActivity.myData.dataUsers.get(LoginActivity.currentUser).userCity);

        mback = getActivity().findViewById(R.id.back);
        view = getActivity().findViewById(R.id.frame);
        mback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginActivity.myData.dataUsers.get(LoginActivity.currentUser).pSpecies = spinner_species.getSelectedItem().toString();
                LoginActivity.myData.dataUsers.get(LoginActivity.currentUser).pGender = spinner_gender.getSelectedItem().toString();
                LoginActivity.myData.dataUsers.get(LoginActivity.currentUser).pAge = spinner_age.getSelectedItem().toString();
                LoginActivity.myData.dataUsers.get(LoginActivity.currentUser).pFee = spinner_adoption_fee.getSelectedItem().toString();
                EditText city = getActivity().findViewById(R.id.editText);
                LoginActivity.myData.dataUsers.get(LoginActivity.currentUser).userCity = city.getText().toString();
                User user = LoginActivity.myData.dataUsers.get(LoginActivity.currentUser);
                filterPreferences(user.pSpecies, user.pGender, user.pAge, user.pFee, user.userCity);

                Intent intent = new Intent(getActivity(), AdopterActivity.class);
                startActivity(intent);
            }
        });
    }

    public void filterPreferences(String mSpecies, String mGender, String mAge, String mFee, String mCity) {
        AdopterActivity.adoptionPets.clear();

        int age=-100;
        if(mAge.equals("<1")) {
            age = -100;
        }
        else if(mAge.equals("1 - 3")) {
            age = 3;
        }
        else if(mAge.equals("4 - 7")) {
            age = 7;
        }
        else if(mAge.equals("8 - 10")) {
            age = 10;
        }
        else if(mAge.equals("10+")) {
            age = 100;
        }
        else {
            age = -200;
        }

        /*for(User u : LoginActivity.myData.dataUsers) {
            if (u.listedPets.size() > 0) {
                for (Pets p : u.listedPets) {
                    /*if (LoginActivity.myData.dataUsers.get(LoginActivity.currentUser).swipedPets.contains(p.getPetId())
                            || (!p.species.equals(mSpecies))
                            || (!p.getGender().equals(mGender))
                            || ((p.age>age) || ((p.age < age-2) && (p.age<8)))
                            || (!p.fee.equals(mFee))
                            || !p.city.equals(mCity)) {
                        continue;
                    }*//*
                    if (!LoginActivity.myData.dataUsers.get(LoginActivity.currentUser).swipedPets.contains(p.getPetId())
                            && (p.species.equals(mSpecies) || mSpecies.equals("All"))
                            && (p.getGender().equals(mGender) || mGender.equals("All"))
                            && (((p.age >= age-3) && (p.age <= age)) || (age==100 && p.age>10) ||(age==-100 && p.age==0) || (age==-200) )
                            && (p.fee.equals(mFee) || mFee.equals("All"))
                            && (p.city.equals(mCity))) {
                        AdopterActivity.adoptionPets.add(p);
                    }
                    else {
                        continue;
                    }
                }
            }
        }
    }
}*/
