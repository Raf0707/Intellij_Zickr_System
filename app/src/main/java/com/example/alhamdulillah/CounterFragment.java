package com.example.alhamdulillah;

import static android.content.Context.MODE_PRIVATE;

import android.content.*;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.animation.*;
import android.os.*;
import android.view.*;
import android.view.animation.*;
import android.widget.*;

import java.text.*;
import java.util.concurrent.*;


public class CounterFragment extends Fragment implements View.OnClickListener {
    private int myCounter = 0;
    private String defolt_value = "10";
    private int maxvalue;
    private Button plus;
    private Button Zero;
    private Button Minus;
    private Button Ok;
    private Button baccck;
    private Button set;
    private TextView counter;
    private TextView editprogress;
    private EditText tsel;
    private Handler handler;
    private SharedPreferences sPreff;

    private ProgressBar mProgressBar;
    private static final TimeInterpolator GAUGE_ANIMATION_INTERPOLATOR = new DecelerateInterpolator(2);
    private static final long GAUGE_ANIMATION_DURATION = 50000;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_counter, null);

        editprogress = view.findViewById(R.id.editprogress);
        plus = view.findViewById(R.id.plus);
        Zero = view.findViewById(R.id.Zzero);
        Minus = view.findViewById(R.id.minus);
        counter = view.findViewById(R.id.count);
        mProgressBar = view.findViewById(R.id.mainProgressBar);
        mProgressBar.setVisibility(ProgressBar.VISIBLE);
        tsel = view.findViewById(R.id.Tsel);
        Ok = view.findViewById(R.id.ok);
        baccck = view.findViewById(R.id.baccck);
        set = view.findViewById(R.id.set);

        plus.setOnClickListener(this);
        Zero.setOnClickListener(this);
        Minus.setOnClickListener(this);
        Ok.setOnClickListener(this);
        set.setOnClickListener(this);
        baccck.setOnClickListener(this);

        handler = new Handler();

        Thread thread = new Thread(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(100);
                handler.post(runnable);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();

        loadText();

        return view;
    }

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            Callback.runAllCallbacks();
            handler.postDelayed(runnable, 100);
        }
    };


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.set:
                saveText();
                Intent set = new Intent(v.getContext(), SettingsActivity.class);
                startActivity(set);
                loadText();
                break;

            case R.id.ok:
                saveText();
                tsel.setText(tsel.getText().toString().replaceAll("\\.", ""));
                tsel.setText(tsel.getText().toString().replaceAll("-", ""));
                tsel.setText(tsel.getText().toString().replaceAll(",", ""));
                tsel.setText(tsel.getText().toString().replaceAll(" ", ""));

                if (tsel.getText().toString().length() == 0) {
                    tsel.setText(defolt_value);
                    maxvalue = Integer.parseInt(tsel.getText().toString());
                    mProgressBar.setMax(maxvalue);
                    Toast toast = Toast.makeText(requireActivity().getApplicationContext(), (String) ("Вы не ввели цель. По умолчанию: " + defolt_value), Toast.LENGTH_SHORT);
                    toast.show();
                } else {

                    if (Integer.parseInt(tsel.getText().toString()) <= 0) {
                        Toast toast = Toast.makeText(requireActivity().getApplicationContext(), R.string.vvediteNumberBiggerZero, Toast.LENGTH_SHORT);
                        toast.show();
                    } else {
                        Toast toast = Toast.makeText(requireActivity().getApplicationContext(), R.string.textToast, Toast.LENGTH_SHORT);
                        toast.show();
                        maxvalue = Integer.parseInt(tsel.getText().toString());
                        mProgressBar.setMax(maxvalue);

                    }
                }

                saveText();
                loadText();

                break;

            case R.id.plus:
                saveText();
                if (tsel.getText().toString().length() == 0) {
                    maxvalue = 100;
                    tsel.setText(Integer.toString(maxvalue));
                    mProgressBar.setMax(100);
                    editprogress.setText(MessageFormat.format("{0} / {1}", myCounter, 100));
                }
                if (myCounter == maxvalue) {
                    editprogress.setText(MessageFormat.format("{0} / {1}", tsel.getText().toString(), tsel.getText().toString()));
                    Toast toast = Toast.makeText(requireActivity().getApplicationContext(), R.string.CompleteTsel, Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                    }

                if (tsel.getText().toString() != null) {
                    myCounter++;
                    counter.setText(Integer.toString(myCounter));
                    if (myCounter <= Integer.parseInt(tsel.getText().toString())) {
                        editprogress.setText(MessageFormat.format("{0} / {1}", myCounter, tsel.getText().toString()));
                    }

                    ObjectAnimator animator = ObjectAnimator.ofInt(mProgressBar, "progress", myCounter, myCounter);
                    animator.setInterpolator(GAUGE_ANIMATION_INTERPOLATOR);
                    animator.setDuration(GAUGE_ANIMATION_DURATION);
                    animator.start();


                    if (tsel.length() != 0) {
                        maxvalue = Integer.parseInt(tsel.getText().toString());

                        if (myCounter == maxvalue) {
                            Toast toast = Toast.makeText(requireActivity().getApplicationContext(), R.string.CompleteTsel, Toast.LENGTH_LONG);
                            toast.setGravity(Gravity.CENTER, 0, 0);
                            toast.show();

                            }

                        }

                    }


                else {
                    Toast toast = Toast.makeText(requireActivity().getApplicationContext(), "Введите цель", Toast.LENGTH_SHORT);
                    toast.show();
                }

                saveText();
                loadText();

                break;

            case R.id.minus:
                saveText();
                myCounter--;
                if (myCounter < 0) {
                    myCounter = 0;
                }
                counter.setText(Integer.toString(myCounter));

                if (tsel.getText().toString().length() == 0) {
                    editprogress.setText(MessageFormat.format("{0} / {1}", myCounter, 100));
                } else if (myCounter <= Integer.parseInt(tsel.getText().toString())) {
                    editprogress.setText(MessageFormat.format("{0} / {1}", myCounter, tsel.getText().toString()));
                }

                ObjectAnimator animator1 = ObjectAnimator.ofInt(mProgressBar, "progress", myCounter, myCounter);
                animator1.setInterpolator(GAUGE_ANIMATION_INTERPOLATOR);
                animator1.setDuration(GAUGE_ANIMATION_DURATION);
                animator1.start();

                saveText();
                loadText();

                break;

            case R.id.Zzero:
                saveText();
                myCounter = 0;
                counter.setText(Integer.toString(myCounter));
                editprogress.setText("");

                ObjectAnimator animator2 = ObjectAnimator.ofInt(mProgressBar, "progress", myCounter, myCounter);
                animator2.setInterpolator(GAUGE_ANIMATION_INTERPOLATOR);
                animator2.setDuration(GAUGE_ANIMATION_DURATION);
                animator2.start();

                saveText();
                loadText();

                break;

            case R.id.baccck:
                saveText();
                Intent baccck = new Intent(getContext(), MainActivity.class);
                startActivity(baccck);
                loadText();

        }


    }

    public void saveText() {
        sPreff = getActivity().getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor ed = sPreff.edit();
        ed.putString("Цель", tsel.getText().toString());
        ed.putString("Сделал", counter.getText().toString());
        ed.putString("ПрогрессВью", editprogress.getText().toString());
        if (counter.getText().toString().length() != 0 ) {myCounter = Integer.parseInt(counter.getText().toString());}
        if (tsel.getText().toString().length() != 0) {mProgressBar.setMax(Integer.parseInt(tsel.getText().toString()));}
        mProgressBar.setProgress(myCounter);
        ed.apply();
    }

    public void loadText() {
        sPreff = getActivity().getPreferences(MODE_PRIVATE);
        String tselText = sPreff.getString("Цель", tsel.getText().toString());
        String sdelText = sPreff.getString("Сделал", counter.getText().toString());
        String progressText = sPreff.getString("ПрогрессВью", editprogress.getText().toString());
        tsel.setText(tselText);
        counter.setText(sdelText);
        editprogress.setText(progressText);
        myCounter = Integer.parseInt(counter.getText().toString());
        mProgressBar.setMax(Integer.parseInt(tsel.getText().toString()));
        mProgressBar.setProgress(myCounter);
    }

    @Override
    public void onDestroy() {
        saveText();
        loadText();
        super.onDestroy();
    }


}