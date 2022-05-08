package com.example.rehberapp;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.rehberapp.fragment.FragmentAdd;
import com.example.rehberapp.fragment.FragmentHome;
import com.example.rehberapp.fragment.FragmentProfile;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gecisYap(new FragmentAdd());

        BottomNavigationView navigationView = findViewById(R.id.bottom_navigation);
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment;
                switch (item.getItemId()) {
                    case R.id.page_1:
                        fragment = new FragmentHome();

                        break;

                    case R.id.page_2:
                        fragment = new FragmentAdd();

                        break;
                    case R.id.page_3:
                        fragment = new FragmentProfile();

                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + item.getItemId());
                }
                gecisYap(fragment);

                return true;
            }
        });
    }


    void gecisYap(Fragment fragment) {

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.main, fragment, fragment.getTag());
        transaction.commit();
    }
}

