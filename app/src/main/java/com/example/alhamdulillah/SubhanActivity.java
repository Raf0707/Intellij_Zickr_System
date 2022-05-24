package com.example.alhamdulillah;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.*;

import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;
import android.widget.*;

import java.util.concurrent.*;
import java.util.zip.*;

public class SubhanActivity extends AppCompatActivity implements View.OnClickListener {

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
    View vview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subhan);
        //subhanLayout = findViewById(R.id.subhanLayout1);
        handler = new Handler();
        subhanCounter = findViewById(R.id.subhanCount1);
        bacckmenusss = findViewById(R.id.bacckmenusss1);
        bacckmenusss.setOnClickListener(this);

        subhanLlahBiHamdih = findViewById(R.id.subhanLlahBiHamdih1);
        translateSubhanLlahBiHamdih = findViewById(R.id.translateSubhanLlahBiHamdih1);

        generateTsel = findViewById(R.id.subhanCountGenerateTsel1);

        generateTsel.setText(getRandomTsel(146325749, 938789359));
        tselCount = Integer.parseInt(generateTsel.getText().toString());
        final int ccount = Integer.parseInt(generateTsel.getText().toString());

        View view = findViewById(R.id.subhanView);

        Thread t = new Thread(() -> {
            try{
                TimeUnit.MILLISECONDS.sleep(10);
                handler.post(r);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        });

        t.start();


        view.setOnTouchListener(new OnSwipeTouchListener(getApplicationContext()) {

            @Override
            public void onSwipeRight() {
                saveText();
                counter++;
                if (tselCount > 0) tselCount--;
                subhanCounter.setText(Integer.toString(counter));
                generateTsel.setText(Integer.toString(tselCount));
                saveText();
                loadText();
            }

            @Override
            public void onSwipeLeft() {
                saveText();
                if (counter > 0) counter--;
                tselCount++;
                subhanCounter.setText(Integer.toString(counter));
                generateTsel.setText(Integer.toString(tselCount));
                saveText();
                loadText();
            }

            @Override
            public void onSwipeUp() {
                saveText();
                if (counter > 0) counter--;
                tselCount++;
                subhanCounter.setText(Integer.toString(counter));
                generateTsel.setText(Integer.toString(tselCount));
                saveText();
                loadText();
            }

            @Override
            public void onSwipeDown() {
                saveText();
                counter++;
                if (tselCount > 0) tselCount--;
                subhanCounter.setText(Integer.toString(counter));
                generateTsel.setText(Integer.toString(tselCount));
                saveText();
                loadText();
            }

            @Override
            public void onClick() {
                saveText();
                counter++;
                if (tselCount > 0) tselCount--;
                subhanCounter.setText(Integer.toString(counter));
                generateTsel.setText(Integer.toString(tselCount));
                saveText();
                loadText();

            }

            @Override
            public void onLongClick() {
                saveText();
                if (counter != 0 && subhanCounter.getText().toString() != "0") onAlert();
                saveText();
                loadText();
            }

        });

        loadText();

    }

    Runnable r = new Runnable() {
        public void run(){
            subhanCounter.setText(Integer.toString(counter));
            handler.postDelayed(r,10);
        }
    };

    @Override
    public void onClick(View view) {
        saveText();
        Intent bacckkmenu = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(bacckkmenu);
        loadText();

    }

    public static String getRandomTsel(int min, int max){
        int x = (int) ((Math.random() * ((max - min) + 1)) + min);
        return Integer.toString(x);
    }

    public void saveText() {
        sssPrefff = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor ed = sssPrefff.edit();
        ed.putString("Сделаллсс", subhanCounter.getText().toString());
        ed.putString("Осталосьь", generateTsel.getText().toString());
        counter = Integer.parseInt(subhanCounter.getText().toString());
        tselCount = Integer.parseInt(generateTsel.getText().toString());
        ed.apply();
    }

    public void loadText() {
        sssPrefff = getPreferences(MODE_PRIVATE);
        String sdellText = sssPrefff.getString("Сделаллсс", subhanCounter.getText().toString());
        String ossstText = sssPrefff.getString("Осталосьь", generateTsel.getText().toString());
        subhanCounter.setText(sdellText);
        generateTsel.setText(ossstText);
        counter = Integer.parseInt(subhanCounter.getText().toString());
        tselCount = Integer.parseInt(generateTsel.getText().toString());
    }

    public void onAlert() {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setMessage("Вы уверены, что хотите сбросить счетчик?");
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                "Да", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        counter = 0;
                        subhanCounter.setText(Integer.toString(counter));
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

   
