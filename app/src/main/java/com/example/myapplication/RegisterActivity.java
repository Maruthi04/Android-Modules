package com.example.myapplication;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    SQLiteDatabase db;
    Button b1;
    EditText e1,e2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
db=openOrCreateDatabase("logindb",Context.MODE_PRIVATE,null);
db.execSQL("CREATE table if not exists logindb1(username varchar,password varchar)");
        e1=findViewById(R.id.regusername);
        e2=findViewById(R.id.regpassword);
        b1=findViewById(R.id.registerregister);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
db.execSQL("insert into logindb1 values('" +e1.getText().toString() +"','"+e2.getText().toString()+"')");
                Toast.makeText(RegisterActivity.this,"Inserted Successfully",Toast.LENGTH_LONG).show();
            }
        });

    }
}
