package com.example.a1.campr;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class ListerActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private DrawerLayout drawer;
    private NavigationView navigationView;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lister);

        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawer,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new PetsFragment(), "pets_frag").commit();
        navigationView.setCheckedItem(R.id.nav_pets);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_profile:
                //getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        //new ProfileFragment()).commit();
                intent = new Intent(ListerActivity.this, ProfileActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_pets:
                Fragment petsFrag = getSupportFragmentManager().findFragmentByTag("pets_frag");
                if(petsFrag == null) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            new PetsFragment(), "pets_frag").commit();
                }
                else {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            petsFrag).commit();
                }
                break;
            case R.id.nav_addnew:
                //getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                  //      new AddnewFragment()).commit();*/
                intent = new Intent(this, AddNewActivity.class);
                startActivity(intent);
                navigationView.setCheckedItem(R.id.nav_pets);
                break;
            case R.id.nav_signout:
                petsFrag = getSupportFragmentManager().findFragmentByTag("pets_frag");
                getSupportFragmentManager().beginTransaction().remove(petsFrag).commit();
                getSupportFragmentManager().popBackStack();
                mAuth.signOut();
                intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                //finish();
                break;
            case R.id.switch_lister:
                //intent = new Intent(this, workmodeActivity.class);
                //startActivity(intent);
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    /*public void onBackPressed(){
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }
    }*/
}
