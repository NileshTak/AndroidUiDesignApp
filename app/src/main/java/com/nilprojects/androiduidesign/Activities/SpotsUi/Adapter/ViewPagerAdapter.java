package com.nilprojects.androiduidesign.Activities.SpotsUi.Adapter;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.nilprojects.androiduidesign.Activities.SpotsUi.Fragment.PriceFirstFragment;
import com.nilprojects.androiduidesign.Activities.SpotsUi.Fragment.PriceSecondFragment;
import com.nilprojects.androiduidesign.Activities.SpotsUi.Fragment.PriceThirdFragment;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private static int NUM_ITEMS = 3;

    public ViewPagerAdapter(FragmentManager fragmentManager) {
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
                return PriceFirstFragment.newInstance(0);
            case 1:
                return PriceSecondFragment.newInstance(1);
            case 2:
                return PriceThirdFragment.newInstance(2);
            default:
                return null;
        }
    }

}