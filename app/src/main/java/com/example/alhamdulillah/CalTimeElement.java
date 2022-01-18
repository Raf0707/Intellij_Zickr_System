package com.example.alhamdulillah;

import android.content.*;
import android.content.res.*;
import android.graphics.*;
import android.util.*;
import android.view.*;
import android.widget.*;

import androidx.core.content.*;


public class CalTimeElement {
    private long secPerHours;
    private String time;
    private String timerTitle;
    private TableLayout tl;
    private Context ctx;

    public TextView tv;
    public TextView tv2;
    public CheckBox cb;

    public CalTimeElement(Context ctx,TableLayout tl,String timerTitle, String time) {
        this.ctx = ctx;
        this.tl = tl;
        this.timerTitle = timerTitle;
        this.time = time;

        int vpx = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,0,ctx.getResources().getDisplayMetrics());
        TableRow tr = new TableRow(ctx);
        //tr.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,TableLayout.LayoutParams.WRAP_CONTENT));

        tv = new TextView(ctx);
        //tv.setLayoutParams(new TableLayout.LayoutParams(vpx,vpx,3f));
        tv.setTextColor(ctx.getResources().getColor(R.color.purple_300));
        tv.setTypeface(tv.getTypeface(), Typeface.BOLD);
        tv.setTextSize(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 9, ctx.getResources().getDisplayMetrics()));
        tv.setText(this.getTimerTitle());

        secPerHours = secPerHours(this.getTime());

        long seconds = secPerHours(this.getTime());
        String resl = timeToString(seconds);


        tv2 = new TextView(ctx);
        tv2.setTextColor(ctx.getResources().getColor(R.color.purple_300));
        tv2.setTypeface(tv2.getTypeface(), Typeface.BOLD);
        tv2.setTextSize(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 9, ctx.getResources().getDisplayMetrics()));
        tv2.setText(this.getTime());
        int a = (int) this.hoursToMinutes(this.getTime());

        cb = new CheckBox(ctx);
        //cb.setLayoutParams(new TableLayout.LayoutParams(vpx,vpx,1f));
        cb.setButtonTintList(ColorStateList.valueOf(Color.parseColor("#12705A")));
        cb.setChecked(false);

        tr.addView(tv);
        tr.addView(cb);
        tr.addView(tv2);

        tl.addView(tr);
        //Log.d("TBLOG",String.valueOf(tv.getTextAlignment()));
    }

    public long hoursToMinutes(String text){
        String[] hoursInMinutes = text.split(":");
        Double hInM = Double.valueOf(hoursInMinutes[0]) * 60;
        Double hmresult = Double.valueOf(hInM + Integer.valueOf(hoursInMinutes[1]));
        long a = Math.round(hmresult);
        return a;
    }

    public long secPerHours(String text){
        String[] secPerHours = text.split(":");
        Double sPerH = Double.valueOf(secPerHours[0]) * 60 * 60;
        Double shResult = Double.valueOf(sPerH + Integer.valueOf(secPerHours[1]));
        long a = Math.round(shResult);
        return a;
    }

    public TextView getTv()
    {
        return tv;
    }


    public TextView getTv2()
    {
        return tv2;
    }


    public CheckBox getCb()
    {
        return cb;
    }

    public void setTime(String time)
    {
        this.time = time;
    }

    public String getTime()
    {
        return time;
    }

    public void setTimerTitle(String timerTitle)
    {
        this.timerTitle = timerTitle;
    }

    public String getTimerTitle()
    {
        return timerTitle;
    }

    private String timeToString(long secs) {
        long hour = secs / 3600,
                min = secs / 60 % 60,
                sec = secs / 1 % 60;
        return String.format("%02d:%02d:%02d", hour, min, sec);
    }

    @Override
    public String toString()
    {
        return timerTitle + " " + time;
    }

}