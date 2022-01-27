package com.example.alhamdulillah;

import android.os.Bundle;

import androidx.constraintlayout.widget.*;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.*;

import android.util.*;
import android.view.*;
import android.widget.*;

import java.lang.ref.*;
import java.util.*;


public class AllahNamesFragment extends Fragment {

    public static MainActivity context = MainActivity.ctx.get();

    private String[] namesAllaha = new String[] {
            "للهُﷻ ",
            "الرَّحْمَانُﷻ ",
            "الرَّحِيمُﷻ ",
            "المَلِكُﷻ ",
            "القُدُّوسُﷻ ",
            "السَّلَامُﷻ ",
            "المُؤمِنُﷻ ",
            "المُهَيْمِنُﷻ ",
            "العَزِيزُﷻ ",
            "الجَبَّارُﷻ ",
            "المُتَكَبِّرُﷻ ",
            "الخَالِقُﷻ ",
            "البَارِئُﷻ ",
            "المُصَوِّرُﷻ ",
            "الغَفَّارُﷻ ",
            "القَهَّارُﷻ ",
            "الوَهَّابُﷻ ",
            "الرَّزَّاقُﷻ ",
            "الفَتَّاحُﷻ ",
            "العَلِيمُﷻ ",
            "القَابِضُﷻ ",
            "البَاسِطُﷻ ",
            "الخَافِضُﷻ ",
            "الرَّافِعُﷻ ",
            "المُعِزُّﷻ ",
            "المُذِلُّﷻ ",
            "السَّمِيعُﷻ ",
            "البَصِيرُﷻ " ,
            "الحَكَمُﷻُ ",
            "العَدْلُﷻُ ",
            "اللَّطِيفُﷻُ ",
            "الخَبِيرُﷻ ",
            "الحَلِيمُﷻ ",
            "العَظِيمُﷻ ",
            "الغَفُورُﷻ ",
            "الشَّكُورُﷻ ",
            "العَلِيُّﷻ ",
            "الكَبِيرُﷻ ",
            "الحَفِيظُﷻ ",
            "المُقِيتُﷻ ",
            "الحَسِيبُﷻ ",
            "الجَلِيلُﷻ ",
            "الكَرِيمُﷻ ",
            "الرَّقِيبُﷻ ",
            "المُجِيبُﷻ ",
            "الوَاسِعُﷻ ",
            "الحَكِيمُﷻ ",
            "الوَدُودُﷻ ",
            "المَجِيدُﷻ ",
            "البَاعِثُﷻ ",
            "الشَّهِيدُﷻ ",
            "الحَقُّﷻ ",
            "الوَكِيلُﷻ ",
            "القَوِيُّﷻ ",
            "المَتِينُﷻ ",
            "الوَلِيُّﷻ ",
            "الحَمِيدُﷻ ",
            "المُحْصِيﷻ ",
            "المُبْدِئُﷻ ",
            "المُعِيدُﷻ ",
            "المُحْيِيﷻ ",
            "المُمِيتُﷻ ",
            "الحَيُّﷻ ",
            "القَيُّومُﷻ ",
            "الوَاجِدُﷻ ",
            "المَاجِدُﷻ ",
            "الوَاحِدُﷻ ",
            "الصَّمَدُﷻ ",
            "القَادِرُﷻ ",
            "المُقْتَدِرُﷻ ",
            "المُقَدِّمُﷻ ",
            "المُؤَخِّرُﷻ ",
            "الأَوَّلُﷻ ",
            "الآخِرُﷻ ",
            "الظَّاهِرُﷻ ",
            "البَاطِنُﷻ ",
            "الوَالِيﷻ ",
            "المُتَعَالِيﷻ ",
            "البَرُّﷻ ",
            "التَّوَّابُﷻ ",
            "المُنْتَقِمُﷻ ",
            "العَفُوُّﷻ ",
            "الرَّءُؤفُﷻ ",
            "مَالِكُ المُلْكِﷻ ",
            "ذُو الجَلَالِ وَ الإِكْرَامِﷻ ",
            "المُقْسِطُﷻ ",
            "الجَامِعُﷻ ",
            "الغَنِيُّﷻ ",
            "المُغْنِيﷻ ",
            "المَانِعُﷻ ",
            "الضَّارُّﷻ ",
            "النَّافِعُﷻ ",
            "النُّورُﷻ ",
            "الهَادِيﷻ ",
            "البَدِيعُﷻ ",
            "البَاقِيﷻ ",
            "الوَارِثﷻ ",
            "الرَّشِيدُﷻ ",
            "الصَّبُورُﷻ "};

    public static WeakReference<AllahNamesFragment> ctx = null;
    private List<Name> names = new ArrayList<>();
    private NamesAdapter namesAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_allah_names, null);

        ctx = new WeakReference<>(this);

        init();

        for (int x = 0; x < namesAllaha.length; x++) {
            Log.d("LOGG",namesAllaha[x] + "\n" + names.toString());
        }

        namesAdapter = new NamesAdapter(view.getContext(), names);
        RecyclerView nameView = view.findViewById(R.id.list);
        nameView.setAdapter(namesAdapter);
        nameView.setHasFixedSize(false);

        return view;

    }

    public void init(){
        for(String n : namesAllaha){
            names.add(new Name(n));
        }
    }



}


