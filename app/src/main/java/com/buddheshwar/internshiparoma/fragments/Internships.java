package com.buddheshwar.internshiparoma.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import com.buddheshwar.internshiparoma.R;
import com.buddheshwar.internshiparoma.adapters.InternshipsAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class Internships extends Fragment {
    RecyclerView mrecyclerview;
    InternshipsAdapter madapter;
    LinearLayoutManager linearLayoutManager;
    public Internships() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_internships, container, false);
        setHasOptionsMenu(true);
        return view;
    }
    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.searchandfiltermenu,menu);
        MenuItem menuItem=menu.findItem(R.id.action_search);
        SearchView searchView=(SearchView)menuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.filter:{

            }
        }
        return super.onOptionsItemSelected(item);
    }
}
