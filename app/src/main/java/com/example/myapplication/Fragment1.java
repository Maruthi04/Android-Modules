package com.example.myapplication;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Fragment1 extends Fragment{
    int count=0; // int to maintain the no of button clicks
    Button bt; //object for button
    Communicator comm; //object for interface to pass the message to the activity
    View view;
    ListView lv;
    TextView txt;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment1comm1, container, false);
        comm= (Communicator) getActivity();


        String days[]={"Monday","Tuesday","Wednesday","Thursday",

                "Friday","Saturday","Sunday"};

        lv=view.findViewById(R.id.lv);
            ArrayAdapter<String> ada= new ArrayAdapter<String>(Fragment1.this.getActivity(), android.R.layout.simple_list_item_1,days);
            lv.setAdapter(ada);
            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                     txt = (TextView) view;
                    comm.respond((String) txt.getText());
                    Toast.makeText(Fragment1.this.getActivity(), "You have selected : " + txt.getText(), Toast.LENGTH_SHORT).show();
                }
            });

        return view;
    }

}
