package com.example.alhamdulillah;

import static android.content.Context.MODE_PRIVATE;

import android.animation.*;
import android.app.*;
import android.content.*;
import android.os.*;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import java.util.concurrent.*;


public class PostRamadanFragment extends Fragment implements View.OnClickListener {
    private Handler handler;
    private int countCheck = 0;
    private TextView itog;
    private SharedPreferences sPreff;
    private View vview;

    private ProgressBar postProgressBar;

    private Button reset;
    private Button menu;

    private CheckBox c1;
    private CheckBox c2;
    private CheckBox c3;
    private CheckBox c4;
    private CheckBox c5;
    private CheckBox c6;
    private CheckBox c7;
    private CheckBox c8;
    private CheckBox c9;
    private CheckBox c10;
    private CheckBox c11;
    private CheckBox c12;
    private CheckBox c13;
    private CheckBox c14;
    private CheckBox c15;
    private CheckBox c16;
    private CheckBox c17;
    private CheckBox c18;
    private CheckBox c19;
    private CheckBox c20;
    private CheckBox c21;
    private CheckBox c22;
    private CheckBox c23;
    private CheckBox c24;
    private CheckBox c25;
    private CheckBox c26;
    private CheckBox c27;
    private CheckBox c28;
    private CheckBox c29;
    private CheckBox c30;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_post_ramadan, null);

        itog = view.findViewById(R.id.itoooog);

        postProgressBar = view.findViewById(R.id.postProgressBar);

        reset = view.findViewById(R.id.button_reset);
        menu = view.findViewById(R.id.button_menu);

        reset.setOnClickListener(this);
        menu.setOnClickListener(this);

        c1 = view.findViewById(R.id.r1);
        c2 = view.findViewById(R.id.r2);
        c3 = view.findViewById(R.id.r3);
        c4 = view.findViewById(R.id.r4);
        c5 = view.findViewById(R.id.r5);
        c6 = view.findViewById(R.id.r6);
        c7 = view.findViewById(R.id.r7);
        c8 = view.findViewById(R.id.r8);
        c9 = view.findViewById(R.id.r9);
        c10 = view.findViewById(R.id.r10);
        c11 = view.findViewById(R.id.r11);
        c12 = view.findViewById(R.id.r12);
        c13 = view.findViewById(R.id.r13);
        c14 = view.findViewById(R.id.r14);
        c15 = view.findViewById(R.id.r15);
        c16 = view.findViewById(R.id.r16);
        c17 = view.findViewById(R.id.r17);
        c18 = view.findViewById(R.id.r18);
        c19 = view.findViewById(R.id.r19);
        c20 = view.findViewById(R.id.r20);
        c21 = view.findViewById(R.id.r21);
        c22 = view.findViewById(R.id.r22);
        c23 = view.findViewById(R.id.r23);
        c24 = view.findViewById(R.id.r24);
        c25 = view.findViewById(R.id.r25);
        c26 = view.findViewById(R.id.r26);
        c27 = view.findViewById(R.id.r27);
        c28 = view.findViewById(R.id.r28);
        c29 = view.findViewById(R.id.r29);
        c30 = view.findViewById(R.id.r30);


        this.c1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                onCountCheck(isChecked);
            }
        });

        this.c2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                onCountCheck(isChecked);
            }
        });

        this.c3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                onCountCheck(isChecked);
            }
        });

        this.c4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                onCountCheck(isChecked);
            }
        });

        this.c5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                onCountCheck(isChecked);
            }
        });

        this.c6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                onCountCheck(isChecked);
            }
        });

        this.c7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                onCountCheck(isChecked);
            }
        });

        this.c8.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                onCountCheck(isChecked);
            }
        });

        this.c9.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                onCountCheck(isChecked);
            }
        });

        this.c10.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                onCountCheck(isChecked);
            }
        });

        this.c11.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                onCountCheck(isChecked);
            }
        });

        this.c12.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                onCountCheck(isChecked);
            }
        });

        this.c13.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                onCountCheck(isChecked);
            }
        });

        this.c14.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                onCountCheck(isChecked);
            }
        });

        this.c15.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                onCountCheck(isChecked);
            }
        });

        this.c16.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                onCountCheck(isChecked);
            }
        });

        this.c17.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                onCountCheck(isChecked);
            }
        });

        this.c18.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                onCountCheck(isChecked);
            }
        });

        this.c19.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                onCountCheck(isChecked);
            }
        });

        this.c20.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                onCountCheck(isChecked);
            }
        });

        this.c21.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                onCountCheck(isChecked);
            }
        });

        this.c22.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                onCountCheck(isChecked);
            }
        });

        this.c23.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                onCountCheck(isChecked);
            }
        });

        this.c24.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                onCountCheck(isChecked);
            }
        });

        this.c25.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                onCountCheck(isChecked);
            }
        });

        this.c26.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                onCountCheck(isChecked);
            }
        });

        this.c27.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                onCountCheck(isChecked);
            }
        });

        this.c28.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                onCountCheck(isChecked);
            }
        });

        this.c29.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                onCountCheck(isChecked);
            }
        });

        this.c30.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                onCountCheck(isChecked);
            }
        });

        loadText();

        return view;
    }

    public void onCountCheck(boolean isChecked) {
        if (isChecked) {
            countCheck++;
            itog.setText(Integer.toString(countCheck));
            postProgressBar.setProgress(countCheck);
        }
        if (!isChecked && countCheck != 0) {
            countCheck--;
            if (countCheck < 0) countCheck = 0;
            itog.setText(Integer.toString(countCheck));
            postProgressBar.setProgress(countCheck);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_reset:
                if (countCheck != 0 && itog.getText().toString() != "0") onAlert();
                break;

            case R.id.button_menu:
                saveText();
                loadText();
                Intent intent = new Intent(getContext(), MainActivity.class);
                startActivity(intent);
                saveText();
                break;


        }
    }

    public void saveText() {
        sPreff = getActivity().getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor ed = sPreff.edit();

        ed.putBoolean("c1", c1.isChecked());
        ed.putBoolean("c2", c1.isChecked());
        ed.putBoolean("c3", c3.isChecked());
        ed.putBoolean("c4", c4.isChecked());
        ed.putBoolean("c5", c5.isChecked());
        ed.putBoolean("c6", c6.isChecked());
        ed.putBoolean("c7", c7.isChecked());
        ed.putBoolean("c8", c8.isChecked());
        ed.putBoolean("c9", c9.isChecked());
        ed.putBoolean("c10", c10.isChecked());
        ed.putBoolean("c11", c11.isChecked());
        ed.putBoolean("c12", c12.isChecked());
        ed.putBoolean("c13", c13.isChecked());
        ed.putBoolean("c14", c14.isChecked());
        ed.putBoolean("c15", c15.isChecked());
        ed.putBoolean("c16", c16.isChecked());
        ed.putBoolean("c17", c17.isChecked());
        ed.putBoolean("c18", c18.isChecked());
        ed.putBoolean("c19", c19.isChecked());
        ed.putBoolean("c20", c20.isChecked());
        ed.putBoolean("c21", c21.isChecked());
        ed.putBoolean("c22", c22.isChecked());
        ed.putBoolean("c23", c23.isChecked());
        ed.putBoolean("c24", c24.isChecked());
        ed.putBoolean("c25", c25.isChecked());
        ed.putBoolean("c26", c26.isChecked());
        ed.putBoolean("c27", c27.isChecked());
        ed.putBoolean("c28", c28.isChecked());
        ed.putBoolean("c29", c29.isChecked());
        ed.putBoolean("c30", c30.isChecked());



        ed.putString("ПродержалПост", itog.getText().toString());
        postProgressBar.setProgress(countCheck);
        countCheck = Integer.parseInt(itog.getText().toString());
        ed.apply();
    }

    public void loadText() {
        sPreff = getActivity().getPreferences(MODE_PRIVATE);

        c1.setChecked(sPreff.getBoolean("c1", false));
        c2.setChecked(sPreff.getBoolean("c2", false));
        c3.setChecked(sPreff.getBoolean("c3", false));
        c4.setChecked(sPreff.getBoolean("c4", false));
        c5.setChecked(sPreff.getBoolean("c5", false));
        c6.setChecked(sPreff.getBoolean("c6", false));
        c7.setChecked(sPreff.getBoolean("c7", false));
        c8.setChecked(sPreff.getBoolean("c8", false));
        c9.setChecked(sPreff.getBoolean("c9", false));
        c10.setChecked(sPreff.getBoolean("c10", false));
        c11.setChecked(sPreff.getBoolean("c11", false));
        c12.setChecked(sPreff.getBoolean("c12", false));
        c13.setChecked(sPreff.getBoolean("c13", false));
        c14.setChecked(sPreff.getBoolean("c14", false));
        c15.setChecked(sPreff.getBoolean("c15", false));
        c16.setChecked(sPreff.getBoolean("c16", false));
        c17.setChecked(sPreff.getBoolean("c17", false));
        c18.setChecked(sPreff.getBoolean("c18", false));
        c19.setChecked(sPreff.getBoolean("c19", false));
        c20.setChecked(sPreff.getBoolean("c20", false));
        c21.setChecked(sPreff.getBoolean("c21", false));
        c22.setChecked(sPreff.getBoolean("c22", false));
        c23.setChecked(sPreff.getBoolean("c23", false));
        c24.setChecked(sPreff.getBoolean("c24", false));
        c25.setChecked(sPreff.getBoolean("c25", false));
        c26.setChecked(sPreff.getBoolean("c26", false));
        c27.setChecked(sPreff.getBoolean("c27", false));
        c28.setChecked(sPreff.getBoolean("c28", false));
        c29.setChecked(sPreff.getBoolean("c29", false));
        c30.setChecked(sPreff.getBoolean("c30", false));



        String tselText = sPreff.getString("ПродержалПост", itog.getText().toString());
        itog.setText(tselText);
        postProgressBar.setProgress(countCheck);
    }

    public void onAlert() {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(getContext());
        builder1.setMessage("Вы уверены, что хотите сбросить счетчик?");
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                "Да", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        c1.setChecked(false);
                        c2.setChecked(false);
                        c3.setChecked(false);
                        c4.setChecked(false);
                        c5.setChecked(false);
                        c6.setChecked(false);
                        c7.setChecked(false);
                        c8.setChecked(false);
                        c9.setChecked(false);
                        c10.setChecked(false);
                        c11.setChecked(false);
                        c12.setChecked(false);
                        c13.setChecked(false);
                        c14.setChecked(false);
                        c15.setChecked(false);
                        c16.setChecked(false);
                        c17.setChecked(false);
                        c18.setChecked(false);
                        c19.setChecked(false);
                        c20.setChecked(false);
                        c21.setChecked(false);
                        c22.setChecked(false);
                        c23.setChecked(false);
                        c24.setChecked(false);
                        c25.setChecked(false);
                        c26.setChecked(false);
                        c27.setChecked(false);
                        c28.setChecked(false);
                        c29.setChecked(false);
                        c30.setChecked(false);

                        itog.setText("0");
                        countCheck = 0;
                        postProgressBar.setProgress(countCheck);


                        saveText();
                        loadText();
                    }
                });

        builder1.setNegativeButton(
                "Отмена", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        vview = getLayoutInflater().inflate(R.layout.alert_dialog_counter, null);
        builder1.setView(vview);
        AlertDialog alert11 = builder1.create();
        alert11.getWindow().setLayout(400,800);
        alert11.setTitle("Reset");
        alert11.show();
    }

    @Override
    public void onDestroy() {
        saveText();
        loadText();
        super.onDestroy();
    }
}

