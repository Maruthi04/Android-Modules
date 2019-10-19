package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivitywithsql extends AppCompatActivity {
Button b1,b2;
EditText e1,e2;
SQLiteDatabase db;
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_activitywithsql2);
        e1=findViewById(R.id.username);
    e2=findViewById(R.id.password);
    b1=findViewById(R.id.loginbutton);
    b2=findViewById(R.id.registerbutton);
    db=openOrCreateDatabase("logindb", Context.MODE_PRIVATE,null);
    b2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent in=new Intent(LoginActivitywithsql.this,RegisterActivity.class);
            startActivity(in);
        }
    });
    b1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Cursor c=  db.rawQuery("select * from logindb1 where username='"+ e1.getText().toString()+"' and password='"+e2.getText().toString()+"'",null);
            if(c.moveToFirst())
            {
               Intent in=new Intent(LoginActivitywithsql.this,BookActivity.class);
               startActivity(in);
            }
        }
    });


}
}
