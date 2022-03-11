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
    private Button starter;
    private Button nazad;
    private Button prod;

    private int dolg;
    public int dney;
    private int namazov;
    public String strDney;
    private String strNamazov;
    private View view;
    private LayoutInflater layoutInflater;
    private String[] ism;
    private Spinner qwert;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_count_dolg_namaz, null);

        ism = new String[]{"Единица измерения", "Годы", "Месяцы", "Недели", "Дни", "Свое количество намазов"};

        ok = view.findViewById(R.id.okk);
        starter = view.findViewById(R.id.startt);
        nazad = view.findViewById(R.id.nazad);
        prod = view.findViewById(R.id.prod);
        prod.setOnClickListener(this);

        tsel = view.findViewById(R.id.tsel);
        podschet = view.findViewById(R.id.podschet);
        layoutInflater = getLayoutInflater();
        qwert = view.findViewById(R.id.spinnerqwert);

        ok.setOnClickListener(this);
        starter.setOnClickListener(this);
        nazad.setOnClickListener(this);

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
                } else if (tsel.getText().toString().length() == 0) {
                    Toast toast = Toast.makeText(getContext(), "Введите цель!", Toast.LENGTH_SHORT);
                    toast.show();
                } else if (myIsm == "Годы") {
                    dolg = Integer.parseInt(tsel.getText().toString());
                    if (dolg <= 0) {
                        Toast.makeText(getContext(), "Введите число больше нуля", Toast.LENGTH_SHORT).show();
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
                        Toast.makeText(getContext(), "Введите число больше нуля", Toast.LENGTH_SHORT).show();
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
                        Toast.makeText(getContext(), "Введите число больше нуля", Toast.LENGTH_SHORT).show();
                        break;
                    } else {
                        dney = dolg * 7;
                        namazov = dolg * 7 * 6;
                        strDney = Integer.toString(dney);
                        strNamazov = Integer.toString(namazov);
                        if (strNamazov == "11" || strNamazov == "12" || strNamazov == "13" || strNamazov == "14") {
                            podschet.setText(String.format("Вам надо восполнить долг за %s дней, совершить %s намазов. ", strDney, strNamazov));
                        } else if (strNamazov.substring(strNamazov.length() - 1) == "1" && strNamazov != "11") {
                            podschet.setText(String.format("Вам надо восполнить долг за %s день, совершить %s намазов. ", strDney, strNamazov));
                        }
                    }
                } else if (myIsm == "Дни") {
                    dolg = Integer.parseInt(tsel.getText().toString());
                    if (dolg <= 0) {
                        Toast.makeText(getContext(), "Введите число больше нуля", Toast.LENGTH_SHORT).show();
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
                        Toast.makeText(getContext(), "Введите число больше нуля", Toast.LENGTH_SHORT).show();
                        break;
                    } else {
                        namazov = dolg;
                        strNamazov = Integer.toString(namazov);
                        strDney = strNamazov;
                        podschet.setText(String.format("Вам надо восполнить %s намазов. ", strNamazov));
                    }
                }
                break;

            case R.id.startt:
                String times = tsel.getText().toString();
                if (times.length() == 0) {
                    Toast toast = Toast.makeText(getContext(), "Введите цель!", Toast.LENGTH_SHORT);
                    toast.show();
                } else if (podschet.getText().toString().length() == 0) {
                    Toast toast = Toast.makeText(getContext(), "Введите количество намазов и нажмите ок!", Toast.LENGTH_SHORT);
                    toast.show();
                } else {
                    DolgNamazFragment dolgNamazFragment = new DolgNamazFragment();
                    Boolean flag = false;
                    Bundle bundle = new Bundle();
                    bundle.putString("days", strDney);
                    bundle.putBoolean("1", flag);
                    dolgNamazFragment.setArguments(bundle);
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.navigationlayout, dolgNamazFragment).commit();
                    break;
                }
                break;

            case R.id.nazad:
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.navigationlayout, new DolgFragment()).commit();
                break;

            case R.id.prod:
                DolgNamazFragment dolgNamazFragment1 = new DolgNamazFragment();
                Boolean flag = true;
                Bundle bundle = new Bundle();
                bundle.putBoolean("1", flag);
                dolgNamazFragment1.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.navigationlayout, dolgNamazFragment1).commit();
                break;
        }
    }
}