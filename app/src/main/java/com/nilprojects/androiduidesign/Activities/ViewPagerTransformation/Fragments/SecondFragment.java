package com.nilprojects.androiduidesign.Activities.ViewPagerTransformation.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.nilprojects.androiduidesign.R;
import com.squareup.picasso.Picasso;

public class SecondFragment extends Fragment {


    public SecondFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ImageView two = (ImageView) view.findViewById(R.id.fragmentTwoBackground);

        Picasso.get().load(R.drawable.two).fit().centerCrop().into(two);
    }
}