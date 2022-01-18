package com.example.alhamdulillah;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.*;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import java.lang.ref.*;
import java.util.*;


public class AllahNamesFragment extends Fragment {
    private String[] names;
    public static WeakReference<AllahNamesFragment> ctx = null;
    public static ArrayList<Name> namess;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_allah_names, null);
        ctx = new WeakReference<>(this);
        namess = new ArrayList<Name>();
        NamesAdapter namesAdapter = new NamesAdapter(view.getContext(), namess);
        RecyclerView nameView = view.findViewById(R.id.namesAllah);
        nameView.setAdapter(namesAdapter);
        nameView.setHasFixedSize(false);

        names = new String[] {
                "للهﷻُ",
                "الرَّحْمَانُﷻ",
                "الرَّحِيمُﷻ",
                "المَلِكُﷻ",
                "القُدُّوسﷻُ",
                "السَّلَامُﷻ",
                "المُؤمِنﷻ",
                "المُهَيْمِنﷻُ",
                "العَزِيزﷻُ",
                "الجَبَّارُﷻ",
                "المُتَكَبِّرﷻُ" ,
                "الخَالِقُﷻ" ,
                "البَارِئُ" ,
                "المُصَوِّرُ" ,
                "الغَفَّارُ" ,
                "القَهَّارُ" ,
                "الوَهَّابُ" ,
                "الرَّزَّاقُ" ,
                "الفَتَّاحُ" ,
                "العَلِيمُ" ,
                "القَابِضُ" ,
                "البَاسِطُ" ,
                "الخَافِضُ" ,
                "الرَّافِعُ" ,
                "المُعِزُّ" ,
                "المُذِلُّ" ,
                "السَّمِيعُ" ,
                "البَصِيرُ" ,
                "ُالحَكَم" ,
                "العَدْلُ" ,
                "اللَّطِيفُ" ,
                "الخَبِيرُ" ,
                "الحَلِيمُ" ,
                "العَظِيمُ" ,
                "الغَفُورُ" ,
                "الشَّكُورُ" ,
                "العَلِيُّ" ,
                "الكَبِيرُ" ,
                "الحَفِيظُ" ,
                "المُقِيتُ" ,
                "الحَسِيبُ" ,
                "الجَلِيلُ" ,
                "الكَرِيمُ" ,
                "الرَّقِيبُ" ,
                "المُجِيبُ" ,
                "الوَاسِعُ" ,
                "الحَكِيمُ" ,
                "الوَدُودُ" ,
                "المَجِيدُ" ,
                "البَاعِثُ" ,
                "الشَّهِيدُ" ,
                "الحَقُّ" ,
                "الوَكِيلُ" ,
                "القَوِيُّ" ,
                "المَتِينُ" ,
                "الوَلِيُّ" ,
                "الحَمِيدُ" ,
                "المُحْصِي" ,
                "المُبْدِئُ" ,
                "المُعِيدُ" ,
                "المُحِييُ" ,
                "المُمِيتُ" ,
                "الحَيُّ" ,
                "القَيُّومُ" ,
                "الوَاجِدُ" ,
                "المَاجِدُ" ,
                "الوَاحِدُ" ,
                "الصَّمَدُ" ,
                "القَادِرُ" ,
                "المُقْتَدِرُ" ,
                "المُقَدِّمُ" ,
                "المُؤَخِّرُ" ,
                "الأَوَّلُ" ,
                "الآخِرُ" ,
                "الظَّاهِرُ" ,
                "البَاطِنُ" ,
                "الوَالِي" ,
                "المُتَعَالِي",
                "البَرُّ" ,
                "التَّوَّابُ",
                "المُنْتَقِمُ",
                "العَفْوُّ" ,
                "الرَّءُؤفُ" ,
                "مَالِكُ المُلْكِ" ,
                "ذُو الجَلَالِ وَ الإِكْرَامِ",
                "المُقْسِطُ" ,
                "الجَامِعُ" ,
                "الغَنِيُّ" ,
                "المُغْنِي" ,
                "المَانِعُ" ,
                "الضَّارُّ" ,
                "النَّافِعُ" ,
                "النُّورُ" ,
                "الهَادِي" ,
                "البَدِيعُ" ,
                "البَاقِي" ,
                "الوَارِث" ,
                "الرَّشِيدُ" ,
                "الصَّبُورُ" };

        init();

        return inflater.inflate(R.layout.fragment_allah_names, container, false);

    }

    public void init() {
        for (int i = 0; i < names.length; ++i) {
            namess.add(new Name(names[i]));
        }
    }

}