package com.example.myapplication;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class savedinstance extends AppCompatActivity {
Button increment;
EditText editt;
int a=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_savedinstance);
        editt=findViewById(R.id.editt);
        increment=findViewById(R.id.increment);
        increment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a++;
                editt.setText(String.valueOf(a));
            }
        });
if(savedInstanceState!=null)
{
 a=savedInstanceState.getInt("value");
 editt.setText(String.valueOf(a));
}

    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        outState.putInt("value",a);
    }
}
