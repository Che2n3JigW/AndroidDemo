package com.example.basedemo.components4.notification;

import android.app.Application;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.lifecycle.AndroidViewModel;

import com.example.basedemo.MainActivity;
import com.example.basedemo.R;

public class NotificationViewModel extends AndroidViewModel {

    private static final String CHANNEL_ID = "1";
    private Application application;

    public NotificationViewModel(Application application) {
        super(application);
        this.application = application;
    }

    public void startNotification() {
//        NotificationCompat.Builder builder = defaultNotification();

        Intent fullScreenIntent = new Intent(application, MainActivity.class);
        PendingIntent fullScreenPendingIntent
                = PendingIntent.getActivity(application, 0,
                fullScreenIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        createNotificationChannel();

        NotificationCompat.Builder notificationBuilder =
                new NotificationCompat.Builder(application, CHANNEL_ID)
                        .setSmallIcon(R.drawable.ic_launcher_background)
                        .setContentTitle("Incoming call")
                        .setContentText("(919) 555-1234")
                        .setPriority(NotificationManager.IMPORTANCE_HIGH)
                        .setCategory(NotificationCompat.CATEGORY_CALL)
                        .setFullScreenIntent(fullScreenPendingIntent, true);

        Notification notification = notificationBuilder.build();


        NotificationManagerCompat notificationManager
                = NotificationManagerCompat.from(application);
        notificationManager.notify(0, notification);

    }

    private NotificationCompat.Builder defaultNotification() {
        return new NotificationCompat.Builder(application, "CHANNEL_ID")
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle("My notification")
                .setContentText("Much longer text that cannot fit one line...")
                .setStyle(new NotificationCompat.BigTextStyle()
                        .bigText("Much longer text that cannot fit one line..."))
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = application.getString(R.string.channel_name);
            int importance = NotificationManager.IMPORTANCE_HIGH;

            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);

            NotificationManager notificationManager = application
                    .getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }



}
