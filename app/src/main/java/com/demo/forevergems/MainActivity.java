package com.demo.forevergems;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    MediaPlayer music;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        music = MediaPlayer.create(MainActivity.this, R.raw.introding);
        music.start();
        setContentView(R.layout.activity_main);

        ImageView imgOne = findViewById(R.id.imageView1);
        ImageView imgTwo = findViewById(R.id.imageView2);

        Button btnref = (Button) findViewById(R.id.btn);

        imgOne.setOnClickListener(new View.OnClickListener() {
            //@Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, gold.class);
                startActivity(intent);
            }
        });

        imgTwo.setOnClickListener(new View.OnClickListener() {
            //@Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, silver.class);
                startActivity(intent);
            }
        });

        btnref.setOnClickListener(new View.OnClickListener() {
            //@Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, csv.class);
                startActivity(intent);
            }
        });
    }
}

