package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.Telephony;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class MySmsReciever extends BroadCastReciever {


    public void onReceive
            (Context context, Intent intent) {
        Bundle bundle  = intent.getExtras();
        SmsMessage smsMessage;

        if (Build.VERSION.SDK_INT >= 19) { //KITKAT
            SmsMessage[] msgs =
                    Telephony.Sms.Intents.getMessagesFromIntent(intent);
            smsMessage = msgs[0];
        }
        else {
            Object pdus[] =
                    (Object[]) bundle.get("pdus");
            smsMessage = SmsMessage.createFromPdu((byte[]) pdus[0]);
        }
        String messageBody =
                smsMessage.getMessageBody();
        Toast.makeText
                (context,
                        "Msg from BroadcastReceiver - " +messageBody,Toast.LENGTH_LONG).show();

    }

}
