package com.example.myapplication.Practice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.myapplication.R;

import java.util.List;

public class phonesAdapter extends ArrayAdapter<phones> {

    public phonesAdapter(Context context, List<phones> objects) {
        super(context, 0, objects);
    }


    @Override
    public View getView(int position,View convertView,ViewGroup parent) {
        View listitem=convertView;
        if(listitem==null)
        {
            listitem= LayoutInflater.from(getContext()).inflate(R.layout.sample,parent,false);
        }
        phones name=getItem(position);
        TextView tv1=listitem.findViewById(R.id.tvv1);
        TextView tv2=listitem.findViewById(R.id.tvv2);
        TextView tv3=listitem.findViewById(R.id.tvv3);
        TextView tv4=listitem.findViewById(R.id.tvv4);
tv1.setText(name.getA());
tv2.setText(name.getB());
tv3.setText(name.getC());
tv4.setText(name.getD());
        return listitem;
    }
}
