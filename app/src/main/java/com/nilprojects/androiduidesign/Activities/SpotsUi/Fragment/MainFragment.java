package com.nilprojects.androiduidesign.Activities.SpotsUi.Fragment;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.RequiresApi;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.nilprojects.androiduidesign.Activities.SpotsUi.Activity.MainActivitySpot;
import com.nilprojects.androiduidesign.Activities.SpotsUi.Utils.LVRingProgress;
import com.nilprojects.androiduidesign.R;


public class MainFragment extends Fragment {
    View view;


    MainActivitySpot mainActivity;


    RelativeLayout lyttop;



    FrameLayout frmcontainer;
    FrameLayout frmcolaps;

    ImageView imvprev;
    public  static AppBarLayout appBarLayout;
    public  static NestedScrollView scrollView1;
    CollapsingToolbarLayout collapsingToolbarLayout;




    public static MainFragment newInstance(int page) {
        MainFragment fragmentFirst = new MainFragment();
        Bundle args = new Bundle();
        args.putInt("subInt", page);
        fragmentFirst.setArguments(args);
        return fragmentFirst;
    }

    public  static LVRingProgress mLVRingProgress;

    private static final int NUM_PAGES = 5;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_main, container, false);



        mLVRingProgress = (LVRingProgress) view.findViewById(R.id.lv_ringp);
        mLVRingProgress.setViewColor(getResources().getColor(R.color.progressback));
        mLVRingProgress.setTextColor(getResources().getColor(R.color.textcolor));
        mLVRingProgress.setPorBarStartColor(getResources().getColor(R.color.startprogress));
        mLVRingProgress.setPorBarEndColor(getResources().getColor(R.color.endprogress));
       // mLVRingProgress.setProgress(80);

        lyttop=(RelativeLayout)view.findViewById(R.id.lyt_topview);
        collapsingToolbarLayout=(CollapsingToolbarLayout)view.findViewById(R.id.collapsing_toolbar);

      //  collapsingToolbarLayout.setAlpha((float) 0.2);


       // scrview.setEnableScrolling(true);
        frmcontainer=(FrameLayout)view.findViewById(R.id.frm_contain);
       // subscrolview.setEnableScrolling(false);
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        MainsubFragment fragment = new MainsubFragment();
        fragmentTransaction.add(R.id.frm_contain, fragment);
        fragmentTransaction.commit();


        frmcolaps=(FrameLayout)view.findViewById(R.id.frm_colaps);
        frmcolaps.setAlpha(1);




        imvprev=(ImageView)view.findViewById(R.id.imv_preve1);
        imvprev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivity.getViewPager1().setCurrentItem(0, true);
            }
        });

        appBarLayout=(AppBarLayout)view.findViewById(R.id.lyt_appbar1);
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                float alpah= (float) (1-(float) Math.abs(verticalOffset)/1000);
                //collapsingToolbarLayout.setAlpha(alpah);
                frmcolaps.setAlpha(alpah);

                Log.d("offset=====", String.valueOf(alpah));
            }
        });
        scrollView1=(NestedScrollView)view.findViewById(R.id.scr_view_2);










        return view;

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        mainActivity = (MainActivitySpot) context;

    }
}
