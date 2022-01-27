package com.example.alhamdulillah;

import android.content.*;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;


public class TodayNamazFragment extends Fragment implements View.OnClickListener {

    private CheckBox fajr;
    private CheckBox fadjr_sunna;
    private CheckBox fadjr_fard;
    private CheckBox zuckhr;
    private CheckBox zuckhr_sunna_4;
    private CheckBox zuckhr_fard;
    private CheckBox zuckhr_sunna_2;
    private CheckBox asr;
    private CheckBox asr_sunna;
    private CheckBox asr_fard;
    private CheckBox magrib;
    private CheckBox magrib_fard;
    private CheckBox magrib_sunna;
    private CheckBox isha;
    private CheckBox isha_sunna_4;
    private CheckBox isha_fard;
    private CheckBox isha_sunna_2;
    private CheckBox tahajud;
    private CheckBox witr_vajib;

    private Button back_namaz;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_today_namaz, null);
        
        this.fajr = view.findViewById(R.id.fadjr_namaz);
        this.fadjr_sunna = view.findViewById(R.id.fadjr_sunna_namaz);
        this.fadjr_fard = view.findViewById(R.id.fadjr_fard_namaz);

        this.zuckhr = view.findViewById(R.id.zuckhr_namaz);
        this.zuckhr_sunna_4 = view.findViewById(R.id.zuckhr_sunna_4_namaz);
        this.zuckhr_fard = view.findViewById(R.id.zuckhr_fard_namaz);
        this.zuckhr_sunna_2 = view.findViewById(R.id.zuckhr_sunna_2_namaz);

        this.asr = view.findViewById(R.id.asr_namaz);
        this.asr_sunna = view.findViewById(R.id.asr_sunna_namaz);
        this.asr_fard = view.findViewById(R.id.asr_fard_namaz);

        this.magrib = view.findViewById(R.id.magrib_namaz);
        this.magrib_fard = view.findViewById(R.id.magrib_fard_namaz);
        this.magrib_sunna = view.findViewById(R.id.magrib_sunna_namaz);

        this.isha = view.findViewById(R.id.isha_namaz);
        this.isha_sunna_4 = view.findViewById(R.id.isha_sunna_4_namaz);
        this.isha_fard = view.findViewById(R.id.isha_fard_namaz);
        this.isha_sunna_2 = view.findViewById(R.id.isha_sunna_2_namaz);
        this.tahajud = view.findViewById(R.id.tahajud_namaz);
        this.witr_vajib = view.findViewById(R.id.witr_namaz);

        back_namaz = view.findViewById(R.id.back_namaz);
        back_namaz.setOnClickListener(this);

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

        this.fadjr_sunna.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                checkFajr(isChecked);
            }
        });

        this.fadjr_fard.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                checkFajr(isChecked);
            }
        });

        this.zuckhr_sunna_4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                checkZuckhr(isChecked);
            }
        });

        this.zuckhr_fard.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                checkZuckhr(isChecked);
            }
        });

        this.zuckhr_sunna_2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                checkZuckhr(isChecked);
            }
        });

        this.asr_sunna.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                checkAsr(isChecked);
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

        this.magrib_sunna.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                checkMagrib(isChecked);
            }
        });

        this.isha_sunna_4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                checkIsha(isChecked);
            }
        });

        this.isha_fard.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                checkIsha(isChecked);
            }
        });

        this.isha_sunna_2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                checkIsha(isChecked);
            }
        });

        this.tahajud.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
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

        return view;

    }

    private void checkAllFajrCheckedChange(boolean isChecked)  {
        this.fadjr_sunna.setChecked(isChecked);
        this.fadjr_fard.setChecked(isChecked);
    }

    private void checkAllZuckrCheckedChange(boolean isChecked) {
        this.zuckhr_sunna_4.setChecked(isChecked);
        this.zuckhr_fard.setChecked(isChecked);
        this.zuckhr_sunna_2.setChecked(isChecked);
    }

    private void checkAllAsrCheckedChange(boolean isChecked) {
        this.asr_sunna.setChecked(isChecked);
        this.asr_fard.setChecked(isChecked);
    }

    private void checkAllMagribCheckedChange(boolean isChecked) {
        this.magrib_fard.setChecked(isChecked);
        this.magrib_sunna.setChecked(isChecked);
    }

    private void checkAllIshaCheckedChange(boolean isChecked) {
        this.isha_sunna_4.setChecked(isChecked);
        this.isha_fard.setChecked(isChecked);
        this.isha_sunna_2.setChecked(isChecked);
        this.tahajud.setChecked(isChecked);
        this.witr_vajib.setChecked(isChecked);
    }

    private void checkFajr (boolean isChecked) {
        if (fadjr_sunna.isChecked() & fadjr_fard.isChecked()) {
            this.fajr.setChecked(isChecked);
        }
    }

    private void checkZuckhr (boolean isChecked) {
        if (zuckhr_sunna_4.isChecked() & zuckhr_fard.isChecked() & zuckhr_sunna_2.isChecked()) {
            this.zuckhr.setChecked(isChecked);
        }
    }

    private void checkAsr (boolean isChecked) {
        if (asr_sunna.isChecked() & asr_fard.isChecked()) {
            this.asr.setChecked(isChecked);
        }
    }

    private void checkMagrib (boolean isChecked) {
        if (magrib_fard.isChecked() & magrib_sunna.isChecked()) {
            this.magrib.setChecked(isChecked);
        }
    }

    private void checkIsha (boolean isChecked) {
        if (isha_sunna_4.isChecked() & isha_fard.isChecked() & isha_sunna_2.isChecked() & tahajud.isChecked() & witr_vajib.isChecked()) {
            this.isha.setChecked(isChecked);
        }
    }


    @Override
    public void onClick(View view) {
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.navigationlayout, new DolgFragment()).commit();
    }
        
    

    
}