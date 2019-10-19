package com.example.myapplication.Practice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.myapplication.R;

import java.util.ArrayList;

public class girlslist extends AppCompatActivity {
AutoCompleteTextView atv;
String harsha[]={"maruthi","harsha","chetan","hemanth"};
    ArrayList<girls> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_girlslist);
        list=new ArrayList<girls>();
        list.add(new girls("Maruthi","23","Yes"));
        list.add(new girls("saruthi","23","Yes"));
        list.add(new girls("aaruthi","23","Yes"));
        list.add(new girls("raruthi","23","Yes"));
        list.add(new girls("uaruthi","23","Yes"));
        list.add(new girls("taruthi","23","Yes"));
        list.add(new girls("haruthi","23","Yes"));
        list.add(new girls("Maruthi","23","Yes"));
        list.add(new girls("Maruthi","23","Yes"));
        list.add(new girls("Maruthi","23","Yes"));
        list.add(new girls("Maruthi","23","Yes"));
      girlsadapter ga=new girlsadapter(this,list);
        ListView listv=findViewById(R.id.llist);
        listv.setAdapter(ga);
listv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        String s=list.get(i).name;
        Toast.makeText(girlslist.this,s,Toast.LENGTH_LONG).show();
    }
});
atv=findViewById(R.id.autoCompleteTextView);
atv.addTextChangedListener(new TextWatcher() {
    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {
       // String
    }
});



    }
}
