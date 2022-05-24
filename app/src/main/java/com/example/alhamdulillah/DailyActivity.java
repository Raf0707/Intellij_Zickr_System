package com.example.alhamdulillah;

import androidx.appcompat.app.AppCompatActivity;

import android.content.*;
import android.os.Bundle;
import android.view.*;
import android.widget.*;

public class DailyActivity extends AppCompatActivity implements View.OnClickListener {
    public SharedPreferences sPrefer;

    public Button tauhid1;
    public Button hasbunaLlah1;
    public Button astagfiruLlah1;
    public Button subhanAllah1;
    public Button dailyRabbiGfirLy1;
    public Button haulya1;
    public Button dailyAllahuAkbar1;
    public Button dailySalavat1;

    public Button tauhid2;
    public Button hasbunaLlah2;
    public Button astagfiruLlah2;
    public Button subhanAllah2;
    public Button dailyRabbiGfirLy2;
    public Button haulya2;
    public Button dailyAllahuAkbar2;
    public Button dailySalavat2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily);

        tauhid1 = findViewById(R.id.checkDailyTauhid1);
        hasbunaLlah1 = findViewById(R.id.checkDailyHasbuna1);
        astagfiruLlah1 = findViewById(R.id.checkDailyAstagfiruLlah1);
        subhanAllah1 = findViewById(R.id.checkDailySubhanaLlahiWaBiHamdih1);
        dailyRabbiGfirLy1 = findViewById(R.id.checkDailyRabbyGfirLy1);
        haulya1 = findViewById(R.id.checkDailyLaHaulaWaLaKuwwataIllaBiLlah1);
        dailyAllahuAkbar1 = findViewById(R.id.checkDailyAllahuAkbar1);
        dailySalavat1 = findViewById(R.id.checkDailySalavat1);

        tauhid2 = findViewById(R.id.checkDailyTauhid2);
        hasbunaLlah2 = findViewById(R.id.checkDailyHasbuna2);
        astagfiruLlah2 = findViewById(R.id.checkDailyAstagfiruLlah2);
        subhanAllah2 = findViewById(R.id.checkDailySubhanaLlahiWaBiHamdih2);
        dailyRabbiGfirLy2 = findViewById(R.id.checkDailyRabbyGfirLy2);
        haulya2 = findViewById(R.id.checkDailyLaHaulaWaLaKuwwataIllaBiLlah2);
        dailyAllahuAkbar2 = findViewById(R.id.checkDailyAllahuAkbar2);
        dailySalavat2 = findViewById(R.id.checkDailySalavat2);

        tauhid1.setOnClickListener(this);
        hasbunaLlah1.setOnClickListener(this);
        astagfiruLlah1.setOnClickListener(this);
        subhanAllah1.setOnClickListener(this);
        dailyRabbiGfirLy1.setOnClickListener(this);
        haulya1.setOnClickListener(this);
        dailyAllahuAkbar1.setOnClickListener(this);
        dailySalavat1.setOnClickListener(this);

        tauhid2.setOnClickListener(this);
        hasbunaLlah2.setOnClickListener(this);
        astagfiruLlah2.setOnClickListener(this);
        subhanAllah2.setOnClickListener(this);
        dailyRabbiGfirLy2.setOnClickListener(this);
        haulya2.setOnClickListener(this);
        dailyAllahuAkbar2.setOnClickListener(this);
        dailySalavat2.setOnClickListener(this);

        loadText();

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.checkDailyTauhid1:
                tauhid1.setVisibility(View.INVISIBLE);
                tauhid2.setVisibility(View.VISIBLE);
                break;

            case R.id.checkDailyTauhid2:
                tauhid2.setVisibility(View.INVISIBLE);
                tauhid1.setVisibility(View.VISIBLE);
                break;

            case R.id.checkDailyHasbuna1:
                hasbunaLlah1.setVisibility(View.INVISIBLE);
                hasbunaLlah2.setVisibility(View.VISIBLE);
                break;

            case R.id.checkDailyHasbuna2:
                hasbunaLlah2.setVisibility(View.INVISIBLE);
                hasbunaLlah1.setVisibility(View.VISIBLE);
                break;

            case R.id.checkDailyAstagfiruLlah1:
                astagfiruLlah1.setVisibility(View.INVISIBLE);
                astagfiruLlah2.setVisibility(View.VISIBLE);
                break;

            case R.id.checkDailyAstagfiruLlah2:
                astagfiruLlah2.setVisibility(View.INVISIBLE);
                astagfiruLlah1.setVisibility(View.VISIBLE);
                break;

            case R.id.checkDailySubhanaLlahiWaBiHamdih1:
                subhanAllah1.setVisibility(View.INVISIBLE);
                subhanAllah2.setVisibility(View.VISIBLE);
                break;

            case R.id.checkDailySubhanaLlahiWaBiHamdih2:
                subhanAllah2.setVisibility(View.INVISIBLE);
                subhanAllah1.setVisibility(View.VISIBLE);
                break;

            case R.id.checkDailyRabbyGfirLy1:
                dailyRabbiGfirLy1.setVisibility(View.INVISIBLE);
                dailyRabbiGfirLy2.setVisibility(View.VISIBLE);
                break;

            case R.id.checkDailyRabbyGfirLy2:
                dailyRabbiGfirLy2.setVisibility(View.INVISIBLE);
                dailyRabbiGfirLy1.setVisibility(View.VISIBLE);
                break;

            case R.id.checkDailyLaHaulaWaLaKuwwataIllaBiLlah1:
                haulya1.setVisibility(View.INVISIBLE);
                haulya2.setVisibility(View.VISIBLE);
                break;

            case R.id.checkDailyLaHaulaWaLaKuwwataIllaBiLlah2:
                haulya2.setVisibility(View.INVISIBLE);
                haulya1.setVisibility(View.VISIBLE);
                break;

            case R.id.checkDailyAllahuAkbar1:
                dailyAllahuAkbar1.setVisibility(View.INVISIBLE);
                dailyAllahuAkbar2.setVisibility(View.VISIBLE);
                break;

            case R.id.checkDailyAllahuAkbar2:
                dailyAllahuAkbar2.setVisibility(View.INVISIBLE);
                dailyAllahuAkbar1.setVisibility(View.VISIBLE);
                break;

            case R.id.checkDailySalavat1:
                dailySalavat1.setVisibility(View.INVISIBLE);
                dailySalavat2.setVisibility(View.VISIBLE);
                break;

            case R.id.checkDailySalavat2:
                dailySalavat2.setVisibility(View.INVISIBLE);
                dailySalavat1.setVisibility(View.VISIBLE);
                break;
        }
    }

    public void saveText() {
        sPrefer = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor ed = sPrefer.edit();

        ed.commit();

    }

    public void loadText() {
        sPrefer = getPreferences(MODE_PRIVATE);

    }

    @Override
    public void onDestroy() {
        saveText();
        loadText();
        super.onDestroy();
    }


}