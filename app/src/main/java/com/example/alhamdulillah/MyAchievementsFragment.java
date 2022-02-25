package com.example.alhamdulillah;

import android.content.*;
import android.os.Bundle;

import androidx.appcompat.widget.*;
import androidx.constraintlayout.widget.*;
import androidx.coordinatorlayout.widget.*;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.*;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.*;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.*;

import java.util.*;


public class MyAchievementsFragment extends Fragment {
    private RecyclerView recyclerView;
    private CoordinatorLayout achivLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_my_achievements, null, false);
        //view.setOnTouchListener(new OnSwipeTouchListener(view.getContext()));

        achivLayout = view.findViewById(R.id.achivLayout);

        recyclerView = view.findViewById(R.id.listtt);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));

        final AdapterAchievs adapter = new AdapterAchievs();
        recyclerView.setAdapter(adapter);

        FloatingActionButton fab = view.findViewById(R.id.fab);
        fab.setOnClickListener(view1 -> {
            Intent intent = new Intent(getContext(), NoteDetailsActivity.class);
            startActivity(intent);
        });

        MainViewModel mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        mainViewModel.getNoteLiveData().observe(getViewLifecycleOwner(), adapter::setItems);

//        achivLayout.setOnTouchListener(new OnSwipeTouchListener(getContext()) {
//            @Override
//            public void onSwipeRight() {
//                Intent intent = new Intent(getContext(), MainActivity.class);
//                startActivity(intent);
//            }
//        });

        return view;
    }
}