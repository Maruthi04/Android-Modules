package com.example.myapplication;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class transfer extends Fragment {
SQLiteDatabase db;
EditText amount;
View view1;
String username;
    int recieverbalance;
    int number1;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Bundle b=getActivity().getIntent().getExtras();
         username=b.getString("name");
         view1=inflater.inflate(R.layout.fragment_transfer, container, false);
        ListView lv = view1.findViewById(R.id.lv);
        ContentResolver cr = getActivity().getContentResolver();
        Cursor c = cr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);
        List<Map<String, String>> list = new ArrayList<>();
        HashMap<String,String> map ;

        if (c.moveToFirst()) {
            do {
//                numbers.add(c.getString(c.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)));
//                contacts.add(c.getString((c.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME))));
                map = new HashMap<String, String>();
                map.put("numbers", c.getString(c.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)));
                map.put("contacts", c.getString((c.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME))));
                list.add(map);

            } while (c.moveToNext());
        }
        String [] from = {"contacts", "numbers"};
        int [] to = {android.R.id.text1,
                android.R.id.text2};

        SimpleAdapter ad = new SimpleAdapter(getActivity(), list,android.R.layout.simple_list_item_2, from,to);
        lv.setAdapter(ad);
        amount=view1.findViewById(R.id.sendamount);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView phonetv = view.findViewById(android.R.id.text1);
                String toadd=phonetv.getText().toString();
                db=getActivity().openOrCreateDatabase("Bank",Context.MODE_PRIVATE,null);
                Cursor c2=db.rawQuery("select * from customers where username='"+toadd+"'",null);
                String recievername;
                while(c2.moveToNext())
                {
                     recievername=c2.getString(0);
                     recieverbalance=Integer.parseInt(c2.getString(4));
                }

                Cursor c1=db.rawQuery("select * from customers where username='"+username+"'",null);
                int x=Integer.parseInt(amount.getText().toString());
                while(c1.moveToNext())
                {
                    number1=Integer.parseInt(c1.getString(4));
                }
                number1=number1-x;
                recieverbalance=recieverbalance+x;
                db.execSQL("update customers set balance='"+String.valueOf(number1)+"' where username='"+username+"'");
                Toast.makeText(getContext(),"sender updated",Toast.LENGTH_LONG).show();
//
//                Cursor c4=db.rawQuery("select * from customers where username='"+toadd+"'",null);

//                while(c4.moveToNext())
//                {
//                    number1=Integer.parseInt(c4.getString(4));
//                }
//                number1=number1+Integer.parseInt(amount.getText().toString());
                db.execSQL("update customers set balance='"+String.valueOf(recieverbalance)+"' where username='"+toadd+"'");
//                Toast.makeText(getContext(),"reciever updated",Toast.LENGTH_LONG).show();

            }
            });

                return view1;
    }


}
