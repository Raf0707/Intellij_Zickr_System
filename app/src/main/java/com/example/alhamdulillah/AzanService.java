package com.example.alhamdulillah;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import androidx.core.app.NotificationCompat;
import android.app.Notification;
import androidx.core.app.NotificationManagerCompat;
import android.os.Build;
import android.app.NotificationManager;
import android.app.NotificationChannel;

public class AzanService extends Service {

    @Override
    public IBinder onBind(Intent intent) {

        throw new UnsupportedOperationException("Not yet implemented");
    }
    @Override
    public void onCreate(){

        createNotificationChannel();
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId){

        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this,"mychid")
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle("Title")
                        .setContentText("Notification text");

        Notification notification = builder.build();

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        //notificationManager.notify(1,notification);
        startForeground(1,notification);

        return START_STICKY;
    }

    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "mych";
            String description = "mych description";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("mychid", name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);

        }
    }

    @Override
    public void onDestroy() {

    }
}
