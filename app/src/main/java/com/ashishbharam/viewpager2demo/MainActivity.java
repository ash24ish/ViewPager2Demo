package com.ashishbharam.viewpager2demo;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager2 viewPager2 = findViewById(R.id.viewpager);
        viewPager2.setAdapter(new OrdersPagerAdapter(this));

        TabLayout tabs = findViewById(R.id.tabLayout);

        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(tabs, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {

                BadgeDrawable badgeDrawable = tab.getOrCreateBadge();


                switch (position) {
                    case 0:
                        tab.setText("Pending");
                        tab.setIcon(R.drawable.ic_pending_24);
                        badgeDrawable.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.purple_200));
                        badgeDrawable.setVisible(true);
                        break;

                    case 1:
                        tab.setText("Confirmed");
                        tab.setIcon(R.drawable.ic_check_circle_24);
                        badgeDrawable.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.purple_200));
                        badgeDrawable.setVisible(true);
                        badgeDrawable.setNumber(9);
                        break;

                    case 2:
                        tab.setText("Delivered");
                        tab.setIcon(R.drawable.ic_delivered);
                        badgeDrawable.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.purple_200));
                        badgeDrawable.setVisible(true);
                        badgeDrawable.setNumber(100);
                        badgeDrawable.setMaxCharacterCount(3);
                        break;
                }
            }
        });

        tabLayoutMediator.attach();

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                BadgeDrawable drawable = tabs.getTabAt(position).getOrCreateBadge();
                drawable.setVisible(false);
            }
        });

    }

}