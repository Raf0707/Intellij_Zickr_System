package com.example.alhamdulillah;

import android.net.*;
import android.os.*;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.barteksc.pdfviewer.*;

import java.io.*;


public class GreenKoranFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_koran, null);

        PDFView pdfView = view.findViewById(R.id.pdfView);
        File file = new File(Environment.getExternalStorageDirectory()+"/Download/","GreenQuran.pdf");
        Uri path  = Uri.fromFile(file);
        pdfView.fromUri(path).load();

        return view;
    }
}