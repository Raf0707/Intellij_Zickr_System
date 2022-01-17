package com.example.alhamdulillah;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.*;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import java.util.*;


public class AllahNamesFragment extends Fragment {
    private TextView nameAllah;
    private TextView nameRahman;
    private TextView nameRahim;
    private TextView nameMalick;
    private TextView nameKuddus;
    private TextView nameSalam;
    private TextView nameMu_Min;
    private TextView nameMuhaymin;
    private TextView nameAziz;
    private TextView nameDjabbar;
    private TextView nameMutacabbir;
    private TextView nameHalick;
    private TextView nameBary;
    private TextView nameMusawwir;
    private TextView nameGaffar;
    private TextView nameKahhar;
    private TextView nameWahhab;
    private TextView nameRazzak;
    private TextView nameFattah;
    private TextView nameAlim;
    private TextView nameKabid;
    private TextView nameBasit;
    private TextView nameHafid;
    private TextView nameRafy_;
    private TextView nameMu_izz;
    private TextView nameMuzill;
    private TextView nameSamy_;
    private TextView nameBasir;
    private TextView nameHakam;
    private TextView nameAdl;
    private TextView nameLatif;
    private TextView nameHabir;
    private TextView nameHalim;
    private TextView nameAzim;
    private TextView nameGafur;
    private TextView nameShakur;
    private TextView nameAli;
    private TextView nameKabir;
    private TextView nameHafith;
    private TextView nameMukit;
    private TextView nameHacib;
    private TextView nameDjalil;
    private TextView nameKarim;
    private TextView nameRakib;
    private TextView nameMujib;
    private TextView nameWasy_;
    private TextView nameHakim;
    private TextView nameWadud;
    private TextView nameMajid;
    private TextView nameBa_ith;
    private TextView nameShahid;
    private TextView nameHackk;
    private TextView nameWakil;
    private TextView nameKawy;
    private TextView nameMatin;
    private TextView nameWaly;
    private TextView nameHamid;
    private TextView nameMuhsy;
    private TextView nameMubdy;
    private TextView nameMu_id;
    private TextView nameMuhyi;
    private TextView nameMumit;
    private TextView nameHayyi;
    private TextView nameKayyum;
    private TextView nameWajid;
    private TextView nameMaajid;
    private TextView nameWahid;
    private TextView nameSamad;
    private TextView nameKadir;
    private TextView nameMuctadir;
    private TextView nameMuctaddim;
    private TextView nameMu_ahhir;
    private TextView nameAwwal;
    private TextView nameAhir;
    private TextView nameZahir;
    private TextView nameBatin;
    private TextView nameWaaly;
    private TextView nameMuta_aly;
    private TextView nameBarr;
    private TextView nameTawwab;
    private TextView nameMuntakim;
    private TextView nameAfuwwu;
    private TextView nameRa_uf;
    private TextView nameMalic_Al_Mulk;
    private TextView nameZul_Djalally_Wal_Icram;
    private TextView nameMuksitu;
    private TextView nameJami_;
    private TextView nameGany;
    private TextView nameMugni;
    private TextView nameMany_;
    private TextView nameDarr;
    private TextView nameNafy_;
    private TextView nameNur;
    private TextView nameHady;
    private TextView nameBady_u;
    private TextView nameBaky;
    private TextView nameWarith;
    private TextView nameRashid;
    private TextView nameSabur;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_salavat, null);
        ScrollView scrollView = new ScrollView(requireView().getContext());
        nameAllah = view.findViewById(R.id.nameAllah);
        nameRahman = view.findViewById(R.id.nameRahim);
        nameRahim = view.findViewById(R.id.nameRahim);
        nameMalick = view.findViewById(R.id.nameMalic);
        nameKuddus = view.findViewById(R.id.nameKuddus);
        nameSalam = view.findViewById(R.id.nameSalam);
        nameMu_Min = view.findViewById(R.id.nameMumin);
        nameMuhaymin = view.findViewById(R.id.nameMuhaymin);
        nameAziz = view.findViewById(R.id.nameAziz);
        nameDjabbar = view.findViewById(R.id.nameDjabbar);
        nameMutacabbir = view.findViewById(R.id.nameMutacabbir);



        nameAllah.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        nameRahman.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        nameRahim.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        nameMalick.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        nameKuddus.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        nameSalam.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        nameMu_Min.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        nameMuhaymin.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        nameAziz.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        nameDjabbar.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        nameMutacabbir.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        scrollView.addView(nameAllah);
        scrollView.addView(nameRahman);
        scrollView.addView(nameRahim);
        scrollView.addView(nameMalick);
        scrollView.addView(nameKuddus);
        scrollView.addView(nameSalam);
        scrollView.addView(nameMu_Min);
        scrollView.addView(nameMuhaymin);
        scrollView.addView(nameAziz);
        scrollView.addView(nameDjabbar);
        scrollView.addView(nameMutacabbir);


        return inflater.inflate(R.layout.fragment_allah_names, container, false);

    }
}