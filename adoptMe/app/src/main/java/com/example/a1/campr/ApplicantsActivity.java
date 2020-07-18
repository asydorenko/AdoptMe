package com.example.a1.campr;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

/*public class ApplicantsActivity extends AppCompatActivity {
    public static RecyclerView recyclerView;
    public RecyclerView.Adapter mAdapter_applicants;
    public RecyclerView.LayoutManager layoutManager;
    public static Pets pet;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_pets);

        String id = getIntent().getExtras().getString("pet_id");
        pet = PetsFragment.myPets.get(id);

        ImageView image = findViewById(R.id.add_pet);
        image.setVisibility(View.GONE);

        recyclerView = findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter_applicants = new MyAdapterApplicants(retrieveApplicants());
        recyclerView.setAdapter(mAdapter_applicants);
    }

    public ArrayList<User> retrieveApplicants() {
        ArrayList<User> applicants = new ArrayList<>();
        for(String key : pet.applicantId.keySet()) {
            for(User u : LoginActivity.myData.dataUsers) {
                if(u.userID.equals(key)) {
                    applicants.add(u);
                }
            }
        }
        return applicants;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }
}*/
