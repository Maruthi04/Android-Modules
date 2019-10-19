package com.example.myapplication;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import java.io.IOException;

import static android.app.Activity.RESULT_OK;
import static android.content.Context.NOTIFICATION_SERVICE;


public class notificationfrag2 extends Fragment {
    View view;
    Button b1, b2;
    NotificationManager manager;

    Notification myNotification;
    int notifyID =2;
    ImageView iv;


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_notificationfrag2, container, false);
        b1 = view.findViewById(R.id.nb3);
        iv = view.findViewById(R.id.iv);
        b2 = view.findViewById(R.id.nb4);
        manager = (NotificationManager)
                getActivity().getSystemService(NOTIFICATION_SERVICE);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
                    Intent intent = new Intent();
                    intent.setType("image/*");
                    intent.setAction
                            (Intent.ACTION_GET_CONTENT);

                    //PendingIntent.FLAG_UPDATE_CURRENT -
                    // Flag indicating that if the described
                    // PendingIntent already exists,
                    // then keep it but replace its extra data
                    // with what is in this new Intent.
                    PendingIntent pendingIntent =
                            PendingIntent.getActivity
                                    (getActivity(), 1,
                                            intent, PendingIntent.FLAG_UPDATE_CURRENT);

                    Notification.Builder builder =
                            new Notification.Builder
                                    (getActivity(), channel_Id);
                    builder.setContentTitle("New Message");
                    //builder.setAutoCancel(true);
                    builder.setOngoing(true);
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
                } else {
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
                                    (getActivity(), 1,
                                            intent, PendingIntent.FLAG_UPDATE_CURRENT);

                    Notification.Builder builder =
                            new Notification.Builder
                                    (getActivity());
                    builder.setAutoCancel(true);
                    builder.setContentTitle("App Notification");
                    builder.setContentText("You have a new message");
                    builder.setSmallIcon(R.drawable.ic_launcher_background);
                    builder.setContentIntent(pendingIntent);
                    builder.setOngoing(true);
                    // builder.setSubText("This is subtext...");   //API level 16
                    // builder.setNumber(100);
                    myNotification = builder.build();
                    //  myNotication = builder.getNotification();
                    // myNotication.flags = Notification.FLAG_AUTO_CANCEL;
                    manager.notify(notifyID, myNotification);


                }

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
manager.cancel(notifyID);
            }
        });
        return view;
    }

    public void onActivityResult(int requestCode,
                                 int resultCode, Intent data) {
        super.onActivityResult
                (requestCode, resultCode, data);
        Log.d("hua","hiiiii");


        if (requestCode == 1
                && resultCode == RESULT_OK
                && data != null
                && data.getData() != null) {
            try {
                Log.d("hua","hioih");
                Bitmap bitmap = MediaStore.
                        Images.Media.
                        getBitmap(getActivity().getContentResolver(),
                                data.getData());
                //   Log.d(TAG, String.valueOf(bitmap));
                ImageView imageView = getActivity().findViewById(R.id.iv);
                imageView.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
