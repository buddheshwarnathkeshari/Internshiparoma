package com.buddheshwar.internshiparoma.resume;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.buddheshwar.internshiparoma.R;

public class PersonalDetails extends Fragment {


    public PersonalDetails() {
        // Required empty public constructor
    }

    RelativeLayout actionResume;
    TextView resumeTitle;
    ImageView home;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_personal_details, container, false);

        actionResume=getActivity().findViewById(R.id.actionResume);
        resumeTitle=getActivity().findViewById(R.id.title);
        home=getActivity().findViewById(R.id.home);

        home.setVisibility(View.VISIBLE);

        resumeTitle.setText("Personal Details");

        return view;
    }
}
