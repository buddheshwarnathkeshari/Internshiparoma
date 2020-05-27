package com.buddheshwar.internshiparoma.fragments;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.buddheshwar.internshiparoma.PostInternshipActivity;
import com.buddheshwar.internshiparoma.adapters.CitiesAdapter;
import com.buddheshwar.internshiparoma.R;
import com.buddheshwar.internshiparoma.model.CitiesModel;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A simple {@link Fragment} subclass.
 */
public class DashboardFragment extends Fragment {
    private ArrayList<CitiesModel> modelArrayList;
    private EditText searchtext;
    private RecyclerView citiesrecyclerview;
    CitiesAdapter madapter;
    public DashboardFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_dashboard,container,false);
        searchtext=view.findViewById(R.id.search);
        citiesrecyclerview=view.findViewById(R.id.citiesrecyclerview);


        Button post=view.findViewById(R.id.postinternship);

        post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), PostInternshipActivity.class));
            }
        });

        LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity());
        modelArrayList=new ArrayList<CitiesModel>();
        modelArrayList.add(new CitiesModel(R.drawable.banglore,"Banglore"));
        modelArrayList.add(new CitiesModel(R.drawable.mumbai,"Mumbai"));
        modelArrayList.add(new CitiesModel(R.drawable.hyderabad,"Hyderabad"));
        modelArrayList.add(new CitiesModel(R.drawable.pune,"Pune"));
        modelArrayList.add(new CitiesModel(R.drawable.jaipur,"Jaipur"));
        modelArrayList.add(new CitiesModel(R.drawable.lucknow,"Lucknow"));
        modelArrayList.add(new CitiesModel(R.drawable.delhi,"Delhi"));
        modelArrayList.add(new CitiesModel(R.drawable.kolkata,"Kolkata"));
        Collections.shuffle(modelArrayList);
        madapter=new CitiesAdapter(getContext(),modelArrayList);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        citiesrecyclerview.setLayoutManager(layoutManager);
        citiesrecyclerview.setAdapter(madapter);
        madapter.setonclicklistener(new CitiesAdapter.onclicklistener() {
            @SuppressLint("ShowToast")
            @Override
            public void oncityselelected(int position) {
                Toast.makeText(getActivity(),modelArrayList.get(position).getCityname(),Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}
