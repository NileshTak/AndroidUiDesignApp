package com.nilprojects.androiduidesign.Activities.SpotsUi.Adapter;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.nilprojects.androiduidesign.Activities.SpotsUi.Fragment.ContactoverviewFragment;
import com.nilprojects.androiduidesign.Activities.SpotsUi.Fragment.MainFragment;

public class MainViewPager1Adapter extends FragmentStatePagerAdapter {

    private static int NUM_ITEMS = 2;

    public MainViewPager1Adapter(FragmentManager fragmentManager) {
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
                return ContactoverviewFragment.newInstance(0);
            case 1:
                return MainFragment.newInstance(1);


            default:
                return null;
        }
    }

}