package com.example.alhamdulillah;

import static android.content.Context.MODE_PRIVATE;

import android.content.*;
import android.os.Bundle;

import androidx.constraintlayout.widget.*;
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
    private Button reset;

    private ConstraintLayout todayLayout;

    private SharedPreferences ssPref;


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

        reset = view.findViewById(R.id.reset);
        reset.setOnClickListener(this);

        todayLayout = view.findViewById(R.id.todayLayout);

        this.fajr.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                checkAllFajrCheckedChange(isChecked);
                saveText();
                loadText();
            }
        });

        this.zuckhr.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                checkAllZuckrCheckedChange(isChecked);
                saveText();
                loadText();
            }
        });

        this.asr.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                checkAllAsrCheckedChange(isChecked);
                saveText();
                loadText();
            }
        });

        this.magrib.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                checkAllMagribCheckedChange(isChecked);
                saveText();
                loadText();
            }
        });

        this.isha.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                checkAllIshaCheckedChange(isChecked);
                saveText();
                loadText();
            }
        });

        this.fadjr_sunna.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                checkFajr(isChecked);
                saveText();
                loadText();
            }
        });

        this.fadjr_fard.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                checkFajr(isChecked);
                saveText();
                loadText();
            }
        });

        this.zuckhr_sunna_4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                checkZuckhr(isChecked);
                saveText();
                loadText();
            }
        });

        this.zuckhr_fard.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                checkZuckhr(isChecked);
                saveText();
                loadText();
            }
        });

        this.zuckhr_sunna_2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                checkZuckhr(isChecked);
                saveText();
                loadText();
            }
        });

        this.asr_sunna.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                checkAsr(isChecked);
                saveText();
                loadText();
            }
        });

        this.asr_fard.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                checkAsr(isChecked);
                saveText();
                loadText();
            }
        });

        this.magrib_fard.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                checkMagrib(isChecked);
                saveText();
                loadText();
            }
        });

        this.magrib_sunna.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                checkMagrib(isChecked);
                saveText();
                loadText();
            }
        });

        this.isha_sunna_4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                checkIsha(isChecked);
                saveText();
                loadText();
            }
        });

        this.isha_fard.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                checkIsha(isChecked);
                saveText();
                loadText();
            }
        });

        this.isha_sunna_2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                checkIsha(isChecked);
                saveText();
                loadText();
            }
        });

        this.tahajud.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                checkIsha(isChecked);
                saveText();
                loadText();
            }
        });

        this.witr_vajib.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                checkIsha(isChecked);
                saveText();
                loadText();
            }
        });

        view.setOnTouchListener(new OnSwipeTouchListener(view.getContext()) {

            @Override
            public void onDoubleClick() {
                saveText();
                loadText();
                Intent bacckkmenu = new Intent(getContext(), MainActivity.class);
                startActivity(bacckkmenu);
                saveText();
                loadText();
            }
        });

        loadText();

        return view;

    }

    private void checkAllFajrCheckedChange(boolean isChecked)  {
        this.fadjr_sunna.setChecked(isChecked);
        this.fadjr_fard.setChecked(isChecked);
        saveText();
        loadText();
    }

    private void checkAllZuckrCheckedChange(boolean isChecked) {
        this.zuckhr_sunna_4.setChecked(isChecked);
        this.zuckhr_fard.setChecked(isChecked);
        this.zuckhr_sunna_2.setChecked(isChecked);
        saveText();
        loadText();
    }

    private void checkAllAsrCheckedChange(boolean isChecked) {
        this.asr_sunna.setChecked(isChecked);
        this.asr_fard.setChecked(isChecked);
        saveText();
        loadText();
    }

    private void checkAllMagribCheckedChange(boolean isChecked) {
        this.magrib_fard.setChecked(isChecked);
        this.magrib_sunna.setChecked(isChecked);
        saveText();
        loadText();
    }

    private void checkAllIshaCheckedChange(boolean isChecked) {
        this.isha_sunna_4.setChecked(isChecked);
        this.isha_fard.setChecked(isChecked);
        this.isha_sunna_2.setChecked(isChecked);
        this.tahajud.setChecked(isChecked);
        this.witr_vajib.setChecked(isChecked);
        saveText();
        loadText();
    }

    private void checkFajr (boolean isChecked) {
        if (fadjr_sunna.isChecked() & fadjr_fard.isChecked()) {
            this.fajr.setChecked(isChecked);
            saveText();
            loadText();
        }
    }

    private void checkZuckhr (boolean isChecked) {
        if (zuckhr_sunna_4.isChecked() & zuckhr_fard.isChecked() & zuckhr_sunna_2.isChecked()) {
            this.zuckhr.setChecked(isChecked);
            saveText();
            loadText();
        }
    }

    private void checkAsr (boolean isChecked) {
        if (asr_sunna.isChecked() & asr_fard.isChecked()) {
            this.asr.setChecked(isChecked);
            saveText();
            loadText();
        }
    }

    private void checkMagrib (boolean isChecked) {
        if (magrib_fard.isChecked() & magrib_sunna.isChecked()) {
            this.magrib.setChecked(isChecked);
            saveText();
            loadText();
        }
    }

    private void checkIsha (boolean isChecked) {
        if (isha_sunna_4.isChecked() & isha_fard.isChecked() & isha_sunna_2.isChecked() & tahajud.isChecked() & witr_vajib.isChecked()) {
            this.isha.setChecked(isChecked);
            saveText();
            loadText();
        }
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_namaz:
                saveText();
                loadText();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.navigationlayout, new DolgFragment()).commit();
                saveText();
                //loadText();
                break;

            case R.id.reset:

                saveText();
                loadText();

                fajr.setChecked(false);
                fadjr_sunna.setChecked(false);
                fadjr_fard.setChecked(false);

                zuckhr.setChecked(false);
                zuckhr_sunna_4.setChecked(false);
                zuckhr_fard.setChecked(false);
                zuckhr_sunna_2.setChecked(false);

                asr.setChecked(false);
                asr_sunna.setChecked(false);
                asr_fard.setChecked(false);

                magrib.setChecked(false);
                magrib_fard.setChecked(false);
                magrib_sunna.setChecked(false);

                isha.setChecked(false);
                isha_sunna_4.setChecked(false);
                isha_fard.setChecked(false);
                isha_sunna_2.setChecked(false);
                tahajud.setChecked(false);
                witr_vajib.setChecked(false);

                saveText();
                //loadText();

                break;

        }

    }

    public void saveText() {
        ssPref = getActivity().getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor ed = ssPref.edit();

        ed.putBoolean("fadjr", fajr.isChecked());
        ed.putBoolean("fadjr_sunna", fadjr_sunna.isChecked());
        ed.putBoolean("fadjr_fard", fadjr_fard.isChecked());

        ed.putBoolean("zuckhr", zuckhr.isChecked());
        ed.putBoolean("zuckhr_sunna_4", zuckhr_sunna_4.isChecked());
        ed.putBoolean("zuckhr_fard", zuckhr_fard.isChecked());
        ed.putBoolean("zuckhr_sunna_2", zuckhr_sunna_2.isChecked());

        ed.putBoolean("asr", asr.isChecked());
        ed.putBoolean("asr_sunna", asr_sunna.isChecked());
        ed.putBoolean("asr_fard", asr_fard.isChecked());

        ed.putBoolean("magrib", magrib.isChecked());
        ed.putBoolean("magrib_fard", magrib_fard.isChecked());
        ed.putBoolean("magrib_sunna", magrib_sunna.isChecked());

        ed.putBoolean("isha", isha.isChecked());
        ed.putBoolean("isha_sunna_4", isha_sunna_4.isChecked());
        ed.putBoolean("isha_fard", isha_fard.isChecked());
        ed.putBoolean("isha_sunna_2", isha_sunna_2.isChecked());
        ed.putBoolean("tahajud", tahajud.isChecked());
        ed.putBoolean("witr", witr_vajib.isChecked());

        ed.apply();
    }

    public void loadText() {
        ssPref = getActivity().getPreferences(MODE_PRIVATE);

        fajr.setChecked(ssPref.getBoolean("fadjr", true));
        fadjr_sunna.setChecked(ssPref.getBoolean("fadjr_sunna", true));
        fadjr_fard.setChecked(ssPref.getBoolean("fadjr_fard", true));

        zuckhr.setChecked(ssPref.getBoolean("zuckhr", true));
        zuckhr_sunna_4.setChecked(ssPref.getBoolean("zuckhr_sunna_4", true));
        zuckhr_fard.setChecked(ssPref.getBoolean("zuckhr_fard", true));
        zuckhr_sunna_2.setChecked(ssPref.getBoolean("zuckhr_sunna_2", true));

        asr.setChecked(ssPref.getBoolean("asr", true));
        asr_sunna.setChecked(ssPref.getBoolean("asr_sunna", true));
        asr_fard.setChecked(ssPref.getBoolean("asr_fard", true));

        magrib.setChecked(ssPref.getBoolean("magrib", true));
        magrib_fard.setChecked(ssPref.getBoolean("magrib_fard", true));
        magrib_sunna.setChecked(ssPref.getBoolean("magrib_sunna", true));

        isha.setChecked(ssPref.getBoolean("isha", true));
        isha_sunna_4.setChecked(ssPref.getBoolean("isha_sunna_4", true));
        isha_fard.setChecked(ssPref.getBoolean("isha_fard", true));
        isha_sunna_2.setChecked(ssPref.getBoolean("isha_sunna_2", true));
        tahajud.setChecked(ssPref.getBoolean("tahajud", true));
        witr_vajib.setChecked(ssPref.getBoolean("witr", true));

    }

    @Override
    public void onDestroy() {
        saveText();
        loadText();
        super.onDestroy();
    }

}