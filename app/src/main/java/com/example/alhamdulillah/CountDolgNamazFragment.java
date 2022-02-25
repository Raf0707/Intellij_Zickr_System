package com.example.alhamdulillah;

import android.content.*;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;


public class CountDolgNamazFragment extends Fragment implements View.OnClickListener {

    private EditText tsel;
    private TextView podschet;
    private Button ok;
    private int dolg;
    public int dney;
    private int namazov;
    private String strDney;
    private String strNamazov;
    private View view;
    private LayoutInflater layoutInflater;
    public SharedPreferences ssPref;
    public TextView ostalos;
    public TextView vospoln;
    private String[] ism;
    private Spinner qwert;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_count_dolg_namaz, null);

        ism = new String[]{"Единица измерения", "Годы", "Месяцы", "Недели", "Дни", "Свое Количество намазов"};

        Button starter = view.findViewById(R.id.startt);
        starter.setOnClickListener(this);

        Button nazad = view.findViewById(R.id.nazad);
        nazad.setOnClickListener(this);

        tsel = view.findViewById(R.id.tsel);
        podschet = view.findViewById(R.id.podschet);
        ok = view.findViewById(R.id.okk);
        ok.setOnClickListener(this);
        layoutInflater = getLayoutInflater();
        qwert = view.findViewById(R.id.spinnerqwert);

        // Создаем адаптер ArrayAdapter с помощью массива строк и стандартной разметки элемета spinner
        ArrayAdapter<String> adapter = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_item, ism);
        // Определяем разметку для использования при выборе элемента
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Применяем адаптер к элементу spinner
        qwert.setAdapter(adapter);

        AdapterView.OnItemSelectedListener itemSelectedListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item = (String)parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
        qwert.setOnItemSelectedListener(itemSelectedListener);



        //loadText();
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.okk:
                String myIsm = qwert.getSelectedItem().toString();
                if (myIsm == "Единица измерения") {
                    podschet.setText("Выберете единицу измерения!");
                } else if (myIsm == "Годы") {
                    dolg = Integer.parseInt(tsel.getText().toString());
                    if (dolg <= 0) {
                        Toast.makeText(getContext(), "Введите число больше нуля",Toast.LENGTH_SHORT).show();
                        break;
                    } else {
                        dney = dolg * 365;
                        namazov = dolg * 365 * 6;
                        strDney = Integer.toString(dney);
                        strNamazov = Integer.toString(namazov);
                        podschet.setText(String.format("Вам надо восполнить долг за %s дней, совершить %s намазов. ", strDney, strNamazov));
                    }
                } else if (myIsm == "Месяцы") {
                    dolg = Integer.parseInt(tsel.getText().toString());
                    if (dolg <= 0) {
                        Toast.makeText(getContext(), "Введите число больше нуля",Toast.LENGTH_SHORT).show();
                        break;
                    } else {
                        dney = dolg * 30;
                        namazov = dolg * 30 * 6;
                        strDney = Integer.toString(dney);
                        strNamazov = Integer.toString(namazov);
                        podschet.setText(String.format("Согласно мусульманскому календарю в каждом месяце 30 дней. Вам надо восполнить долг за %s дней, совершить %s намазов. ", strDney, strNamazov));
                    }
                } else if (myIsm == "Недели") {
                    dolg = Integer.parseInt(tsel.getText().toString());
                    if (dolg <= 0) {
                        Toast.makeText(getContext(), "Введите число больше нуля",Toast.LENGTH_SHORT).show();
                        break;
                    } else {
                        dney = dolg * 7;
                        namazov = dolg * 7 * 6;
                        strDney = Integer.toString(dney);
                        strNamazov = Integer.toString(namazov);
                        podschet.setText(String.format("Вам надо восполнить долг за %s дней, совершить %s намазов. ", strDney, strNamazov));
                    }
                } else if (myIsm == "Дни") {
                    dolg = Integer.parseInt(tsel.getText().toString());
                    if (dolg <= 0) {
                        Toast.makeText(getContext(), "Введите число больше нуля",Toast.LENGTH_SHORT).show();
                        break;
                    } else {
                        dney = dolg;
                        namazov = dolg * 6;
                        strDney = Integer.toString(dney);
                        strNamazov = Integer.toString(namazov);
                        podschet.setText(String.format("Вам надо восполнить долг за %s дней, совершить %s намазов. ", strDney, strNamazov));
                    }
                } else if (myIsm == "Свое количество намазов") {
                    dolg = Integer.parseInt(tsel.getText().toString());
                    if (dolg <= 0) {
                        Toast.makeText(getContext(), "Введите число больше нуля",Toast.LENGTH_SHORT).show();
                        break;
                    } else {
                        namazov = dolg;
                        strNamazov = Integer.toString(namazov);
                        podschet.setText(String.format("Вам надо восполнить %s намазов. ", strNamazov));
                    }
                }
                break;

            case R.id.startt:
                String times = tsel.getText().toString();
                if (times.length() == 0) {
                    Toast toast = Toast.makeText(getContext(), "Введите цель!", Toast.LENGTH_SHORT);
                    toast.show();
                } else {
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.navigationlayout, new DolgNamazFragment()).commit();
                    break;
                }
                break;
        }
    }
}