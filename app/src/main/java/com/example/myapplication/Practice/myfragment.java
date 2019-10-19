package com.example.myapplication.Practice;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.myapplication.R;

public class myfragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    View view;
    ListView list11;
    String[] girlfriends=new String[]{"rishika","Reshma","By Rishitha","Srija","dedeepya","Jayabhavani","Pooja bharathi"};

   @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       view=inflater.inflate(R.layout.fragment_myfragment, container, false);
    list11=view.findViewById(R.id.list1);
    ArrayAdapter<String> newadap=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,girlfriends);
    list11.setAdapter(newadap);
       return view;

    }
}
