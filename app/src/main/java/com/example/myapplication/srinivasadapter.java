package com.example.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class srinivasadapter extends ArrayAdapter<srinivas> {
    public srinivasadapter(@NonNull Context context,  @NonNull List<srinivas> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listitemview=convertView;
        if(listitemview==null)
        {
            listitemview= LayoutInflater.from(getContext()).inflate(R.layout.maruthicard,parent,false);
        }
     srinivas name=getItem(position);

        TextView tv=listitemview.findViewById(R.id.m1);
        TextView t1=listitemview.findViewById(R.id.m2);
        TextView t2=listitemview.findViewById(R.id.m3);
tv.setText(name.getA());
        t1.setText(name.getB());
        t2.setText(name.getC());

        return listitemview;
    }
}
