package com.example.myapplication.Practice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.myapplication.R;

public class customradiocheckbuttons extends AppCompatActivity {
RadioButton radioButton1,radioButton22;
Switch switches;
CheckBox checkBox1;
ToggleButton  toggleButton1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customradiocheckbuttons);
        switches=findViewById(R.id.switch1);
        checkBox1=findViewById(R.id.checkBox);
        toggleButton1=findViewById(R.id.toggleButton);
        radioButton1=findViewById(R.id.radioButton);
        radioButton22=findViewById(R.id.radioButton2);
      switches.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
          @Override
          public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
              if(b)
              {
                  Toast.makeText(customradiocheckbuttons.this,"you onned it",Toast.LENGTH_LONG).show();
              }
          }
      });
     checkBox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
         @Override
         public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
             if(b)
             {
                 Toast.makeText(customradiocheckbuttons.this,"you checked it",Toast.LENGTH_LONG).show();
             }
         }
     });
     toggleButton1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
         @Override
         public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
             if(b)
             {
                 Toast.makeText(customradiocheckbuttons.this,"you toggled it",Toast.LENGTH_LONG).show();
             }
         }
     });

    }
    public void gotoo(View v)
    {
        Toast.makeText(customradiocheckbuttons.this,"you Radioed it",Toast.LENGTH_LONG).show();
    }
}
