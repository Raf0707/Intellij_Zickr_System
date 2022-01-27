package com.example.alhamdulillah;

import android.content.*;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;


public class CountDolgNamazFragment extends Fragment implements View.OnClickListener {

    private EditText tsel;
    private TextView podschet;
    private Button ok;
    private int dolg;
    public int dney;
    private int namazov;
    private String strDney;
    private String strNamazov;
    private View view;
    private LayoutInflater layoutInflater;
    public SharedPreferences ssPref;
    public TextView ostalos;
    public TextView vospoln;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_count_dolg_namaz, null);

        Button starter = view.findViewById(R.id.startt);
        starter.setOnClickListener(this);

        Button nazad = view.findViewById(R.id.nazad);
        nazad.setOnClickListener(this);

        tsel = view.findViewById(R.id.tsel);
        podschet = view.findViewById(R.id.podschet);
        ok = view.findViewById(R.id.ok);
        ok.setOnClickListener(this);
        layoutInflater = getLayoutInflater();

        //loadText();


        return view;
    }

    @Override
    public void onClick(View view) {
    }
}