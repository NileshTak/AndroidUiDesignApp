package com.nilprojects.androiduidesign.Activities.SpotsUi.Fragment;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.fragment.app.Fragment;


import com.nilprojects.androiduidesign.Activities.SpotsUi.Activity.CartActivity;
import com.nilprojects.androiduidesign.R;

import java.util.Calendar;

public class Cartfirstsub1Fragment extends Fragment {
    TextView datetitle;
    static TextView datetxv;
    View view;
    CartActivity mainActivity;


    public static Cartfirstsub1Fragment newInstance() {
        Cartfirstsub1Fragment fragment = new Cartfirstsub1Fragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_cartfirstsub1, container, false);
        datetitle=(TextView) view.findViewById(R.id.txv_datetitle);
        datetitle.setVisibility(View.INVISIBLE);
        datetxv=(TextView) view.findViewById(R.id.txv_date);
        datetxv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               SelectDateFragment fragment6 = new SelectDateFragment();
                fragment6.show(mainActivity.getFragmentManager(), "DatePicker");
            }
        });
        datetxv.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(datetxv.getText().length()>0){
                    datetitle.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        return view;
    }

    public static class SelectDateFragment extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);
            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        public void onDateSet(DatePicker view, int yy, int mm, int dd) {
            populateSetDate(yy, mm + 1, dd);
        }

        public void populateSetDate(int year, int month, int day) {
            //  date = String.valueOf(day) + "/" + String.valueOf(month) + "/" + String.valueOf(year);
            String date= String.valueOf(day)+"."+ String.valueOf(month)+"."+ String.valueOf(year);
            datetxv.setText(date);


        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        mainActivity = (CartActivity)context;

    }



}
