package com.example.myapplication.Practice;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myapplication.R;


public class Frag2 extends Fragment {
   View view;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_frag2, container, false);


        return view;
    }
public void changeData(String i)
{
    TextView txt=view.findViewById(R.id.sample);
    txt.setText(i);
}
}
