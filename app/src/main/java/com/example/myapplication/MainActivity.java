package com.example.myapplication;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static com.example.myapplication.R.menu.menu;

public class MainActivity extends AppCompatActivity {
Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16,b17,b18,b19,b20;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo);
        b1=findViewById(R.id.first);
        b2=findViewById(R.id.second);
        b3=findViewById(R.id.third);
        b4=findViewById(R.id.fourth);
        b7=findViewById(R.id.seventh);
        b8=findViewById(R.id.eigth);
        b9=findViewById(R.id.nine);
        b5=findViewById(R.id.fifth);
        b6=(Button)findViewById(R.id.sixth);
        b10=findViewById(R.id.ten);
        b11=findViewById(R.id.eleven);
        b12=findViewById(R.id.twelve);
        b13=findViewById(R.id.thirteen);
        b14=findViewById(R.id.fourteen);
        b15=findViewById(R.id.fifteen);
        b16=findViewById(R.id.sixteen);
        b17=findViewById(R.id.seventeen);
        b18=findViewById(R.id.eighteen);
        b19=findViewById(R.id.nineteen);
        b20=findViewById(R.id.twenty);


        Toast.makeText(MainActivity.this,"Scroll down for viewing every item!!!",Toast.LENGTH_LONG).show();
        b1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent in=new Intent(MainActivity.this,buttonclicking.class);
        startActivity(in);
    }
});
        b20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(MainActivity.this,temparature.class);
                startActivity(in);
            }
        });
b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(MainActivity.this,onCreateondestroy.class);
                startActivity(in);
            }
        });
        b19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(MainActivity.this,HomePageB.class);
                startActivity(in);
            }
        });
        b12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(MainActivity.this,SQLlite.class);
                startActivity(in);
            }
        });
        b13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(MainActivity.this,LoginActivitywithsql.class);
                startActivity(in);
            }
        });
        b14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(MainActivity.this,SharedPreferencess.class);
                startActivity(in);
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(MainActivity.this, BluetoothActivity.class);
                startActivity(in);
            }
        });
        b18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(MainActivity.this, MapsActivity.class);
                startActivity(in);
            }
        });
        b10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(MainActivity.this, GalleryActivity.class);
                startActivity(in);
            }
        });
        b11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(MainActivity.this, ContactsActivity.class);
                startActivity(in);
            }
        });
        b17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(MainActivity.this, asynctaskChumma.class);
                startActivity(in);
            }
        });
b7.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent in=new Intent(MainActivity.this,commfrag1.class);
        startActivity(in);
    }
});
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(MainActivity.this,CameraActivity.class);
                startActivity(in);
            }
        });
        b15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(MainActivity.this, FragmentLifecycle.class);
                startActivity(in);
            }
        });
        b16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(MainActivity.this, com.example.myapplication.Practice.phoneslist.class);
                startActivity(in);
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(MainActivity.this,incrementActivity.class);
                startActivity(in);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(MainActivity.this,savedinstance.class);
                startActivity(in);
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(MainActivity.this,actorslist.class);
                startActivity(in);
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(MainActivity.this,FRAGMENTtESTINGaCT.class);
                startActivity(in);
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       switch (item.getItemId())
       {
           case R.id.toast:
               Intent in =new Intent(MainActivity.this,Login.class);
               startActivity(in);
               break;
           case R.id.destroy:
               break;
           case R.id.errors:
               Intent iin =new Intent(MainActivity.this,Errors.class);
               startActivity(iin);
               break;


       }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;

    }
}
