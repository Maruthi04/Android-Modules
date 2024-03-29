package com.example.myapplication;

import android.app.Activity;
import android.app.ProgressDialog;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

public class downloadmusic_asynctask  extends Activity
        implements View.OnClickListener{
    // Button to download and play Music
    private Button btnPlayMusic;
    // Media Player Object
    private MediaPlayer mPlayer;
    // Music resource URL
    private static String file_url =
            "https://android.programmerguru.com/" +
                    "wp-content/uploads/2014/01/jai_ho.mp3";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_downloadmusic_asynctask);
        // Show Download Music Button
        btnPlayMusic = findViewById(R.id.b);
        // Download Music Button click listener
        btnPlayMusic.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        // Downloaded Music File path in SD Card
        File file = new File(Environment.
                getExternalStorageDirectory().
                getPath()
                +"/jai_ho.mp3");
        // Check if the Music file already exists
        if (file.exists()) {
            Toast.makeText(getApplicationContext(),
                    "File already exist " +
                            "at "+ Environment.getExternalStorageDirectory()
                            .getPath() +
                            " , playing Music", Toast.LENGTH_LONG).show();
            // Play Music
            playMusic();
            // If the Music File doesn't
            // exist in SD card (Not yet downloaded)
        } else {
            Toast.makeText(getApplicationContext(),
                    "File doesn't exist " +
                            "under SD Card, " +
                            "downloading Mp3 from Internet",
                    Toast.LENGTH_LONG).show();
            // Trigger Async Task (onPreExecute method)

            DownloadMusicfromInternet music =
                    new DownloadMusicfromInternet();
            music.execute(file_url);
        }
    }


    // Async Task Class
    class DownloadMusicfromInternet extends
            AsyncTask<String, String, String> {

        ProgressDialog prgDialog;

        // Show Progress bar before downloading Music
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Shows Progress Bar Dialog and
            // then call doInBackground method

            prgDialog = new ProgressDialog(
                    downloadmusic_asynctask.this);
            prgDialog.setMessage
                    ("Downloading Mp3 file. " +
                            "Please wait...");
            prgDialog.setIndeterminate(false);
            prgDialog.setProgressStyle
                    (ProgressDialog.STYLE_HORIZONTAL);
            prgDialog.setCancelable(false);
            prgDialog.show();

        }
        // Download Music File from Internet
        @Override
        protected String doInBackground
        (String... f_url) {
            int count;
            try {
                URL url = new URL(f_url[0]);
                URLConnection conection =
                        url.openConnection();
                conection.connect();
                // Get Music file length
                int lenghtOfFile =
                        conection.getContentLength();
                // input stream to read file - with 8k buffer
                InputStream input =
                        new BufferedInputStream
                                (url.openStream(),
                                        10*1024);
                // Output stream to write file in SD card
                OutputStream output =
                        new FileOutputStream
                                (Environment.
                                        getExternalStorageDirectory().
                                        getPath()+"/jai_ho.mp3");

                byte data[] = new byte[1024];
                long total = 0;
                while ((count = input.read(data)) != -1) {
                    total += count;
                    // Publish the progress which triggers onProgressUpdate method
                    publishProgress("" +
                            (int) ((total * 100) /
                                    lenghtOfFile));
                    // Write data to file
                    output.write(data, 0, count);
                }
                // Flush output
                output.flush();
                // Close streams
                output.close();
                input.close();
            } catch (Exception e) {
                Log.e("Error: ", e.getMessage());
            }
            return null;
        }
        // While Downloading Music File
        protected void onProgressUpdate
        (String... progress) {
            // Set progress percentage
            prgDialog.setProgress
                    (Integer.parseInt(progress[0]));
        }
        // Once Music File is downloaded
        @Override
        protected void onPostExecute(String file_url) {
            // Dismiss the dialog after the
            // Music file was downloaded
            prgDialog.dismiss();
            Toast.makeText(getApplicationContext(),
                    "Download complete, " +
                            "playing Music",
                    Toast.LENGTH_LONG).show();
            // Play the music
            playMusic();
        }
    }

    // Play Music
    protected void playMusic(){
        // Read Mp3 file present under SD card
        Uri myUri1 =
                Uri.parse("file:///sdcard/jai_ho.mp3");
        mPlayer  = new MediaPlayer();
        mPlayer.setAudioStreamType(
                AudioManager.STREAM_MUSIC);
        try {
            mPlayer.setDataSource
                    (getApplicationContext(), myUri1);
            mPlayer.prepare();
            // Start playing the Music file
            mPlayer.start();
            mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {

                                    // Once Music is completed playing,
                                    // enable the button
                                    btnPlayMusic.setEnabled(true);
                                    Toast.makeText(getApplicationContext(),
                                            "Music completed playing",
                                            Toast.LENGTH_LONG).show();

                }
            });
        } catch (IllegalArgumentException e) {
            Toast.makeText(getApplicationContext(),
                    "You might not set the URI correctly!",    Toast.LENGTH_LONG).show();
        } catch (SecurityException e) {
            Toast.makeText(getApplicationContext(),
                    "URI cannot be accessed, " +
                            "permissed needed",
                    Toast.LENGTH_LONG).show();
        } catch (IllegalStateException e) {
            Toast.makeText(getApplicationContext(),
                    "Media Player is not in correct state",    Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            Toast.makeText(getApplicationContext(),
                    "IO Error occured",
                    Toast.LENGTH_LONG).show();
        }
    }
}




