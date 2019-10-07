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

public class EighthFragment extends Fragment {


    public EighthFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_eighth, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ImageView eight = (ImageView)view.findViewById(R.id.fragmentEightBackground);

        Picasso.get().load(R.drawable.eight).fit().centerCrop().into(eight);
    }
}