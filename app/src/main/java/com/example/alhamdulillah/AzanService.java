package com.example.alhamdulillah;

import android.app.*;
import android.content.Intent;
import android.os.IBinder;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import android.os.Build;

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
        notificationManager.notify(1,notification);

        Intent resultIntent = new Intent(this, SubhanActivity.class);
        PendingIntent resultPendingIntent = PendingIntent.getActivity(this, 0, resultIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);


        NotificationCompat.Builder builder1 =
                new NotificationCompat.Builder(this, "newMain")
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle("Main")
                        .setContentText("Main")
                        .setContentIntent(resultPendingIntent);

        Notification notification1 = builder1.build();

        NotificationManager notificationManager1 = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        NotificationManagerCompat notificationManager2 = NotificationManagerCompat.from(this);

        notificationManager2.notify(2, notification1);

        //startForeground(1,notification);

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
            NotificationChannel channel1 = new NotificationChannel("newMain", name, importance);
            channel.setDescription(description);
            channel1.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            NotificationManager notificationManager1 = getSystemService(NotificationManager.class);
            notificationManager1.createNotificationChannel(channel1);
            notificationManager.createNotificationChannel(channel);

        }
    }

    @Override
    public void onDestroy() {

    }
}
