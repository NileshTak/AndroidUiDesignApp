package com.nilprojects.androiduidesign.Activities.SpotsUi.Adapter;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.nilprojects.androiduidesign.Activities.SpotsUi.Fragment.SartscreenFragment;
import com.nilprojects.androiduidesign.Activities.SpotsUi.Fragment.StartrealscreenFragment;

public class MainViewPagerAdapter extends FragmentStatePagerAdapter {

    private static int NUM_ITEMS = 2;

    public MainViewPagerAdapter(FragmentManager fragmentManager) {
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
                return StartrealscreenFragment.newInstance(0);
            case 1:
                return SartscreenFragment.newInstance(1);


            default:
                return null;
        }
    }

}