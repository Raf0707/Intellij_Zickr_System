package com.example.alhamdulillah;

import androidx.appcompat.app.AppCompatActivity;

import android.content.*;
import android.os.Bundle;
import android.view.*;
import android.widget.*;

public class SettingsActivity extends AppCompatActivity implements View.OnClickListener {

    private Button menu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        menu = findViewById(R.id.menu);
        menu.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.menu:
                Intent menu = new Intent(this, MainActivity.class);
                startActivity(menu);
        }
    }
}