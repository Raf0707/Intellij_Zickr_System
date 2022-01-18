package com.example.alhamdulillah;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.*;

import android.animation.*;
import android.os.*;
import android.content.*;
import android.util.*;
import android.view.*;
import android.widget.*;
import com.google.android.material.floatingactionbutton.*;

import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;

import java.io.*;
import java.lang.ref.*;
import java.util.*;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {



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

    private Button hadice_button;
    private Button close_hadice_button;
    private LinearLayout hadice_layout;
    private boolean isOpenHadice = false;

    private Button ayat_button;
    private Button close_ayat_button;
    private LinearLayout ayat_layout;
    private boolean isOpenAyat = false;

    public static int SelectFragment = 0;

    private TextView hijra;
    private TextView countNamaz;
    private TextView textHadice;
    private TextView textAyat;
    private TableLayout namazLayout;

    private final String url = "https://www.mihrab.ru";
    private Document document = null;

    private CalTimeElement calTimeElement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countNamaz = findViewById(R.id.countnamaz);
        textHadice = findViewById(R.id.textHadice);
        textAyat = findViewById(R.id.textAyat);

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

        Koran_Karim.setOnClickListener(View -> {
            Toast toast = Toast.makeText(getApplicationContext(), "Коран", Toast.LENGTH_SHORT);
            toast.show();
        });

        Koran_Karim_by_heart.setOnClickListener(View -> {
            Toast toast = Toast.makeText(getApplicationContext(), "Заучивание Корана Наизусть", Toast.LENGTH_SHORT);
            toast.show();
        });

        salavats.setOnClickListener(View -> {
            SelectFragment = 2;
            startActivity(new Intent(MainActivity.this, NavigationActivity.class));
            Toast toast = Toast.makeText(getApplicationContext(), "Салаваты", Toast.LENGTH_SHORT);
            toast.show();
        });

        dua.setOnClickListener(View -> {
            Toast toast = Toast.makeText(getApplicationContext(), "Ду'а", Toast.LENGTH_SHORT);
            toast.show();
        });

        zickr.setOnClickListener(View -> {
            Toast toast = Toast.makeText(getApplicationContext(), "Зикры", Toast.LENGTH_SHORT);
            toast.show();
        });

        hadice.setOnClickListener(View -> {
            Toast toast = Toast.makeText(getApplicationContext(), "Хадисы", Toast.LENGTH_SHORT);
            toast.show();
        });

        names_of_Allah.setOnClickListener(View -> {
            SelectFragment = 4;
            startActivity(new Intent(MainActivity.this, NavigationActivity.class));
            Toast toast = Toast.makeText(getApplicationContext(), "99 имен Аллаха", Toast.LENGTH_SHORT);
            toast.show();
        });


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

        kompas.setOnClickListener(View -> {
            Toast toast = Toast.makeText(getApplicationContext(), "Компас", Toast.LENGTH_SHORT);
            toast.show();
        });

        zickr_Counter.setOnClickListener(View -> {
            SelectFragment = 1;
            startActivity(new Intent(MainActivity.this, NavigationActivity.class));
            Toast toast = Toast.makeText(getApplicationContext(), "Счетчик", Toast.LENGTH_SHORT);
            toast.show();
        });

        swipe_Zickr_Counter.setOnClickListener(View -> {
            SelectFragment = 3;
            startActivity(new Intent(MainActivity.this, NavigationActivity.class));
            Toast toast = Toast.makeText(getApplicationContext(), "Жестовый Счетчик", Toast.LENGTH_SHORT);
            toast.show();
        });

        dolgi_i_zaslugi.setOnClickListener(View -> {
            Toast toast = Toast.makeText(getApplicationContext(), "Долги и заслуги перед Аллахом", Toast.LENGTH_SHORT);
            toast.show();
        });

        my_tsels.setOnClickListener(View -> {
            Toast toast = Toast.makeText(getApplicationContext(), "Мои цели", Toast.LENGTH_SHORT);
            toast.show();
        });

        my_achieves.setOnClickListener(View -> {
            Toast toast = Toast.makeText(getApplicationContext(), "Мои достижения", Toast.LENGTH_SHORT);
            toast.show();
        });

        resfolder.setOnClickListener(View -> {
            Toast toast = Toast.makeText(getApplicationContext(), "Папка результата", Toast.LENGTH_SHORT);
            toast.show();
        });

        music_Koran.setOnClickListener(View -> {
            Toast toast = Toast.makeText(getApplicationContext(), "Прослушивание Корана", Toast.LENGTH_SHORT);
            toast.show();
        });

        hadice_button = findViewById(R.id.hadice_button);
        close_hadice_button = findViewById(R.id.close_hadice_button);
        hadice_button.setOnClickListener(this);
        close_hadice_button.setOnClickListener(this);
        hadice_layout = findViewById(R.id.hadice_layout);
        hadice_layout.setTranslationY(-2300);

        ayat_button = findViewById(R.id.ayat_button);
        ayat_button.setOnClickListener(this);
        close_ayat_button = findViewById(R.id.close_ayat_button);
        close_ayat_button.setOnClickListener(this);
        ayat_layout = findViewById(R.id.ayat_layout);
        ayat_layout.setTranslationY(730);

        hijra = findViewById(R.id.hijra);
        namazLayout = findViewById(R.id.namazLayout);

        new MyTask().execute();

        Intent intent = new Intent(this, AzanService.class);
        startService(intent);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.hadice_button:

                if (!(isOpenHadice)) {

                    hadice_button.setVisibility(View.INVISIBLE);
                    hadice_button.setClickable(false);

                    close_hadice_button.setVisibility(View.VISIBLE);
                    close_hadice_button.setClickable(true);

                    ObjectAnimator hadice_animator = ObjectAnimator.ofFloat(hadice_layout, "translationY", 0);
                    hadice_animator.setDuration(200);
                    hadice_animator.start();
                    isOpenHadice = true;

                    /*
                    ObjectAnimator hide_button = ObjectAnimator.ofFloat(hadice_button, "alpha", 0);
                    hide_button.setDuration(100);
                    hide_button.start();

                     */

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

                    Koran_Karim.hide();
                    Koran_Karim_by_heart.hide();
                    salavats.hide();
                    dua.hide();
                    zickr.hide();
                    hadice.hide();
                    names_of_Allah.hide();

                    fab.hide();
                    wijets.hide();
                    textAyat.setVisibility(View.GONE);
                    hijra.setVisibility(View.GONE);

                    namazLayout.setVisibility(View.GONE);
                    ayat_layout.setVisibility(View.GONE);

                    ayat_button.setVisibility(View.INVISIBLE);
                    ayat_button.setClickable(false);

                    //calTimeElement.getCb().setClickable(false);
                    //calTimeElement.getCb().setVisibility(View.INVISIBLE);

                }

                break;

            case R.id.close_hadice_button:

                if (isOpenHadice) {

                    hadice_button.setClickable(true);
                    hadice_button.setVisibility(View.VISIBLE);

                    close_hadice_button.setVisibility(View.INVISIBLE);
                    close_hadice_button.setClickable(false);

                    ObjectAnimator hadice_animator = ObjectAnimator.ofFloat(hadice_layout, "translationY", -1300f);
                    hadice_animator.setDuration(200);
                    hadice_animator.start();
                    isOpenHadice = false;

                    ObjectAnimator hide_button = ObjectAnimator.ofFloat(hadice_button, "alpha", 1);
                    hide_button.setDuration(100);
                    hide_button.start();

                    textAyat.setVisibility(View.VISIBLE);
                    fab.show();
                    wijets.show();

                    ayat_button.setVisibility(View.VISIBLE);
                    ayat_button.setClickable(true);
                    namazLayout.setVisibility(View.VISIBLE);
                    textAyat.setVisibility(View.VISIBLE);
                    ayat_layout.setVisibility(View.VISIBLE);
                    hijra.setVisibility(View.VISIBLE);

                    //calTimeElement.getCb().setClickable(true);
                    //calTimeElement.getCb().setVisibility(View.VISIBLE);


                    break;

                }

            case R.id.ayat_button:

                if (!(isOpenAyat)) {

                    ayat_button.setClickable(false);

                    ObjectAnimator ayat_animator = ObjectAnimator.ofFloat(ayat_layout, "translationY", 0f);
                    ayat_animator.setDuration(1000);
                    ayat_animator.start();
                    isOpenAyat = true;

                    ObjectAnimator hide_button_ayat = ObjectAnimator.ofFloat(ayat_button, "alpha", 0);
                    hide_button_ayat.setDuration(600);
                    hide_button_ayat.start();
                    //Log.d("cord", String.valueOf(ayat_layout.getTranslationY()));
                }

                break;

            case R.id.close_ayat_button:

                ayat_button.setClickable(true);

                ObjectAnimator ayat_animator = ObjectAnimator.ofFloat(ayat_layout, "translationY", 730f);
                ayat_animator.setDuration(1000);
                ayat_animator.start();
                isOpenAyat = false;

                ObjectAnimator hide_button_ayat = ObjectAnimator.ofFloat(ayat_button, "alpha", 1);
                hide_button_ayat.setDuration(600);
                hide_button_ayat.start();
                //Log.d("cord1", String.valueOf(ayat_layout.getTranslationY()));

                break;

        }
    }


    class MyTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... params) {
            try {
                document = Jsoup.connect(url).get();

            } catch(IOException e){
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);

            Element header_calendar = document.getElementsByClass("head-calendar").first();

            StringBuilder stringBuilder = new StringBuilder();

            String[] spl = header_calendar.text().split(" ");
            spl[3] = "\n\n" + spl[3];
            for (String s : spl) {
                stringBuilder.append(" " + s + " ");
            }
            hijra.setText(stringBuilder.toString());
            hijra.setTextColor(getResources().getColor(R.color.purple_300));
            hijra.setTextSize(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 6, getResources().getDisplayMetrics()));

            String txt = header_calendar.html();
            String elt = Jsoup.parse(txt).text();

            Elements elementsRasp = document.getElementsByClass("modiptprayer");
            ArrayList<CalTimeElement> ctElements = new ArrayList<CalTimeElement>();

            Element ayat = document.getElementById("srq_quote");
            textHadice.setGravity(Gravity.CENTER);
            textHadice.setTextColor(getResources().getColor(R.color.purple_300));
            textHadice.setTextSize(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 8, getResources().getDisplayMetrics()));
            textHadice.setText(ayat.text());


            for(Element element: elementsRasp) {
                String elh= element.html();
                String preresul = elh.replace("<span>","spaceop").replace("</span>","spacend");
                String resul = preresul.replace("spaceop"," ").replace("spacend","");
                String[] pars = resul.split(" ",2);

                if (pars[1].contains(" ")) {
                    pars[1] = pars[1].replace(" ", "");
                }

                if (pars[0].contains("Шурук")) {
                    pars[0] = pars[0].replace("Шурук", "Восход");
                }

                ctElements.add(new CalTimeElement(getApplicationContext(), namazLayout, pars[0], pars[1]));

            }

        }
    }

    public boolean containsTime(String string){
        return string.matches(".*\\d+.*");
    }


}