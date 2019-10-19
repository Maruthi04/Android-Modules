package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class HomePageB extends AppCompatActivity {
EditText username,password,dob,accountno,balance;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page_b);
        // Creating database and table  
        db = openOrCreateDatabase("Bank", Context.MODE_PRIVATE, null);

db.execSQL("create table if not exists customers(username varchar,password varchar,dob varchar,accountnumber varchar,balance varchar);");
        username=findViewById(R.id.usernameb);
        password=findViewById(R.id.passwordb);
        dob=findViewById(R.id.dobb);
        accountno=findViewById(R.id.accountb);
        balance=findViewById(R.id.balance);

    }
    public void senddbb(View v)
    {
        String a=username.getText().toString();
        String b=password.getText().toString();
        String c=dob.getText().toString();
        String d=accountno.getText().toString();
        String e=balance.getText().toString();

        db = openOrCreateDatabase("Bank", Context.MODE_PRIVATE, null);

        db.execSQL("insert into customers values('"+a+"','"+b+"','"+c+"','"+d+"','"+e+"');");
        Toast.makeText(HomePageB.this,"Record Created",Toast.LENGTH_LONG).show();
    }
    public void intentlogin(View v)
    {
       EditText x=findViewById(R.id.usernamelogin) ;
        EditText y=findViewById(R.id.passwordlogin) ;
        EditText z=findViewById(R.id.doblogin) ;
        String a=x.getText().toString();
        String b=y.getText().toString();
        String c=z.getText().toString();
        db = openOrCreateDatabase("Bank", Context.MODE_PRIVATE, null);

        Cursor c1 = db.rawQuery("SELECT * FROM customers WHERE username='"+a+"' and password='"+b+"' and dob='"+c+"'"  , null);
        if (c1.moveToFirst()) {
            Intent in =new Intent(HomePageB.this,ShowALLfragments.class);
            in.putExtra("name",a);
            startActivity(in);
            Toast.makeText(HomePageB.this,"Record found",Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(HomePageB.this,"No Record Found",Toast.LENGTH_LONG).show();
        }

    }

    }

