package com.nilprojects.androiduidesign.Activities.SpotsUi.Fragment;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;


import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.nilprojects.androiduidesign.Activities.SpotsUi.Activity.CartActivity;
import com.nilprojects.androiduidesign.Activities.SpotsUi.Activity.MainActivitySpot;
import com.nilprojects.androiduidesign.Activities.SpotsUi.Adapter.HomeRecyclerViewAdapter;
import com.nilprojects.androiduidesign.Activities.SpotsUi.Adapter.StartrealViewPagerAdapter;
import com.nilprojects.androiduidesign.Activities.SpotsUi.Utils.DrawFromBackTransformer;
import com.nilprojects.androiduidesign.CommonUtils.Utils;
import com.nilprojects.androiduidesign.MainActivity;
import com.nilprojects.androiduidesign.R;

import java.util.ArrayList;

import okhttp3.internal.Util;


public class StartrealscreenFragment extends Fragment {

    View view;
    RecyclerView recyclerView1,recyclerView2,recyclerView3,recyclerView4,recyclerView5,recyclerView6,recyclerView7;
    HomeRecyclerViewAdapter homeRecyclerViewAdapter, homeRecyclerViewAdapter2,homeRecyclerViewAdapter3,homeRecyclerViewAdapter4,homeRecyclerViewAdapter5,homeRecyclerViewAdapter6,homeRecyclerViewAdapter7;
    ArrayList<Integer> _imgs = new ArrayList<>();
    ArrayList<Integer> _imgs1 = new ArrayList<>();
    MainActivitySpot mainActivity;
    ViewPager viewPager;
    ImageView ivGit;
    StartrealViewPagerAdapter startrealViewPagerAdapter;
    ScrollView scrollView;

    ImageView imvbacket;

    public static StartrealscreenFragment newInstance(int page) {
        StartrealscreenFragment fragmentFirst = new StartrealscreenFragment();
        Bundle args = new Bundle();
        args.putInt("subInt", page);
        fragmentFirst.setArguments(args);
        return fragmentFirst;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_startrealscreen, container, false);
        _imgs.add(R.drawable.swimmer); _imgs.add(R.drawable.swimmer); _imgs.add(R.drawable.swimmer); _imgs.add(R.drawable.swimmer);
        _imgs.add(R.drawable.swimmer); _imgs.add(R.drawable.swimmer);


        _imgs1.add(R.drawable.image); _imgs1.add(R.drawable.man1); _imgs1.add(R.drawable.image);
        _imgs1.add(R.drawable.man3); _imgs1.add(R.drawable.man1); _imgs1.add(R.drawable.image);

        viewPager=(ViewPager)view.findViewById(R.id.view_pager2);
        ivGit = (ImageView) view.findViewById(R.id.ivGit);
        startrealViewPagerAdapter=new StartrealViewPagerAdapter(getChildFragmentManager());
        viewPager.setAdapter(startrealViewPagerAdapter);
        viewPager.setPageTransformer(true, new DrawFromBackTransformer());




        recyclerView1=(RecyclerView)view.findViewById(R.id.rev_image3);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mainActivity, LinearLayoutManager.HORIZONTAL, false);
        recyclerView1.setLayoutManager(linearLayoutManager);
        homeRecyclerViewAdapter = new HomeRecyclerViewAdapter(mainActivity, _imgs);
        recyclerView1.setAdapter(homeRecyclerViewAdapter);

        recyclerView2=(RecyclerView)view.findViewById(R.id.rev_image4);
        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(mainActivity, LinearLayoutManager.HORIZONTAL, false);
        recyclerView2.setLayoutManager(linearLayoutManager1);
        homeRecyclerViewAdapter2 = new HomeRecyclerViewAdapter(mainActivity, _imgs1);
        recyclerView2.setAdapter(homeRecyclerViewAdapter2);

        recyclerView3=(RecyclerView)view.findViewById(R.id.rev_image5);
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(mainActivity, LinearLayoutManager.HORIZONTAL, false);
        recyclerView3.setLayoutManager(linearLayoutManager2);
        homeRecyclerViewAdapter3 = new HomeRecyclerViewAdapter(mainActivity, _imgs);
        recyclerView3.setAdapter(homeRecyclerViewAdapter3);

        recyclerView4=(RecyclerView)view.findViewById(R.id.rev_image6);
        LinearLayoutManager linearLayoutManager3 = new LinearLayoutManager(mainActivity, LinearLayoutManager.HORIZONTAL, false);
        recyclerView4.setLayoutManager(linearLayoutManager3);
        homeRecyclerViewAdapter4 = new HomeRecyclerViewAdapter(mainActivity, _imgs1);
        recyclerView4.setAdapter(homeRecyclerViewAdapter4);

        recyclerView5=(RecyclerView)view.findViewById(R.id.rev_image7);
        LinearLayoutManager linearLayoutManager4 = new LinearLayoutManager(mainActivity, LinearLayoutManager.HORIZONTAL, false);
        recyclerView5.setLayoutManager(linearLayoutManager4);
        homeRecyclerViewAdapter5 = new HomeRecyclerViewAdapter(mainActivity, _imgs1);
        recyclerView5.setAdapter(homeRecyclerViewAdapter5);

        recyclerView6=(RecyclerView)view.findViewById(R.id.rev_image8);
        LinearLayoutManager linearLayoutManager5 = new LinearLayoutManager(mainActivity, LinearLayoutManager.HORIZONTAL, false);
        recyclerView6.setLayoutManager(linearLayoutManager5);
        homeRecyclerViewAdapter6 = new HomeRecyclerViewAdapter(mainActivity, _imgs1);
        recyclerView6.setAdapter(homeRecyclerViewAdapter6);

        recyclerView7=(RecyclerView)view.findViewById(R.id.rev_image9);
        LinearLayoutManager linearLayoutManager6 = new LinearLayoutManager(mainActivity, LinearLayoutManager.HORIZONTAL, false);
        recyclerView7.setLayoutManager(linearLayoutManager6);
        homeRecyclerViewAdapter7 = new HomeRecyclerViewAdapter(mainActivity, _imgs1);
        recyclerView7.setAdapter(homeRecyclerViewAdapter7);

        scrollView=(ScrollView)view.findViewById(R.id.lyt_scrol);


        ivGit.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Utils.INSTANCE.navigateToGithub("https://github.com/raiarainne/Spots-App-UI",getActivity());
                    }
                }
        );


        mainActivity.getViewPager().addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if(mainActivity.getViewPager().getCurrentItem()==1){
                  //  Toast.makeText(mainActivity, "toast", Toast.LENGTH_SHORT).show();

                    scrollView.setVisibility(View.GONE);

                }else {
                    scrollView.setVisibility(View.VISIBLE);
                  //  Toast.makeText(mainActivity, "true", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        imvbacket=(ImageView)view.findViewById(R.id.imv_baket);
        imvbacket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(mainActivity, CartActivity.class);
                startActivity(intent);
            }
        });





        return view;
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        mainActivity = (MainActivitySpot) context;

    }

    /*@Override
    public void onAttach(Context context) {
        super.onAttach(context);

        mainActivity = (MainActivity)context;

    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if(hidden==true){
            Toast.makeText(mainActivity, "hidden", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(mainActivity, "view", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        scrollView.setVisibility(View.GONE);
        Toast.makeText(mainActivity, "pause", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Toast.makeText(mainActivity, "desctoy", Toast.LENGTH_SHORT).show();
    }
    */

}
