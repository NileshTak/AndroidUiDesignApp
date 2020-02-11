package com.nilprojects.androiduidesign.Activities.SpotsUi.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.nilprojects.androiduidesign.Activities.SpotsUi.Activity.MainActivitySpot;
import com.nilprojects.androiduidesign.R;


public class fouth_sub2Fragment extends Fragment {
    MainActivitySpot mainActivity;
    private String title;
    private int page;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fouth_sub2, container, false);
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        mainActivity = (MainActivitySpot) context;

    }


}
