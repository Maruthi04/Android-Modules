package com.example.myapplication.Practice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.myapplication.R;

import java.util.ArrayList;

class CountryAdapter extends ArrayAdapter<Countries> {
TextView t1,t2,t3;

     public CountryAdapter(Context context, ArrayList<Countries> countries) {
         super(context, 0, countries);
     }


    @Override
    public View getView(int position, View convertView,ViewGroup parent) {
         View listItemView=convertView;
         if(listItemView==null)
         {
             listItemView= LayoutInflater.from(getContext()).inflate(R.layout.countriescard,parent,false);
         }
         Countries name=getItem(position);
         t1=listItemView.findViewById(R.id.country);
         t2=listItemView.findViewById(R.id.currency);
         t3=listItemView.findViewById(R.id.time);
         t1.setText(name.getState());
         t2.setText(name.getCurrency());
         t3.setText(name.getTime());


        return listItemView;
    }
}
