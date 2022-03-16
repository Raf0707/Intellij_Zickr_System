package com.example.alhamdulillah;

import android.content.*;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.*;
import android.view.inputmethod.*;
import android.widget.*;


public class CountDolgPostFragment extends Fragment implements View.OnClickListener {

    private EditText tselPost;
    private TextView podschetPost;

    private Button okPost;
    private Button prodPost;
    private Button starterPost;
    private Button nazadPost;
    private Button editPost;

    private int dolgPost;
    private int postov;
    private String strPostov;
    private LayoutInflater layoutInflaterPost;
    public SharedPreferences ssPrefPost;
    private String[] ismPost;
    private Spinner qwertPost;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_count_dolg_post, null);

        ismPost = new String[]{"Единица измерения", "Годы", "Недели", "Свое количество дней"};

        starterPost = view.findViewById(R.id.starttPost);
        starterPost.setOnClickListener(this);

        nazadPost = view.findViewById(R.id.nazadPost);
        nazadPost.setOnClickListener(this);

        tselPost = view.findViewById(R.id.tselPost);
        podschetPost = view.findViewById(R.id.podschetPost);

        okPost = view.findViewById(R.id.okkPost);
        okPost.setOnClickListener(this);

        prodPost = view.findViewById(R.id.prodPost);
        prodPost.setOnClickListener(this);

        editPost = view.findViewById(R.id.editPost);
        editPost.setOnClickListener(this);


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

                tselPost.setCursorVisible(false);
                tselPost.setFocusableInTouchMode(false);
                tselPost.setEnabled(false);

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
                    Toast toast = Toast.makeText(getContext(), "Введите количество дней (постов) и нажмите ок!", Toast.LENGTH_SHORT);
                    toast.show();
                } else {
                    DolgPostFragment dolgPostFragment = new DolgPostFragment();
                    Boolean flag = false;
                    Bundle bundle = new Bundle();
                    bundle.putString("postKey", strPostov);
                    bundle.putBoolean("1", flag);
                    dolgPostFragment.setArguments(bundle);
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.navigationlayout, dolgPostFragment).commit();
                    break;
                }
                break;

            case R.id.editPost:

                tselPost.setCursorVisible(true);
                tselPost.setFocusableInTouchMode(true);
                tselPost.setEnabled(true);

                tselPost.requestFocus();
                tselPost.setSelection(tselPost.getText().length());

                getActivity().getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE, WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);

                getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
                getContext().getSystemService(Context.INPUT_METHOD_SERVICE);

                InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                if (imm != null) {
                    imm.showSoftInput(tselPost, InputMethodManager.SHOW_FORCED);
                }

                break;

            case R.id.prodPost:
                DolgPostFragment dolgPostFragment1 = new DolgPostFragment();
                Boolean flag = true;
                Bundle bundle = new Bundle();
                bundle.putBoolean("1", flag);
                dolgPostFragment1.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.navigationlayout, dolgPostFragment1).commit();
                break;

            case R.id.nazadPost:
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.navigationlayout, new DolgFragment()).commit();
                break;
        }
    }
}