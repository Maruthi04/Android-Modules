package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.view.MenuItem;


import static android.view.ContextMenu.*;

public class ContextMenu extends AppCompatActivity {
    ListView l1;
    String[] arr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_class);
        l1 = (ListView) findViewById(R.id.lv1);
        arr = new String[]
                {"Books", "Glasses", "Bag"};
        ArrayAdapter ad = new ArrayAdapter
                (ContextMenu.this,
                        android.R.layout.
                                simple_list_item_1, arr);
        l1.setAdapter(ad);


        registerForContextMenu(l1);
        l1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {


                hello(position);
                return false;
            }
        });

            l1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    if (position == 0) {


                        Toast.makeText
                                (ContextMenu.this, "Book costs 30-/", Toast.LENGTH_LONG).show();
                    }
                    if (position == 1) {
                        Toast.makeText
                                (ContextMenu.this, "Glass costs 30-/", Toast.LENGTH_LONG).show();
                    }
                }


            });


    }

    private String hello(int position) {
        Toast.makeText(ContextMenu.this,""+arr[position],Toast.LENGTH_LONG).show();
        String bb=arr[position];
        sample(bb);
        return arr[position];
    }

    private void sample(String bb) {
        MenuItem item=null;
        onContextItemSelected(item,bb);
    }

    public void onCreateContextMenu(android.view.ContextMenu menu, View v, ContextMenuInfo menuInfo) {

        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menuinfo, menu);


     /*  menu.setHeaderTitle("Please Select");
       menu.add(0,v.getId(),0,"New");
       menu.add(0,v.getId(),0,"Edit");
       menu.add(0,v.getId(),0,"Delete");
       */
    }

    public boolean onContextItemSelected(MenuItem item,String bb) {
        switch (item.getItemId()) {
            case R.id.i1:

                Toast.makeText
                        (this, "Book costs 30-/"+bb, Toast.LENGTH_LONG).show();
                break;
            case R.id.i2:
                Toast.makeText
                        (this, "Edit Selected", Toast.LENGTH_LONG).show();
                break;

        }
        return super.onContextItemSelected(item);

    }

}
