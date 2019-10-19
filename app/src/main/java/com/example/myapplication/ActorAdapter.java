package com.example.myapplication;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ActorAdapter extends ArrayAdapter<Actor> {
    TextView txt1,txt2;
    public ActorAdapter(Activity context, ArrayList<Actor> Actor) {
        super(context, 0, Actor);
    }




    @Override
    public View getView(int position,  View convertView, ViewGroup parent) {

        View listItemView=convertView;
        if(listItemView==null)
        {
listItemView= LayoutInflater.from(getContext()).inflate(R.layout.actors_list,parent,false);

        }
        Actor name=getItem(position);
        txt1=listItemView.findViewById(R.id.actor);
        txt1.setText(name.getActor());
        txt2=listItemView.findViewById(R.id.age);
    txt2.setText(name.getAge());
        return listItemView;
    }

}
