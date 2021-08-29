package com.example.anonimo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;


import com.example.anonimo.activities.all_in;
import com.example.anonimo.fragments.Community;
import com.example.anonimo.fragments.HomeFragment;
import com.example.anonimo.fragments.PostFragment;
import com.example.anonimo.fragments.SearchFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ImageView settings1= findViewById(R.id.settings_logo);
        BottomNavigationView nav = findViewById(R.id.nav);
//        MeowBottomNavigation nav = findViewById(R.id.nav);
//        nav.add(new MeowBottomNavigation.Model(1,R.drawable.home));
//        nav.add(new MeowBottomNavigation.Model(2,R.drawable.search));
//        nav.add(new MeowBottomNavigation.Model(3,R.drawable.posts));
//        nav.add(new MeowBottomNavigation.Model(4,R.drawable.community));
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new HomeFragment()).commit();
        nav.setSelectedItemId(R.id.Home);
        nav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                switch ((item.getItemId())){
                    case R.id.Home:
                        fragment = new HomeFragment();
                        break;

                    case R.id.Search:
                        fragment = new SearchFragment();
                        break;

                    case R.id.Post:
                        fragment =  new PostFragment();
                        break;

                    case R.id.Community:
                        fragment = new Community();
                        break;
                }
//                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,fragment).commit();
                loadFragments(fragment);
                return  true;
            }
        });

        settings1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, all_in.class));
            }
        });

//        nav.setOnShowListener(new MeowBottomNavigation.ShowListener() {
//            @Override
//            public void onShowItem(MeowBottomNavigation.Model item) {
//                Fragment fragment = null;
//
//                switch (item.getId()){
//                    case 1:
//                        fragment = new HomeFragment();
//                        break;
//
//                    case 2 :
//                        fragment = new SearchFragment();
//                        break;
//
//                    case 3 :
//                        fragment = new PostFragment();
//                        break;
//
//                    case 4 :
//                        fragment = new Community();
//                        break;
//
//
//                }
//
//                //load fragments
//                loadFragments(fragment);
//            }
//        });


    }

    public void loadFragments(Fragment fragment){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container,fragment)
                .commit();

    }
}