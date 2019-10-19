package com.example.myapplication;

import android.app.ListActivity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class contacts extends AppCompatActivity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);
        ContentResolver cr = getContentResolver();
        Cursor c = cr.query
                (ContactsContract.Contacts.CONTENT_URI,
                        new String[] {ContactsContract.Contacts.DISPLAY_NAME},
                        null, null, null);

        List<String> contacts = new ArrayList<String>();
        List<String> numbers = new ArrayList<String>();
        if (c.moveToFirst()) {
            do {
                contacts.add(c.getString(c.getColumnIndex(
                        ContactsContract.Contacts.DISPLAY_NAME)));

            } while (c.moveToNext());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this,
                        R.layout.list,R.id.list_item, contacts);
               ListView list=findViewById(R.id.list_item);
        list.setAdapter(adapter);
    }
}

