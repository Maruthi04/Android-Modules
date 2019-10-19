package com.example.myapplication;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class notificationfinal extends AppCompatActivity {

    Button btnShow, btnClear;

    NotificationManager manager;

    Notification myNotification;


   /*
   A notification is a message that Android
   displays outside your app's UI to provide
    the user with reminders, communication
    from other people, or other timely information
    from your app.
    Users can tap the notification to open your
    app or take an action directly
    from the notification.

   A class that represents how a persistent
    notification is to be presented to the user
    using the NotificationManager.
    The Notification.Builder has been
    added to make it easier
    to construct Notifications.
    */

    int notifyID =1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notificationfinal);

        btnShow = findViewById(R.id.btshow);
        btnClear = findViewById(R.id.btclear);
        manager = (NotificationManager)
                getSystemService(NOTIFICATION_SERVICE);
        btnShow.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                if (Build.VERSION.SDK_INT >=
                        Build.VERSION_CODES.O) {

                    String channel_Id = "my_channel_01";
                    // The id of the channel.
                    CharSequence channelName =
                            "NotifChannel";
                    // The user-visible name of the channel.
                    int channelImportance =
                            NotificationManager.IMPORTANCE_HIGH;



                    // Create a notification and
                    // set the notification channel.
                    NotificationChannel channel =
                            new NotificationChannel
                                    (channel_Id,
                                            channelName,
                                            channelImportance);
                    manager.createNotificationChannel
                            (channel);

                    //Create the intent that’ll fire
                    // when the user taps the notification//
                    Intent intent = new Intent
                            (Intent.ACTION_VIEW,
                                    Uri.parse("https://www.google.com/"));
                    //PendingIntent.FLAG_UPDATE_CURRENT -
                    // Flag indicating that if the described
                    // PendingIntent already exists,
                    // then keep it but replace its extra data
                    // with what is in this new Intent.
                    PendingIntent pendingIntent =
                            PendingIntent.getActivity
                                    (notificationfinal.this, 1,
                                            intent, PendingIntent.FLAG_UPDATE_CURRENT);

                    Notification.Builder builder  =
                            new Notification.Builder
                                    (notificationfinal.this,channel_Id);
                    builder.setContentTitle("New Message");
//                    builder.setOngoing(false);
                    builder.setContentText("Browse the content");
                    builder.setSmallIcon(R.drawable.ic_launcher_background);
                    builder.setContentIntent(pendingIntent);
                    myNotification = builder.build();

                    manager.notify(notifyID, myNotification);

                   /*
                   This pair identifies this notification
                   from your app to the system,
                   so that pair should be unique within your app.
                    */
                }
                else{
                    Intent intent =
                            new Intent(Intent.ACTION_VIEW,
                                    Uri.parse("https://www.google.com/"));
                    //PendingIntent.FLAG_UPDATE_CURRENT -
                    // Flag indicating that if the described
                    // PendingIntent already exists,
                    // then keep it but replace its
                    // extra data with what is in this new Intent.
                    PendingIntent pendingIntent =
                            PendingIntent.getActivity
                                    (notificationfinal.this, 1,
                                            intent, PendingIntent.FLAG_UPDATE_CURRENT);

                    Notification.Builder builder =
                            new Notification.Builder
                                    (notificationfinal.this);
                    builder.setAutoCancel(true);
                    builder.setContentTitle("App Notification");
                    builder.setContentText("You have a new message");
                    builder.setSmallIcon(R.drawable.ic_launcher_background);
                    builder.setContentIntent(pendingIntent);
                    builder.setOngoing(true);
                    // builder.setSubText("This is subtext...");   //API level 16
                    // builder.setNumber(100);
                    myNotification= builder.build();
                    //  myNotication = builder.getNotification();
                    // myNotication.flags = Notification.FLAG_AUTO_CANCEL;
                    manager.notify(notifyID,myNotification);


                }
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                manager.cancel(notifyID);
            }
        });

    }

}
