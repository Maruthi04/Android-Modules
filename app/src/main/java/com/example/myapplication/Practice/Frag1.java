package com.example.myapplication.Practice;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.myapplication.R;


public class Frag1 extends Fragment {
  ListView listt;
  View view;
  InterfaceOf in;
  String[] listof=new String[]{"oneplus","Iphone"};
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        in= (InterfaceOf) getActivity();
        view= inflater.inflate(R.layout.fragment_frag1, container, false);
        listt=view.findViewById(R.id.maruthi);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,listof);
        listt.setAdapter(adapter);
        listt.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView txt= (TextView) view;
                in.reciever((String) txt.getText());

            }
        });

        return view;
    }

}
