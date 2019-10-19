package com.example.myapplication;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.telephony.SmsManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class withdraw extends Fragment {
   TextView tv;
   SQLiteDatabase db;
   EditText withdrawamount;
   Button with;
   int number1;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_newtempfragment, container, false);
       Bundle b1=getActivity().getIntent().getExtras();
       String username=b1.getString("name");
       withdrawamount=view.findViewById(R.id.amount);
       with=view.findViewById(R.id.withdraww);
       with.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               db=getActivity().openOrCreateDatabase("Bank",Context.MODE_PRIVATE,null);
               Bundle b1=getActivity().getIntent().getExtras();
               String username=b1.getString("name");
               int number=Integer.parseInt(withdrawamount.getText().toString());
               Cursor c1=db.rawQuery("select * from customers where username='"+username+"'",null);
               while(c1.moveToNext())
               {
                    number1=Integer.parseInt(c1.getString(4));
               }
               number1=number1-number;
               Toast.makeText(getContext(),"updated balance "+String.valueOf(number1),Toast.LENGTH_LONG).show();
               db.execSQL("update customers set balance='"+String.valueOf(number1)+"' where username='"+username+"'");
               Toast.makeText(getContext(),"Records updated",Toast.LENGTH_LONG).show();


               Intent intent=new Intent
                       (getActivity().getApplicationContext(),
                               getActivity().getClass());
               PendingIntent pi=PendingIntent.getActivity
                       (getActivity().getApplicationContext(),
                               0, intent,0);

               SmsManager sms = SmsManager.getDefault();

               sms.sendTextMessage("9290573453", null, "You have withdrawed "+String.valueOf(number), pi, null);


               Toast.makeText(getActivity().getApplicationContext(), "Message Sent successfully!",
                       Toast.LENGTH_LONG).show();

           }
       });
        Toast.makeText(getContext(),"hii "+username,Toast.LENGTH_LONG).show();
        return view;
    }

}
