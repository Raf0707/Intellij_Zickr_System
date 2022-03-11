package com.example.alhamdulillah;

import static android.content.Context.MODE_PRIVATE;

import android.app.*;
import android.content.*;
import android.graphics.*;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import org.w3c.dom.*;


public class DolgPostFragment extends Fragment implements View.OnClickListener {

    private SharedPreferences ssPref;
    private Button plusDolgPost;
    private Button minusDolgPost;
    private Button resetDolgPost;

    private TextView ostPostDolg;
    private TextView sdelPostDolg;
    private TextView backPost;

    private int dolg;
    private int sdel;

    private View vview;

    private ProgressBar dolgPostProgressBar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dolg_post, null, false);

        plusDolgPost = view.findViewById(R.id.plusDolgPost);
        minusDolgPost = view.findViewById(R.id.minusDolgPost);
        resetDolgPost = view.findViewById(R.id.resetDolgPost);

        ostPostDolg = view.findViewById(R.id.ostDolgPost);
        sdelPostDolg = view.findViewById(R.id.sdelDolgPost);
        backPost = view.findViewById(R.id.backPost);

        dolgPostProgressBar = view.findViewById(R.id.dolgPostProgressBar);

        plusDolgPost.setOnClickListener(this);
        minusDolgPost.setOnClickListener(this);
        resetDolgPost.setOnClickListener(this);
        backPost.setOnClickListener(this);

//        assert getArguments() != null;
        ostPostDolg.setText(getArguments().getString("postKey")); //NULL POINTER EXCEPTION
        Bundle bundle = this.getArguments();
        ostPostDolg.setText(bundle.getString("postKey"));
        Boolean flag = bundle.getBoolean("1");

        ostPostDolg.setTextColor(Color.rgb(18,112,90));
        sdelPostDolg.setText("0");

        if (flag) loadText();

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.backPost:
                saveText();
                Intent main = new Intent(getContext(), MainActivity.class);
                startActivity(main);
                loadText();
                break;

            case R.id.resetDolgPost:
                onAlert();
                break;

            case R.id.plusDolgPost:
                dolg = Integer.parseInt(ostPostDolg.getText().toString());

                if (dolg > 0) dolg--;
                ostPostDolg.setText(Integer.toString(dolg));
                sdel = Integer.parseInt(sdelPostDolg.getText().toString());
                if (sdel != (dolg + sdel + 1)) sdel++;
                sdelPostDolg.setText(Integer.toString(sdel));

                if (dolg == 0 && sdel == (dolg + sdel)) {
                    Toast toast = Toast.makeText(getContext(), "Цель выполнена", Toast.LENGTH_SHORT);
                    toast.show();
                    plusDolgPost.setClickable(false);
                    minusDolgPost.setClickable(false);
                } else {
                    plusDolgPost.setClickable(true);
                    minusDolgPost.setClickable(true);
                }

                saveText();
                loadText();

                break;

            case R.id.minusDolgPost:
                dolg = Integer.parseInt(ostPostDolg.getText().toString());
                sdel = Integer.parseInt(sdelPostDolg.getText().toString());

                //final int days1 = Integer.parseInt(getArguments().getString("days"));

                if (dolg != (dolg + sdel + 1)) dolg++;
                ostPostDolg.setText(Integer.toString(dolg));
                if (sdel > 0) sdel--;
                sdelPostDolg.setText(Integer.toString(sdel));

                if (dolg == 0 && sdel == (dolg + sdel - 1)) {
                    Toast toast = Toast.makeText(getContext(), "Цель выполнена", Toast.LENGTH_SHORT);
                    toast.show();
                    plusDolgPost.setClickable(false);
                    minusDolgPost.setClickable(false);
                } else {
                    plusDolgPost.setClickable(true);
                    minusDolgPost.setClickable(true);
                }

                saveText();
                loadText();

                break;
        }
    }

    public void saveText() {
        ssPref = getActivity().getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor ed = ssPref.edit();
        ed.putString("ВосполнилПост", sdelPostDolg.getText().toString());
        ed.putString("ОсталосьПост", ostPostDolg.getText().toString());
        ed.apply();
    }

    public void loadText() {
        ssPref = getActivity().getPreferences(MODE_PRIVATE);
        String vospText = ssPref.getString("ВосполнилПост", sdelPostDolg.getText().toString());
        String ostText = ssPref.getString("ОсталосьПост", ostPostDolg.getText().toString());
        sdelPostDolg.setText(vospText);
        ostPostDolg.setText(ostText);
    }

    public void onAlert() {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(getContext());
        builder1.setMessage("Вы уверены, что хотите сбросить счетчик?");
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                "Да", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.navigationlayout, new CountDolgPostFragment()).commit();
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