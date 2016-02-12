package com.example.mrugesh.mrugeshthaker;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.*;
import android.os.Process;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.Button;
import android.media.MediaPlayer;

import java.util.ArrayList;
import java.util.List;

public class MrugeshThaker extends AppCompatActivity {

    int i=10;
    int j=0;
    int z;
    MediaPlayer mediaPlayer;
    CountDownTimer waitTimer;


    public void cancelTimer(){
        waitTimer.cancel();
        waitTimer = null;
    }





    public void aboutClick(View view){
        Intent i = new Intent(getApplicationContext(), AboutMe.class);
        startActivity(i);
        mediaPlayer.stop();
        cancelTimer();
    }

    public void generateClick(View view){
        mediaPlayer.stop();
        cancelTimer();
        z= i/j;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mrugesh_thaker);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });




        Button submit = (Button) findViewById(R.id.button3);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Process.killProcess(Process.myPid());
                System.exit(1);
                mediaPlayer.stop();
                cancelTimer();
            }
        });

        mediaPlayer = MediaPlayer.create(this, R.raw.sound);
        mediaPlayer.start();



        waitTimer=new CountDownTimer(mediaPlayer.getDuration(), 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {

                mediaPlayer.start();
                waitTimer.start();
            }
        }.start();





    }




    protected void onPause() {
        super.onPause();
        if (this.isFinishing()){
            mediaPlayer.stop();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_mrugesh_thaker, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
