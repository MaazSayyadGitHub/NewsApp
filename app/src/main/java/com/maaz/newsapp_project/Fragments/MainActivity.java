package com.maaz.newsapp_project.Fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import com.maaz.newsapp_project.R;

public class MainActivity extends AppCompatActivity {


    TabLayout tabLayout;
    TabItem mHome, mSports, mHealth, mScience, mEntertainment, mTechnology;

    PagerAdapter pagerAdapter;
    ViewPager pager;

    Toolbar toolbar;

    String api_key = "5d2b3f9a18a9464f945f8880e8937122";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // setting our own toolbar
        setSupportActionBar(toolbar);

        mHome = findViewById(R.id.home);
        mSports = findViewById(R.id.sports);
        mHealth = findViewById(R.id.health);
        mScience = findViewById(R.id.science);
        mEntertainment = findViewById(R.id.entertainment);
        mTechnology = findViewById(R.id.technology);

        pager = findViewById(R.id.fragmentContainer);
        tabLayout = findViewById(R.id.includeTab);

        // for view pager sliding
        pagerAdapter = new PagerAdapter(getSupportFragmentManager(), 6); // how many fragments/tabs.
        pager.setAdapter(pagerAdapter);

        // for selecting tab directly
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                pager.setCurrentItem(tab.getPosition());

                if (tab.getPosition() == 0 || tab.getPosition() == 1 || tab.getPosition() == 2 ||
                        tab.getPosition() == 3 || tab.getPosition() == 4 || tab.getPosition() == 5) {
                    // it will change data according to fragments
                    pagerAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {


            }
        });

        // with this tab will also change
        pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }
}