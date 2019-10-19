package com.example.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


public class showfragment extends Fragment {
    SQLiteDatabase db;
    TextView name11,accno,accb;
    Cursor c2;
    String myInt;


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_showfragment, container, false);
        db = getActivity().openOrCreateDatabase("Bank", Context.MODE_PRIVATE, null);
        name11=view.findViewById(R.id.nameb3);
        accno=view.findViewById(R.id.accountnumber);
        accb=view.findViewById(R.id.accountbalance);
        Bundle b = getActivity().getIntent().getExtras();
        String n = b.getString("name");
        Cursor c2=db.rawQuery("select * from customers where username='"+n+"'",null);
while(c2.moveToNext())
{
    name11.setText("you'r usernamec is "+c2.getString(0));
    accno.setText("you'r account number is "+c2.getString(1));
    accb.setText("you'r account balance is "+c2.getString(4));



}
        Toast.makeText(getActivity()," in fragment"+n,Toast.LENGTH_LONG).show();

       // name11.setText("hi");

        return view;
    }
}
