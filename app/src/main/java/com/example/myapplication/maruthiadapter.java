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

public class maruthiadapter extends ArrayAdapter<maruthi> {
    public maruthiadapter(@NonNull Context context, @NonNull List<maruthi> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view=convertView;
        if(view==null)
        {
            view= LayoutInflater.from(getContext()).inflate(R.layout.maruthicard,parent,false);

        }
        maruthi name=getItem(position);
        TextView t1=view.findViewById(R.id.m1);
        TextView t2=view.findViewById(R.id.m2);
        TextView t3=view.findViewById(R.id.m3);
        t1.setText(name.getA());
        t2.setText(name.getB());
        t3.setText(name.getC());






        return view;

    }
}
