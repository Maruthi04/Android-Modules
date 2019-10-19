package com.example.myapplication;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class asynctaskChumma extends AppCompatActivity {
TextView tv;
ProgressBar pb;
ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asynctask_chumma);
        tv=findViewById(R.id.countdown);
        pb=findViewById(R.id.normal);
        img=findViewById(R.id.ippo);
        pb.setVisibility(View.INVISIBLE);
    }
    public void starttask(View v)
    {
        myfinalsynctask mm=new myfinalsynctask();
                mm.execute(R.drawable.carpic);
    }
    public class myfinalsynctask extends AsyncTask<Integer,Integer, Bitmap>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pb.setVisibility(View.VISIBLE);
        }

        @Override
        protected Bitmap doInBackground(Integer... integers) {
            Bitmap bm= BitmapFactory.decodeResource(getResources(),integers[0]);
            for(int i=0;i<10;i++)
            {
                publishProgress(i*100/10);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return bm;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            pb.setProgress(values[0]);
            tv.setText("Image Gets Loaded in "+(values[0]/10)+" seconds!");
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            pb.setVisibility(View.INVISIBLE);
            img.setImageBitmap(bitmap);
            tv.setText("Image Loaded :)!");
        }

    }
}
