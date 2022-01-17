package com.example.alhamdulillah;

import android.content.*;
import android.os.*;

import androidx.constraintlayout.widget.*;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import java.util.concurrent.*;

public class Jest_CounterFragment extends Fragment implements View.OnClickListener {
    private ConstraintLayout jestLayout;
    private Handler handler;
    private int counter = 0;
    private TextView jestCounter;
    private Button bacckmenu;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_jest__counter, null);

        jestLayout = view.findViewById(R.id.jestLayout);
        handler = new Handler();
        jestCounter = view.findViewById(R.id.jestCount);
        bacckmenu = view.findViewById(R.id.bacckmenu);
        bacckmenu.setOnClickListener(this);

        Thread t = new Thread(() -> {
            try{
                TimeUnit.MILLISECONDS.sleep(100);
                handler.post(r);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        });

        t.start();

        jestLayout.setOnTouchListener(new OnSwipeTouchListener(view.getContext()) {

            @Override
            public void onSwipeRight() {
                counter++;
                jestCounter.setText(Integer.toString(counter));
            }

            @Override
            public void onSwipeLeft() {
                counter = 0;
                jestCounter.setText(Integer.toString(counter));
            }

            @Override
            public void onSwipeTop() {
                if (counter > 0) counter--;
                jestCounter.setText(Integer.toString(counter));
            }

            @Override
            public void onSwipeBottom() {
                counter++;
                jestCounter.setText(Integer.toString(counter));
            }
        });

        return view;
    }

    Runnable r = new Runnable() {
        public void run(){
            jestCounter.setText(Integer.toString(counter));
            handler.postDelayed(r,100);
        }
    };

    @Override
    public void onClick(View view) {
        Intent bacckkmenu = new Intent(getContext(), MainActivity.class);
        startActivity(bacckkmenu);

    }
}