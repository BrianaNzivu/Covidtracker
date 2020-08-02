package com.example.covid_19;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.bottomnavigation.BottomNavigationView;

//Java class for the Bottom Navigation Bar
public class Home extends AppCompatActivity
{
    private BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener
            = item ->
    {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction ft = fragmentManager.beginTransaction();
                switch (item.getItemId())
                {

                    case R.id.home:


                        HomeFragment home = new HomeFragment();
                        ft.replace(R.id.container_fragment, home);
                        ft.commit();
                        return true;

                    case R.id.details:

                        DetailsFragment details = new DetailsFragment();
                        ft.replace(R.id.container_fragment,details);
                        ft.commit();
                        return true;

                }
                return false;
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        BottomNavigationView navView = findViewById(R.id.navView);


        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        HomeFragment home = new HomeFragment();
        ft.replace(R.id.container_fragment, home);
        ft.commit();


    }
}

