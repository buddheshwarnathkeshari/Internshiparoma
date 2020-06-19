package com.buddheshwar.internshiparoma.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.buddheshwar.internshiparoma.R;


public class ChatsFragment extends Fragment {
    private RecyclerView recyclerView;
    public ChatsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragmen
        View view=inflater.inflate(R.layout.fragment_chats, container, false);
        recyclerView=view.findViewById(R.id.chatsrecyclerview);
        return view;
    }
}