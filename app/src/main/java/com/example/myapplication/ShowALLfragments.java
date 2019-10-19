package com.example.myapplication;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class ShowALLfragments extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_allfragments);
    }
    public void showfragment(View v)
    {

        Bundle b = getIntent().getExtras();
        String n = b.getString("name");
//        SharedPreferences sp =
//                getSharedPreferences
//                        ("mycredentials",
//                                Context.MODE_PRIVATE);
//        SharedPreferences.Editor edit =
//                sp.edit();
//        edit.putString
//                ("name",n);
//        Fragment fragment = new showfragment();
//        Bundle bundle = new Bundle();
//        bundle.putString("name",n);
//        fragment.setArguments(bundle);
////        edit.commit();
//        Toast.makeText(this,
//                n,
//                Toast.LENGTH_SHORT).show();

        loadFragment(new showfragment());

    }
    public void withdrawfrag(View v)
    {
loadFragment(new withdraw());
    } public void depositfrag(View v)
    {
loadFragment(new deposit());
    }
    public void transferfrag(View v)
    {
loadFragment(new transfer());
    }

    public void loadFragment(Fragment fragment) {
        // create a FragmentManager
        FragmentManager fm = getSupportFragmentManager();
        // android.support.v4.app.FragmentManager fm=getSupportFragmentManager();
        // create a FragmentTransaction to begin the transaction and replace the Fragment
        FragmentTransaction ft =
                fm.beginTransaction();
        // replace the FrameLayout with new Fragment
        ft.replace(R.id.frameLayout,
                fragment);
        //fragmentTransaction.add(R.id.firstFragment,fragment);
        ft.commit(); // save the changes
    }
}



