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

public class SeventhFragment extends Fragment {


    public SeventhFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_seventh, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ImageView seven = (ImageView)view.findViewById(R.id.fragmentSevenBackground);

        Picasso.get().load(R.drawable.seven).fit().centerCrop().into(seven);
    }
}