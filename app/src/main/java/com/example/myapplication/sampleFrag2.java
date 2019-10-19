package com.example.myapplication;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class sampleFrag2 extends Fragment {
View view;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_sample_frag2, container, false);
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sample_frag2, container, false);
    }

    public void adddata(int s) {
        TextView tv=getActivity().findViewById(R.id.textresult);


        tv.setText("the Addition is "+s);
    }
}
