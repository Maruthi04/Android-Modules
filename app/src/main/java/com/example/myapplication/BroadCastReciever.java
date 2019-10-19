package com.example.myapplication;

import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BroadCastReciever extends AppCompatActivity
implements SmsListener{


            MyOTPReciever broadcastReceiver;
            public static final String OTP_REGEX = "[0-9]{1,6}";

            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
setContentView(R.layout.activity_broad_cast_reciever);
                broadcastReceiver = new MyOTPReciever();
            }

   /*
   Below code is to get MainActivity instance in
   MyOTPReceiver to invoke the interface method
    */
            private static BroadCastReciever instance;
            @Override
            protected void onStart() { // onStart() of your activity
                super.onStart();
                instance = this;

       /*This is required to register broadcast
       instead of adding the action in manifest file
        */


                IntentFilter intentFilter=new IntentFilter
                        ("android.provider.Telephony.SMS_RECEIVED");
                registerReceiver(broadcastReceiver,intentFilter);
            }
            public static BroadCastReciever getInstance(){
                return instance;
            }
            @Override
            protected void onStop() {
                super.onStop();
                unregisterReceiver(broadcastReceiver);
            }

            @Override
            public void messageReceived(String messageText) {

                //From the received text string you
                // may do string operations to get the required OTP
                //It depends on your SMS format

                // If your OTP is six digits number
                // you may use the below code

                Pattern pattern = Pattern.compile(OTP_REGEX);
                Matcher matcher = pattern.matcher(messageText);
                String otp = "XXXXX";
                while (matcher.find())
                {
                    otp = matcher.group();
                }

                Toast.makeText(BroadCastReciever.this,"OTP: "+ otp ,
                        Toast.LENGTH_LONG).show();


            }

}
