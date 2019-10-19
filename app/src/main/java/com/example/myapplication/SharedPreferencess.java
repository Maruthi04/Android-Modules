package com.example.myapplication;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SharedPreferencess extends AppCompatActivity {
EditText e11,e22;
TextView t1,t2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);
        e11=(EditText)findViewById(R.id.nameof);
        e22=findViewById(R.id.no1);
        t1=findViewById(R.id.text11);
        t2=findViewById(R.id.text22);


    }
    public void savee(View v)
    {
        e11=findViewById(R.id.nameof);
        e22=findViewById(R.id.no1);
        SharedPreferences sp =
                (SharedPreferences) getSharedPreferences
                        ("mycredentials",
                                Context.MODE_PRIVATE);
SharedPreferences.Editor edit=sp.edit();

        edit.putString
                ("name",e11.getText().toString());
        edit.putString
                ("pass",e22.getText().toString());
        edit.commit();
        Toast.makeText(this,
                "Data Saved in Shared Preference",
                Toast.LENGTH_SHORT).show();
    }
    public void gett(View v)
    {
        t1=findViewById(R.id.text11);
        t2=findViewById(R.id.text22);
        SharedPreferences sp =
                getSharedPreferences
                        ("mycredentials",
                                Context.MODE_PRIVATE);
        String name = sp.getString
                ("name","NA");
        String passwd = sp.getString
                ("pass","NA");
        t1.setText(name);
        t2.setText(passwd);

    }


}
