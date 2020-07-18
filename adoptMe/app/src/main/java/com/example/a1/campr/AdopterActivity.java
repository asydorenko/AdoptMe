package com.example.a1.campr;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.lorentzos.flingswipe.SwipeFlingAdapterView;

import java.util.ArrayList;
import java.util.HashMap;

public class AdopterActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    //private ArrayList<String> a1;
    //private ArrayAdapter arrayAdapter;
   /* private CardsStackAdapter arrayAdapter;
    private DrawerLayout drawer;
    private Intent intent;
    public static ArrayList<Pets> adoptionPets = new ArrayList<Pets>();
    public static HashMap<String, Pets> myChosenPets = new HashMap<String, Pets>();
    private Pets pet;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adopter);

        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawer,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

//        if(savedInstanceState == null) {
//            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
//                    new ProfileFragment()).commit();
//            navigationView.setCheckedItem(R.id.nav_profile);
//        }

        /*a1 = new ArrayList<>();
        a1.add("php");
        a1.add("c");
        a1.add("python");
        a1.add("java");
        a1.add("html");
        a1.add("c++");
        a1.add("css");
        a1.add("javascript");*/

        //arrayAdapter = new ArrayAdapter<>(this, R.layout.item, R.id.hello,a1);

        //petCards = new ArrayList<Pets>(adoptionPets);
        /*arrayAdapter = new CardsStackAdapter(this, adoptionPets);

        SwipeFlingAdapterView flingContainer = (SwipeFlingAdapterView) findViewById(R.id.frame) ;

        flingContainer.setAdapter(arrayAdapter);
        flingContainer.setFlingListener(new SwipeFlingAdapterView.onFlingListener() {
            @Override
            public void removeFirstObjectInAdapter() {
                // this is the simplest way to delete an object from the Adapter (/AdapterView)
                Log.d("LIST", "removed object!");
                pet = adoptionPets.get(0);
                adoptionPets.remove(pet);
                //petCards.remove(0);
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onLeftCardExit(Object dataObject) {
                //Do something on the left!
                //You also have access to the original object.
                //If you want to use it just cast it (String) dataObject
                //Toast.makeText(AdopterActivity.this, "Left", Toast.LENGTH_SHORT).show();
                //LoginActivity.myData.dataUsers.get(LoginActivity.currentUser).swipedPets.add(pet.getPetId());
            }

            @Override
            public void onRightCardExit(Object dataObject) {
                //Toast.makeText(AdopterActivity.this, "Right", Toast.LENGTH_SHORT).show();
                //LoginActivity.myData.dataUsers.get(LoginActivity.currentUser).chosenPets.add(pet);
                myChosenPets.put(pet.getPetId(), pet);
                //LoginActivity.myData.dataUsers.get(Integer.parseInt(pet.getOwnerId())).myApplicants.add(new Pair<String, String>(Integer.toString(LoginActivity.currentUser), pet.getPetId()));
                //LoginActivity.myData.dataUsers.get(LoginActivity.currentUser).swipedPets.add(pet.getPetId());
            }

            @Override
            public void onAdapterAboutToEmpty(int itemsInAdapter) {
            }

            @Override
            public void onScroll(float scrollProgressPercent) {

            }
        });


    }*/

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Intent intent;
        View view = findViewById(R.id.frame);
        switch (item.getItemId()) {
            case R.id.nav_profile:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ProfileFragment()).commit();
                view.setVisibility(View.GONE);
                break;
            case R.id.nav_preference:
                //getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                  //      new PreferenceFragment()).commit();
                view.setVisibility(View.GONE);
                break;
            case R.id.nav_browse:
                intent = new Intent(this, AdopterActivity.class);
                finish();
                startActivity(intent);
                break;
            case R.id.nav_favorite:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new FavoriteFragment()).commit();
                view.setVisibility(View.GONE);
                break;
            case R.id.nav_signout:
                intent = new Intent(AdopterActivity.this, LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.switch_adopter:
                //intent = new Intent(AdopterActivity.this, workmodeActivity.class);
                //startActivity(intent);
                break;
        }
        //drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    /*public void onBackPressed(){
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }
    }*/
    /*@Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }*/
}
