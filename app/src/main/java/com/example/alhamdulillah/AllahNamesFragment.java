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

    private String[] namesAllaha = new String[]{
            "للهُ ",
            "الرَّحْمَانُ ",
            "الرَّحِيمُ ",
            "المَلِكُ ",
            "القُدُّوسُ ",
            "السَّلَامُ ",
            "المُؤمِن ",
            "المُهَيْمِنُ ",
            "العَزِيزُ ",
            "الجَبَّارُ ",
            "المُتَكَبِّرُ ",
            "الخَالِقُ ",
            "البَارِئُ ",
            "المُصَوِّرُ ",
            "الغَفَّارُ ",
            "القَهَّارُ ",
            "الوَهَّابُ ",
            "الرَّزَّاقُ ",
            "الفَتَّاحُ ",
            "العَلِيمُ ",
            "القَابِضُ ",
            "البَاسِطُ ",
            "الخَافِضُ ",
            "الرَّافِعُ ",
            "المُعِزُّ ",
            "المُذِلُّ ",
            "السَّمِيعُ ",
            "البَصِيرُ ",
            "ُالحَكَم ",
            "العَدْلُ ",
            "اللَّطِيفُ ",
            "الخَبِيرُ ",
            "الحَلِيمُ ",
            "العَظِيمُ ",
            "الغَفُورُ ",
            "الشَّكُورُ ",
            "العَلِيُّ ",
            "الكَبِيرُ ",
            "الحَفِيظُ ",
            "المُقِيتُ ",
            "الحَسِيبُ ",
            "الجَلِيلُ ",
            "الكَرِيمُ ",
            "الرَّقِيبُ ",
            "المُجِيبُ ",
            "الوَاسِعُ ",
            "الحَكِيمُ ",
            "الوَدُودُ ",
            "المَجِيدُ ",
            "البَاعِثُ ",
            "الشَّهِيدُ ",
            "الحَقُّ ",
            "الوَكِيلُ ",
            "القَوِيُّ ",
            "المَتِينُ ",
            "الوَلِيُّ ",
            "الحَمِيدُ ",
            "المُحْصِي ",
            "المُبْدِئُ ",
            "المُعِيدُ ",
            "المُحِييُ ",
            "المُمِيتُ ",
            "الحَيُّ ",
            "القَيُّومُ ",
            "الوَاجِدُ ",
            "المَاجِدُ ",
            "الوَاحِدُ ",
            "الصَّمَدُ ",
            "القَادِرُ ",
            "المُقْتَدِرُ ",
            "المُقَدِّمُ ",
            "المُؤَخِّرُ ",
            "الأَوَّلُ ",
            "الآخِرُ ",
            "الظَّاهِرُ ",
            "البَاطِنُ ",
            "الوَالِي ",
            "المُتَعَالِي ",
            "البَرُّ ",
            "التَّوَّابُ ",
            "المُنْتَقِمُ ",
            "العَفْوُّ ",
            "الرَّءُؤفُ ",
            "مَالِكُ المُلْكِ ",
            "ذُو الجَلَالِ وَ الإِكْرَامِ ",
            "المُقْسِطُ ",
            "الجَامِعُ ",
            "الغَنِيُّ ",
            "المُغْنِي ",
            "المَانِعُ ",
            "الضَّارُّ ",
            "النَّافِعُ ",
            "النُّورُ ",
            "الهَادِي ",
            "البَدِيعُ ",
            "البَاقِي ",
            "الوَارِث ",
            "الرَّشِيدُ ",
            "الصَّبُورُ "};

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


