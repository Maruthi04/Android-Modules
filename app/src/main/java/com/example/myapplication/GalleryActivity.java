package com.example.myapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.IOException;

public class GalleryActivity extends AppCompatActivity {
ImageView img;
Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        b1=findViewById(R.id.gallerybutton);
        img=findViewById(R.id.selimage);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Intent in=new Intent();
              in.setType("image/*");
              in.setAction(Intent.ACTION_GET_CONTENT);
              startActivityForResult(in,3);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
       if(requestCode==3&& resultCode==RESULT_OK&& data!=null&&data.getData()!=null)
       {
           try {
               Bitmap bitmap=(Bitmap)MediaStore.Images.Media.getBitmap(getContentResolver(),data.getData());
               img.setImageBitmap(bitmap);
           } catch (IOException e) {
               e.printStackTrace();
           }

       }
    }
}
