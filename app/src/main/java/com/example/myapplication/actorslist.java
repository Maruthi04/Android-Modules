package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;

public class actorslist extends AppCompatActivity {
Button register;
String answer;
EditText name,roll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actorslist);
        final ArrayList<Actor> actor=new ArrayList<Actor>();
        actor.add(new Actor("Data Science","6000"));
        actor.add(new Actor("Python","5000"));
        actor.add(new Actor("Ruby","4000"));
        actor.add(new Actor("Data Mining","3000"));
name=findViewById(R.id.name);
        roll=findViewById(R.id.roll);

register=findViewById(R.id.reg);
register.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
 String a=name.getText().toString();
 String b=roll.getText().toString();
        Toast.makeText(actorslist.this,"Congrats "+a+" "+b+" of "+answer+" ",Toast.LENGTH_SHORT).show();
    }
});



        ActorAdapter act=new ActorAdapter(this,actor);
        ListView list=findViewById(R.id.actorslist);
        list.setAdapter(act);
//        list.setOnItemClickListener(new AdapterView.OnItemClickListener()
//        {
//            @Override
//            public void onItemClick(AdapterView<?> adapter, View v, int position,
//                                    long arg3)
//            {
//                String value = (String)adapter.getItemAtPosition(position);
//
//                Toast.makeText(actorslist.this," "+value.toString(),Toast.LENGTH_SHORT).show();
//                // assuming string and if you want to get the value on click of list item
//                // do what you intend to do on click of listview row
//            }
//        });
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String s=actor.get(position).toString();
                Toast.makeText(actorslist.this, s+"", Toast.LENGTH_SHORT).show();
            }
        });






    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.okati:
                if (checked)
                    Toast.makeText(actorslist.this,"you are first year",Toast.LENGTH_SHORT).show();
                answer="first year";
                    break;
            case R.id.rendu:
                if (checked)
                    // Ninjas rule
                    Toast.makeText(actorslist.this,"you are Second year",Toast.LENGTH_SHORT).show();
                answer="2nd year";
                    break;
            case R.id.moodu:
                if (checked)
                    // Ninjas rule
                    Toast.makeText(actorslist.this,"you are third year",Toast.LENGTH_SHORT).show();
                answer="3rd year";
                    break;
            case R.id.nalugu:
                if (checked)
                    // Ninjas rule
                    answer="fourth year";
                    Toast.makeText(actorslist.this,"you are fourth year",Toast.LENGTH_SHORT).show();
                    break;
        }
    }

}
