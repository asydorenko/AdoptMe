package com.example.a1.campr;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

public class ProfileFragment extends Fragment {
    private TextView mback, edit;
    private EditText name, city, email, contact;
    private static boolean toEdit = false;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_profile,container,false);
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        /*if(ProfileFragment.toEdit == true) {
            ProfileFragment.toEdit = false;
            edit = getActivity().findViewById(R.id.textView14);
            edit.setText("Save");

            name = getActivity().findViewById(R.id.profile_edit_name);
            name.setText(LoginActivity.myData.dataUsers.get(LoginActivity.currentUser).userName);
            city = getActivity().findViewById(R.id.profile_edit_city);
            city.setText(LoginActivity.myData.dataUsers.get(LoginActivity.currentUser).userCity);
            email = getActivity().findViewById(R.id.profile_edit_email);
            email.setText(LoginActivity.myData.dataUsers.get(LoginActivity.currentUser).userEmail);
            contact = getActivity().findViewById(R.id.profile_share_info);
            contact.setText(LoginActivity.myData.dataUsers.get(LoginActivity.currentUser).userContact);

            edit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    LoginActivity.myData.dataUsers.get(LoginActivity.currentUser).userName = name.getText().toString();
                    LoginActivity.myData.dataUsers.get(LoginActivity.currentUser).userCity = city.getText().toString();
                    LoginActivity.myData.dataUsers.get(LoginActivity.currentUser).userEmail = email.getText().toString();
                    LoginActivity.myData.dataUsers.get(LoginActivity.currentUser).userContact = contact.getText().toString();

                    if(getActivity().getClass().getSimpleName().equals("AdopterActivity")) {
                        Intent intent = new Intent(getActivity(), AdopterActivity.class);
                        startActivity(intent);
                    }
                    else {
                        Intent intent = new Intent(getActivity(), ListerActivity.class);
                        startActivity(intent);
                    }
                }
            });

        }
        else {
            edit = getActivity().findViewById(R.id.textView14);
            edit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ProfileFragment.toEdit = true;
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            new ProfileFragment()).commit();
                }
            });

            name = getActivity().findViewById(R.id.profile_edit_name);
            name.setInputType(InputType.TYPE_NULL);
            name.setBackground(null);
            name.setText(LoginActivity.myData.dataUsers.get(LoginActivity.currentUser).userName);
            city = getActivity().findViewById(R.id.profile_edit_city);
            city.setInputType(InputType.TYPE_NULL);
            city.setBackground(null);
            city.setText(LoginActivity.myData.dataUsers.get(LoginActivity.currentUser).userCity);
            email = getActivity().findViewById(R.id.profile_edit_email);
            email.setInputType(InputType.TYPE_NULL);
            email.setBackground(null);
            email.setText(LoginActivity.myData.dataUsers.get(LoginActivity.currentUser).userEmail);
            contact = getActivity().findViewById(R.id.profile_share_info);
            contact.setInputType(InputType.TYPE_NULL);
            contact.setBackground(null);
            contact.setSingleLine(false);
            //contact.setImeOptions(EditorInfo.IME_FLAG_NO_ENTER_ACTION);
            //Of particular importance, do not leave out the InputType.TYPE_CLASS_TEXT; it will not work without it!
            //contact.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_FLAG_MULTI_LINE);
            //contact.setMaxLines(10);
            contact.setText(LoginActivity.myData.dataUsers.get(LoginActivity.currentUser).userContact);
        }

        mback = getActivity().findViewById(R.id.back);
        mback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getActivity().getClass().getSimpleName().equals("AdopterActivity")) {
                    Intent intent = new Intent(getActivity(), AdopterActivity.class);
                    startActivity(intent);
                }
                else {
                    Intent intent = new Intent(getActivity(), ListerActivity.class);
                    startActivity(intent);
                }
            }
        });*/
    }
}

