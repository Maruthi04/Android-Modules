package com.example.myapplication;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class sampleFrag1 extends Fragment {
View view;
sampleinterface sample;
    EditText e1,e2;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_sample_frag1, container, false);
      e1=view.findViewById(R.id.firstnumber);
         e2=view.findViewById(R.id.secondnumber);
        Button b1=view.findViewById(R.id.addn);


sample= (sampleinterface) getActivity();
b1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        String one=e1.getText().toString();
        String two=e2.getText().toString();
        sample.sampletrasfo(one,two);
    }
});
        // Inflate the layout for this fragment
        return view;
    }

}
