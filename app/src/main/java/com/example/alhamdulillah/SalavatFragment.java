package com.example.alhamdulillah;

import android.content.*;
import android.os.*;

import androidx.constraintlayout.widget.*;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import java.util.*;
import java.util.concurrent.*;


public class SalavatFragment extends Fragment implements View.OnClickListener{
    private Handler handler;
    private String[] textsArabic;
    private String[] textPage;
    private String[] textCount;
    private String[] save;
    private int currentPage = 0;
    private int currentCount = 0;
    private ConstraintLayout myLayout;
    private TextView arabic;
    private TextView page;
    private TextView salavatCounter;
    private SeekBar seekBar;
    private Button back;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_salavat, null);

        myLayout = view.findViewById(R.id.myLayout);
        back = view.findViewById(R.id.back);
        back.setOnClickListener(this);
        arabic = view.findViewById(R.id.arabic);
        page = view.findViewById(R.id.page);
        salavatCounter = view.findViewById(R.id.salavatCounter);
        handler = new Handler();
        textsArabic = new String[31];
        textPage = new String[31];
        textCount = new String[31];
        save = new String[31];
        seekBar = view.findViewById(R.id.seekBar);
        //Objects.requireNonNull(getSupportActionBar()).hide();

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    currentPage = progress;
                    textPage[currentPage] = Integer.toString(progress);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

        });

        initArabic();
        initPage();
        initCounter();
        initSave();
        setRes();


        Thread t = new Thread(() -> {
            try{
                TimeUnit.MILLISECONDS.sleep(100);
                handler.post(r);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        });

        t.start();

        myLayout.setOnTouchListener(new OnSwipeTouchListener(view.getContext()) {
            int ciCurrent = currentPage;

            @Override
            public void onSwipeRight() {
                textCount[currentPage] = salavatCounter.getText().toString();
                save[currentPage] = salavatCounter.getText().toString();
                int ciCurrent = currentPage;
                currentCount = 0;
                salavatCounter.setText("0");
                currentPage--;
                if (currentCount < 0) currentCount = 0;
                seekBar.setProgress(currentPage);
            }

            @Override
            public void onSwipeLeft() {
                textCount[currentPage] = salavatCounter.getText().toString();
                save[currentPage] = salavatCounter.getText().toString();
                int ciCurrent = currentPage;
                currentCount = 0;
                salavatCounter.setText("0");
                currentPage++;
                seekBar.setProgress(currentPage);
            }

            @Override
            public void onSwipeDown() {
                currentCount++;
                textCount[currentPage] = Integer.toString(currentCount);
                salavatCounter.setText(textCount[currentPage]);

            }

            @Override
            public void onSwipeUp() {
                currentCount--;
                if (currentCount < 0) currentCount = 0;
                textCount[currentPage] = Integer.toString(currentCount);
                salavatCounter.setText(textCount[currentPage]);

            }

            @Override
            public void onClick() {
                currentCount++;
                textCount[currentPage] = Integer.toString(currentCount);
                salavatCounter.setText(textCount[currentPage]);

            }

            @Override
            public void onDoubleClick() {
                currentCount++;
                textCount[currentPage] = Integer.toString(currentCount);
                salavatCounter.setText(textCount[currentPage]);

            }

            @Override
            public void onLongClick() {
                currentCount = 0;
                textCount[currentPage] = Integer.toString(currentCount);
                salavatCounter.setText(textCount[currentPage]);

            }
        });

        return view;
    }

    public void initArabic() {
        textsArabic[0] = "اللَّهُمَّ صَلِّ عَلَى سَيِّدِنَا مُحَمَّدٍ فِي الْأَوَّلِينَ وَالْآخِرِ ينَ وَفِي الْمَلَا ءِالْأَ عْلَى اِلَى يَوْمِ الدِّينِ";
        textsArabic[1] = "أللَّهُمَّ صَلِّ وَ سَلِّمْ وَ بَارِكْ عَلَى سَيِّدِنَا مُحَمَّدِنِ الْفَاتِحِ لِمَا أُغْلِقَ وَالْخَاتِمِ لِمَا سَبَقَ وَ نَاصِرِ الْحَقِّ بِالْحَقِّ وَالْهَادِي إِلَى صِرَاطِكَ الْمُسْتَقِيم صَلَّى ٱللَّٰهُ تَعَالَى عَلَيْهِ وَ عَلَى آلِهِ وَ أَ صْحَابِهِ حَقَّ قَدْرِهِ وَ مِقْدَارِهِ الْعَظِيمِ";
        textsArabic[2] = "السَلَامُ عَلَيْكَ أيُّهَا النَّبِيُّ وَ رَحْمَةُ اللهِ تَعَالَى وَ بَرَكَاتُهُ";
        textsArabic[3] = "اَللَّهُمَّ صَلِّ عَلَى سَيِّدِنَا مُحَمَّدٍ عَبْدِكَ وَ نَبِيِّكَ وَ رَسُو لِكَ النَّبِيِّ اْلأُمِّيِّ وَ عَلَى آَلِهِ وَ صَحْبِهِ وَ سَلِّمْ";
        textsArabic[4] = "صَلَوَاتُ اللهِ وَ مَلَاإِكَتِهِ وَأَنْبِيَاإِهِ وَ رُسُلِهِ وَجَمِيعِ خَلْقِهِ عَلَى سَيِّدِنَا مُحَمَّدٍ وَ عَلَى آَلِ سَيِّدِنَا مُحَمَّدٍ عَلَيْهِ وَ عَلَيهِمْ السَّلَامُ وَ رَحْمَةُ اللهِ تَعَالَى وَ بَرَكَاتُهُ";
        textsArabic[5] = "اللَّهُـمَّ صَلِّ عَلَـى مُحَمَّـدٍ، وَعَلَـى آلِ مُحَمَّدٍ، كَمَـا صَلَّيـتَ عَلَـى إبْرَاهِـيمَ وَعَلَـى آلِ إبْرَاهِـيمَ، إِنَّكَ حَمِـيدٌ مَجِـيدٌ ، اللَّهُـمَّ بَارِكْ عَلَـى مُحَمَّـدٍ، وَعَلَـى آلِ مُحَمَّـدٍ، كَمَـا بَارَكْتَ عَلَى إبْرَاهِـيمَ وَعَلَـى آلِ إبْرَاهِيمَ، إِنَّكَ حَمِـيدٌ مَجِـيدٌ";
        textsArabic[6] = "اللّهُـمَّ صَلِّ عَلَـى مُحَمَّـدٍ عَبْدِكَ وَ عَلَى آلِهِ وَ أَزْوَاجِـهِ وَ ذُرِّيَّـتِهِ، كَمَـا صَلَّيْـتَ عَلَـى إبْرَاهِـيمَ وَ عَلَى آلِ إبْرَاهِـيمَ، وَ بَارِكْ عَلَـى مُحَمَّـدٍ وَ أَزْوَاجِـهِ وَ ذُرِّيَّـتِهِ، كَمَـا بَارَكْتَ عَلَـى إبْرَاهِـيمَ وَ عَلَى آلِ إبْرَاهِـيمَ. إِنَّكَ حَمِـيدٌ مَجِـيدٌ";
        textsArabic[7] = "اَللَّهُمَّ صَلِّ صَلَاةً كَامِلَةً وَسَلِّمْ سَلَاماً تَامًّا عَلَى سَيِّدِنَا مُحَمَّدٍ اِلَّذِي تَنْحَلُّ بِهِ الْعُقَدُ وَتَنْفَرِجُ بِهِ الْكُرَبُ وَتُقْضَى بِهِ الْحَوَائِجُ وَتُنَالُ بِهِ الرَّغَائِبُ وَحُسْنُ الْخَوَاتِمِ وَيُسْتَسْقَى الْغَمَامُ بِوَجْهِهِ الْكَرِيمِ وَعَلَى آلِهِ وَصَحْبِهِ فِي كُلِّ لَمْحَةٍ وَنَفَسٍ بِعَدَدِ كُلِّ مَعْــلُومٍ لَكَ";
        textsArabic[8] = "اللَّهُمَّ صَلِّ عَلَى سَيِّدِنَا مُحَمَّدٍ طِبِّ الْقُلُوبِ وَدَوَاءِهَا وَ عَافِيَةِ الْأَبْدَانِ وَشِفَاءِهَا وَ نُورِ الْأَبْصَارِ وَضِيَا أِهَا وَ عَلَى آلِهِ وَ صَحْبِهِ وَ سَلِّمْ";
        textsArabic[9] = "اَللَّهُمَّ صَلِّي وَ سَلِّمْ وَبَارِكْ عَلَى سَيِّدِنَا مُحَمَّدٍ وَ عَلَى آلِهِ وَ صَحْبِهِ وَ سَلِّمْ";
        textsArabic[10] = "اللَّهُمَّ صَلِّ عَلَى سَيِّدِنَا مُحَمَّدٍ، وَ عَلَى آلِ سَيِّدِنَا مُحِمَّدٍ، صَلَاةً تُنَجِّينَا بِهَا مِنْ جَمِيعِ الْأَهوَالِ وَالْأَفَاتِ، وَتَقْضِي لَنَا بِهَا جَمِيعَ الْحَاجَاتِ وَتُطَهِّرُنَا بِهَا مِنْ جَمِيعِ السَّيِّئَاتِ وَتَرْفَعُنَا بِهَا أَعْلَى الدَّرَجَاتِ وَتُبَلِّغُنَا بِهَا أَقْصَى الْغَايَاتِ مِنْ جَمِيعِ الْخَيْرَاتِ فِي الْحَيَاةِ وَبَعْدَ الْمَمَاتِ، بِرَحْمَتِكَ يَا أَرْحَمَ الرَّاحِمِينِ. حَسْبُنَا اللهُ وَ نِعْمَ الوَكِيلُ، نِعْمَ المَوْلَى وَ نِعْمَ النَّصِيرُ، غُفْرَانَكَ رَبَّنَا وَاِلَيْكَ الْمَصِيرُ";
        textsArabic[11] = "اَللَّهُمَّ صَلِّ عَلَى مُحَمَّدٍ وَ عَلَى آلِ مُحَمَّدٍ وَ اهْدِنِى مِنْ عِنْدِكَ وَ أَفْضِ عَلَيَّ مِنْ فَضْلِكَ وَ انْشُرْ عَلَيَّ مِنْ رَحْمَتِكَ وَ أَنْزِلْ عَلَيَّ بَرَكَاتِكَ";
        textsArabic[12] = "اللَّهُمَّ صَلِّ عَلَى مُحَمَّدٍ كُلَّمَا ذَكَرَهُ الذَاكِرُونَ وَ صَلِّ عَلَى مُحَمَّدٍ كُلَّمَا غَفَلَ عَنْ ذِكْرِهِ الغَافِلُونَ";
        textsArabic[13] = "جَزَى اللهُ عَنَّا مُحَمَّدًا صَلَّى اللهُ تَعَالَى عَلَيْهِ وَ سَلَّمَ بِمَا هُوَ أَهْلُهُ";
        textsArabic[14] = "اَللَّهُمَّ صَلِّ وَسَلِّمْ وَبَارِكْ عَلَى سَيِّدِنَا مُحَمَّدٍ وَعَلَى آلِهِ كَمَا لاَ نِهَايَةَ لِكَمَالِكَ وَعَدَدَ كَمَالِه";
        textsArabic[15] = "اَللّٰهُمَّ صَلِّى عَلَى سَيِّدِنَا مُحَمَّدٍ وَ اَنْزِلْهُ الْمُنزَلَ الْمُقَرَّبَ عِنْدَكَ يَوْمِ الْقِيَامَةِ";

    }

    public void initPage() {
        textPage[0] = "0";
        textPage[1] = "1";
        textPage[2] = "2";
        textPage[3] = "3";
        textPage[4] = "4";
        textPage[5] = "5";
        textPage[6] = "6";
        textPage[7] = "7";
        textPage[8] = "8";
        textPage[9] = "9";
        textPage[10] = "10";
        textPage[11] = "11";
        textPage[12] = "12";
        textPage[13] = "13";
        textPage[14] = "14";
        textPage[15] = "15";
        textPage[16] = "16";
        textPage[17] = "17";
        textPage[18] = "18";
        textPage[19] = "19";
        textPage[20] = "20";
        textPage[21] = "21";
        textPage[22] = "22";
        textPage[23] = "23";
        textPage[24] = "24";
        textPage[25] = "25";
        textPage[26] = "26";
        textPage[27] = "27";
        textPage[28] = "28";
        textPage[29] = "29";
        textPage[30] = "30";
    }

    public void initCounter() {
        textCount[0] = "0";
        textCount[1] = "0";
        textCount[2] = "0";
        textCount[3] = "0";
        textCount[4] = "0";
        textCount[5] = "0";
        textCount[6] = "0";
        textCount[7] = "0";
        textCount[8] = "0";
        textCount[9] = "0";
        textCount[10] = "0";
        textCount[11] = "0";
        textCount[12] = "0";
        textCount[13] = "0";
        textCount[14] = "0";
        textCount[15] = "0";
        textCount[16] = "0";
        textCount[17] = "0";
        textCount[18] = "0";
        textCount[19] = "0";
        textCount[20] = "0";
        textCount[21] = "0";
        textCount[22] = "0";
        textCount[23] = "0";
        textCount[24] = "0";
        textCount[25] = "0";
        textCount[26] = "0";
        textCount[27] = "0";
        textCount[28] = "0";
        textCount[29] = "0";
        textCount[30] = "0";

    }

    public int getCurrentPage() {
        return Integer.parseInt(page.getText().toString());
    }

    public void initSave() {
        save[0] = "";
        save[1] = "";
        save[2] = "";
        save[3] = "";
        save[4] = "";
        save[5] = "";
        save[6] = "";
        save[7] = "";
        save[8] = "";
        save[9] = "";
        save[10] = "";
        save[11] = "";
        save[12] = "";
        save[13] = "";
        save[14] = "";
        save[15] = "";
        save[16] = "";
        save[17] = "";
        save[18] = "";
        save[19] = "";
        save[20] = "";
        save[21] = "";
        save[22] = "";
        save[23] = "";
        save[24] = "";
        save[25] = "";
        save[26] = "";
        save[27] = "";
        save[28] = "";
        save[29] = "";
        save[30] = "";
    }

    public void setRes(){
        salavatCounter.setText(textCount[currentPage]);
    }



    Runnable r = new Runnable() {
        public void run(){
            if(currentPage < 0) currentPage = 0;
            if(currentPage > 30) currentPage = 30;
            arabic.setText(textsArabic[currentPage]);
            page.setText(textPage[currentPage]);
            handler.postDelayed(r,100);
        }
    };

    @Override
    public void onClick(View view) {
        Intent back = new Intent(getActivity(), MainActivity.class);
        startActivity(back);
    }
}