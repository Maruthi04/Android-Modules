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

public class CameraActivity extends AppCompatActivity {
Button b1;
ImageView im;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        b1=findViewById(R.id.camerabutton);
        im=findViewById(R.id.camcapture);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
Intent in=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
startActivityForResult(in,11);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==11)
        {
            Bitmap image=(Bitmap)data.getExtras().get("data");
            im.setImageBitmap(image);
        }
    }
}
