package com.example.myapplication;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


public class BlankFragment1 extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
Button b11,b22;
View view;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_blank_fragment1, container, false);
        b11=view.findViewById(R.id.first1);
        b22=view.findViewById(R.id.second1);
        b11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("BlankFragment1","hiiii");
              finalcomm f= (finalcomm) getActivity();
              f.respond("hello");



                //Toast.makeText(getActivity(),"ypu clicked button1",Toast.LENGTH_LONG).show();
            }
        });
         b22.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Toast.makeText(getActivity(),"ypu clicked button2",Toast.LENGTH_LONG).show();

    }
});
        return view;
    }

}
