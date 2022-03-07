package com.example.alhamdulillah;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import org.w3c.dom.*;


public class DolgPostFragment extends Fragment implements View.OnClickListener {
    private Button plusDolgPost;
    private Button minusDolgPost;
    private Button resetDolgPost;

    private TextView ostPostDolg;
    private TextView sdelPostDolg;

    private ProgressBar dolgPostProgressBar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dolg_post, null, false);

        plusDolgPost = view.findViewById(R.id.plusDolgPost);
        minusDolgPost = view.findViewById(R.id.minusDolgPost);
        resetDolgPost = view.findViewById(R.id.resetDolgPost);

        ostPostDolg = view.findViewById(R.id.ostDolgPost);
        sdelPostDolg = view.findViewById(R.id.sdelDolgPost);

        dolgPostProgressBar = view.findViewById(R.id.dolgPostProgressBar);

        plusDolgPost.setOnClickListener(this);
        minusDolgPost.setOnClickListener(this);
        resetDolgPost.setOnClickListener(this);



        return view;
    }

    @Override
    public void onClick(View view) {

    }
}