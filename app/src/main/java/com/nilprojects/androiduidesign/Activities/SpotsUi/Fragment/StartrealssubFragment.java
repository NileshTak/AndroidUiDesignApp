package com.nilprojects.androiduidesign.Activities.SpotsUi.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.nilprojects.androiduidesign.R;


public class StartrealssubFragment extends Fragment {

    public static StartrealssubFragment newInstance(int page) {
        StartrealssubFragment fragmentFirst = new StartrealssubFragment();
        Bundle args = new Bundle();
        args.putInt("subInt", page);
        fragmentFirst.setArguments(args);
        return fragmentFirst;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_startrealssub, container, false);
    }


}
