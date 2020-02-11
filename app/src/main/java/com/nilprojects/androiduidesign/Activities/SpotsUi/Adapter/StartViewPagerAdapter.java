package com.nilprojects.androiduidesign.Activities.SpotsUi.Adapter;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.nilprojects.androiduidesign.Activities.SpotsUi.Fragment.Start1Fragment;
import com.nilprojects.androiduidesign.Activities.SpotsUi.Fragment.Start2Fragment;

public class StartViewPagerAdapter extends FragmentStatePagerAdapter {

    private static int NUM_ITEMS = 2;

    public StartViewPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public int getCount() {
        return NUM_ITEMS;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {

            case 0:
                return Start1Fragment.newInstance(0);
            case 1:
                return Start2Fragment.newInstance(1);

            default:
                return null;
        }
    }

}