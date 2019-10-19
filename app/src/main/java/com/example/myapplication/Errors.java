package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Errors extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_errors);
    }
    public void errorreport(View v)
    {

        EditText e1=findViewById(R.id.typee);
        EditText e2=findViewById(R.id.description);
String s1,s2;
String to="smaruthisrinivas420@gmail.com";
s1=e1.getText().toString();
s2=e2.getText().toString();
        Intent email = new Intent(Intent.ACTION_SEND);
        email.putExtra(Intent.EXTRA_EMAIL, new String[]{to });
        email.putExtra(Intent.EXTRA_SUBJECT, s1);
        email.putExtra(Intent.EXTRA_TEXT, s2);

//need this to prompts email client only
        email.setType("message/rfc822");

        startActivity(Intent.createChooser(email, "Choose an Email client :"));
    }
}
