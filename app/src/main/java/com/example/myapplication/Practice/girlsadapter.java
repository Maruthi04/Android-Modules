package com.example.myapplication.Practice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.myapplication.R;

import java.util.ArrayList;

public class girlsadapter extends ArrayAdapter<girls> {
    TextView t1,t2,t3;
    public girlsadapter(Context context, ArrayList<girls> list) {
        super(context, 0,list);
    }


    @Override
    public View getView(int position, View convertView,  ViewGroup parent) {
        View listItemView=convertView;
        if(listItemView==null)
        {
            listItemView= LayoutInflater.from(getContext()).inflate(R.layout.girlscard,parent,false);

        }
        girls name=getItem(position);
        t1=listItemView.findViewById(R.id.girls);
        t2=listItemView.findViewById(R.id.age);
        t3=listItemView.findViewById(R.id.comitted);
        t1.setText(name.getName());
        t2.setText(name.getAge());
        t3.setText(name.getComitted());

        return listItemView;
    }
}
