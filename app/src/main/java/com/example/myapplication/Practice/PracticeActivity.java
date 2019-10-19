package com.example.myapplication.Practice;

import android.app.PendingIntent;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.PersistableBundle;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.BlankFragment1;
import com.example.myapplication.BlankFragment2;
import com.example.myapplication.MyOTPReciever;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PracticeActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice);
//        LayoutInflater inflater=getLayoutInflater();
//        View alertView=inflater.inflate(R.layout.customdialogue,null);
//        AlertDialog.Builder alert=new AlertDialog.Builder(this);
//        alert.setView(alertView);
//        alert.setCancelable(true);
//        AlertDialog dialog=alert.create();
//        dialog.show();
//
//
        EditText ev=findViewById(R.id.ee);
        EditText ev1=findViewById(R.id.ee1);
 LayoutInflater inflater=getLayoutInflater();
 View alertView = inflater.inflate(R.layout.customdialogue,null);
 AlertDialog.Builder alert=new AlertDialog.Builder(this);
 alert.setView(alertView);
 alert.setCancelable(true);
 AlertDialog dialog=alert.create();
 dialog.show();
    }
    public  void sendsmss(View v)
    {
    loadFragment(new BlankFragment2());
    }

    private void loadFragment(Fragment fragment) {
    FragmentManager fm=getSupportFragmentManager();
    FragmentTransaction ft=fm.beginTransaction();
    ft.replace(R.id.frameLayoutt,fragment);
    ft.commit();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==11)
        {
            Bitmap photo= (Bitmap) data.getExtras().get("data");
            ImageView img1=findViewById(R.id.imagee);
            img1.setImageBitmap(photo);
        }
    }
}
