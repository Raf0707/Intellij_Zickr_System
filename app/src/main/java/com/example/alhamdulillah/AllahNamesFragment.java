package com.example.alhamdulillah;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.*;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
                "البَارِئُﷻ" ,
                "المُصَوِّرُﷻ" ,
                "الغَفَّارُﷻ" ,
                "القَهَّارُﷻ" ,
                "الوَهَّابُﷻ" ,
                "الرَّزَّاقُﷻ" ,
                "الفَتَّاحُﷻ" ,
                "العَلِيمُﷻ" ,
                "القَابِضُﷻ" ,
                "البَاسِطُﷻ" ,
                "الخَافِضُﷻ" ,
                "الرَّافِعُﷻ" ,
                "المُعِزُّﷻ" ,
                "المُذِلُّﷻ" ,
                "السَّمِيعُﷻ" ,
                "البَصِيرُﷻ" ,
                "ُالحَكَمﷻ" ,
                "العَدْلُﷻ" ,
                "اللَّطِيفُﷻ" ,
                "الخَبِيرُﷻ" ,
                "الحَلِيمُﷻ" ,
                "العَظِيمُﷻ" ,
                "الغَفُورُﷻ" ,
                "الشَّكُورُﷻ" ,
                "العَلِيُّﷻ" ,
                "الكَبِيرُﷻ" ,
                "الحَفِيظُﷻ" ,
                "المُقِيتُﷻ" ,
                "الحَسِيبُﷻ" ,
                "الجَلِيلُﷻ" ,
                "الكَرِيمُﷻ" ,
                "الرَّقِيبُﷻ" ,
                "المُجِيبُﷻ" ,
                "الوَاسِعُﷻ" ,
                "الحَكِيمُﷻ" ,
                "الوَدُودُﷻ" ,
                "المَجِيدُﷻ" ,
                "البَاعِثُﷻ" ,
                "الشَّهِيدُﷻ" ,
                "الحَقُّﷻ" ,
                "الوَكِيلُﷻ" ,
                "القَوِيُّﷻ" ,
                "المَتِينُﷻ" ,
                "الوَلِيُّﷻ" ,
                "الحَمِيدُﷻ" ,
                "المُحْصِيﷻ" ,
                "المُبْدِئُﷻ" ,
                "المُعِيدُﷻ" ,
                "المُحِييُﷻ" ,
                "المُمِيتُﷻ" ,
                "الحَيُّﷻ" ,
                "القَيُّومُﷻ" ,
                "الوَاجِدُﷻ" ,
                "المَاجِدُﷻ" ,
                "الوَاحِدُﷻ" ,
                "الصَّمَدُﷻ" ,
                "القَادِرُﷻ" ,
                "المُقْتَدِرُﷻ" ,
                "المُقَدِّمُﷻ" ,
                "المُؤَخِّرُﷻ" ,
                "الأَوَّلُﷻ" ,
                "الآخِرُﷻ" ,
                "الظَّاهِرُﷻ" ,
                "البَاطِنُﷻ" ,
                "الوَالِيﷻ" ,
                "المُتَعَالِيﷻ",
                "البَرُّﷻ" ,
                "التَّوَّابُﷻ",
                "المُنْتَقِمُﷻ",
                "العَفْوُّﷻ" ,
                "الرَّءُؤفُﷻ" ,
                "مَالِكُ المُلْكِﷻ" ,
                "ذُو الجَلَالِ وَ الإِكْرَامِﷻ",
                "المُقْسِطُﷻ" ,
                "الجَامِعُﷻ" ,
                "الغَنِيُّﷻ" ,
                "المُغْنِيﷻ" ,
                "المَانِعُﷻ" ,
                "الضَّارُّﷻ" ,
                "النَّافِعُﷻ" ,
                "النُّورُﷻ" ,
                "الهَادِيﷻ" ,
                "البَدِيعُﷻ" ,
                "البَاقِيﷻ" ,
                "الوَارِثﷻ" ,
                "الرَّشِيدُﷻ" ,
                "الصَّبُورُﷻ" };


        init(names);


        NamesAdapter namesAdapter = new NamesAdapter(view.getContext(), namess);
        RecyclerView nameView = view.findViewById(R.id.namesAllah);
        nameView.setAdapter(namesAdapter);
        nameView.setHasFixedSize(false);

        return inflater.inflate(R.layout.fragment_allah_names, container, false);

    }

    public void init(String[] names) {
        for (int i = 0; i < this.names.length; ++i) {
            namess.add(new Name(this.names[i]));
        }
    }

}