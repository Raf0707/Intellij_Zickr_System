package com.example.alhamdulillah;

import static android.os.Build.VERSION.SDK_INT;

import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.*;

import android.animation.*;
import android.app.*;
import android.net.*;
import android.os.*;
import android.content.*;
import android.provider.*;
import android.util.*;
import android.view.*;
import android.widget.*;
import com.google.android.material.floatingactionbutton.*;

import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;

import java.io.*;
import java.lang.ref.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static HashMap<String, String> hm= new HashMap<>();
    public static WeakReference<MainActivity> ctx = null;

    private Handler handler;
    private String activeNamaz;

    private Date currentDate;
    private Date localTime;

    private FloatingActionButton fab;
    private FloatingActionButton Koran_Karim;
    private FloatingActionButton sunna;
    private FloatingActionButton salavats;
    private FloatingActionButton dua;
    private FloatingActionButton zickr;
    private FloatingActionButton hadice;
    private FloatingActionButton names_of_Allah;
    private FloatingActionButton post;
    private FloatingActionButton intellij_zickr_system;

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

    private FloatingActionButton daily;

    private FloatingActionButton subhanAllah_wa_bi_Hamdih;

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
    public TextView nextNamaz;
    public TextView localtime_next_namaz;

    private TextView textHadice;
    private TextView textCount;
    private TextView textAyat;
    private TableLayout namazLayout;

    private final String url = "https://www.mihrab.ru";
    private Document document = null;

    private CalTimeElement calTimeElement;
    private int dailyCount;
    private String[] dailySpis;

    private View mainView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainView = findViewById(R.id.mainView);

        ctx = new WeakReference<MainActivity>(this);

        handler = new Handler();

        daily = findViewById(R.id.add_fab_daily);

        subhanAllah_wa_bi_Hamdih = findViewById(R.id.add_fab_subhanLlahWaBiHamdih);

        nextNamaz = findViewById(R.id.next_namaz);
        localtime_next_namaz = findViewById(R.id.localtime_next_namaz);

        textHadice = findViewById(R.id.textHadice);
        textAyat = findViewById(R.id.textAyat);
        textCount = findViewById(R.id.textCount);

        fab = findViewById(R.id.add_fab);
        Koran_Karim = findViewById(R.id.add_fab_read_Koran);
        sunna = findViewById(R.id.add_fab_Koran_by_heart);
        salavats = findViewById(R.id.add_fab_salavats);
        dua = findViewById(R.id.add_fab_dua);
        zickr = findViewById(R.id.add_fab_zickr);
        hadice = findViewById(R.id.add_fab_hadice);
        names_of_Allah = findViewById(R.id.add_fab_99_names_of_Allah);
        post = findViewById(R.id.add_fab_post);
        intellij_zickr_system = findViewById(R.id.add_fab_intellij_zickr_system);

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
        sunna.setVisibility(View.GONE);
        salavats.setVisibility(View.GONE);
        dua.setVisibility(View.GONE);
        zickr.setVisibility(View.GONE);
        hadice.setVisibility(View.GONE);
        names_of_Allah.setVisibility(View.GONE);
        post.setVisibility(View.GONE);
        intellij_zickr_system.setVisibility(View.GONE);


        settings.setVisibility(View.GONE);
        //kompas.setVisibility(View.GONE);
        zickr_Counter.setVisibility(View.GONE);
        swipe_Zickr_Counter.setVisibility(View.GONE);
        dolgi_i_zaslugi.setVisibility(View.GONE);
        //my_tsels.setVisibility(View.GONE);
        my_achieves.setVisibility(View.GONE);
        //resfolder.setVisibility(View.GONE);
        //music_Koran.setVisibility(View.GONE);

        isAllFabsVisible = false;
        isAllWijetsVisible = false;

        fab.setOnClickListener(View -> {
            if (!(isAllFabsVisible)) {
                Koran_Karim.show();
                //sunna.show();
                salavats.show();
                //dua.show();
                //zickr.show();
                //hadice.show();
                names_of_Allah.show();
                post.show();
                //intellij_zickr_system.show();
                isAllFabsVisible = true;
            } else {
                Koran_Karim.hide();
                //sunna.hide();
                salavats.hide();
                //dua.hide();
                //zickr.hide();
                //hadice.hide();
                names_of_Allah.hide();
                post.hide();
                //intellij_zickr_system.hide();
                isAllFabsVisible = false;
            }
        });

        Koran_Karim.setOnClickListener(View -> {
            SelectFragment = 8;
            startActivity(new Intent(MainActivity.this, NavigationActivity.class));
            Toast toast = Toast.makeText(getApplicationContext(), "Коран", Toast.LENGTH_SHORT);
            toast.show();
        });

        sunna.setOnClickListener(View -> {
            Toast toast = Toast.makeText(getApplicationContext(), "Сунна", Toast.LENGTH_SHORT);
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

        post.setOnClickListener(View -> {
            SelectFragment = 5;
            startActivity(new Intent(MainActivity.this, NavigationActivity.class));
            Toast toast = Toast.makeText(getApplicationContext(), "Пост в месяц Рамадан", Toast.LENGTH_SHORT);
            toast.show();
        });

        intellij_zickr_system.setOnClickListener(View -> {
            Toast toast = Toast.makeText(getApplicationContext(), "Система умных зикров", Toast.LENGTH_SHORT);
            toast.show();
        });


        wijets.setOnClickListener(View -> {
            if (!(isAllWijetsVisible)) {
                settings.show();
                //kompas.show();
                zickr_Counter.show();
                swipe_Zickr_Counter.show();
                dolgi_i_zaslugi.show();
                //my_tsels.show();
                my_achieves.show();
                //resfolder.show();
                //music_Koran.show();
                isAllWijetsVisible = true;
            } else {
                settings.hide();
                //kompas.hide();
                zickr_Counter.hide();
                swipe_Zickr_Counter.hide();
                dolgi_i_zaslugi.hide();
                //my_tsels.hide();
                my_achieves.hide();
                //resfolder.hide();
                //music_Koran.hide();
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
            SelectFragment = 7;
            startActivity(new Intent(MainActivity.this, NavigationActivity.class));
            Toast toast = Toast.makeText(getApplicationContext(), "Долги и заслуги перед Аллахом", Toast.LENGTH_SHORT);
            toast.show();
        });

        my_tsels.setOnClickListener(View -> {
            Toast toast = Toast.makeText(getApplicationContext(), "Мои цели", Toast.LENGTH_SHORT);
            toast.show();
        });

        my_achieves.setOnClickListener(View -> {
            SelectFragment = 10;
            startActivity(new Intent(MainActivity.this, NavigationActivity.class));
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

        daily.setOnClickListener(View -> {
            Intent intentt = new Intent(this, DailyActivity.class);
            startActivity(intentt);
            Toast toast = Toast.makeText(getApplicationContext(), "Дневной план", Toast.LENGTH_SHORT);
            toast.show();
        });

        subhanAllah_wa_bi_Hamdih.setOnClickListener(View -> {
//            SelectFragment = 9;
//            startActivity(new Intent(MainActivity.this, NavigationActivity.class));
            Intent intentt = new Intent(this, SubhanActivity.class);
            startActivity(intentt);
            Toast toast = Toast.makeText(getApplicationContext(), "Субхана Ллахи ва би Хамдих, Субхана Ллахиль Азым", Toast.LENGTH_SHORT);
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

        dailySpis = new String[]{"لاَ إلَهَ إلاَّ اللهُ", "حَسْبُنَا اللّهُ وَنِعْمَ الْوَكِيلُ", "أَسْتَغْفِرُ الله", "سُبْحَانَ اللَّهِ وَبِحَمْدِهِ سُبْحَانَ اللَّهِ الْعَظِيمِ", "الْحَمْدُ الِلهِ رَبِّ الْعَالَمِينَ",
                "لاَ اِلَهَ اِلَّا اللهُ الْمَلِكُ الْحَقُّ الْمُبِين", "رَبِّ اغْفِـرْ لِي", "أَسْتَغْفِرُ الله العَظِيم اَلَّذِي لاَ إلَهَ إلَّا هُوَ الْحَيَّ القَيُّومَ وَأَتُوبُ إِلَيْهِ", "الم.  اللّهُ لا إِلَهَ إِلاَّ هُوَ الْحَيُّ الْقَيُّومُ" ,"رَبِّ ابْنِ لِي عِنْدَكَ بَيْتًا فِي الْجَنَّةِ" ,"اللهُ أكْبَرُ" ,"لاَ اِلَهَ اِلَّا أَنْتَ سُبْحَانَكَ اِنِّي كُنْتُ مِنَ الظَّالِمِين", "لَا حَوْلَ وَلَا قُوَّةَ إِلَّا بِٱللَّٰهِ"};


        Random random = new Random();
        int myRandStringIndex = random.nextInt(dailySpis.length);
        textAyat.setText(dailySpis[myRandStringIndex]);
        dailyCount = 5;
        textCount.setText(Integer.toString(dailyCount));

        Callback.addCallback(() -> {

            if (hm.get("Фаджр") != null && hm.get("Шурук") != null && hm.get("Духа") != null && hm.get("Зухр") != null && hm.get("Аср") != null && hm.get("Магриб") != null && hm.get("Иша") != null && hm.get("Тахаджуд") != null) {

                localTime = Calendar.getInstance().getTime();;
                Date fff = localTime;
                SimpleDateFormat sss = new SimpleDateFormat("HH:mm:ss");

                String lt = sss.format(fff);
                long llt = CalTimeElement.secPerHours(lt);

                long fajr = CalTimeElement.secPerHours(hm.get("Фаджр") );
                long voshod = CalTimeElement.secPerHours(hm.get("Шурук"));
                long duha = CalTimeElement.secPerHours(hm.get("Духа"));
                long zuckhr = CalTimeElement.secPerHours(hm.get("Зухр"));
                long asr = CalTimeElement.secPerHours(hm.get("Аср"));
                long magrib = CalTimeElement.secPerHours(hm.get("Магриб"));
                long isha = CalTimeElement.secPerHours(hm.get("Иша"));
                long tahajud = (CalTimeElement.secPerHours(hm.get("Тахаджуд")) + (24 * 3600));

                long fajr_voshod = Math.abs((voshod + 24 * 3600) - llt);
                long voshod_duha = Math.abs((duha + 24 * 3600) - llt);
                long duha_zuckhr = Math.abs((zuckhr + 24 * 3600) - llt);
                long zuckhr_asr = Math.abs((asr + 24 * 3600) - llt);
                long asr_magrib = Math.abs((magrib + 24 * 3600) - llt);
                long magrib_isha = Math.abs((isha + 24 * 3600) - llt);
                long isha_tahajud = Math.abs((tahajud + 24 * 3600) - llt);
                long tahajud_fajr = Math.abs((fajr + 24 * 3600) - llt);

                Log.d("NAMAZ", "" + CalTimeElement.timeToStringSec(isha_tahajud) + " " + CalTimeElement.timeToStringSec(llt));
                Log.d("SECC", "" + isha_tahajud + " " + llt);

                if (llt >= 0 && llt <= fajr) {
                    llt += (24 * 3600);
                }

                if ((fajr <= llt) && (llt < voshod)) {
                    nextNamaz.setText("Восход");
                    localtime_next_namaz.setText((CalTimeElement.timeToStringSec(fajr_voshod % (24 * 3600))));
                    Log.d("VVV", "VVV");
                } else if ((voshod <= llt) && (llt < duha)) {
                    nextNamaz.setText("Духа");
                    localtime_next_namaz.setText((CalTimeElement.timeToStringSec(voshod_duha % (24 * 3600))));
                    Log.d("QQQ", "QQQ");
                } else if ((duha <= llt) && (llt < zuckhr)) {
                    nextNamaz.setText("Зухр");
                    localtime_next_namaz.setText((CalTimeElement.timeToStringSec(duha_zuckhr % (24 * 3600))));
                    Log.d("RRR", "RRR");
                } else if ((zuckhr <= llt) && (llt < asr)) {
                    nextNamaz.setText("Аср");
                    localtime_next_namaz.setText((CalTimeElement.timeToStringSec(zuckhr_asr % (24 * 3600))));
                    Log.d("EEE", "EEE");
                } else if ((asr <= llt) && (llt < magrib)) {
                    nextNamaz.setText("Магриб");
                    localtime_next_namaz.setText((CalTimeElement.timeToStringSec(asr_magrib % (24 * 3600))));
                    Log.d("SSS", "SSS");
                } else if ((magrib <= llt) && (llt < isha)) {
                    nextNamaz.setText("Иша");
                    localtime_next_namaz.setText((CalTimeElement.timeToStringSec(magrib_isha % (24 * 3600))));
                    Log.d("AAA", "AAA");
                } else if ((isha <= llt) && (llt < tahajud)) {
                    nextNamaz.setText("Тахаджуд");
                    localtime_next_namaz.setText((CalTimeElement.timeToStringSec(isha_tahajud % (24 * 3600))));
                    Log.d("PPP", "PPP");
                } else if ((tahajud <= llt) && (llt < (fajr % (24 * 3600)))) {
                    nextNamaz.setText("Фаджр");
                    localtime_next_namaz.setText((CalTimeElement.timeToStringSec(tahajud_fajr)));
                    Log.d("OOO", "OOO");
                }


            }


        });

        Thread t = new Thread(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
                handler.post((Runnable) r);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t.start();

        mainView.setOnTouchListener(new OnSwipeTouchListener(getApplicationContext()) {

            @Override
            public void onDoubleClick() {
                SelectFragment = 6;
                startActivity(new Intent(MainActivity.this, NavigationActivity.class));
            }
        });

        Intent resultIntent = new Intent(this, MainActivity.class);
        PendingIntent resultPendingIntent = PendingIntent.getActivity(this, 0, resultIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);


        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle("Title")
                        .setContentText("Notification text")
                        .setContentIntent(resultPendingIntent);

        Notification notification = builder.build();


        NotificationManager notificationManager =
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(2, notification);

    }


    Runnable r = new Runnable() {
        @Override
        public void run() {
            Callback.runAllCallbacks();
            handler.postDelayed(r,1000);
        }
    };



    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.hadice_button:

                if (!(isOpenHadice)) {

                    textHadice.setVisibility(View.VISIBLE);

                    hadice_button.setVisibility(View.INVISIBLE);
                    hadice_button.setClickable(false);

                    close_hadice_button.setVisibility(View.VISIBLE);
                    close_hadice_button.setClickable(true);

                    ObjectAnimator hadice_animator = ObjectAnimator.ofFloat(hadice_layout, "translationY", 0);
                    hadice_animator.setDuration(200);
                    hadice_animator.start();
                    isOpenHadice = true;

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
                    sunna.hide();
                    salavats.hide();
                    dua.hide();
                    zickr.hide();
                    hadice.hide();
                    names_of_Allah.hide();
                    post.hide();

                    fab.hide();
                    wijets.hide();
                    daily.hide();
                    subhanAllah_wa_bi_Hamdih.hide();

                    textAyat.setVisibility(View.GONE);
                    hijra.setVisibility(View.GONE);

                    namazLayout.setVisibility(View.GONE);
                    ayat_layout.setVisibility(View.GONE);

                    nextNamaz.setVisibility(View.GONE);
                    localtime_next_namaz.setVisibility(View.GONE);

                }

                break;

            case R.id.close_hadice_button:

                if (isOpenHadice) {

                    textHadice.setVisibility(View.GONE);

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
                    daily.show();
                    subhanAllah_wa_bi_Hamdih.show();

                    namazLayout.setVisibility(View.VISIBLE);
                    textAyat.setVisibility(View.VISIBLE);
                    ayat_layout.setVisibility(View.VISIBLE);
                    hijra.setVisibility(View.VISIBLE);

                    nextNamaz.setVisibility(View.VISIBLE);
                    localtime_next_namaz.setVisibility(View.VISIBLE);

                    break;

                }

            case R.id.ayat_button:

                if (!(isOpenAyat)) {

                    ayat_button.setClickable(false);
                    ayat_button.setVisibility(View.INVISIBLE);

                    fab.hide();
                    wijets.hide();
                    daily.hide();
                    subhanAllah_wa_bi_Hamdih.hide();

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
                    sunna.hide();
                    salavats.hide();
                    dua.hide();
                    zickr.hide();
                    hadice.hide();
                    names_of_Allah.hide();
                    post.hide();

                    ObjectAnimator ayat_animator = ObjectAnimator.ofFloat(ayat_layout, "translationY", 0f);
                    ayat_animator.setDuration(200);
                    ayat_animator.start();
                    isOpenAyat = true;

                }

                break;

            case R.id.close_ayat_button:
                dailyCount = Integer.parseInt(textCount.getText().toString());
                dailyCount--;
                if (dailyCount < 0) {
                    dailyCount = 0;

                }

                textCount.setText(Integer.toString(dailyCount));

                if (dailyCount == 0) {
                    ObjectAnimator ayat_animator = ObjectAnimator.ofFloat(ayat_layout, "translationY", 900f);
                    ayat_animator.setDuration(200);
                    ayat_animator.start();
                    isOpenAyat = false;

                    ObjectAnimator hide_button_ayat = ObjectAnimator.ofFloat(ayat_button, "alpha", 1);
                    hide_button_ayat.setDuration(100);
                    hide_button_ayat.start();

                    Toast toast1 = Toast.makeText(this, "Да вознаградит Вас Аллах за ежедневное поминание", Toast.LENGTH_SHORT);
                    toast1.show();

                    fab.show();
                    wijets.show();
                    daily.show();
                    subhanAllah_wa_bi_Hamdih.show();

                    Random r = new Random();
                    int myRandStringIndex = r.nextInt(dailySpis.length);
                    textAyat.setText(dailySpis[myRandStringIndex]);
                    dailyCount = 33;
                    textCount.setText(Integer.toString(dailyCount));
                }

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

        @RequiresApi(api = Build.VERSION_CODES.O)
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
            //Elements elementsRasp = document.getElementsByClass("modiptultimer");
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
                String[] pars = resul.split(" ", 2);
                hm.put(pars[0], pars[1]);
            }


            for(Element element: elementsRasp) {
                String elh= element.html();
                String preresul = elh.replace("<span>","spaceop").replace("</span>","spacend");
                String resul = preresul.replace("spaceop"," ").replace("spacend","");
                String[] pars = resul.split(" ", 2);

                if (pars[1].contains(" ")) {
                    pars[1] = pars[1].replace(" ", "");
                }

                if (pars[0].contains("Шурук")) {
                    pars[0] = pars[0].replace("Шурук", "Восход");
                }

                if (pars[0].contains("Фаджр")) {
                    if (String.valueOf(pars[1]).length() == 4) {
                        pars[1] = "0" + pars[1];
                    }
                }

                if (pars[0].contains("Восход")) {
                    if (String.valueOf(pars[1]).length() == 4) {
                        pars[1] = "0" + pars[1];
                    }
                }

                if (pars[0].contains("Духа")) {
                    if (String.valueOf(pars[1]).length() == 4) {
                        pars[1] = "0" + pars[1];
                    }
                }

                if (pars[0].contains("Тахаджуд")) {
                    if (String.valueOf(pars[1]).length() == 4) {
                        pars[1] = "0" + pars[1];
                    }
                }

                if (pars[0].equals("Иша")) {
                    ctElements.add(new CalTimeElement(getApplicationContext(), namazLayout, pars[0], pars[1]));
                }

                if (pars[0].contains("Иша")) {
                    pars[0] = pars[0].replace("Иша", "Тахаджуд");
                }

                if (pars[0].equals("Восход")) {
                    ctElements.add(new CalTimeElement(getApplicationContext(), namazLayout, pars[0], pars[1]));
                }

                if (pars[0].contains("Восход")) {
                    pars[0] = pars[0].replace("Восход", "Духа");
                }

                ctElements.add(new CalTimeElement(getApplicationContext(), namazLayout, pars[0], pars[1]));
            }

        }
    }

    public boolean containsTime(String string){
        return string.matches(".*\\d+.*");
    }

    private void requestPermission() {
        if (SDK_INT >= Build.VERSION_CODES.R) {
            try {
                Intent intent = new Intent(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION);
                intent.addCategory("android.intent.category.DEFAULT");
                intent.setData(Uri.parse(String.format("package:%s",getApplicationContext().getPackageName())));
                startActivityForResult(intent, 2296);
            } catch (Exception e) {
                Intent intent = new Intent();
                intent.setAction(Settings.ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION);
                startActivityForResult(intent, 2296);
            }
        } else {
            //below android 11
            //ActivityCompat.requestPermissions(MainActivity.this, new String[]{WRITE_EXTERNAL_STORAGE}, PERMISSION_REQUEST_CODE);
        }

    }

}