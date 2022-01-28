package com.example.alhamdulillah;

import android.content.*;
import android.graphics.*;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import java.lang.ref.*;


public class DolgNamazFragment extends Fragment implements View.OnClickListener {

    private CheckBox fajr;
    private CheckBox fadjr_fard;
    private CheckBox zuckhr;
    private CheckBox zuckhr_fard;
    private CheckBox asr;
    private CheckBox asr_fard;
    private CheckBox magrib;
    private CheckBox magrib_fard;
    private CheckBox isha;
    private CheckBox isha_fard;
    private CheckBox witr_vajib;

    public TextView vosp;
    public TextView ost;

    private int dolg;
    private int sdel;

    private Button reset;
    private Button plus;
    private Button minus;

    public static WeakReference<DolgNamazFragment> weakReference = null;

    public SharedPreferences ssPref;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dolg_namaz, null);

        vosp = view.findViewById(R.id.vospolnill);
        ost = view.findViewById(R.id.ostaloss);
        //int this_dolg = getIntent().getIntExtra("dney", 0);
        //String this_save_dolg = Integer.toString(this_dolg);
        //ost.setText(Integer.toString(this_dolg));
        //ost.setTextColor(Color.rgb(18,112,90));
        //vosp.setText("0");

        weakReference = new WeakReference<>(this);

        reset = view.findViewById(R.id.resett);
        reset.setOnClickListener(this);

        plus = view.findViewById(R.id.pluss);
        plus.setOnClickListener(this);

        minus = view.findViewById(R.id.minuss);
        minus.setOnClickListener(this);

        Button nmainn = view.findViewById(R.id.backbackk);
        nmainn.setOnClickListener(this);

        this.fajr = view.findViewById(R.id.fadjrr);
        this.fadjr_fard = view.findViewById(R.id.fadjr_fardd);

        this.zuckhr = view.findViewById(R.id.Zuckhrr);
        this.zuckhr_fard = view.findViewById(R.id.Zuckhr_fardd);

        this.asr = view.findViewById(R.id.asrr);
        this.asr_fard = view.findViewById(R.id.asr_fardd);

        this.magrib = view.findViewById(R.id.Magribb);
        this.magrib_fard = view.findViewById(R.id.Magrib_fardd);

        this.isha = view.findViewById(R.id.Ishaa);
        this.isha_fard = view.findViewById(R.id.Isha_fardd);
        this.witr_vajib = view.findViewById(R.id.Witrr);

        this.fajr.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                checkAllFajrCheckedChange(isChecked);
            }
        });

        this.zuckhr.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                checkAllZuckrCheckedChange(isChecked);
            }
        });

        this.asr.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                checkAllAsrCheckedChange(isChecked);
            }
        });

        this.magrib.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                checkAllMagribCheckedChange(isChecked);
            }
        });

        this.isha.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                checkAllIshaCheckedChange(isChecked);
            }
        });

        this.fadjr_fard.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                checkFajr(isChecked);
            }
        });

        this.zuckhr_fard.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                checkZuckhr(isChecked);
            }
        });

        this.asr_fard.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                checkAsr(isChecked);
            }
        });

        this.magrib_fard.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                checkMagrib(isChecked);
            }
        });

        this.isha_fard.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                checkIsha(isChecked);
            }
        });

        this.witr_vajib.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                checkIsha(isChecked);
            }
        });

        //loadText();

        return view;

    }

    private void checkAllFajrCheckedChange(boolean isChecked)  {
        this.fadjr_fard.setChecked(isChecked);
    }

    private void checkAllZuckrCheckedChange(boolean isChecked) {
        this.zuckhr_fard.setChecked(isChecked);
    }

    private void checkAllAsrCheckedChange(boolean isChecked) {
        this.asr_fard.setChecked(isChecked);
    }

    private void checkAllMagribCheckedChange(boolean isChecked) {
        this.magrib_fard.setChecked(isChecked);
    }

    private void checkAllIshaCheckedChange(boolean isChecked) {
        this.isha_fard.setChecked(isChecked);
        this.witr_vajib.setChecked(isChecked);

    }

    private void checkFajr (boolean isChecked) {
        if (fadjr_fard.isChecked()) {
            this.fajr.setChecked(isChecked);
        }
    }

    private void checkZuckhr (boolean isChecked) {
        if (zuckhr_fard.isChecked()) {
            this.zuckhr.setChecked(isChecked);
        }
    }

    private void checkAsr (boolean isChecked) {
        if (asr_fard.isChecked()) {
            this.asr.setChecked(isChecked);
        }
    }

    private void checkMagrib (boolean isChecked) {
        if (magrib_fard.isChecked()) {
            this.magrib.setChecked(isChecked);
        }
    }

    private void checkIsha (boolean isChecked) {
        if (isha_fard.isChecked()& witr_vajib.isChecked()) {
            this.isha.setChecked(isChecked);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.backbackk:
                Intent main = new Intent(getContext(), MainActivity.class);
                startActivity(main);
                break;

            case R.id.resett:

                //ost.setText(Integer.toString((Integer.parseInt(vosp.getText().toString())) + (Integer.parseInt(ost.getText().toString()))));
                //vosp.setText("0");

                this.fajr.setChecked(false);
                this.fadjr_fard.setChecked(false);
                this.zuckhr.setChecked(false);
                this.zuckhr_fard.setChecked(false);
                this.asr.setChecked(false);
                this.asr_fard.setChecked(false);
                this.magrib.setChecked(false);
                this.magrib_fard.setChecked(false);
                this.isha.setChecked(false);
                this.isha_fard.setChecked(false);
                this.witr_vajib.setChecked(false);
                break;

            case R.id.pluss:
                this.fajr.setChecked(false);
                this.fadjr_fard.setChecked(false);
                this.zuckhr.setChecked(false);
                this.zuckhr_fard.setChecked(false);
                this.asr.setChecked(false);
                this.asr_fard.setChecked(false);
                this.magrib.setChecked(false);
                this.magrib_fard.setChecked(false);
                this.isha.setChecked(false);
                this.isha_fard.setChecked(false);
                this.witr_vajib.setChecked(false);

                /*
                dolg = Integer.parseInt(ost.getText().toString());
                dolg--;
                ost.setText(Integer.toString(dolg));
                sdel = Integer.parseInt(vosp.getText().toString());
                sdel++;
                vosp.setText(Integer.toString(sdel));

                 */

                break;


            case R.id.minuss:

                this.fajr.setChecked(false);
                this.fadjr_fard.setChecked(false);
                this.zuckhr.setChecked(false);
                this.zuckhr_fard.setChecked(false);
                this.asr.setChecked(false);
                this.asr_fard.setChecked(false);
                this.magrib.setChecked(false);
                this.magrib_fard.setChecked(false);
                this.isha.setChecked(false);
                this.isha_fard.setChecked(false);
                this.witr_vajib.setChecked(false);

                /*
                dolg = Integer.parseInt(ost.getText().toString());
                sdel = Integer.parseInt(vosp.getText().toString());
                final int a = dolg;
                if ((Integer.parseInt(ost.getText().toString()) <= a) & (sdel > 0)) {
                    dolg++;
                    ost.setText(Integer.toString(dolg));
                    sdel--;
                    vosp.setText(Integer.toString(sdel));
                }

                 */

                break;

        }
    }
/*
    public void saveText() {
        sPref = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString("Восполнил", vosp.getText().toString());
        ed.putString("Осталось", ost.getText().toString());
        ed.apply();
    }

    public void loadText() {
        sPref = getPreferences(MODE_PRIVATE);
        String vospText = sPref.getString("Восполнил", vosp.getText().toString());
        String ostText = sPref.getString("Осталось", ost.getText().toString());
        vosp.setText(vospText);
        ost.setText(ostText);
    }

    @Override
    public void onDestroy() {
        saveText();
        super.onDestroy();
    }

 */

}