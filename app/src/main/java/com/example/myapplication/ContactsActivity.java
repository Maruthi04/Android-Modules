package com.example.myapplication;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContactsActivity extends AppCompatActivity {
ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts2);
        ContentResolver cr=getContentResolver();
        lv=findViewById(R.id.lv);
        Cursor c=cr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,null,null,null);
        List<Map<String,String>> mapp=new ArrayList<>();
        HashMap<String,String> map;
        if(c.moveToFirst())
        {
            do{
                map=new HashMap<String,String>();
                map.put("name",c.getString(c.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME)));
                map.put("numbers",c.getString(c.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)));

    mapp.add(map);
            }while(c.moveToNext());
        }
        String[] from={"name","numbers"};
        int[] to={android.R.id.text1,android.R.id.text2};
        SimpleAdapter ad=new SimpleAdapter(this,mapp,android.R.layout.simple_list_item_2,from,to);
        lv.setAdapter(ad);
lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        TextView tv=view.findViewById(android.R.id.text2);
        Intent intent=new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+tv.getText().toString()));
        startActivity(intent);

    }
});
    }
}
