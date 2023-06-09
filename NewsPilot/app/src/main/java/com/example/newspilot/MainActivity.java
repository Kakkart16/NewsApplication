package com.example.newspilot;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    String api = "bf2a393676d347bfaad8135c5494680e";
    TabItem mentertainment;
    TabItem mheath;
    TabItem mhome;
    TabItem mscience;
    TabItem msports;
    TabItem mtechnology;
    Toolbar mtoolbar;
    PagerAdapter pagerAdapter;
    TabLayout tabLayout;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_main);
        mtoolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mtoolbar);
        mhome = findViewById(R.id.home);
        msports = findViewById(R.id.sports);
        mheath = findViewById(R.id.health);
        mentertainment = findViewById(R.id.entertainment);
        mscience = findViewById(R.id.science);
        mtechnology = findViewById(R.id.technology);

        ViewPager viewPager = findViewById(R.id.fragmentContainer);
        tabLayout = findViewById(R.id.include);
        pagerAdapter = new PagerAdapter(getSupportFragmentManager(), 7);
        viewPager.setAdapter(pagerAdapter);

        tabLayout.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new TabLayout.OnTabSelectedListener() {
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if (tab.getPosition() == 0 || tab.getPosition() == 1 || tab.getPosition() == 2 || tab.getPosition() == 3 || tab.getPosition() == 4 || tab.getPosition() == 5 || tab.getPosition() == 6) {
                    MainActivity.this.pagerAdapter.notifyDataSetChanged();
                }
            }

            public void onTabUnselected(TabLayout.Tab tab) {
            }

            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(this.tabLayout));
    }
}
