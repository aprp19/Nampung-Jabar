package com.aprp19.nampungjabar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import com.aprp19.nampungjabar.adapter.ViewPagerAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Buat nampilin button di top toolbar
        Toolbar toolbar = findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);

        bottomNavigationView = findViewById(R.id.tb_bottomnav);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.btnav_home);

        FragmentTransaction homeTransaction = getSupportFragmentManager().beginTransaction();
        homeTransaction.replace(R.id.fg_content, homeFragment,"" );
        homeTransaction.commit();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) { //ini juga buat nampilin toolbar
        getMenuInflater().inflate(R.menu.top_toolbar, menu);
        return true;
    }

    HomeFragment homeFragment = new HomeFragment();
    ListFragment listFragment = new ListFragment();
    SettingsFragment settingsFragment = new SettingsFragment();

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.btnav_home) {
            FragmentTransaction homeTransaction = getSupportFragmentManager().beginTransaction();
            homeTransaction.replace(R.id.fg_content, homeFragment, "");
            homeTransaction.commit();
        } else if (item.getItemId() == R.id.btnav_listview) {
            FragmentTransaction listTransaction = getSupportFragmentManager().beginTransaction();
            listTransaction.replace(R.id.fg_content, listFragment, "");
            listTransaction.commit();
        } else if (item.getItemId() == R.id.btnav_settings) {
            FragmentTransaction settingsTransaction = getSupportFragmentManager().beginTransaction();
            settingsTransaction.replace(R.id.fg_content, settingsFragment, "");
            settingsTransaction.commit();
        }

        return false;
    }
}