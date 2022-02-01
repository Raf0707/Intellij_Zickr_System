package com.example.alhamdulillah;

import static java.lang.String.format;

import android.content.*;
import android.view.*;
import android.widget.*;

import androidx.annotation.*;
import androidx.recyclerview.widget.*;

import com.github.barteksc.pdfviewer.*;

import java.util.*;

public class KoranAdapter extends RecyclerView.Adapter<KoranAdapter.ViewHolder> {
    private PDFView viewKoran;
    private LayoutInflater inflater;
    private List<KoranItemContent> sures;

    public KoranAdapter(Context context, List<KoranItemContent> sures, PDFView viewKoran) {
        this.viewKoran = viewKoran;
        this.sures = sures;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public KoranAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.listitem_koran, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final KoranAdapter.ViewHolder holder, int position) {
        KoranItemContent sure = sures.get(position);
        holder.nameView.setText(format("%s %d", sure.getTitle(), sure.getPageNumber()));

        holder.nameView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                viewKoran.jumpTo(sure.getPageNumber(), true);
            }
        });
    }

    @Override
    public int getItemCount() {
        return sures.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView nameView;
        ViewHolder(View view){
            super(view);
            nameView = view.findViewById(R.id.itemKoran);
        }
    }




}