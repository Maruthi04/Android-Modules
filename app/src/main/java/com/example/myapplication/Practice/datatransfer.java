package com.example.myapplication.Practice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.myapplication.R;

public class datatransfer extends AppCompatActivity {
EditText editText;
String b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datatransfer);
        editText=findViewById(R.id.enter);
         b=editText.getText().toString();
    }
    public void send(View v)
    {
        b=editText.getText().toString();
        Intent in=new Intent(this,datarecieve.class);
        in.putExtra("name",b);
        startActivity(in);
    }
}
