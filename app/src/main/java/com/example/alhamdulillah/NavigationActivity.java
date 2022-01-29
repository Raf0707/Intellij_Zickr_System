package com.example.alhamdulillah;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class NavigationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        switch (MainActivity.SelectFragment) {
            case 1:
                getSupportFragmentManager().beginTransaction().replace(R.id.navigationlayout, new CounterFragment()).commit();
                break;

            case 2:
                getSupportFragmentManager().beginTransaction().replace(R.id.navigationlayout, new SalavatFragment()).commit();
                break;

            case 3:
                getSupportFragmentManager().beginTransaction().replace(R.id.navigationlayout, new Jest_CounterFragment()).commit();
                break;

            case 4:
                getSupportFragmentManager().beginTransaction().replace(R.id.navigationlayout, new AllahNamesFragment()).commit();
                break;

            case 5:
                getSupportFragmentManager().beginTransaction().replace(R.id.navigationlayout, new PostRamadanFragment()).commit();
                break;

            case 6:
                getSupportFragmentManager().beginTransaction().replace(R.id.navigationlayout, new TodayNamazFragment()).commit();
                break;

            case 7:
                getSupportFragmentManager().beginTransaction().replace(R.id.navigationlayout, new DolgFragment()).commit();
                break;

            case 8:
                getSupportFragmentManager().beginTransaction().replace(R.id.navigationlayout, new GreenKoranFragment()).commit();
                break;
        }
    }
}