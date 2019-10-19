package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class incrementActivity extends AppCompatActivity {

    EditText shower;
    Button b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_increment);
        shower=findViewById(R.id.edit);
        b1=findViewById(R.id.b11);
        b2=findViewById(R.id.b22);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a=Integer.parseInt(shower.getText().toString());
                a++;
                String b=String.valueOf(a);
                Toast.makeText(incrementActivity.this,"the number is "+b,Toast.LENGTH_SHORT).show();
                shower.setText(String.valueOf(a));
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a=Integer.parseInt(shower.getText().toString());
                a--;
                String b=String.valueOf(a);
                Toast.makeText(incrementActivity.this,"the number is "+b,Toast.LENGTH_SHORT).show();
                shower.setText(String.valueOf(a));
            }
        });

    }


}
