package com.example.alhamdulillah;

import android.content.*;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

public class DolgFragment extends Fragment implements View.OnClickListener {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_dolg, null);

        Button namaz = view.findViewById(R.id.namaz);
        namaz.setOnClickListener(this);

        Button post = view.findViewById(R.id.postt);
        post.setOnClickListener(this);

        Button today = view.findViewById(R.id.today);
        today.setOnClickListener(this);


        return inflater.inflate(R.layout.fragment_dolg, container, false);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.namaz:


            case R.id.postt:


            case R.id.today:
                

        }

    }

}