package com.example.alhamdulillah;

import static android.content.Context.MODE_PRIVATE;

import android.content.*;
import android.os.*;

import androidx.constraintlayout.widget.*;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import java.util.concurrent.*;


public class SubhanFragment extends Fragment implements View.OnClickListener {
    private ConstraintLayout subhanLayout;
    private Handler handler;
    private int counter = 0;
    private TextView subhanCounter;
    private Button bacckmenusss;
    private SharedPreferences sssPrefff;
    private TextView subhanLlahBiHamdih;
    private TextView translateSubhanLlahBiHamdih;
    private TextView generateTsel;
    private int tselCount;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        
        View view = inflater.inflate(R.layout.fragment_subhan, null);

        subhanLayout = view.findViewById(R.id.subhanLayout);
        handler = new Handler();
        subhanCounter = view.findViewById(R.id.subhanCount);
        bacckmenusss = view.findViewById(R.id.bacckmenusss);
        bacckmenusss.setOnClickListener(this);

        subhanLlahBiHamdih = view.findViewById(R.id.subhanLlahBiHamdih);
        translateSubhanLlahBiHamdih = view.findViewById(R.id.translateSubhanLlahBiHamdih);

        generateTsel = view.findViewById(R.id.subhanCountGenerateTsel);

        generateTsel.setText(getRandomTsel(146325749, 938789359));
        tselCount = Integer.parseInt(generateTsel.getText().toString());
        final int ccount = Integer.parseInt(generateTsel.getText().toString());

        Thread t = new Thread(() -> {
            try{
                TimeUnit.MILLISECONDS.sleep(100);
                handler.post(r);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        });

        t.start();

        subhanLayout.setOnTouchListener(new OnSwipeTouchListener(view.getContext()) {

            @Override
            public void onSwipeRight() {
                counter++;
                if (tselCount > 0) tselCount--;
                subhanCounter.setText(Integer.toString(counter));
                generateTsel.setText(Integer.toString(tselCount));
                saveText();
            }

            @Override
            public void onSwipeLeft() {
                if (counter > 0) counter--;
                tselCount++;
                subhanCounter.setText(Integer.toString(counter));
                generateTsel.setText(Integer.toString(tselCount));
                saveText();
            }

            @Override
            public void onSwipeUp() {
                if (counter > 0) counter--;
                tselCount++;
                subhanCounter.setText(Integer.toString(counter));
                generateTsel.setText(Integer.toString(tselCount));
                saveText();
            }

            @Override
            public void onSwipeDown() {
                counter++;
                if (tselCount > 0) tselCount--;
                subhanCounter.setText(Integer.toString(counter));
                generateTsel.setText(Integer.toString(tselCount));
                saveText();
            }

            @Override
            public void onClick() {
                counter++;
                if (tselCount > 0) tselCount--;
                subhanCounter.setText(Integer.toString(counter));
                generateTsel.setText(Integer.toString(tselCount));
                saveText();

            }

            @Override
            public void onLongClick() {
                counter = 0;
                subhanCounter.setText(Integer.toString(counter));
                saveText();
            }

        });

        loadText();

        return view;
    }

    Runnable r = new Runnable() {
        public void run(){
            subhanCounter.setText(Integer.toString(counter));
            handler.postDelayed(r,100);
        }
    };

    @Override
    public void onClick(View view) {
        saveText();
        Intent bacckkmenu = new Intent(getContext(), MainActivity.class);
        startActivity(bacckkmenu);
        loadText();

    }

    public static String getRandomTsel(int min, int max){
        int x = (int) ((Math.random()*((max-min)+1))+min);
        return Integer.toString(x);
    }

    public void saveText() {
        sssPrefff = getActivity().getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor ed = sssPrefff.edit();
        ed.putString("Сделаллсс", subhanCounter.getText().toString());
        ed.putString("Осталосьь", generateTsel.getText().toString());
        counter = Integer.parseInt(subhanCounter.getText().toString());
        tselCount = Integer.parseInt(generateTsel.getText().toString());
        ed.apply();
    }

    public void loadText() {
        sssPrefff = getActivity().getPreferences(MODE_PRIVATE);
        String sdellText = sssPrefff.getString("Сделаллсс", subhanCounter.getText().toString());
        String ossstText = sssPrefff.getString("Осталосьь", generateTsel.getText().toString());
        subhanCounter.setText(sdellText);
        generateTsel.setText(ossstText);
        counter = Integer.parseInt(subhanCounter.getText().toString());
        tselCount = Integer.parseInt(generateTsel.getText().toString());
    }

    @Override
    public void onDestroy() {
        saveText();
        loadText();
        super.onDestroy();
    }

}
