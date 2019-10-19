package com.example.myapplication;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


public class LifecycleFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        printmessage("Fragment view Created");
        return inflater.inflate(R.layout.fragment_lifecycle, container, false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        printmessage("OnAttach(0 Fragment");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        printmessage("Fragment Created");

    }

    @Override
    public void onStart() {
        super.onStart();
        printmessage("started fragment");
    }

    @Override
    public void onResume() {
        super.onResume();
        printmessage("fragment resumed");
    }

    @Override
    public void onPause() {
        super.onPause();
        printmessage("fragment paused");
    }

    @Override
    public void onStop() {
        super.onStop();
        printmessage("fragment stopped");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        printmessage("destroy view");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        printmessage("destroyed fragment");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        printmessage("Detached fragment");
    }

    private void printmessage(String s) {
        Toast.makeText(getActivity(),"Fragment is "+s,Toast.LENGTH_LONG).show();
    }

}
