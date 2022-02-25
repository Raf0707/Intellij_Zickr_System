package com.example.alhamdulillah;

import android.content.*;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;


public class CountDolgPostFragment extends Fragment implements View.OnClickListener {

    private EditText tselPost;
    private TextView podschetPost;
    private Button okPost;
    private int dolgPost;
    private int postov;
    private String strDneyPost;
    private String strPostov;
    private LayoutInflater layoutInflaterPost;
    public SharedPreferences ssPrefPost;
    public TextView ostalosPost;
    public TextView vospolnPost;
    private String[] ismPost;
    private Spinner qwertPost;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_count_dolg_post, null);

        ismPost = new String[]{"Единица измерения", "Годы", "Недели", "Свое Количество дней"};

        Button starterPost = view.findViewById(R.id.starttPost);
        starterPost.setOnClickListener(this);

        Button nazadPost = view.findViewById(R.id.nazadPost);
        nazadPost.setOnClickListener(this);

        tselPost = view.findViewById(R.id.tselPost);
        podschetPost = view.findViewById(R.id.podschetPost);
        okPost = view.findViewById(R.id.okkPost);
        okPost.setOnClickListener(this);
        layoutInflaterPost = getLayoutInflater();
        qwertPost = view.findViewById(R.id.spinnerqwertPost);

        // Создаем адаптер ArrayAdapter с помощью массива строк и стандартной разметки элемета spinner
        ArrayAdapter<String> adapter = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_item, ismPost);
        // Определяем разметку для использования при выборе элемента
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Применяем адаптер к элементу spinner
        qwertPost.setAdapter(adapter);

        AdapterView.OnItemSelectedListener itemSelectedListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item = (String)parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
        qwertPost.setOnItemSelectedListener(itemSelectedListener);



        //loadText();
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.okkPost:
                String myIsm = qwertPost.getSelectedItem().toString();
                if (myIsm == "Единица измерения") {
                    podschetPost.setText("Выберете единицу измерения!");
                } else if (tselPost.getText().toString().length() == 0) {
                    Toast toast = Toast.makeText(getContext(), "Введите цель!", Toast.LENGTH_SHORT);
                    toast.show();
                } else if (myIsm == "Годы") {
                    dolgPost = Integer.parseInt(tselPost.getText().toString());
                    if (dolgPost <= 0) {
                        Toast.makeText(getContext(), "Введите число больше нуля",Toast.LENGTH_SHORT).show();
                        break;
                    } else {
                        postov = dolgPost * 30;
                        strPostov = Integer.toString(postov);
                        podschetPost.setText(String.format("Вам надо пропоститься %s дней ", strPostov));
                    }
                } else if (myIsm == "Недели") {
                    dolgPost = Integer.parseInt(tselPost.getText().toString());
                    if (dolgPost <= 0) {
                        Toast.makeText(getContext(), "Введите число больше нуля",Toast.LENGTH_SHORT).show();
                        break;
                    } else {
                        postov = dolgPost * 7;
                        strPostov = Integer.toString(postov);
                        podschetPost.setText(String.format("Вам надо пропоститься %s дней ", strPostov));
                    }
                } else if (myIsm == "Свое количество дней") {
                    dolgPost = Integer.parseInt(tselPost.getText().toString());
                    if (dolgPost <= 0) {
                        Toast.makeText(getContext(), "Введите число больше нуля",Toast.LENGTH_SHORT).show();
                        break;
                    } else {
                        postov = dolgPost;
                        strPostov = Integer.toString(postov);
                        podschetPost.setText(String.format("Вам надо пропоститься %s дней. ", strPostov));
                    }
                }
                break;

            case R.id.starttPost:
                String times = tselPost.getText().toString();
                if (times.length() == 0) {
                    Toast toast = Toast.makeText(getContext(), "Введите цель!", Toast.LENGTH_SHORT);
                    toast.show();
                } else if (podschetPost.getText().toString().length() == 0) {
                    Toast toast = Toast.makeText(getContext(), "Введите количество намазов и нажмите ок!", Toast.LENGTH_SHORT);
                    toast.show();
                } else {
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.navigationlayout, new DolgPostFragment()).commit();
                    break;
                }
                break;

            case R.id.nazadPost:
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.navigationlayout, new DolgFragment()).commit();
                break;
        }
    }
}