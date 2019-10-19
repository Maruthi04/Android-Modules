package com.example.myapplication;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
public class commfrag1 extends AppCompatActivity
        implements Communicator {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.commfrag);
    }


    // implementing the method defined in the interface
    @Override
    public void respond(String i) {
        FragmentManager fm=
                getSupportFragmentManager();
        Fragment2 f2= (Fragment2)fm.
                findFragmentById(R.id.fragment2);
        f2.changedata(i);
    }

}



