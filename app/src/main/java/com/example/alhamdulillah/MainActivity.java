package com.example.alhamdulillah;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.*;
import android.view.*;
import android.widget.*;
import com.google.android.material.floatingactionbutton.*;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private FloatingActionButton fab;
    private FloatingActionButton Koran_Karim;
    private FloatingActionButton Koran_Karim_by_heart;
    private FloatingActionButton salavats;
    private FloatingActionButton dua;
    private FloatingActionButton zickr;
    private FloatingActionButton hadice;
    private FloatingActionButton names_of_Allah;

    private FloatingActionButton wijets;
    private FloatingActionButton settings;
    private FloatingActionButton kompas;
    private FloatingActionButton zickr_Counter;
    private FloatingActionButton swipe_Zickr_Counter;
    private FloatingActionButton dolgi_i_zaslugi;
    private FloatingActionButton my_tsels;
    private FloatingActionButton my_achieves;
    private FloatingActionButton resfolder;
    private FloatingActionButton music_Koran;

    private boolean isAllFabsVisible;
    private boolean isAllWijetsVisible;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fab = findViewById(R.id.add_fab);
        Koran_Karim = findViewById(R.id.add_fab_read_Koran);
        Koran_Karim_by_heart = findViewById(R.id.add_fab_Koran_by_heart);
        salavats = findViewById(R.id.add_fab_salavats);
        dua = findViewById(R.id.add_fab_dua);
        zickr = findViewById(R.id.add_fab_zickr);
        hadice = findViewById(R.id.add_fab_hadice);
        names_of_Allah = findViewById(R.id.add_fab_99_names_of_Allah);

        wijets = findViewById(R.id.add_fab_wijet);
        settings = findViewById(R.id.add_fab_settings);
        kompas = findViewById(R.id.add_fab_kompas);
        zickr_Counter = findViewById(R.id.add_fab_zickr_counter);
        swipe_Zickr_Counter = findViewById(R.id.add_fab_swipe_zickr_counter);
        dolgi_i_zaslugi = findViewById(R.id.add_fab_dolgi_i_zaslugi);
        my_tsels = findViewById(R.id.add_fab_my_tsels);
        my_achieves = findViewById(R.id.add_fab_my_achieves);
        resfolder = findViewById(R.id.add_fab_resfolder);
        music_Koran = findViewById(R.id.add_fab_music_Koran);


        Koran_Karim.setVisibility(View.GONE);
        Koran_Karim_by_heart.setVisibility(View.GONE);
        salavats.setVisibility(View.GONE);
        dua.setVisibility(View.GONE);
        zickr.setVisibility(View.GONE);
        hadice.setVisibility(View.GONE);
        names_of_Allah.setVisibility(View.GONE);


        settings.setVisibility(View.GONE);
        kompas.setVisibility(View.GONE);
        zickr_Counter.setVisibility(View.GONE);
        swipe_Zickr_Counter.setVisibility(View.GONE);
        dolgi_i_zaslugi.setVisibility(View.GONE);
        my_tsels.setVisibility(View.GONE);
        my_achieves.setVisibility(View.GONE);
        resfolder.setVisibility(View.GONE);
        music_Koran.setVisibility(View.GONE);


        isAllFabsVisible = false;
        isAllWijetsVisible = false;

        fab.setOnClickListener(View -> {
            if (!(isAllFabsVisible)) {
                Koran_Karim.show();
                Koran_Karim_by_heart.show();
                salavats.show();
                dua.show();
                zickr.show();
                hadice.show();
                names_of_Allah.show();
                isAllFabsVisible = true;
            } else {
                Koran_Karim.hide();
                Koran_Karim_by_heart.hide();
                salavats.hide();
                dua.hide();
                zickr.hide();
                hadice.hide();
                names_of_Allah.hide();
                isAllFabsVisible = false;
            }
        });

        Koran_Karim.setOnClickListener(View -> {});
        Koran_Karim_by_heart.setOnClickListener(View -> {});
        salavats.setOnClickListener(View -> {});
        dua.setOnClickListener(View -> {});
        zickr.setOnClickListener(View -> {});
        hadice.setOnClickListener(View -> {});


        wijets.setOnClickListener(View -> {
            if (!(isAllWijetsVisible)) {
                settings.show();
                kompas.show();
                zickr_Counter.show();
                swipe_Zickr_Counter.show();
                dolgi_i_zaslugi.show();
                my_tsels.show();
                my_achieves.show();
                resfolder.show();
                music_Koran.show();
                isAllWijetsVisible = true;
            } else {
                settings.hide();
                kompas.hide();
                zickr_Counter.hide();
                swipe_Zickr_Counter.hide();
                dolgi_i_zaslugi.hide();
                my_tsels.hide();
                my_achieves.hide();
                resfolder.hide();
                music_Koran.hide();
                isAllWijetsVisible = false;
            }
        });

        settings.setOnClickListener(View -> {
            Intent settings = new Intent(this, SettingsActivity.class);
            startActivity(settings);
        });
        kompas.setOnClickListener(View -> {});
        zickr_Counter.setOnClickListener(View -> {});
        swipe_Zickr_Counter.setOnClickListener(View -> {});
        dolgi_i_zaslugi.setOnClickListener(View -> {});
        my_tsels.setOnClickListener(View -> {});
        my_achieves.setOnClickListener(View -> {});
        resfolder.setOnClickListener(View -> {});
        music_Koran.setOnClickListener(View -> {});




    }

    @Override
    public void onClick(View view) {

    }
}