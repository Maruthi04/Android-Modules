package com.example.myapplication;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class BluetoothActivity extends AppCompatActivity {


    TextView tv;
    Button button1;
    Button button2;
    Button button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bluetooth);
        button1=findViewById(R.id.button1);
        button2=findViewById(R.id.button2);
        button3=findViewById(R.id.button3);
        tv=findViewById(R.id.out);
       final BluetoothAdapter bluetoothAdapter=BluetoothAdapter.getDefaultAdapter();
        button1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
if(bluetoothAdapter==null)
{
    tv.setText("I cannot DO that");
}
if(!bluetoothAdapter.isEnabled())
{
    Intent in=new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
    startActivity(in);
}
           }
       });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bluetoothAdapter==null)
                {
                    tv.setText("I cannot DO that");
                }
                if(bluetoothAdapter.isDiscovering())
                {
                    Intent in=new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
                    startActivity(in);
                }
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bluetoothAdapter.disable();
                Toast.makeText(BluetoothActivity.this,"I am turning Bluetooth off!!",Toast.LENGTH_LONG).show();
            }
        });
    }
}




