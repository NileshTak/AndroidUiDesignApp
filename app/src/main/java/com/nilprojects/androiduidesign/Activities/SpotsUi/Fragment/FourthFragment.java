package com.nilprojects.androiduidesign.Activities.SpotsUi.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.nilprojects.androiduidesign.Activities.SpotsUi.Activity.MainActivitySpot;
import com.nilprojects.androiduidesign.R;

import java.util.ArrayList;
import java.util.List;


public class FourthFragment extends Fragment {
    MainActivitySpot mainActivity;
    View view;
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    public static FourthFragment newInstance() {
        FourthFragment fragment = new FourthFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_fourth_spot, container, false);



        viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) view.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        return view;





    }
    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager());
        adapter.addFragment(new fouth_sub1Fragment(), "Ubersicht");
        adapter.addFragment(new fouth_sub2Fragment(), "Schutz");
        adapter.addFragment(new fouth_sub3Fragment(), "Chronik");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        mainActivity = (MainActivitySpot) context;

    }


}
