package com.example.mynotifier;

import android.app.Notification;
import android.content.Intent;
import android.os.Bundle;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.util.Log;



import androidx.core.app.NotificationCompat;

public class NotificationListener extends NotificationListenerService  {
    private static final String TAG = "NotificationListener";
    private static final String WA_PACKAGE = "com.whatsapp";

    @Override
    public void onListenerConnected() {

        Log.i(TAG, "Notification Listener connected Frango");
        initMqttClient();
    }

    @Override
    public void onNotificationPosted(StatusBarNotification sbn) {
        if (!sbn.getPackageName().equals(WA_PACKAGE)) return;

        Notification notification = sbn.getNotification();
        Bundle bundle = notification.extras;

        String from = bundle.getString(NotificationCompat.EXTRA_TITLE);
        String message = bundle.getString(NotificationCompat.EXTRA_TEXT);

        Log.i(TAG, "From: " + from);
        Log.i(TAG, "Message: " + message);

        Intent msgInfo = new Intent("Msg");
        msgInfo.putExtra("package", from);
        msgInfo.putExtra("nTicker", message);

    }

    @Override

    public void onNotificationRemoved(StatusBarNotification sbn) {
        Log.i("Msg","Notification Removed");

    }

    public void initMqttClient(){


    }
}