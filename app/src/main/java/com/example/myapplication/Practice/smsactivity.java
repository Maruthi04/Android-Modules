package com.example.myapplication.Practice;

import android.Manifest;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.R;

public class smsactivity extends AppCompatActivity implements View.OnClickListener{

    EditText mobileno, message;
    Button sendsms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smsactivity);
        mobileno = (EditText) findViewById(R.id.phonenum);
        message = (EditText) findViewById(R.id.message);
        sendsms = (Button) findViewById(R.id.buttonsend);
        sendsms.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String no = mobileno.getText().toString();
        String msg = message.getText().toString();
        //Getting intent and PendingIntent instance
//        Intent intent = new Intent
//                (getApplicationContext(),
//                        datatransfer.class);
//        PendingIntent pi = PendingIntent.getActivity
//                (getApplicationContext(),
//                        0, intent, 0);
//Get the SmsManager instance and call the sendTextMessage method to send message
        SmsManager sms = SmsManager.getDefault();
//        sms.sendTextMessage(no, null, msg, pi, null);
 /*     if intent is commented, run the below
       code to send sms where the 4th
       parameter is null
  */
        sms.sendTextMessage(no, null, msg, null, null);

        Toast.makeText(getApplicationContext(), "Message Sent successfully!",
                Toast.LENGTH_LONG).show();

    }
}