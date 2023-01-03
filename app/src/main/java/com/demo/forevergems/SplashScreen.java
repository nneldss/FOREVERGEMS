package com.demo.forevergems;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {

    MediaPlayer music;

    @Override
    protected void onCreate(Bundle SavedInstancesState){
        super.onCreate(SavedInstancesState);
        setContentView(R.layout.act_splashscreen);
        music = MediaPlayer.create(SplashScreen.this, R.raw.introsound);
        music.start();

        new Handler().postDelayed(new Runnable () {
            @Override
            public void run() {
                startActivity(new Intent(SplashScreen.this,MainActivity.class));
                finish();
            }
        }, 4000);
    }
}
