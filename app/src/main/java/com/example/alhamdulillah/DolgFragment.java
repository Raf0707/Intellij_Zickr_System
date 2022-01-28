package com.example.alhamdulillah;

import android.content.*;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

public class DolgFragment extends Fragment implements View.OnClickListener {
    private Button namaz;
    private Button post;
    private Button today;
    private Button nazad;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_dolg, null);

        namaz = view.findViewById(R.id.namaz);
        namaz.setOnClickListener(this);

        post = view.findViewById(R.id.postt);
        post.setOnClickListener(this);

        today = view.findViewById(R.id.today);
        today.setOnClickListener(this);

        nazad = view.findViewById(R.id.nazad);
        nazad.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.namaz:
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.navigationlayout, new CountDolgNamazFragment()).commit();
                break;

            case R.id.postt:


            case R.id.today:
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.navigationlayout, new TodayNamazFragment()).commit();
                break;

            case R.id.nazad:
                Intent settings = new Intent(getContext(), MainActivity.class);
                startActivity(settings);

        }

    }

}