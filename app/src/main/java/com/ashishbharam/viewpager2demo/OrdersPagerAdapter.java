package com.ashishbharam.viewpager2demo;
/* 
Created by Ashish Bharam on 08-Feb-21 at 12:20 AM.
Copyright (c) 2021 Ashish Bharam. All rights reserved.
*/

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class OrdersPagerAdapter extends FragmentStateAdapter {

    public OrdersPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        switch (position) {
            case 0:
                return new PendingOrdersFragment();
            case 1:
                return new ConfirmedFragment();
            default:
                return new DeliveredFragment();
        }

    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
