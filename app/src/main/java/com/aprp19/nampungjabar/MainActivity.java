package com.aprp19.nampungjabar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.Menu;

import com.aprp19.nampungjabar.adapter.ViewPagerAdapter;
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    WormDotsIndicator dotsIndicator;
    ViewPagerAdapter viewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Buat nampilin button di top toolbar
        Toolbar toolbar = findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);

        //Buat nampilin View Pager
        viewPager = findViewById(R.id.vp_container);
        dotsIndicator = findViewById(R.id.vp_dotsIndicator);
        viewAdapter = new ViewPagerAdapter(this);
        viewPager.setAdapter(viewAdapter);
        //noinspection deprecation
        dotsIndicator.setViewPager(viewPager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) { //ini juga buat nampilin toolbar
        getMenuInflater().inflate(R.menu.top_toolbar, menu);
        return true;
    }
}